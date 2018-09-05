package com.numberservice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusControler {
	
	@RequestMapping(path = "/get", method = RequestMethod.GET)
	public Object getStatus(){
		Object statusResultObj = new Object();
		return statusResultObj;
	}
	
	@RequestMapping(path = "/histories", method = RequestMethod.POST)
	public Object getHistories(){
		Object historiesResultObj = new Object();
		return historiesResultObj;
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public Object updateStatus(){
		Object updateResultObj = new Object();
		return updateResultObj;
	}
}
