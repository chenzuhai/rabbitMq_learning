package util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/11/26
 */

public class RabbitMqUtil {

    private static ConnectionFactory connectionFactory;


    //重量级资源，只执行一次
    static {
        //创建连接 MQ连接工厂
        connectionFactory = new ConnectionFactory();
        //需要设置连接的主机
        connectionFactory.setHost("192.168.31.184");
        connectionFactory.setPort(5672);
        //设置连接虚拟主机
        connectionFactory.setVirtualHost("/ems");
        //设置账号密码
        connectionFactory.setUsername("zuhai");
        connectionFactory.setPassword("zuhai");
    }
    //定义船舰连接的方法
    public static Connection getConnection(){
        try{
            return connectionFactory.newConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //关闭通道和连接
    public static void closeConnectionAndChannel(Connection connection, Channel channel){

        try{
            if(channel!=null){
                channel.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
