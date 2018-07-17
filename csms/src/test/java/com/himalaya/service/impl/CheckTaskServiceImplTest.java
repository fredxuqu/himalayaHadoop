package com.himalaya.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.BaseTestCase;
import com.himalaya.entity.CheckTask;
import com.himalaya.entity.CheckTaskQueryParam;


/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年7月26日 上午11:05:36
* Description
*/
public class CheckTaskServiceImplTest extends BaseTestCase {
	
	@Autowired
	CheckTaskServiceImpl service;
	 
	@Test
    public void testList(){
    	CheckTaskQueryParam queryParam = new CheckTaskQueryParam();
    	queryParam.setPageNum(10);
    	queryParam.setPageSize(10);
    	List<CheckTask> list = service.list(queryParam);
    	System.out.println(list.size());
    }
	
    @Test
    public void testAdd(){
    	CheckTask checkTask = new CheckTask();
    	checkTask.setId(new Long(101));
    	checkTask.setTaskName("三小检查");
    	checkTask.setDescription("检查描述");
    	checkTask.setCheckListId(1l);
    	checkTask.setExecutor("Fred");
    	checkTask.setStatus("p");
    	checkTask.setType(1);
    	service.add(checkTask);
    }
    
    @Test
    public void testUpdate(){
    	CheckTask checkTask = new CheckTask();
    	checkTask.setId(new Long(101));
    	checkTask.setTaskName("三小检查");
    	checkTask.setDescription("检查描述UPDATED");
    	checkTask.setCheckListId(1l);
    	checkTask.setExecutor("Fred");
    	checkTask.setStatus("p");
    	checkTask.setType(1);
    	service.update(checkTask);
    }
    
    @Test
    public void testDelete(){
    	service.delete(new Long(101));
    }
}
