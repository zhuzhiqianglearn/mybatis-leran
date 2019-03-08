package com.mybatis.firstdemo.onetomany;

public class People {
    private Integer pid;
    private String pname;
    private Integer countryId;

    public String getPname() {
        return pname;
    }

    public People setPname(String pname) {
        this.pname = pname;
        return this;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public People setCountryId(Integer countryId) {
        this.countryId = countryId;
        return this;
    }

    public Integer getPid() {
        return pid;
    }

    public People setPid(Integer pid) {
        this.pid = pid;
        return this;
    }
}
