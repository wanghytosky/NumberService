package com.numberservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@RequestMapping(path = "/get", method = RequestMethod.GET)
	public Object getCustomer(){
		Object customerResultObj = new Object();
		return customerResultObj;
	}
	
	@RequestMapping(path = "/delete", method = RequestMethod.DELETE)
	public Object deleteCustomer(){
		Object deleteResultObj = new Object();
		return deleteResultObj;
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public Object updateCustomer(){
		Object updateResultObj = new Object();
		return updateResultObj;
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public Object addCustomer(){
		Object addResultObj = new Object();
		return addResultObj;
	}
}
