package com.number.entity;

import java.io.Serializable;
import java.util.List;

public class HistoryListEntity extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<HistoryEntity> histories;

	public List<HistoryEntity> getHistories() {
		return histories;
	}

	public void setHistories(List<HistoryEntity> histories) {
		this.histories = histories;
	}
	
	
	
}
