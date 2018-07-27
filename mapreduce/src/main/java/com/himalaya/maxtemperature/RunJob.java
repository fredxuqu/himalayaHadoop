package com.himalaya.maxtemperature;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月27日 上午11:17:15
* Description
*/
public class RunJob {
		
	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		
		try {
			Job job = Job.getInstance(conf);
			job.setJobName("temp");
			job.setJarByClass(RunJob.class);
			job.setMapperClass(MaxTemperatureMapper.class);
			job.setReducerClass(MaxTemperatureReducer.class);
			job.setMapOutputKeyClass(KeyPair.class);
			job.setMapOutputValueClass(Text.class);
			
			job.setNumReduceTasks(3);
			job.setPartitionerClass(TemperaturePartitioner.class);
			job.setSortComparatorClass(Sorting.class);
			job.setGroupingComparatorClass(Grouping.class);
			
			FileInputFormat.addInputPath(job, new Path("/usr/input/temp"));
			FileOutputFormat.setOutputPath(job, new Path("/usr/output/temp"));
			System.exit(job.waitForCompletion(true) ? 0 : 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
