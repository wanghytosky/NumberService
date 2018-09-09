package com.number.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.number.dao.NumberInfoMapper;
import com.number.entity.NumberInfoEntity;
import com.number.service.INumberInfoService;


@Service("numberInfoService")
public class NumberInfoServiceImpl implements INumberInfoService {
	
	@Autowired
	private NumberInfoMapper numberInfoMapper;
	
	@Override
	public boolean createNumber(NumberInfoEntity numberInfo) {
		java.util.Date nowTime = new java.util.Date();
		Date time = new Date(nowTime.getTime());
		numberInfo.setCreate_time(time.toString());
		numberInfoMapper.createNumberInfo(numberInfo);
		return numberInfo.getNum_id() > 0 ? true : false;
	}

	@Override
	public NumberInfoEntity searchNumberInfoByPhoneNumber(String phoneNumber) {
		NumberInfoEntity numInfoEntity= numberInfoMapper.getNumberInfoByPhoneNumber(phoneNumber);
		if(numInfoEntity.getNum_id() > 0){
			numInfoEntity.success();
		}
		return numInfoEntity;
	}

	@Override
	public boolean updateNumberInfo(NumberInfoEntity numberInfo) {
		int flag = numberInfoMapper.updateMemberInfo(numberInfo);
		return flag > 0 ? true : false;
	}
	
}
