package com.number.service;


import com.number.entity.NumberInfoEntity;

public interface INumberInfoService {
	
	boolean createNumber(NumberInfoEntity numberInfo);
	
	NumberInfoEntity searchNumberInfo(String phoneNumber, Integer num_id);

	boolean updateNumberInfo(NumberInfoEntity numberInfo);
}

