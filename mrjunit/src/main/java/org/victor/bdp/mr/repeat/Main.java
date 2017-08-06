package org.victor.bdp.mr.repeat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.victor.bdp.mr.sort.Sort;

import java.io.IOException;

/**
 * Created by zhengcunwen on 2017/7/18.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();

        if(args.length != 2){
            System.err.println("Usage: repeat <in> <out> ");
            System.exit(2);
        }

        Job job = Job.getInstance(configuration,"repeat mr");

        job.setJarByClass(Sort.class);
        job.setMapperClass(RepeatMapper.class);
        job.setReducerClass(RepeatReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
