package com.zlfund.headstone.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面 用于日志输出，参数校验等
 * @author Yang Xiaodong
 * @since: 2017年2月22日
 */
public class AccountManageAspect {
    public void doAfter(JoinPoint jp) {
        System.out.println("======>>>>>>Ending method:<<<<<<<====== " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
    }

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        time = System.currentTimeMillis() - time;
        System.out.println("--------->>process time: " + time + " ms");
        return retVal;
    }

    public void doBefore(JoinPoint jp) {
        System.out.println("======>>>>>>Begin method:<<<<<<<====== " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
    }

    public void doThrowing(JoinPoint jp, Throwable ex) {
        System.out.println(
                "======>>>>>>method Throwable<<<<<<<======" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");
        System.out.println("======>>>>>>" + ex.getMessage() + "<<<<<<<======");
    }
}
