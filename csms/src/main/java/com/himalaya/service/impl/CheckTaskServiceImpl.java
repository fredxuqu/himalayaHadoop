package com.himalaya.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.himalaya.entity.CheckTask;
import com.himalaya.entity.CheckTaskQueryParam;
import com.himalaya.repository.CheckTaskDAO;
import com.himalaya.service.CheckTaskService;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2018年7月16日 下午8:28:13 Description
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
public class CheckTaskServiceImpl implements CheckTaskService {

	@Resource
	private CheckTaskDAO checkTaskDAO;

	@Override
	public void add(CheckTask checkTask) {
		checkTaskDAO.insert(checkTask);
	}

	@Override
	public void delete(long taskId) {
		checkTaskDAO.deleteByPrimaryKey(taskId);
	}

	@Override
	public void update(CheckTask task) {
		checkTaskDAO.updateByPrimaryKeySelective(task);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CheckTask> list(CheckTaskQueryParam queryParam) {

		Integer pageNum = queryParam.getPageNum() != null ? queryParam.getPageNum() : 1;
		Integer pageSize = queryParam.getPageSize() != null ? queryParam.getPageSize() : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<CheckTask> list = checkTaskDAO.selectByExample(null);
		return list;
	}
}
