package com.chen.rabbitmq04_route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/28
 */

@Component
public class RouteConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "directs",type = "direct"),
            key = {"info","error","warn"}
    ))
    public void receive_01(String message){
        System.out.println("message1=="+message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "directs",type = "direct"),
            key = {"error"}
    ))
    public void receive_02(String message){
        System.out.println("message2=="+message);
    }

}
