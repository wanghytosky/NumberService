package com.number.entity;

import java.io.Serializable;
import java.util.List;

public class HistoryListEntity extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<HistorySearchEntity> histories;

	public List<HistorySearchEntity> getHistories() {
		return histories;
	}

	public void setHistories(List<HistorySearchEntity> histories) {
		this.histories = histories;
	}
	
	
	
}
