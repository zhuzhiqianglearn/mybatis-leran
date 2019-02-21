package com.mybatis.firstdemo.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope
public class SenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sender(String exchangName,String routingName,Object object){
//           this.rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
//            @Override
//            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
//                System.out.println("消息发送失败："+message.getMessageProperties().getCorrelationId());
//            }
//        });
           this.rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
               @Override
               public void confirm(CorrelationData correlationData, boolean ack, String s) {
                   if (!ack) {
                       System.out.println("HelloSender消息发送失败" + s );
                   } else {
                System.out.println("HelloSender 消息发送成功 ");
                   }
               }
           });
        rabbitTemplate.convertAndSend(exchangName,routingName,object);
    }

}

