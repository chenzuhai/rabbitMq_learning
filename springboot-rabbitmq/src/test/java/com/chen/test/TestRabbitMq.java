package com.chen.test;

import com.chen.SpringbootRabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/28
 */

@SpringBootTest(classes = SpringbootRabbitmqApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMq {

    //注入模板
    @Autowired
    RabbitTemplate rabbitTemplate;

    //hello world
    @Test
    public void testHelloWorld(){
        rabbitTemplate.convertAndSend("hello","hello world");

    }

    //work
    @Test
    public void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","work模型");
        }
    }

    //fanout
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","Fanout消息");
    }


}
