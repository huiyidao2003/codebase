package org.victor.bdp.mr.repeat;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by zhengcunwen on 2017/7/18.
 */
public class RepeatReducer extends Reducer<Text,Text,Text,Text> {
    //实现reduce函数

    public void reduce(Text key,Iterable<Text> values,Context context)
            throws IOException,InterruptedException{

        context.write(key, new Text(""));
    }
}
