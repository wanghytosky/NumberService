package com.number.common.exception;

public class CustomException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
