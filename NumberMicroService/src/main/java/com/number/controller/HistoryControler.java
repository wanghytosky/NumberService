package com.number.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.number.entity.BaseEntity;
import com.number.service.IHistoryService;

@RestController
@RequestMapping("/history")
public class HistoryControler {
	
	@Autowired
	private IHistoryService historyService;
	
	@RequestMapping(path = "/search/{num_id}", method = RequestMethod.GET)
	public BaseEntity seatchHistories(@PathVariable(value = "num_id") int num_id){
		return historyService.searchHistories(num_id);
	}
}
