package com.himalaya.controller;

import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.himalaya.domain.TaskCondition;
import com.himalaya.domain.TaskDO;
import com.himalaya.service.CheckTaskService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年1月16日 下午4:02:33
* Description
*/

@RestController
public class CheckTaskController {

	private final Logger logger = LoggerFactory.getLogger(CheckTaskController.class);

	@Autowired
	private CheckTaskService taskService;
		
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String index() {
		return "Spring boot & druid demo.";
	}

	@RequestMapping(value = "/tasks/list", 
				method = RequestMethod.GET, 
				produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String searchNews(@RequestBody TaskCondition condition) {

		logger.info("List All Records!");

		List<TaskDO> taskList = null;
		
		JSONArray resultJSON = null;

		try {
			taskList = taskService.list(condition);
			logger.info("Get " + taskList.size() + " records");
			resultJSON = new JSONArray(taskList);
			logger.debug("check tasks : {} ", resultJSON.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error("Check task searching error, msg:", e.getMessage());
		}

		return resultJSON.toString();
	}
}
