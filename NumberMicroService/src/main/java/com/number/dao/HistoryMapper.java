package com.number.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.number.entity.HistoryEntity;
import com.number.entity.HistorySearchEntity;

@Mapper
public interface HistoryMapper {
	@SelectProvider(type = HistorySqlBuilder.class, method = "buildSeatchHistoriesSql")
	public List<HistorySearchEntity> searchHistories(@Param("num_id") int num_id);
	
	@Insert(value = "insert into History(history_id,service_id,num_id,cus_id,status_id,create_time) values (#{history_id},#{service_id},#{num_id},#{cus_id},#{status_id},#{create_time})")
	@Options(useGeneratedKeys=true, keyProperty = "cus_id", keyColumn = "cus_id")
	public void insertHistory(HistoryEntity hisEntity);
	
	public static class HistorySqlBuilder{
	    public static String buildSeatchHistoriesSql(Map<String, Object> params) {
	    	SQL sql = new SQL() {
	            {
	               SELECT("h.create_time","n.phone_number","c.cus_name","c.passport_number","c.passport_expiredTime","s.service_name","ns.status_name");
	               FROM("History as h");
	               INNER_JOIN("NumberInfo n ON n.num_id=h.num_id");
	               INNER_JOIN("CustomerInfo c ON c.cus_id=h.cus_id");
	               INNER_JOIN("Service s ON s.service_id=h.service_id");
	               INNER_JOIN("NumberStatus ns ON ns.status_id=h.status_id");
	               WHERE("h.num_id="+params.get("num_id"));
	            }
	         };
	         return sql.toString();
	      }
	}
}
