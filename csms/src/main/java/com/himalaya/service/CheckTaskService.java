package com.himalaya.service;

import java.util.List;

import com.himalaya.domain.TaskCondition;
import com.himalaya.domain.TaskDO;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月16日 下午8:04:47
* Description
*/
public interface CheckTaskService {

	public void add(TaskDO task);
	public void delete(long taskId);
	public void update(TaskDO task);
	public List<TaskDO> list(TaskCondition condition);
}
