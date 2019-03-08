package com.mybatis.firstdemo.service;

import com.mybatis.firstdemo.dao.*;
import com.mybatis.firstdemo.onetomany.Country;
import com.mybatis.firstdemo.zhujie.MethodAnnotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTwoService {
    @Autowired(required = false)
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Autowired(required = false)
    private ICountryDao iCountryDao;
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

    public Country getByIds(int id){
        return iCountryDao.selectById(id);
    }
    public void add11(ClientTemplate clientTemplate){
         iCountryDao.add11(clientTemplate);
    }
}
