package com.zlfund.headstone.aspect;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.zlfund.headstone.common.dto.BaseResultDTO;
import com.zlfund.headstone.core.mongo.repository.CustInfoRepository;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoRequestDTO;
import com.zlfund.headstone.facade.account.manage.exception.AccountManageBizException;
import com.zlfund.headstone.util.AccountManageUtil;

/**
 * 注册切面
 * @author Yang Xiaodong
 * @since: 2017年2月22日
 */
@Aspect
@Component
public class RegisterAspect extends AccountManageAspect {
    private static final Log log = LogFactory.getLog(RegisterAspect.class);

    @Autowired
    private CustInfoRepository custInfoRepository;

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
            if (null != requestObj) {
                AccountManageUtil.logDebug(log, requestObj.toString());
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
                    // mongo check
                    Query query = new Query(
                            Criteria.where("mobileno").is(registerMobilenoRequestDTO.getMobileNo()).and("custst").is("N").and("mobileverifist").ne("N"));
                    long count = custInfoRepository.count(query);
                    if (count > 0) {
                        throw AccountManageBizException.ACCOUNT_ALREADY_REGISTERED;
                    }
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
        Object resultObj = null;
        long startTime = System.currentTimeMillis();
        String methodName = procedingJoinPoint.getSignature().getName();
        String packageName = procedingJoinPoint.getSignature().getDeclaringTypeName();
        BaseResultDTO resultDTO = getBizResultDTO(packageName, methodName);
        try {
            // 执行目标方法
            resultObj = procedingJoinPoint.proceed();
        } catch(AccountManageBizException e) {
            log.warn(e.getMsg(), e);
            resultDTO.setErrCode(e.getCode());
            resultDTO.setErrMsg(e.getMsg());
            resultDTO.setErrDetailMsg(e.getDetailMsg());
            resultDTO.setSuccess(false);
            resultObj = resultDTO;
        } catch(Throwable e) {
            e.printStackTrace();
            resultDTO.setErrCode(AccountManageBizException.OTHER_ERROR.getCode());
            resultDTO.setErrMsg(AccountManageBizException.OTHER_ERROR.getMsg());
            resultDTO.setErrDetailMsg(AccountManageBizException.OTHER_ERROR.getMsg());
            resultDTO.setSuccess(false);
            resultObj = resultDTO;
        }
        long endTime = System.currentTimeMillis();
        // 超时执行打印
        printExecTime(packageName + "." + methodName, startTime, endTime);
        return resultObj;
    }
}
