package com.stu.jdbc.po;

/**
 * Created by admin on 2018/11/6.
 */
public class Depart {
    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
