package com.simple.stock.bo.impl;

import java.util.List;

import com.simple.stock.bo.StockBo;
import com.simple.stock.dao.StockDao;
import com.simple.stock.model.Stock;

public class StockBoImpl implements StockBo {
	
	StockDao stockDao;
	
	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}

	public void save(Stock stock){
		stockDao.save(stock);
	}
	
	public void update(Stock stock){
		stockDao.update(stock);
	}
	
	public void delete(Stock stock){
		stockDao.delete(stock);
	}
	
	public Stock findByStockCode(String stockCode){
		return stockDao.findByStockCode(stockCode);
	}

	public List<Stock> findAllStocks() {
		return stockDao.findAllStocks();
	}
}
