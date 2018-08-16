package com.himalaya.mapreduce.tablejoin;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月13日 下午3:07:24
* Description
*/
public class TableJob {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// 1 获取job对象
		Configuration configuration = new Configuration();
		Job job = Job.getInstance(configuration);
		
		// 2 设置jar包路径
		job.setJarByClass(TableJob.class);
		
		// 3 管理mapper 和 reducer类
		job.setMapperClass(TableMapper.class);
		job.setReducerClass(TableReducer.class);
		
		// 4 设置mapper输出的kv类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(TableBean.class);
		
		// 5 设置最终的输出kv类型
		job.setOutputKeyClass(TableBean.class);
		job.setOutputValueClass(NullWritable.class);
				
		// 6 设置输入输出路径
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
	
		// 7 submit
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}
}
