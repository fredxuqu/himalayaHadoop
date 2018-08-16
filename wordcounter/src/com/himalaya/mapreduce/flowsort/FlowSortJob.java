package com.himalaya.mapreduce.flowsort;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月9日 下午4:14:18
* Description
*/
public class FlowSortJob {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		// 1 获取job对象
		Configuration configuration = new Configuration();
		Job job = Job.getInstance(configuration);
		
		// 2 设置jar包路径
		job.setJarByClass(FlowSortJob.class);
		
		// 3 管理mapper 和 reducer类
		job.setMapperClass(FlowSortMapper.class);
		job.setReducerClass(FlowSortReducer.class);
		
		// 4 设置mapper输出的kv类型
		job.setMapOutputKeyClass(FlowBean.class);
		job.setMapOutputValueClass(Text.class);
		
		// 5 设置最终的输出kv类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FlowBean.class);
		
		// 6 设置分区
		job.setPartitionerClass(FlowSortPartitioner.class);
		job.setNumReduceTasks(5); // Reduce Task 的个数要么为1，要么和分区一致，否则就会出错。
				
		// 7 设置输入输出路径
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
	
		// 8 submit
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}
}
