package com.gunsmoke.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    //交换机名称
    public static String EXCHANGE_NAME = "gunsmoke";
    //队列名称
    public static String QUEUE_NAME = "gunsmoke";

    //声明交换机
    @Bean("myExchange")
    public Exchange myExchange()
    {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    //声明队列
    @Bean("myQueue")
    public Queue myQueue()
    {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    //交换机与队列绑定
    @Bean
    public Binding myBinding(@Qualifier("myQueue") Queue queue, @Qualifier("myExchange")Exchange exchange)
    {
        return BindingBuilder.bind(queue).to(exchange).with("gunsmoke.#").noargs();
    }
}