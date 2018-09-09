package com.number.dao;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import com.number.entity.NumberInfoEntity;


@Mapper
public interface NumberInfoMapper {
	
	@Insert(value = "INSERT INTO NumberInfo(phone_number,cus_id,status_id,service_id,expired_time,create_time) VALUES (#{phone_number},#{cus_id},#{status_id},#{service_id},#{expired_time},#{create_time})")
	@Options(useGeneratedKeys=true, keyProperty = "num_id", keyColumn = "num_id")
	public void createNumberInfo(NumberInfoEntity numberInfo);
	
	@Select(value = "SELECT num_id,phone_number,cus_id,status_id,service_id,expired_time,create_time FROM NumberInfo WHERE phone_number=#{phone_number} or num_id=#{num_id}")
	public NumberInfoEntity getNumberInfo(@Param("phone_number") String phone_number,@Param("num_id") Integer num_id);
	
	@UpdateProvider(type = MemberInfoSqlBuilder.class, method = "buildUpdateNumberInfoSql")
	public int updateMemberInfo(NumberInfoEntity numberInfo);
	
	public static class MemberInfoSqlBuilder{
	    public static String buildUpdateNumberInfoSql(NumberInfoEntity numberInfo) {
	    	SQL sql = new SQL() {
	            {
	               UPDATE("numberInfo");
	               if(numberInfo.getCus_id() > 0){
	            	   SET("cus_id=#{cus_id}");
	               }
	               if(StringUtils.isNotEmpty(numberInfo.getExpired_time())){
	            	   SET("expired_time=#{expired_time}");
	               }
	               if(numberInfo.getStatus_id() > 0){
	            	   SET("status_id=#{status_id}");
	               }
	               if(numberInfo.getService_id() > 0){
	            	   SET("service_id=#{service_id}");
	               }
	               if(numberInfo.getNum_id() > 0){
	            	   WHERE("num_id=#{num_id}");
	               } else {
	            	   WHERE("phone_number=#{phone_number}");
	               }
	               
	            }
	         };
	         return sql.toString();
	      }
	}
}
