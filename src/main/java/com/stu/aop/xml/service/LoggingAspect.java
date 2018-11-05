package com.stu.aop.xml.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by admin on 2018/11/4.
 */
//把这个类声明为一个切面：先放进IOC容器中，再声明为一个切面

public class LoggingAspect {
    private Log logger= LogFactory.getLog(this.getClass());

    //前置通知：在目标方法执行前执行
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("-----------------------------------------------------");
        System.out.println("the methoe "+joinPoint.getSignature().getName()+" paramters:"+ Arrays.asList(joinPoint.getArgs()));
    }

    //后置通知：在目标方法执行后通知（不管目标方法执行时有没有抛异常）
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("the method "+joinPoint.getSignature().getName()+" end");
    }

    /**
     * 返回通知：在目标方法正常执行结束后执行的代码
     * @param joinPoint
     * @param result 目标方法返回值
     */
    public void afterReturnMethod(JoinPoint joinPoint,Object result){
        System.out.println("the method "+joinPoint.getSignature().getName()+" result:"+result);
    }

    /**
     * 异常通知：在执行目标方法出现异常时执行的代码
     * 可以访问到异常对象，并可以指定当出现特定异常时再执行通知代码
     * @param joinPoint
     * @param ex 异常对象
     */
    @AfterThrowing(value = "declareExecution()",throwing = "ex")
    public void afterThrowException(JoinPoint joinPoint,Exception ex){
        ex.printStackTrace();
        System.out.println("the method "+joinPoint.getSignature().getName()+" occur "+ex);
    }

    /**
     * 环绕通知：环绕通知需要携带ProceedingJoinPoint参数
     * 环绕通知类似于动态代理的全过程，ProceedingJoinPoint类型的参数可以决定是否执行目标方法
     * 并且环绕通知必须有返回值，返回值即为目标方法的返回值
     * @param pjp
     * @return
     */
    public Object aroundMethod(ProceedingJoinPoint pjp){
        Object result = null;
        try {
            //前置通知
            System.out.println("=====================================================");
            System.out.println("==the method "+pjp.getSignature().getName()+" paramter:"+Arrays.asList(pjp.getArgs()));
            //执行目标方法
            result=pjp.proceed();
            //执行返回通知
            System.out.println("==the method result:"+result);
        } catch (Throwable e) {
            //执行异常通知
            System.out.println("==the method throw exception:"+e);
            e.printStackTrace();
        }
        //后置通知
        System.out.println("==the method invoke end...");
        return result;
    }

    /**
     * 用于测试切面优先级
     * @param joinPoint
     */
    public void beforeMethod1(JoinPoint joinPoint){
        System.out.println("logging before:"+Arrays.asList(joinPoint.getArgs()));
    }

}
