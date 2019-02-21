package com.mybatis.firstdemo;

public class Person {
    private String name;
    private int age;
    private String sex;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PersonBiulder PersonBiulder(){
        return new PersonBiulder();
    }

    public static class PersonBiulder{
        private String name;
        private int age;
        private String sex;

        public String getName() {
            return name;
        }

        public PersonBiulder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public PersonBiulder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getSex() {
            return sex;
        }

        public PersonBiulder setSex(String sex) {
            this.sex = sex;
            return this;
        }
        public Person build(){
            return new Person(name,age,sex);
        }
    }
}
