package mq_04_routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
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

        channel.exchangeDeclare("logs_direct","direct",false);

        String routingKey = "error";
        //发布消息
        for (int i = 0; i < 10; i++) {
            channel.basicPublish(
                    "logs_direct"
                    ,routingKey
                    ,null
                    ,("routingKey = "+routingKey).getBytes());
        }

        RabbitMqUtil.closeConnectionAndChannel(connection,channel);


    }

}

