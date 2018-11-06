package com.stu.jdbc.po;

/**
 * Created by admin on 2018/11/6.
 */
public class Employee {
    private int id;
    private String name;
    private int departId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departId=" + departId +
                '}';
    }
}
