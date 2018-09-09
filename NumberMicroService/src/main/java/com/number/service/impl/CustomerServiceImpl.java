package com.number.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.number.dao.CustomerMapper;
import com.number.entity.CustomerEntity;
import com.number.service.ICustomerService;


@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	

	@Override
	public boolean createCustomer(CustomerEntity cusEntity) {
		customerMapper.createCustomer(cusEntity);
		return cusEntity.getCus_id() > 0 ? true : false;
	}


	@Override
	public CustomerEntity updateCustomer(CustomerEntity cusEntity) {
		int count = customerMapper.updateCustomer(cusEntity);
		System.out.println(count);
		return cusEntity;
	}
	
}
