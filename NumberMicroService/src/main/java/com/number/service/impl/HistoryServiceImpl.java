package com.number.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.number.dao.HistoryMapper;
import com.number.entity.HistoryListEntity;
import com.number.service.IHistoryService;

@Service("historyService")
public class HistoryServiceImpl implements IHistoryService {

	@Autowired
	private HistoryMapper historyMapper;
	
	@Override
	public HistoryListEntity searchHistories(int num_id) {
		HistoryListEntity hisListEntity= historyMapper.searchHistories(num_id);
		if(hisListEntity != null && hisListEntity.getHistories() != null){
			hisListEntity.success();
		}
		return hisListEntity;
	}

}
