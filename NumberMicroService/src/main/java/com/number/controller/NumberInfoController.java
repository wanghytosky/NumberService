package com.number.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public BaseEntity searchNumberInfo(@RequestParam(required = true) String phoneNumber){
		return numberInfoService.searchNumberInfoByPhoneNumber(phoneNumber);
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public BaseEntity updateNumberInfo(NumberInfoEntity numberInfoEntity){
		BaseEntity updateResult = new BaseEntity();
		//手机号和numid至少有一个
		if(numberInfoService.updateNumberInfo(numberInfoEntity)){
			updateResult.success();
		}
		return updateResult;
	}
}
