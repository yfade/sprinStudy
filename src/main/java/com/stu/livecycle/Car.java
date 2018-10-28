package com.stu.livecycle;

/**
 * Created by admin on 2018/10/28.
 */
public class Car {
    private String brand;

    public Car() {
        System.out.println("init constroctor...");
    }
    private void init(){
        System.out.println("init method...");
    }
    private void destory(){
        System.out.println("destory method...");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("set brand ...");
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
