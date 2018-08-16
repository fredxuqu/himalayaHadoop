package com.himalaya.mapreduce.flowsort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月9日 下午3:19:02
* Description
*/
public class FlowSortPartitioner extends Partitioner<FlowBean, Text> {

	@Override
	public int getPartition(FlowBean key, Text value, int numPartitions) {
		
		int partition = 4;
		
		String province = value.toString().substring(0,3);
		
		if("136".equals(province)){
			partition = 0;
		} else if("137".equals(province)){
			partition = 1;
		} else if("138".equals(province)){
			partition = 2;
		} else if("139".equals(province)){
			partition = 3;
		} 
		return partition;
	}
}
