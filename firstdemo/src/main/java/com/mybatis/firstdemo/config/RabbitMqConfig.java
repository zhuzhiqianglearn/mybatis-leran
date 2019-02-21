package com.mybatis.firstdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//注释为配置文件
@Configuration
public class RabbitMqConfig {

    //配置rabbit连接工厂
    @Bean
    public ConnectionFactory getConnectionFactory(){
        CachingConnectionFactory connectionFactory=new CachingConnectionFactory();
        //配置用户名，密码和端口
        connectionFactory.setAddresses("127.0.0.1:5672");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //权限配置
        connectionFactory.setVirtualHost("/");
       //自动创建的ConnectionFactory无法完成事件的回调，即没有设置下面的代码
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }
    //配置RabbitTemplate
    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate getAmqpTemplate(){
        RabbitTemplate template = new RabbitTemplate(getConnectionFactory());
//        template.setMandatory(true);
        return template;
    }
    //配置交换器
    @Bean
    public DirectExchange getExchange(){
        return new DirectExchange("mybatis-exchange",true,false,null);
    }
    @Bean
    public Queue getQueue(){
        return new Queue("mybatis-queue",true,false,false,null);
    }
    @Bean
    public Binding getBinging(){
        return BindingBuilder.bind(getQueue()).to(getExchange()).with("mybatis-routeKey");
    }

}
