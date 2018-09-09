package com.number.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.number.entity.BaseEntity;
import com.number.entity.CustomerEntity;
import com.number.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="/customer", tags="customer information module")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	
	@ApiOperation(value="update customer information by customerID", notes = "update customer information by customerID")
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	@ResponseBody
	public BaseEntity updateCustomer(CustomerEntity cusEntity){
		customerService.updateCustomer(cusEntity);
		return cusEntity;
	}
	
	@ApiOperation(value="create a new customer record", notes = "create a new customer record")
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	@ResponseBody
	public BaseEntity addCustomer(CustomerEntity cusEntity){
		if(customerService.createCustomer(cusEntity)){
			cusEntity.success();
		}
		return cusEntity;
	}
}
