package com.number.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.number.common.Validator;
import com.number.entity.BaseEntity;
import com.number.entity.NumberInfoEntity;
import com.number.service.INumberInfoService;

@RestController
@RequestMapping("/number")
public class NumberInfoController {
	
	@Autowired
	private INumberInfoService numberInfoService;
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	@ResponseBody
	public BaseEntity createNumberInfo(NumberInfoEntity numberInfoEntity){
		if(numberInfoService.createNumber(numberInfoEntity)){
			numberInfoEntity.success();
		}
		return numberInfoEntity;
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public BaseEntity searchNumberInfo(@RequestParam(value="phoneNumber", required=false) String phoneNumber, @RequestParam(value="num_id", required=false) Integer num_id){
		return numberInfoService.searchNumberInfo(phoneNumber,num_id);
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public BaseEntity updateNumberInfo(NumberInfoEntity numberInfoEntity){
		BaseEntity updateResult = new BaseEntity();
		if(numberInfoEntity.getNum_id() > 0 && !StringUtils.isNullOrEmpty(numberInfoEntity.getPhone_number())){
			if(numberInfoService.updateNumberInfo(numberInfoEntity)){
				updateResult.success();
			}
		}
		return updateResult;
	}
}
