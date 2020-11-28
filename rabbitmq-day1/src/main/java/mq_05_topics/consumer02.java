package mq_05_topics;

import com.rabbitmq.client.*;
import util.ExchangerType;
import util.RabbitMqUtil;

import java.io.IOException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/28
 */

public class consumer02 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics", ExchangerType.TOPICS);

        String queue = channel.queueDeclare().getQueue();

        channel.queueBind(queue,"topics","user.#");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2===>"+new String(body));
            }
        });

    }
}
