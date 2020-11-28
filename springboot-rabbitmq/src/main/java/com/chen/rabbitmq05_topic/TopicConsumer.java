package com.chen.rabbitmq05_topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/6/18
 */
@Component
public class TopicConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "topics",type = "topic"),
            key = {"user.*.*"}
    ))
    public void receive_01(String message){
        System.out.println("message1 == "+message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "topics",type = "topic"),
            key = {"user.#"}
    ))
    public void receive_02(String message){
        System.out.println("message2 == "+message);
    }
}
