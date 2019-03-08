package com.mybatis.firstdemo;

import com.mybatis.firstdemo.dao.ClientTemplate;
import com.mybatis.firstdemo.dao.User;
import com.mybatis.firstdemo.dao.UserDate;
import com.mybatis.firstdemo.onetomany.Country;
import com.mybatis.firstdemo.service.SenderServiceImp;
import com.mybatis.firstdemo.service.UserService;
import com.mybatis.firstdemo.service.UserTwoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
	@Autowired
    private UserTwoService userTwoService;

	@Autowired
	private RabbitTemplate rabbitTemplate;

//	@Autowired
//	private SenderService senderService;
	@Autowired
	private SenderServiceImp senderService;

	@RequestMapping("/hello")
	public String hello(int id){
		return  userService.getbyid(id).toString();
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
	@RequestMapping("/radd")
	public void radd(String name){
				rabbitTemplate.convertAndSend("mybatis-exchange","mybatis-routeKey","简单的情景实现 "+name);
	}
	@RequestMapping("/sender")
	public void sender(String name){
		senderService.sender("mybatis-exchange","mybatis-routeKey","简单的情景实现 "+name);
	}
	@RequestMapping("/sender2")
	public void sender2(String name){
		for (int i = 0; i < 10; i++) {
			final int  aa=i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					if(aa%2==0){
						senderService.sender("mybatis-exchange","mybatis-routeKey","简单的情景实现 "+name);
					}else{
						senderService.sender("mybatis-exchange22","mybatis-routeKey","简单的情景实现 "+name);
					}
				}
			}).start();
		}
	}
	@RequestMapping("/onetomany")
	public void aaaaaa(){
		Country byIds = userTwoService.getByIds(1);
		System.out.println(11111);
	}
	@RequestMapping("/add11")
	public void add11(){
		ClientTemplate clientTemplate=new ClientTemplate();
		clientTemplate.setNickName("ceshi");
		userTwoService.add11(clientTemplate);
	}
}

