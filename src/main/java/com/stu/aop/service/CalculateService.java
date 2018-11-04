package com.stu.aop.service;

/**
 * Created by admin on 2018/11/4.
 */
public interface CalculateService {
    int add(int a,int b);

    int sub(int a,int b);

    int mul(int a,int b);

    int div(int a,int b);

    void testOrder(int a,int b);
}
