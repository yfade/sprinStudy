package com.stu.beanfactory;

/**
 * Created by admin on 2018/10/28.
 */
public class Car {
    private String brand;

    public Car() {
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
