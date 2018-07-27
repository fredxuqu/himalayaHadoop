package com.himalaya.maxtemperature;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月27日 上午10:47:34
* Description
*/
public class KeyPair implements WritableComparable<KeyPair>{

	private int year;
	private int degree;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		this.year = in.readInt();
		this.degree = in.readInt();
	}
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(year);
		out.writeInt(degree);
	}
	@Override
	public int compareTo(KeyPair o) {
		int result = Integer.compare(year, o.year);
		if(result != 0 ){
			return result;
		}
		return Integer.compare(degree , o.degree);
	}
	
	public String toString(){
		
		return year + " " + degree;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + degree;
		result = prime * result + year;
		return result;
	}
}
