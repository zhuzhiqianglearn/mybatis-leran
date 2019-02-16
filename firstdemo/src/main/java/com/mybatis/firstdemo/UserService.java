package com.mybatis.firstdemo;

import com.mybatis.firstdemo.dao.User;
import com.mybatis.firstdemo.dao.UserDao;
import com.mybatis.firstdemo.dao.UserDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired(required = false)
    private UserDao userDao;
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
