package com.stu.beanfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/10/28.
 */
public class BeanInstanceFactory {
    private Map<String,Car> cars;

    private BeanInstanceFactory(){
        cars=new HashMap<>();
        cars.put("mazda",new Car("mazda"));
        cars.put("audi",new Car("audi"));
    }
    private Car getCar(String beanName){
        return cars.get(beanName);
    }
}
