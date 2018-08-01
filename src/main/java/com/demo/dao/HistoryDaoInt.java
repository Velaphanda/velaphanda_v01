package com.demo.dao;

import java.util.List;

import com.demo.bean.HistoryBean;
import com.demo.model.History;

public interface HistoryDaoInt {

	String saveHistory(HistoryBean history);
	List<History> getAllHistoryByCustomer();
	List<History> getHistoryByCustomer(String customerName);
	List<History> getAllHistoryBySerialNumber();
	List<History> getHistoryBySerialNumber(String serialNumber);
	List<History> getHistoryByPartNumber(String partNumber);
	List<History> getAllHistoryByPartNumber();
}
