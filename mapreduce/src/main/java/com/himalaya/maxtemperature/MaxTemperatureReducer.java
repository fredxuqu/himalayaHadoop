package com.himalaya.maxtemperature;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月27日 下午3:47:41
* Description
*/
public class MaxTemperatureReducer extends Reducer<KeyPair, Text, KeyPair, Text>{
	
	@Override
	protected void reduce(KeyPair key, Iterable<Text> value, Context context)
			throws IOException, InterruptedException {
		
		for (Text text : value) {
			context.write(key, text);
		}
	}
}
