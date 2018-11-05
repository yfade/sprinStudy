package com.stu.aop.xml.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by admin on 2018/11/4.
 */
public class ValidateAspect {

    // 如果别的包的类要调用切点表达式方法，需要加上包名
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate before:"+ Arrays.asList(joinPoint.getArgs()));
    }
}
