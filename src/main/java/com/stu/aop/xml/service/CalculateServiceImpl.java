package com.stu.aop.xml.service;

import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/11/4.
 */
@Service("calculateService")
public class CalculateServiceImpl implements CalculateService {
    @Override
    public int add(int a, int b) {
        System.out.println("invoke add...");
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("invoke sub...");
        return a-b;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("invoke mul...");
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("invoke div...");
        return a/b;
    }

    @Override
    public void testOrder(int a, int b) {
        System.out.println("do test order...");
    }
}
