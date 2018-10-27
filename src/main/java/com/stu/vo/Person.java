package com.stu.vo;

/**
 * Created by admin on 2018/10/24.
 */
public class Person {
    private String identity;
    private String name;
    private int age;
    private String sex;

    public Person() {
    }

    public Person(String identity, String name, int age, String sex) {
        this.identity = identity;
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    @Override
    public String toString() {
        return "Person{" +
                "identity='" + identity + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void getPersonInfo(){

    }
}
