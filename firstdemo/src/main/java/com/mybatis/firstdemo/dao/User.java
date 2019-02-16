package com.mybatis.firstdemo.dao;

import java.io.Serializable;

public class User implements Serializable{
    private String name;
    private String age;
    private int id;
    private int sharding_id;

    public User(String name, String age, int id, int sharding_id) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.sharding_id = sharding_id;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public int getSharding_id() {
        return sharding_id;
    }

    public User setSharding_id(int sharding_id) {
        this.sharding_id = sharding_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public User() {
        this.name = name;
        this.age = age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                ", sharding_id=" + sharding_id +
                '}';
    }

}
