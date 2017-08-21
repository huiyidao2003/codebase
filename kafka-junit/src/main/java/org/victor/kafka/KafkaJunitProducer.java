package org.victor.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by zhengcunwen on 2017/8/20.
 */
public class KafkaJunitProducer{
    private static final String TOPIC = "my-replicated-topic5"; //kafka创建的topic
    private Properties prop;

    /**
     * 初始化配置
     */
    public void initConfig(String path){
        prop =  new  Properties();
        //InputStream in = KafkaJunitProducer.class .getResourceAsStream( "/producer.properties" );
        try  {
            // 读配置文件的绝对路径
            FileInputStream in = new FileInputStream(path);
            prop.load(in);
        }  catch  (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送topic
     */
    public void sendTopic(){
        ProducerConfig config = new ProducerConfig(prop);
        Producer<String, String> producer = new Producer<String, String>(config);

        //Send one message.
        KeyedMessage<String, String> message =
                new KeyedMessage<String, String>(TOPIC, "This is a single message");
        producer.send(message);

        //Send multiple messages.
        List<KeyedMessage<String,String>> messages =
                new ArrayList<KeyedMessage<String, String>>();
        for (int i = 0; i < 5; i++) {
            messages.add(new KeyedMessage<String, String>
                    (TOPIC, "Multiple message at a time. " + i));
        }
        producer.send(messages);
    }

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("main args error: must a producer.properties");
            System.exit(0);
        }

        KafkaJunitProducer producer = new KafkaJunitProducer();
        producer.initConfig(args[0]);
        producer.sendTopic();
    }
}
