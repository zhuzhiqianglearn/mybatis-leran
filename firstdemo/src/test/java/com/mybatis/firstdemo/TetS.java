package com.mybatis.firstdemo;

public class TetS {
    public   int a=10;

    public int getA() {
        return a;
    }

    public TetS setA(int a) {
        this.a = a;
        return this;
    }

    public  void aaa(){
        System.out.println(a);
    }

    public static void main(String[] args) {
        Person build = Person.PersonBiulder()
                 .setAge(18)
                .setName("shjiru")
                .build();
        System.out.println(build.toString());
    }
}
