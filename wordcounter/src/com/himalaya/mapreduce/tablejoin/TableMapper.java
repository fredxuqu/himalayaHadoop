package com.himalaya.mapreduce.tablejoin;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月13日 下午2:33:37
* Description
*/
public class TableMapper extends Mapper<LongWritable, Text, Text, TableBean> {

	Text outKey = new Text();
	TableBean outValue = new TableBean();
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		//区分两张表
		FileSplit split = (FileSplit) context.getInputSplit();
		String name = split.getPath().getName();
		
		// 获取一行
		String line = value.toString();
		
		// 订单表
		if(name.startsWith("order")){			
			// 切割
			String[] fields = line.split("\t");
			
			// 产品表
			outValue.setOrderId(fields[0]);
			outValue.setpId(fields[1]);
			outValue.setAmount(Integer.parseInt(fields[2]));
			outValue.setpName("");
			outValue.setFlag("0");
			
			outKey.set(fields[1]);
		} else {
			// 切割
			String[] fields = line.split("\t");
			
			// 产品表
			outValue.setOrderId("");
			outValue.setpId(fields[0]);
			outValue.setAmount(0);
			outValue.setpName(fields[1]);
			outValue.setFlag("1");
			
			outKey.set(fields[0]);
		}
		
		// 输出
		context.write(outKey, outValue);
	}
}
