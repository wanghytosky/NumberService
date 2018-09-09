package com.number.service;

import com.number.entity.BaseEntity;
import com.number.entity.CustomerEntity;

public interface ICustomerService {
	
	boolean createCustomer(CustomerEntity cusEntity);
	
	BaseEntity updateCustomer(CustomerEntity cusEntity);
}

