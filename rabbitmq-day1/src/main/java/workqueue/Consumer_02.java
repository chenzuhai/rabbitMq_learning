package workqueue;

import com.rabbitmq.client.*;
import util.RabbitMqUtil;

import java.io.IOException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/27
 */

public class Consumer_02 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("workQueue",true,false,false,null);

        channel.basicConsume("workQueue",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2=>"+new String(body));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
