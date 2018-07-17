package com.himalaya.service;

import java.util.List;

import com.himalaya.entity.CheckTask;
import com.himalaya.entity.CheckTaskQueryParam;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月16日 下午8:04:47
* Description
*/
public interface CheckTaskService {

	public void add(CheckTask checkTask);
	public void delete(long taskId);
	public void update(CheckTask task);
	public List<CheckTask> list(CheckTaskQueryParam queryParam);
}