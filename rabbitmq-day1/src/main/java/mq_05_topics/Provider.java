package mq_05_topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.ExchangerType;
import util.RabbitMqUtil;

import java.io.IOException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/27
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics", ExchangerType.TOPICS);

        String routingKey = "user.save";

        channel.basicPublish("topics",routingKey,null,("topics动态路由,routeKey=="+routingKey).getBytes());

        RabbitMqUtil.closeConnectionAndChannel(connection,channel);


    }
}
