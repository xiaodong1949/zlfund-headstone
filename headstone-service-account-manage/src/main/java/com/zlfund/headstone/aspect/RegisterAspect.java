package com.zlfund.headstone.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoRequestDTO;
import com.zlfund.headstone.facade.account.manage.exception.AccountManageBizException;

/**
 * 注册切面
 * @author Yang Xiaodong
 * @since: 2017年2月22日
 */
@Aspect
@Component
public class RegisterAspect extends AccountManageAspect {

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.aspect.AccountManageAspect#doBefore(org.aspectj.lang.JoinPoint)
     */
    @Override
    @Before("declareJointPointExpression()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (null != args && args.length > 0) {
            Object requestObj = args[0];
            if (null != requestObj) {
                // 手机号码注册
                if (requestObj instanceof RegisterMobilenoRequestDTO) {
                    RegisterMobilenoRequestDTO registerMobilenoRequestDTO = (RegisterMobilenoRequestDTO)requestObj;
                    // 手机号码注册参数校验
                    checkMobileno(registerMobilenoRequestDTO.getMobileNo());
                    // 密码验证
                    checkPassword(registerMobilenoRequestDTO.getPassword(), "");
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
     * @see com.zlfund.headstone.aspect.AccountManageAspect#doAfterThrowing(org.aspectj.lang.JoinPoint,
     * java.lang.Exception)
     */
    @Override
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        // TODO Auto-generated method stub
        super.doAfterThrowing(joinPoint, e);
    }

}
