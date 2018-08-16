package com.himalaya.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月18日 下午5:55:35
* 	如果需要在本地运行的话，input 和 output 需要换成本地的路径
*	在run configuration 中定义 input 和 output 的位置
*/
public class MapReduceJob {

	public static void main(String[] args) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException {
		
		System.out.println("Begin mapreduce task......");
		
		// 获取job信息
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		
		// 获取jar包位置
		job.setJarByClass(MapReduceJob.class);
				
		// 关联自定义的mapper和reducer
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReduce.class);
		
		// 设置map输出数据类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		// 设置最终输出数据类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		// add combiner
		job.setCombinerClass(WordCountCombiner.class);
		
		// 设置数据输入和输出文件路径
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		// 提交job
//		job.submit();
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
		
		System.out.println("End mapreduce task......");
	}
}
