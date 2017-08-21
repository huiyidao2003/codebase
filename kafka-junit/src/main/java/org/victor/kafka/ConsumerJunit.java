package org.victor.kafka;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

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

    public static void main(String[] args) {
        ConsumerJunit consumerThread = new ConsumerJunit("my-replicated-topic5");
        consumerThread.start();
    }
    public ConsumerJunit(String topic) {
        consumer =kafka.consumer.Consumer.createJavaConsumerConnector(createConsumerConfig());
        this.topic =topic;
    }

    private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        // 设置zookeeper的链接地址
        props.put("zookeeper.connect","d1.datammd.com:2181");
        //props.put("zookeeper.connect","kafka:2181");
        // 设置group id
        props.put("group.id", "1");
        // kafka的group 消费记录是保存在zookeeper上的, 但这个信息在zookeeper上不是实时更新的, 需要有个间隔时间更新
        props.put("auto.commit.interval.ms", "1000");
        props.put("zookeeper.session.timeout.ms","10000");
        return new ConsumerConfig(props);
    }

    public void run(){
        //设置Topic=>Thread Num映射关系, 构建具体的流
        Map<String,Integer> topickMap = new HashMap<String, Integer>();
        topickMap.put(topic, 1);
        Map<String, List<KafkaStream<byte[],byte[]>>>  streamMap=consumer.createMessageStreams(topickMap);

        KafkaStream<byte[],byte[]>stream = streamMap.get(topic).get(0);
        ConsumerIterator<byte[],byte[]> it =stream.iterator();
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
