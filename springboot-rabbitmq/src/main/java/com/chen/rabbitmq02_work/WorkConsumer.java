package com.chen.rabbitmq02_work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/28
 */

@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue(value = "work",durable = "true"))
    public void receive_1(String message){
        System.out.println("message1 == "+message);
    }
    @RabbitListener(queuesToDeclare = @Queue(value = "work",durable = "true"))
    public void receive_2(String message){
        System.out.println("message2 == "+message);
    }
}
