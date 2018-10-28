package com.stu.beanfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/10/28.
 */
public class BeanStaticFactory {
    private static Map<String,Car> cars=new HashMap<>();
    static {
        System.out.println("static...");
        cars.put("mazda",new Car("mazda"));
        cars.put("audi",new Car("audi"));
        cars.put("bmw",new Car("bmw"));
    }
    private static Car getBean(String beanName){
        System.out.println("get bean...");
        return cars.get(beanName);
    }
}
