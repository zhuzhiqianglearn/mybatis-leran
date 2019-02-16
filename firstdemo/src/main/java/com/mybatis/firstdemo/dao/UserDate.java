package com.mybatis.firstdemo.dao;

import java.io.Serializable;
import java.util.Date;

public class UserDate implements Serializable{
    private String name;
    private Date age;
    private int id;
    private int sharding_id;


    public UserDate(String name, Date age, int id, int sharding_id) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.sharding_id = sharding_id;
    }

    public String getName() {
        return name;
    }

    public UserDate setName(String name) {
        this.name = name;
        return this;
    }

    public Date getAge() {
        return age;
    }

    public UserDate setAge(Date age) {
        this.age = age;
        return this;
    }

    public int getId() {
        return id;
    }

    public UserDate setId(int id) {
        this.id = id;
        return this;
    }

    public int getSharding_id() {
        return sharding_id;
    }

    public UserDate setSharding_id(int sharding_id) {
        this.sharding_id = sharding_id;
        return this;
    }

    @Override
    public String toString() {
        return "UserDate{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", sharding_id=" + sharding_id +
                '}';
    }
}
