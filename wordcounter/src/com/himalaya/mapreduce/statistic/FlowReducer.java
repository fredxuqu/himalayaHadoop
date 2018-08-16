package com.himalaya.mapreduce.statistic;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月9日 上午11:11:44
* Description
*/
public class FlowReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
	
	@Override
	protected void reduce(Text key, Iterable<FlowBean> values, Context context)
			throws IOException, InterruptedException {
		
		long upFlowSum = 0;
		long downFlowSum = 0;
		
		// 1.	求和
		for (FlowBean flowBean : values) {
			upFlowSum += flowBean.getUpFlow();
			downFlowSum += flowBean.getDownFlow();
		}
		
		FlowBean flowBean = new FlowBean(upFlowSum, downFlowSum);
		
		// 2.	输出
		context.write(key, flowBean);
	}
}
