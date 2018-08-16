package com.himalaya.mapreduce.flowsort;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月9日 下午4:11:36
* Description
*/
public class FlowSortReducer extends Reducer<FlowBean, Text, Text, FlowBean>{

	@Override
	protected void reduce(FlowBean key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		
		context.write(values.iterator().next(), key);
	}
}
