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
public class Sorting extends WritableComparator{

	public Sorting() {
		super(KeyPair.class, true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		
		KeyPair key1 = (KeyPair)a;
		KeyPair key2 = (KeyPair)b;
		int result = Integer.compare(key1.getYear(), key2.getYear());
		if(result != 0 ){
			return result;
		}
		return -Integer.compare(key1.getDegree(), key2.getDegree());
	}
}
