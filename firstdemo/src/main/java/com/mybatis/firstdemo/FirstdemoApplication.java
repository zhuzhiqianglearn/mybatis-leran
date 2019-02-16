package com.mybatis.firstdemo;

import com.mybatis.firstdemo.dao.User;
import com.mybatis.firstdemo.dao.UserDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@SpringBootApplication
@EnableTransactionManagement
public class FirstdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstdemoApplication.class, args);
	}

	@Autowired
    private UserService userService;
	@RequestMapping("/hello")
	public String hello(){
		return  userService.getbyid(9).toString();
//		return  "123";
	}
	@RequestMapping("/helloDate")
	public String helloDate(){
		return  userService.findbyidDate(9).toString();
//		return  "123";
	}
	@RequestMapping("/add")
	public String helloadd(){
		User user=new User();
		user.setAge(18+"");
		user.setName("aaaa");
		user.setSharding_id(10000);
		this.userService.add(user);
//		return  "123";
		return user.getId()+"";
	}
	@RequestMapping("/add2")
	public void helloadd2(){
		UserDate user=new UserDate("zzqtest",new Date(),9,10020);
//		this.userService.add(user);
//		return  "123";
	}
}

