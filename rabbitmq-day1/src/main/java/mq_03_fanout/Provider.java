package mq_03_fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.RabbitMqUtil;

import java.io.IOException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/27
 */

//广播消息
public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        //交换机 名称 和 类型  fanout为广播
        channel.exchangeDeclare("logs", "mq_03_fanout");

        //发送消息
        channel.basicPublish("logs","",null,"mq_03_fanout type message".getBytes());

        RabbitMqUtil.closeConnectionAndChannel(connection,channel);
    }

}
