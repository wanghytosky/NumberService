package com.number.common.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.number.common.ErrorCode;
import com.number.entity.BaseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BaseEntity defultExcepitonHandler(Exception ex) {
		BaseEntity result;
		if(ex instanceof CustomException){
			result = new BaseEntity("custom exception : " + ex.getMessage(), ErrorCode.CUSTOM_EXCEPTION, false);
		} else {
			result = new BaseEntity("system exception : " + ex.getMessage(), ErrorCode.SYSTEM_EXCEPTION, false);
		}
		logger.error(ex.getMessage());
		return result;
	}
}
