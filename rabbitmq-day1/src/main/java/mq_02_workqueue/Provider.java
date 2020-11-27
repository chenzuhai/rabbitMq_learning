package mq_02_workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.RabbitMqUtil;

import java.io.IOException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/27
 */

//消费者平均消费
public class Provider {
    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMqUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("workQueue",true,false,false,null);
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("","workQueue",null,(i+"hello workQueue").getBytes());
        }

        RabbitMqUtil.closeConnectionAndChannel(connection,channel);

    }
}
