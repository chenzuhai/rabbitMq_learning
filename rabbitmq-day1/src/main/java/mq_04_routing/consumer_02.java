package mq_04_routing;

import com.rabbitmq.client.*;
import util.ExchangerType;
import util.RabbitMqUtil;

import java.io.IOException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/27
 */
public class consumer_02 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs_direct", ExchangerType.DIRECT,false);

        //创建一个临时队列
        String queue = channel.queueDeclare().getQueue();

        //基于routeKey绑定队列和交换机
        channel.queueBind(queue,"logs_direct","info");
        channel.queueBind(queue,"logs_direct","error");

        //消费消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2=>>"+new String(body));
            }
        });



    }
}
