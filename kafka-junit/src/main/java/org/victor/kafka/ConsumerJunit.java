package org.victor.kafka;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zhengcunwen on 2017/8/21.
 */
public class ConsumerJunit extends Thread{

    private final ConsumerConnector consumer;
    private final String topic;
    private Properties props;

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("main args error: must a consumer.properties");
            System.exit(0);
        }

        ConsumerJunit consumerThread = new ConsumerJunit("my-replicated-topic5",args[0]);
        consumerThread.start();
    }
    public ConsumerJunit(String topic,String configPath) {
        initConfig(configPath);
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(createConsumerConfig());
        this.topic = topic;

    }

    /**
     * 初始化配置
     */
    public void initConfig(String configPath){
        props =  new  Properties();
        //InputStream in = KafkaJunitProducer.class .getResourceAsStream( "/producer.properties" );
        try  {
            // 读配置文件的绝对路径
            FileInputStream in = new FileInputStream(configPath);
            props.load(in);
        }  catch  (IOException e) {
            e.printStackTrace();
        }
    }


    private ConsumerConfig createConsumerConfig() {
        return new ConsumerConfig(props);
    }

    public void run(){
        //设置Topic=>Thread Num映射关系, 构建具体的流
        Map<String,Integer> topickMap = new HashMap<String, Integer>();
        topickMap.put(topic, 1);
        Map<String, List<KafkaStream<byte[],byte[]>>>  streamMap=consumer.createMessageStreams(topickMap);

        KafkaStream<byte[],byte[]>stream = streamMap.get(topic).get(0);
        ConsumerIterator<byte[],byte[]> it = stream.iterator();
        System.out.println("*********Results********");

        while(it.hasNext()){
            System.err.println("-----------------------------------get data:" +new String(it.next().message()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
