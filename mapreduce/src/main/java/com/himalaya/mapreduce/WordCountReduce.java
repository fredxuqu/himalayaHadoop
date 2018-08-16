package com.himalaya.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月18日 下午5:47:39
* Description
*/
public class WordCountReduce extends Reducer<Text, IntWritable, Text, IntWritable>{

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		
		// 统计单词个数
		int sum = 0;
		
		for (IntWritable value : values) {
			sum = sum + value.get();
		}
		
		// 输出单词总个数
		context.write(key, new IntWritable(sum));
	}
}
