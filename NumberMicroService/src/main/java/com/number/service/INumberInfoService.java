package com.number.service;


import com.number.entity.NumberInfoEntity;

public interface INumberInfoService {
	
	boolean createNumber(NumberInfoEntity numberInfo);
	
	NumberInfoEntity searchNumberInfoByPhoneNumber(String phoneNumber);

	boolean updateNumberInfo(NumberInfoEntity numberInfo);
}

