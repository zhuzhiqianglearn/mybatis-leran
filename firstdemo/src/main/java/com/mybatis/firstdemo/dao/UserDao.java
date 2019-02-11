package com.mybatis.firstdemo.dao;

import org.springframework.stereotype.Component;

@Component
public interface UserDao {
  public User findbyid(Object id);
}
