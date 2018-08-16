package com.himalaya.mapreduce.statistic;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.jasper.tagplugins.jstl.core.Out;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月9日 上午11:02:52
* Description
*/
public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

	Text outKey = new Text();
	FlowBean outValue = new FlowBean();
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		// read a line
		String line = value.toString();
		
		// split 
		String[] fields = line.split("\t");
		
		// enclosure a object
		String phoneNum = fields[1];
		
		// write out data
		long upFlow = Long.parseLong(fields[fields.length - 3]);
		long downFlow = Long.parseLong(fields[fields.length - 2]);
		
		outKey.set(phoneNum);
		outValue.set(upFlow, downFlow);
		
		context.write(outKey, outValue);
	}
}
