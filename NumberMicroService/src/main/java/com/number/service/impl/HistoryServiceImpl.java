package com.number.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.number.dao.HistoryMapper;
import com.number.entity.HistoryListEntity;
import com.number.entity.HistorySearchEntity;
import com.number.service.IHistoryService;

@Service("historyService")
public class HistoryServiceImpl implements IHistoryService {

	@Autowired
	private HistoryMapper historyMapper;
	
	@Override
	public HistoryListEntity searchHistories(int num_id) {
		HistoryListEntity hisListEntity = new HistoryListEntity();
		if(num_id > 0){
			List<HistorySearchEntity> hisList= historyMapper.searchHistories(num_id);
			hisListEntity.setHistories(hisList);
			hisListEntity.success();
		}
		return hisListEntity;
	}

}
