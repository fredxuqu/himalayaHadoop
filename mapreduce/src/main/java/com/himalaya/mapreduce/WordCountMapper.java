package com.himalaya.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2018年7月18日 
 * 下午4:39:29 
 * Description
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private Text word = new Text();
	
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		
		StringTokenizer itr = new StringTokenizer(value.toString());
		
		while (itr.hasMoreTokens()) {
			word.set(itr.nextToken());
			context.write(word, new IntWritable(1));
		}
	}
}
