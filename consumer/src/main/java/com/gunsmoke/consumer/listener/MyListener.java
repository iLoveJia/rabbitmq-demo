package com.gunsmoke.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

    @RabbitListener(queues = "gunsmoke") //监听的队列名称
    public void getMessage(String message)
    {
        System.out.println("接收到了消息,消息内容为:" + message);
    }
}