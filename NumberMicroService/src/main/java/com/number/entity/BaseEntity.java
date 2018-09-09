package com.number.entity;


public class BaseEntity {
	
	private String errorMsg;
	
	/**
	 * errorCode : -2->CustomException,-1->SystemException, 0->success
	 */
	private int errorCode;
	
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
