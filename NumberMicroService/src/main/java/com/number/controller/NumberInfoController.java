package com.number.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.number.entity.BaseEntity;
import com.number.entity.NumberInfoEntity;
import com.number.service.INumberInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="/number", tags="number information module")
@RestController
@RequestMapping("/number")
public class NumberInfoController {
	
	@Autowired
	private INumberInfoService numberInfoService;
	
	@ApiOperation(value="create a new number", notes = "create a new number")
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	@ResponseBody
	public BaseEntity createNumberInfo(NumberInfoEntity numberInfoEntity){
		if(numberInfoService.createNumber(numberInfoEntity)){
			numberInfoEntity.success();
		}
		return numberInfoEntity;
	}
	
	
	@ApiOperation(value="search number information by a specific number or numberID", notes = "search number information by a specific number or numberID")
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	@ResponseBody
	public BaseEntity searchNumberInfo(@RequestParam(value="phoneNumber", required=false) String phoneNumber, @RequestParam(value="num_id", required=false) Integer num_id){
		return numberInfoService.searchNumberInfo(phoneNumber,num_id);
	}
	
	@ApiOperation(value="update the number information by specific numberID", notes = "update the number information by specific numberID")
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	@ResponseBody
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
