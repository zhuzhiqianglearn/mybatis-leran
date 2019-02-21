package com.mybatis.firstdemo.service;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class SenderServiceImp implements RabbitTemplate.ConfirmCallback{
    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @Autowired
//    public SenderServiceImp(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
//    }

    public void sender(String exchangName,String routingName,Object object){
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容

        rabbitTemplate.convertAndSend(exchangName,routingName,object);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (!b) {
            System.out.println("HelloSender消息发送失败" + s );
        } else {
            System.out.println("HelloSender 消息发送成功 ");
        }
    }
}

