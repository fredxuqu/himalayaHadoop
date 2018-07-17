package com.himalaya.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.BaseTestCase;
import com.himalaya.entity.CheckTask;
import com.himalaya.entity.CheckTaskExample;
import com.himalaya.repository.CheckTaskDAO;


/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年7月26日 上午11:05:36
* Description
*/
public class CheckTaskDAOTest extends BaseTestCase {
	
	@Autowired
	CheckTaskDAO dao;
	
	@Test
	public void testCountAll(){
		
		long count = dao.countByExample(null);
		LOGGER.info("Task Count : " + count);
		Assert.assertEquals(0, count);
	}
	
	@Test
	public void testCountByCondition(){
		
		CheckTaskExample example = new CheckTaskExample();
		example.createCriteria().andTypeIsNotNull();
		Long count = dao.countByExample(example);
		LOGGER.info("Task Count : " + count);
	}
       
    @Test
    public void testSelectByPrimaryKeyNull(){
    	CheckTask task = dao.selectByPrimaryKey(new Long(100));
    	Assert.assertNull(task);
    }
    
    @Test
    public void testSelectByPrimaryKey(){
    	CheckTask task = dao.selectByPrimaryKey(new Long(1));
    	Assert.assertEquals(1l, task.getId().longValue());
    }
	
    @Test
    public void testInsert(){
    	for (int i = 0; i < 99; i++) {
    		CheckTask task = new CheckTask();
        	task.setId(new Long(i+1));
        	task.setTaskName("三小检查");
        	task.setDescription("检查描述");
        	task.setCheckListId(1l);
        	task.setExecutor("Fred");
        	task.setStatus("p");
        	task.setType(1);
        	dao.insert(task);
		}
    }
    
    @Test
    public void testUpdate(){
    	CheckTask task = new CheckTask();
    	task.setId(1L);
    	task.setTaskName("三小检查");
    	task.setDescription("检查描述");
    	task.setCheckListId(1l);
    	task.setExecutor("Fred");
    	task.setStatus("p");
    	task.setType(1);
    	task.setPictures("http://www.qiniu.com/s/sSSJpdks34js.jpg");
    	dao.updateByPrimaryKeySelective(task);
    }
 
    @Test
    public void testDelete(){
    	dao.deleteByPrimaryKey(1l);
    }
}
