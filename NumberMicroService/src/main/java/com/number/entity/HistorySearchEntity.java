package com.number.entity;

import java.io.Serializable;

public class HistorySearchEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String create_time;
	
	private String phone_number;
	
	private String cus_name;
	
	private String passport_number;
	
	private String passport_expiredTime;
	
	private String service_name;
	
	private String status_name;

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	public String getPassport_expiredTime() {
		return passport_expiredTime;
	}

	public void setPassport_expiredTime(String passport_expiredTime) {
		this.passport_expiredTime = passport_expiredTime;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	
	
}
