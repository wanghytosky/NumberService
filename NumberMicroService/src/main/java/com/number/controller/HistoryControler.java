package com.number.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.number.entity.BaseEntity;
import com.number.service.IHistoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value="/history", tags="number history module")
@RestController
@RequestMapping("/history")
public class HistoryControler {
	
	@Autowired
	private IHistoryService historyService;
	
	@ApiImplicitParam(name = "num_id", value = "primary key, id of each number. ", required = true, dataType = "Integer", paramType = "query")
	@ApiOperation(value="search the histories of a specific number", notes = "search histories")
	@RequestMapping(path = "/search/{num_id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseEntity seatchHistories(@PathVariable("num_id") int num_id){
		return historyService.searchHistories(num_id);
	}
}
