package com.mybatis.firstdemo;

import com.mybatis.firstdemo.dao.User;
import com.mybatis.firstdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired(required = false)
    private UserDao userDao;
    public User getbyid(int id){
        return userDao.findbyid(id);
    }
}
