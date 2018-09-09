package com.number.service.impl;



import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.number.common.DateUtil;
import com.number.common.Validator;
import com.number.dao.HistoryMapper;
import com.number.dao.NumberInfoMapper;
import com.number.entity.HistoryEntity;
import com.number.entity.NumberInfoEntity;
import com.number.service.INumberInfoService;


@Service("numberInfoService")
public class NumberInfoServiceImpl implements INumberInfoService {
	
	@Autowired
	private NumberInfoMapper numberInfoMapper;
	
	@Autowired
	private HistoryMapper historyMapper;
	
	@Override
	public boolean createNumber(NumberInfoEntity numberInfo) {
		//validate the phone number, must be number and length between 8 and 10
		if(numberInfo == null || !Validator.isMobile(numberInfo.getPhone_number())){
			return false;
		}
		numberInfo.setCreate_time(DateUtil.getStringDate());
		numberInfoMapper.createNumberInfo(numberInfo);
		return numberInfo.getNum_id() > 0 ? true : false;
	}

	@Override
	public NumberInfoEntity searchNumberInfo(String phoneNumber, int num_id) {
		NumberInfoEntity numInfoEntity = new NumberInfoEntity();
		if((StringUtils.isNotEmpty(phoneNumber) && Validator.isMobile(phoneNumber)) || num_id > 0){
		    numInfoEntity= numberInfoMapper.getNumberInfo(phoneNumber,num_id);
			if(numInfoEntity.getNum_id() > 0){
				numInfoEntity.success();
			}
		}
		
		return numInfoEntity;
	}

	@Transactional
	@Override
	public boolean updateNumberInfo(NumberInfoEntity numberInfo) {
		
		int flag = numberInfoMapper.updateMemberInfo(numberInfo);
		if(flag > 0){//update successfully,then insert a record into history table.
			numberInfo = numberInfoMapper.getNumberInfo(numberInfo.getPhone_number(),numberInfo.getNum_id());
			HistoryEntity hisEntity = new HistoryEntity();
			hisEntity.setService_id(numberInfo.getService_id());
			hisEntity.setNum_id(numberInfo.getNum_id());
			hisEntity.setCus_id(numberInfo.getCus_id());
			hisEntity.setStatus_id(numberInfo.getStatus_id());
			hisEntity.setCreate_time(DateUtil.getStringDate());
			historyMapper.insertHistory(hisEntity);
			return true;
		}
		
		return false;
	}
	
}
