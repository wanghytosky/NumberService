package com.number.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiParam;

/**
 * Entity for customerinfo table
 * @author wanghy
 *
 */
public class CustomerEntity extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiParam(value = "primary key, id of each customer.")
	private int cus_id;
	
	@ApiParam(value = "name of each customer.")
	private String cus_name;
	
	@ApiParam(value = "passport number of the customer")
	private String passport_number;
	
	@ApiParam(value = "the expired time of the customer's passport")
	private String passport_expiredTime;

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
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

	
}
