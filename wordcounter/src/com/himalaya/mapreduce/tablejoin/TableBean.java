package com.himalaya.mapreduce.tablejoin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年8月13日 下午2:24:24
* Description
*/
public class TableBean implements Writable {

	private String orderId;
	private String pId;
	private int amount;
	private String pName;
	private String flag;
	
	public TableBean() {
		super();
	}
	
	public TableBean(String orderId, String pId, int amount, String pName, String flag) {
		super();
		this.orderId = orderId;
		this.pId = pId;
		this.amount = amount;
		this.pName = pName;
		this.flag = flag;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(orderId);
		out.writeUTF(pId);
		out.writeInt(amount);
		out.writeUTF(pName);
		out.writeUTF(flag);
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		orderId = in.readUTF();
		pId = in.readUTF();
		amount = in.readInt();
		pName = in.readUTF();
		flag = in.readUTF();
	}
	
	public String toString(){
		return orderId + "\t" + pName + "\t" + amount +"\t";
	}
}
