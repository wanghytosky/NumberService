package com.number.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.number.entity.BaseEntity;
import com.number.entity.CustomerEntity;
import com.number.service.ICustomerService;
import com.number.service.INumberInfoService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public BaseEntity updateCustomer(CustomerEntity cusEntity){
		customerService.updateCustomer(cusEntity);
		cusEntity.success();
		return cusEntity;
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	@ResponseBody
	public BaseEntity addCustomer(CustomerEntity cusEntity){
		if(customerService.createCustomer(cusEntity)){
			cusEntity.success();
		}
		return cusEntity;
	}
}
