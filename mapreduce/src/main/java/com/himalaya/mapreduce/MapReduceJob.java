package com.himalaya.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月18日 下午5:55:35
* Description
*/
public class MapReduceJob {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.set("", "node1:9001");
		
		try {
			Job job = Job.getInstance(conf);
			job.setJarByClass(MapReduceJob.class);
			job.setMapperClass(WordCountMapper.class);
			job.setReducerClass(WordCountReduce.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);
			
			FileInputFormat.addInputPath(job, new Path("/usr/input/wordcount"));
			
			FileOutputFormat.setOutputPath(job, new Path("/usr/output/wordcount"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
