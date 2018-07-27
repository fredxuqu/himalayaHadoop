package com.himalaya.maxtemperature;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月27日 下午3:48:24
* Description
*/
public class MaxTemperatureMapper extends Mapper<LongWritable, Text, KeyPair, Text> {
	
	public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH24:MM:SS");
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, KeyPair, Text>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] array = line.split("\t");
		if(array.length == 2 ){
			try {
				Date date = SDF.parse(array[0]);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int year = calendar.get(Calendar.YEAR);
				
				int degree = Integer.parseInt(array[1].substring(0, array[1].indexOf("'C")));
				
				KeyPair kPair = new KeyPair();
				kPair.setYear(year);
				kPair.setDegree(degree);
				context.write(kPair, value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
