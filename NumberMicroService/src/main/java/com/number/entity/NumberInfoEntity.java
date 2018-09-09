package com.number.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiParam;

/**
 * Entity for numberinfo table
 * @author wanghy
 *
 */
public class NumberInfoEntity extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiParam(value = "primary key, id of each number.")
	private int num_id;
	
	@ApiParam(value = "phone number.")
	private String phone_number;
	
	@ApiParam(value = "foreign key to customer table.")
	private int cus_id;
	
	@ApiParam(value = "0: available 1: in use; 2: pause; 3: disabled")
	private int status_id;
	
	@ApiParam(value = "0->Prepaid 1->contact .")
	private int service_id;
	
	@ApiParam(value = "the number usage state.")
	private String create_time;
	
	@ApiParam(value = "The expire date of the number.")
	private String expired_time;

	public int getNum_id() {
		return num_id;
	}

	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	
	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getExpired_time() {
		return expired_time;
	}

	public void setExpired_time(String expired_time) {
		this.expired_time = expired_time;
	}
}
