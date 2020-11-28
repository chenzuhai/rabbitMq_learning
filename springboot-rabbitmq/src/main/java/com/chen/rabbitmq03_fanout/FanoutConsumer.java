package com.chen.rabbitmq03_fanout;

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
public class FanoutConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")    //交换机
            )
    })
    public void receive_01(String message){
        System.out.println("message1=="+message);
    }
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")    //交换机
            )
    })
    public void receive_02(String message){
        System.out.println("message2=="+message);
    }
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")    //交换机
            )
    })
    public void receive_03(String message){
        System.out.println("message3=="+message);
    }
}
