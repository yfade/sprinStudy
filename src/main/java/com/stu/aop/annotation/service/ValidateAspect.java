package com.stu.aop.annotation.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by admin on 2018/11/4.
 */
//order注解配置切面的优先级，数值越小优先级越高，默认为优先级最小：Integer.MAX_VALUE
@Order(1)
@Aspect
@Component
public class ValidateAspect {

    //调用其他类声明的切点表达式，当前类和表达式类在同一包下可以不加包名。
    // 如果别的包的类要调用切点表达式方法，需要加上包名
    @Before("com.stu.aop.annotation.service.LoggingAspect.declareExecution()")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate before:"+ Arrays.asList(joinPoint.getArgs()));
    }
}
