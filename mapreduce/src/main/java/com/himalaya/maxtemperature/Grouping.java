package com.himalaya.maxtemperature;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月27日 上午10:58:22
* Description
*/
public class Grouping extends WritableComparator{

	public Grouping() {
		super(KeyPair.class, true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		
		KeyPair key1 = (KeyPair)a;
		KeyPair key2 = (KeyPair)b;
		return Integer.compare(key1.getYear(), key2.getYear());
	}
}
