package com.himalaya.maxtemperature;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月27日 上午11:08:30
* Description
*/
public class TemperaturePartitioner extends Partitioner<KeyPair, Text>{

	@Override
	public int getPartition(KeyPair key, Text value, int numPartitions) {
		return (key.getYear() * 127) % numPartitions;
	}
}
