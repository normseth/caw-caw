package com.simple.stock.bo;

import java.util.List;

import com.simple.stock.model.Stock;

public interface StockBo {
	
	void save(Stock stock);
	
	void update(Stock stock);
	
	void delete(Stock stock);
	
	Stock findByStockCode(String stockCode);

	List<Stock> findAllStocks();

}
