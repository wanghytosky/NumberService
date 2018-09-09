package com.number.entity;

import java.io.Serializable;


/**
 * Entity for customerinfo table
 * @author wanghy
 *
 */
public class CustomerEntity extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cus_id;
	
	private int cus_name;
	
	private String passport_number;
	
	private String passport_expiredTime;

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public int getCus_name() {
		return cus_name;
	}

	public void setCus_name(int cus_name) {
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

	
}