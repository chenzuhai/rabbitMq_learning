package workqueue;

import com.rabbitmq.client.*;
import util.RabbitMqUtil;

import java.io.IOException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/27
 */

public class Consumer_01 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();
        final Channel channel = connection.createChannel();

        channel.basicQos(1);

        channel.queueDeclare("workQueue",true,false,false,null);

        channel.basicConsume("workQueue",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1=>"+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);  //手动确认消息
            }
        });

    }

}
