package com.himalaya.entity;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2018年7月17日 上午10:18:09
 */
public class CheckTaskQueryParam {

    private CheckTask checkTask;
	private Integer pageNum;
	private Integer pageSize;
	
	public CheckTask getCheckTask() {
		return checkTask;
	}

	public void setCheckTask(CheckTask checkTask) {
		this.checkTask = checkTask;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
