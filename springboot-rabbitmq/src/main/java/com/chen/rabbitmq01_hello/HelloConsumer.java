package com.chen.rabbitmq01_hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/28
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "false"))
public class HelloConsumer {

    @RabbitHandler
    public void receive(String message){
        System.out.println("message=="+message);
    }


}
