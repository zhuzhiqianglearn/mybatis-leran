package com.mybatis.firstdemo.service;

import com.mybatis.firstdemo.dao.User;
import com.mybatis.firstdemo.dao.UserDao;
import com.mybatis.firstdemo.dao.UserDate;
import com.mybatis.firstdemo.zhujie.MethodAnnotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTwoService {
    @Autowired(required = false)
    private UserDao userDao;
    @Autowired
    private UserService userService;

//    public UserTwoService(UserService userService) {
//        this.userService = userService;
//    }

    @MethodAnnotion(name = "user")
    public User getbyid(int id){
        return userDao.findbyid(id);
    }
    public UserDate findbyidDate(int id){
        return userDao.findbyidDate(id);
    }
    public void add(User user){
        this.userDao.add(user);
    }
}
