package com.mybatis.firstdemo.dao;

import org.springframework.stereotype.Component;


public interface UserDao {
  public User findbyid(Object id);
  public UserDate findbyidDate(Object id);
  public void add(User user);
}
