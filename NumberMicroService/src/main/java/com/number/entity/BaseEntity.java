package com.number.entity;

import io.swagger.annotations.ApiParam;

public class BaseEntity {
	
	@ApiParam(value = "The specific detail of the exception.")
	private String errorMsg;
	
	@ApiParam(value = "errorCode : -2->CustomException,-1->SystemException, 0->success.")
	private int errorCode;
	
	@ApiParam(value = "success:true, failed:false")
	private boolean isSuccess;

	public BaseEntity(){}
	
	public void success(){
		errorMsg = "";
		errorCode = 0;
		isSuccess = true;		
	}
	
	public BaseEntity(String errMsg, int errCode, boolean isSuccess){
		this.errorMsg = errMsg;
		this.errorCode = errCode;
		this.isSuccess = isSuccess;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
}
