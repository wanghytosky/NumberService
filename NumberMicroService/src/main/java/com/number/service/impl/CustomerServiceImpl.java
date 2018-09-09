package com.number.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.number.common.Validator;
import com.number.dao.CustomerMapper;
import com.number.entity.CustomerEntity;
import com.number.service.ICustomerService;


@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	

	@Override
	public boolean createCustomer(CustomerEntity cusEntity) {
		//cus_name、passportNumber、passportexpiredtime cannot be empty.
		if(cusEntity == null 
				|| StringUtils.isEmpty(cusEntity.getCus_name())
				|| Validator.isUsername(cusEntity.getCus_name())
				|| StringUtils.isEmpty(cusEntity.getPassport_number())
				|| StringUtils.isEmpty(cusEntity.getPassport_expiredTime())){
			return false;
		}
		customerMapper.createCustomer(cusEntity);
		return cusEntity.getCus_id() > 0 ? true : false;
	}


	@Override
	public CustomerEntity updateCustomer(CustomerEntity cusEntity) {
		if(cusEntity !=null && Validator.isUsername(cusEntity.getCus_name())){//validate the user name.only support english name for now
			int count = customerMapper.updateCustomer(cusEntity);
			if(count > 0){
				cusEntity.success();
			}
		}
		return cusEntity;
	}
	
}
