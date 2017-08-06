package org.victor.bdp.mr.repeat;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by zhengcunwen on 2017/7/18.
 */
public class RepeatMapper extends Mapper<Object,Text,Text,Text> {
    private static Text line = new Text();//每行数据

    //实现map函数
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        line = value;

        context.write(line, new Text(""));

    }
}
