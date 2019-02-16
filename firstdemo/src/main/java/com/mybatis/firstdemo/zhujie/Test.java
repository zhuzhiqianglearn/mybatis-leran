package com.mybatis.firstdemo.zhujie;

import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

//@TestAnnotation() 如果指定了默认值，参数可以不填写
@TestAnnotation(id=3,msg = "hello annotation")
public class Test {
    @Check("aaa")
    private   String a;
    @Deprecated
    /*
    这个元素是用来标记过时的元素，想必大家在日常开发中经常碰到。编译器在编译阶段遇到这个注解时会发出提醒警告，
    告诉开发者正在调用一个过时的元素比如过时的方法、过时的类、过时的成员变量。
     */
    public static void say(){
        System.out.println("hello world");
    }

    @SuppressWarnings("deprecation")
    public static void say2(){
       say();
    }
    @SafeVarargs
    static void m(String... stringLists) {
        System.out.println(stringLists[0]);
    }


    public static void main(String[] args) {
        Test.say();
        Test.say2();
        Test.m(new String[]{"aaa"});
        //判断类是否使用了注解
        boolean annotationPresent = Test.class.isAnnotationPresent(TestAnnotation.class);
        if(annotationPresent){
            //获取注解
            TestAnnotation annotation = Test.class.getAnnotation(TestAnnotation.class);
            System.out.println("id          "+annotation.id());
            System.out.println("msg          "+annotation.msg());
        }else{
            System.out.println("没有使用注解");
        }
        //
        try {
            Field a = Test.class.getDeclaredField("a");
            a.setAccessible(true);
            Check annotation = a.getAnnotation(Check.class);
            System.out.println(annotation.value());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    /*
    @Override  子类重写父类的方法
     */
}
