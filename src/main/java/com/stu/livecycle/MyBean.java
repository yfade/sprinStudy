package com.stu.livecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by admin on 2018/10/28.
 */
public class MyBean implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Car car= (Car) bean;
        car.setBrand("audi");
        System.out.println("postProcessBeforeInitialization:"+bean+":"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName))
            System.out.println("this is car....");
        System.out.println("postProcessAfterInitialization:"+bean+":"+beanName);
        return bean;
    }
}
