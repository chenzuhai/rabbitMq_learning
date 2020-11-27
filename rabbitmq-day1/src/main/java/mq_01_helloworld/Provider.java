package mq_01_helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;
import util.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/26
 */

public class Provider {

    //生产消息的代码
    @Test
    public void testSendMessage() throws IOException, TimeoutException {

        Connection connection = RabbitMqUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //绑定对应的消息队列
        //参数1：名字
        //参数2：是否持久化
        //参数3：exclusive ，是否独占这个队列
        //参数4：autoDelete,是否消费完成后自动删除队列
        //参数5：附加参数
        channel.queueDeclare("hello1",true,false,false,null);
        channel.queueDeclare("hello2",false,false,true,null);

        //发布消息
        //参数1：交换机名称
        //参数2：队列名称
        //参数3：传递消息额外的设置
        //参数4：消息
        channel.basicPublish("","hello1", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello rabbitmq".getBytes());

        RabbitMqUtil.closeConnectionAndChannel(connection,channel);


    }
}
