package com.number.dao;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import com.number.entity.CustomerEntity;

@Mapper
public interface CustomerMapper {
	@Insert(value = "INSERT INTO CustomerInfo(cus_name,passport_number,passport_expiredTime) VALUES ()")
	@Options(useGeneratedKeys=true, keyProperty = "cus_id", keyColumn = "cus_id")
	public void createCustomer(CustomerEntity cusEntity);
	
	@UpdateProvider(type = CustomerSqlBuilder.class, method = "buildUpdateCustomerSql")
	public int updateCustomer(CustomerEntity cusEntity);
	
	public static class CustomerSqlBuilder{
	    public static String buildUpdateCustomerSql(CustomerEntity cusEntity) {
	    	SQL sql = new SQL() {
	            {
	               UPDATE("customer");
	               if(cusEntity.getCus_id() > 0){
	            	   SET("cus_name=#{cus_name}");
	               }
	               if(StringUtils.isNotEmpty(cusEntity.getPassport_number())){
	            	   SET("passport_number=#{passport_number}");
	               }
	               if(StringUtils.isNotEmpty(cusEntity.getPassport_expiredTime())){
	            	   SET("expired_time=#{expired_time}");
	               }
	               WHERE("cus_id=#{cus_id}");
	            }
	         };
	         return sql.toString();
	      }
	}
}
