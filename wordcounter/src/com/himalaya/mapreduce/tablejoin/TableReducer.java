package com.himalaya.mapreduce.tablejoin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月13日 下午2:45:25
* Description
*/
public class TableReducer extends Reducer<Text, TableBean, TableBean, NullWritable> {

	@Override
	protected void reduce(Text key, Iterable<TableBean> values,
			Context context) throws IOException, InterruptedException {
		// 1001	01	1
		// 01	name
		ArrayList<TableBean> orderBeans = new ArrayList<>();
		TableBean pdBean = new TableBean();
		
		for (TableBean value : values) {
			
			// order table
			if("0".equals(value.getFlag())){
				TableBean orderBean = new TableBean();
				try {
					BeanUtils.copyProperties(orderBean, value);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
				orderBeans.add(orderBean);
				
			} else { // product table
				try {
					BeanUtils.copyProperties(pdBean, value);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}			
		}
		
		for (TableBean orderBean : orderBeans) {
			orderBean.setpName(pdBean.getpName());
			context.write(orderBean, NullWritable.get());
		}
	}
}