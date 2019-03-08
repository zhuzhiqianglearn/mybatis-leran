package com.mybatis.firstdemo.onetomany;

import java.util.Set;

public class Country {
    private Integer cid;
    private String cname;
    private Set<People> peoples;

    public Integer getCid() {
        return cid;
    }

    public Country setCid(Integer cid) {
        this.cid = cid;
        return this;
    }

    public String getCname() {
        return cname;
    }

    public Country setCname(String cname) {
        this.cname = cname;
        return this;
    }

    public Set<People> getPeoples() {
        return peoples;
    }

    public Country setPeoples(Set<People> peoples) {
        this.peoples = peoples;
        return this;
    }
}
