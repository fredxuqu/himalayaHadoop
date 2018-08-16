package com.himalaya.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月10日 下午3:52:53
* Description
*/
public class WordCountCombiner extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		
		int sum = 0;
		
		// 汇总
		for (IntWritable value : values) {
			sum += value.get();
		}
		
		// 输出
		context.write(key, new IntWritable(sum));
	}
}
