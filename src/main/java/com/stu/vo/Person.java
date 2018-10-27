package com.stu.vo;

import java.math.BigDecimal;

/**
 * Created by admin on 2018/10/24.
 */
public class Person {
    private String identity;
    private String name;
    private int age;
    private String sex;
    private BigDecimal money;
    private Car car;
    private String haveCar;
    private String say;

    @Override
    public String toString() {
        return "Person{" +
                "identity='" + identity + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", money=" + money +
                ", car=" + car +
                ", haveCar='" + haveCar + '\'' +
                ", say='" + say + '\'' +
                '}';
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public String getHaveCar() {
        return haveCar;
    }

    public void setHaveCar(String haveCar) {
        this.haveCar = haveCar;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void getPersonInfo(){

    }
}
