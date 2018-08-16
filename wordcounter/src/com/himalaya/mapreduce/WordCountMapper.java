package com.himalaya.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2018年7月18日 
 * 下午4:39:29 
 * 输入的key LongWritable
 * 输入的value Text
 * 输出的key Text
 * 输出的value IntWritable
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	Text keyOut = new Text();
	IntWritable vOut = new IntWritable(1);
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		// 1. 一行内容转换成String
		String line = value.toString();
			
		// 切分单词
		String[] words = line.split(" ");
		
		// 循环写出到下一阶段
		for (String word : words) {
			keyOut.set(word);
			context.write(keyOut, vOut);
		}
	}
}
