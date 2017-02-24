package com.zlfund.headstone.aspect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;

import com.zlfund.headstone.common.dto.BaseResultDTO;
import com.zlfund.headstone.common.utils.ReflectionUtil;
import com.zlfund.headstone.facade.account.manage.consts.AccountManageConsts;
import com.zlfund.headstone.facade.account.manage.exception.AccountManageBizException;
import com.zlfund.headstone.util.AccountManageUtil;
import com.zlfund.security.DESEncHelper;

/**
 * 切面 用于日志输出，参数校验等
 * @author Yang Xiaodong
 * @since: 2017年2月22日
 */
public class AccountManageAspect {
    private static final Log log = LogFactory.getLog(AccountManageAspect.class);

    /** 
     * 目标方法扫描
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    @Pointcut("execution(public * com.zlfund.headstone.core.biz.*.*(..))")
    public void declareJointPointExpressionBiz() {
    }

    @Pointcut("execution(public * com.zlfund.headstone.facade.account.manage.service.*.*(..))")
    public void declareJointPointExpressionService() {
    }

    /** 
     * 目标方法执行前执行
     * @param joinPoint
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    // @Before("declareJointPointExpression()")
    public void doBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
    }

    /** 
     * 目标方法执行后执行
     * @param joinPoint
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    // @After("declareJointPointExpression()")
    public void doAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }

    /** 
     * 目标方法正常执行后执行
     * @param joinPoint
     * @param result
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    // @AfterReturning(value = "declareJointPointExpression()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }

    /** 
     * 在目标方法出现异常时会执行的代码.
     * @param joinPoint
     * @param e
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    // @AfterThrowing(value = "declareJointPointExpression()", throwing = "e")
    public Object doAfterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs excetion:" + e);
        return methodName;
    }

    /** 
     * 环绕目标方法
     * @param pjd
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    // @Around("declareJointPointExpression()")
    public Object doAround(ProceedingJoinPoint pjd) {

        Object result = null;
        String methodName = pjd.getSignature().getName();

        try {
            // 前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
            // 执行目标方法
            result = pjd.proceed();
            // 返回通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch(Throwable e) {
            // 异常通知
            System.out.println("The method " + methodName + " occurs exception:" + e);
            throw new RuntimeException(e);
        }
        // 后置通知
        System.out.println("The method " + methodName + " ends");

        return result;
    }

    /** 
     * @param password
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @throws Exception 
     * @history: 
     */
    void checkPassword(String password, String idno, String mctcode) throws AccountManageBizException {
        if (StringUtils.isBlank(password)) {
            throw AccountManageBizException.ACCOUNT_PASSWORD_BLANK;
        }
        if (!AccountManageConsts.WEBSERVER_MCT_CODE.equals(mctcode)) {
            DESEncHelper des = DESEncHelper.getInstance();
            try {
                password = des.decrypt(password);
            } catch(Exception e) {
                throw AccountManageBizException.ACCOUNT_PASSWORD_INVALID;
            }
        }
        String verifyPasswordMsg = AccountManageUtil.verifyPassword(password, idno);
        if (StringUtils.isNotBlank(verifyPasswordMsg)) {
            AccountManageBizException accountManageBizException = AccountManageBizException.ACCOUNT_PASSWORD_INVALID;
            throw accountManageBizException.newInstance(verifyPasswordMsg);
        }

    }

    /** 在
     * 检查手机号码
     * @param mobileno
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    void checkMobileno(String mobileno) {
        if (StringUtils.isBlank(mobileno)) {
            throw AccountManageBizException.ACCOUNT_MOBILENO_BLANK;
        }
        if (!AccountManageUtil.isMobileno(mobileno)) {
            throw AccountManageBizException.ACCOUNT_MOBILENO_INVALID;
        }
    }

    void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        if (diffTime > AccountManageConsts.SHOW_EXECTIME_THRESHOLD) {
            log.warn(methodName + " 方法执行耗时：" + diffTime + " ms");
        }
    }

    /** 
     * 根据方法明和包名匹配构造返回对象
     * @param packageName
     * @param methodName
     * @return
     * @return 
     * @create: 2017年2月24日
     * @author: Yang Xiaodong
     * @history: 
     */
    BaseResultDTO getBizResultDTO(String packageName, String methodName) {
        if (StringUtils.isNotBlank(packageName) && StringUtils.isNotBlank(methodName)) {
            try {
                Class<?> clazz = Class.forName(packageName);
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    if (methodName.equals(method.getName())) {
                        Type classType = method.getGenericReturnType();
                        return (BaseResultDTO)ReflectionUtil.newInstance(classType);
                    }
                }
            } catch(ClassNotFoundException e) {
                log.warn("GetBizResultDTO ERROR!", e);
            } catch(InstantiationException e) {
                log.warn("GetBizResultDTO ERROR!", e);
            } catch(IllegalAccessException e) {
                log.warn("GetBizResultDTO ERROR!", e);
            }
        }
        return new BaseResultDTO();

    }
}
