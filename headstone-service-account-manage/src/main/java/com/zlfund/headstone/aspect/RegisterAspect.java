package com.zlfund.headstone.aspect;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.zlfund.headstone.common.dto.BaseResultDTO;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoRequestDTO;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoResultDTO;
import com.zlfund.headstone.facade.account.manage.exception.AccountManageBizException;

/**
 * 注册切面
 * @author Yang Xiaodong
 * @since: 2017年2月22日
 */
@Aspect
@Component
public class RegisterAspect extends AccountManageAspect {
    private static final Log log = LogFactory.getLog(RegisterAspect.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.aspect.AccountManageAspect#doBefore(org.aspectj.lang.JoinPoint)
     */
    @Override
    @Before("declareJointPointExpressionBiz()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (null != args && args.length > 0) {
            Object requestObj = args[0];
            if (log.isDebugEnabled()) {
                log.debug(requestObj);
            }
            if (null != requestObj) {
                // 手机号码注册
                if (requestObj instanceof RegisterMobilenoRequestDTO) {
                    RegisterMobilenoRequestDTO registerMobilenoRequestDTO = (RegisterMobilenoRequestDTO)requestObj;
                    if (StringUtils.isBlank(registerMobilenoRequestDTO.getMctcode())) {
                        throw AccountManageBizException.ACCOUNT_MCTCODE_BLANK;
                    }
                    // 手机号码注册参数校验
                    checkMobileno(registerMobilenoRequestDTO.getMobileNo());
                    // 密码验证
                    checkPassword(registerMobilenoRequestDTO.getPassword(), "", registerMobilenoRequestDTO.getMctcode());
                    // TODO mongo check
                }

            } else {
                throw AccountManageBizException.PARAM_IS_NULL;
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.aspect.AccountManageAspect#doAround(org.aspectj.lang.ProceedingJoinPoint)
     */
    @Override
    @Around("declareJointPointExpressionService()")
    public Object doAround(ProceedingJoinPoint procedingJoinPoint) {
        BaseResultDTO resultDTO = null;
        Object resultObj = null;
        long startTime = System.currentTimeMillis();
        String methodName = procedingJoinPoint.getSignature().getName();
        String packageName = procedingJoinPoint.getSignature().getDeclaringTypeName() + "." + methodName;
        try {
            // 执行目标方法
            resultObj = procedingJoinPoint.proceed();
        } catch(AccountManageBizException e) {
            log.warn(e.getMsg(), e);
            // 手机注册
            if ("registerByMobileno".equals(methodName)) {
                resultDTO = new RegisterMobilenoResultDTO();
            } else {
                resultDTO = new BaseResultDTO();
            }
            resultDTO.setErrCode(e.getCode());
            resultDTO.setErrMsg(e.getMsg());
            resultDTO.setErrDetailMsg(e.getDetailMsg());
            resultDTO.setSuccess(false);
            return resultDTO;
        } catch(Throwable e) {
            log.error(e);
            resultDTO = new BaseResultDTO();
            resultDTO.setErrCode("99999999");
            resultDTO.setErrMsg("未知错误");
            resultDTO.setErrDetailMsg("未知错误");
            resultDTO.setSuccess(false);
        }
        long endTime = System.currentTimeMillis();
        // 超时执行打印
        printExecTime(packageName, startTime, endTime);

        return resultObj;
    }
}
