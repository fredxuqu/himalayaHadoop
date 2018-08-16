package com.himalaya.mapreduce.statistic;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月9日 上午10:54:13
* Description
*/
public class FlowBean implements Writable {

	private long upFlow;
	private long downFlow;
	private long sumFlow;
	
	public FlowBean() {
		super();
	}
	
	public FlowBean(long upFlow, long downFlow) {
		super();
		this.upFlow = upFlow;
		this.downFlow = downFlow;
		this.sumFlow = upFlow + downFlow;
	}
	
	public void set(long upFlow, long downFlow) {
		this.upFlow = upFlow;
		this.downFlow = downFlow;
		this.sumFlow = upFlow + downFlow;
	}


	// 序列化
	@Override
	public void readFields(DataInput input) throws IOException {
		this.upFlow = input.readLong();
		this.downFlow = input.readLong();
		this.sumFlow = input.readLong();
	}
	
	// 反序列化
	@Override
	public void write(DataOutput output) throws IOException {
		output.writeLong(upFlow);
		output.writeLong(downFlow);
		output.writeLong(sumFlow);
	}
	
	public String toString(){		
		return upFlow + "\t" + downFlow +"\t" + sumFlow;
	}

	/**
	 * @return the upFlow
	 */
	public long getUpFlow() {
		return upFlow;
	}

	/**
	 * @param upFlow the upFlow to set
	 */
	public void setUpFlow(long upFlow) {
		this.upFlow = upFlow;
	}

	/**
	 * @return the downFlow
	 */
	public long getDownFlow() {
		return downFlow;
	}

	/**
	 * @param downFlow the downFlow to set
	 */
	public void setDownFlow(long downFlow) {
		this.downFlow = downFlow;
	}

	/**
	 * @return the sumFlow
	 */
	public long getSumFlow() {
		return sumFlow;
	}

	/**
	 * @param sumFlow the sumFlow to set
	 */
	public void setSumFlow(long sumFlow) {
		this.sumFlow = sumFlow;
	}
}
