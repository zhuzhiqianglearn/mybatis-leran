package com.mybatis.firstdemo.dao;

import com.mybatis.firstdemo.onetomany.Country;

public interface ICountryDao {
    Country selectById(int id);
    public void add11(ClientTemplate clientTemplate);
}
