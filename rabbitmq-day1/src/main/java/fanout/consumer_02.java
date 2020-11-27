package fanout;

import com.rabbitmq.client.*;
import util.RabbitMqUtil;

import java.io.IOException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/6/18
 */

public class consumer_02 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();

        Channel channel = connection.createChannel();

        //绑定交换机
        channel.exchangeDeclare("logs","fanout");

        //临时队列
        String queue = channel.queueDeclare().getQueue();

        //绑定队列
        channel.queueBind(queue,"logs","");

        //消费消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2===》"+new String(body));
            }
        });


    }
}
