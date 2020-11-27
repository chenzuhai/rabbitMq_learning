package mq_01_helloworld;

import com.rabbitmq.client.*;
import org.junit.Test;
import util.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/26
 */

public class Consumer_my {

    @Test
    public void test() throws IOException, TimeoutException {
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost("192.168.31.184");
//        connectionFactory.setPort(5672);
//        connectionFactory.setVirtualHost("/ems");
//        connectionFactory.setUsername("zuhai");
//        connectionFactory.setPassword("zuhai");
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//
//        channel.queueDeclare("hello",false,false,false,null);
//
//        // 队列  ， 自动确认消息 , 默认消费者
//        channel.basicConsume("hello",true, new DefaultConsumer(channel){
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                super.handleDelivery(consumerTag, envelope, properties, body);
//            }
//        });
//        channel.close();
//        connection.close();

    }

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMqUtil.getConnection();

        Channel channel = connection.createChannel();


        channel.queueDeclare("hello1",true,false,false,null);

        // 队列  ， 自动确认消息 , 默认消费者
        channel.basicConsume("hello1",true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });
        //channel.close();
        //connection.close();
    }
}
