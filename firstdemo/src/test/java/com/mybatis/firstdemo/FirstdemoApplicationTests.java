package com.mybatis.firstdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstdemoApplicationTests {

	@Test
	public void contextLoads() {

		double m=200000;
		double l=0.03;
		for (int i = 0; i < 10; i++) {
			m+=150000;
			System.out.println(m*0.03);
		}


	}

}

