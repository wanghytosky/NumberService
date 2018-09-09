package com.number.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import com.number.entity.HistoryListEntity;

@Mapper
public interface HistoryMapper {
	@UpdateProvider(type = HistorySqlBuilder.class, method = "buildSeatchHistoriesSql")
	public HistoryListEntity searchHistories(int num_id);
	
	public static class HistorySqlBuilder{
	    public static String buildSeatchHistoriesSql(int num_id) {
	    	SQL sql = new SQL() {
	            {
	               SELECT("h.create_time","n.phone_number","c.cus_name","c.passport_number","c.passport_expiredTime","s.service_name","ns.status_name");
	               FROM("History as h");
	               INNER_JOIN("NumberInfo n ON n.num_id=h.num_id");
	               INNER_JOIN("CustomerInfo c ON c.cus_id=h.cus_id");
	               INNER_JOIN("Service s ON s.service_id=h.service_id");
	               INNER_JOIN("NumberStatus ns ON ns.status_id=h.status_id");
	               WHERE("h.num_id=#{num_id}");
	            }
	         };
	         return sql.toString();
	      }
	}
}
