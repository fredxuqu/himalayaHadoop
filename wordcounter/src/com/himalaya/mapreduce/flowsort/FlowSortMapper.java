package com.himalaya.mapreduce.flowsort;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月9日 下午4:04:26
* Description
*/
public class FlowSortMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
	
	FlowBean outKey = new FlowBean();
	Text outValue = new Text();
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		// read a line
		String line = value.toString();
		
		// split 
		String[] fields = line.split("\t");
				
		// write out data
		long upFlow = Long.parseLong(fields[1]);
		long downFlow = Long.parseLong(fields[2]);
		
		outKey.set(upFlow, downFlow);
		outValue.set(fields[0]);
		
		context.write(outKey, outValue);
	}
}
