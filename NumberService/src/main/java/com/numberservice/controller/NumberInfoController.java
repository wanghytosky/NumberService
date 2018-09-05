package com.numberservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class NumberInfoController {
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public Object createNumberInfo(){
		Object createResultObj = new Object();
		return createResultObj;
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public Object searchNumberInfo(){
		Object searchResultObj = new Object();
		return searchResultObj;
	}
	
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public Object deleteNumberInfo(){
		Object deleteResultObj = new Object();
		return deleteResultObj;
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public Object updateNumberInfo(){
		Object updateResultObj = new Object();
		return updateResultObj;
	}
	
	@RequestMapping(path = "/bind", method = RequestMethod.POST)
	public Object bindNumberInfo(){
		Object bindResultObj = new Object();
		return bindResultObj;
	}
}
