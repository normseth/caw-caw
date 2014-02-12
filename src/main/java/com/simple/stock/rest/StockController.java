package com.simple.stock.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.simple.stock.bo.StockBo;
import com.simple.stock.model.Stock;

public class StockController extends HttpServlet {
	
	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
	{
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String code = request.getParameter("code");
		if (code == null) { 
			// LIST
			StockBo stockBo = (StockBo) appContext.getBean("stockBo");
			List<Stock> stocks = stockBo.findAllStocks();
			JSONArray obj = JSONArray.fromObject(stocks);
			out.println(obj.toString(4));
			return;
		}
		// RETRIEVE
		StockBo stockBo = (StockBo) appContext.getBean("stockBo");
		Stock s = stockBo.findByStockCode(code);
		JSONObject obj = JSONObject.fromObject(s);
		out.println(obj.toString(4));
	}
	
	
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
	{
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		if (name == null) { 
			// DELETE
			StockBo stockBo = (StockBo) appContext.getBean("stockBo");
			Stock stock = stockBo.findByStockCode(code);
			stockBo.delete(stock);
			stock.setStockId(Long.MIN_VALUE);
			JSONObject obj = JSONObject.fromObject(stock);
			out.println(obj.toString(4));
			return;
		}
		// CREATE & UPDATE
		Stock stock = new Stock();
		stock.setStockCode(code);
		stock.setStockName(name);
		StockBo stockBo = (StockBo) appContext.getBean("stockBo");
		stockBo.save(stock);
		JSONArray obj = JSONArray.fromObject(stock);
		out.println(obj.toString(4));
	}
}
