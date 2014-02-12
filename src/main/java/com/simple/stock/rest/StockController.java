package com.simple.stock.rest;

import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;






import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simple.stock.bo.StockBo;
import com.simple.stock.model.Stock;

@Path("/stock")
public class StockController {

	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	
	@GET
	@Path("/i-say/{param}")
	public Response getIsay(@PathParam("param") String msg) { 
		String output = "I say : " + msg; 
		return Response.status(200).entity(output).build(); 
	} 
	
	@GET
	@Path("/code/{param}")
	public Response getStock(@PathParam("param") String code) { 
		StockBo stockBo = (StockBo) appContext.getBean("stockBo");
		Stock stock = stockBo.findByStockCode(code);
		JSONObject obj = JSONObject.fromObject(stock);
		return Response.status(200).entity(obj.toString(4)).build(); 
	}
		
	@GET
	@Path("/list")
	public Response getStocks() { 
		StockBo stockBo = (StockBo) appContext.getBean("stockBo");
		List<Stock> stocks = stockBo.findAllStocks();
		JSONArray obj = JSONArray.fromObject(stocks);
		return Response.status(200).entity(obj.toString(4)).build(); 
	}
	
	@POST
	@Path("/put")
	public Response putStock(@QueryParam("code") String code, 
			@QueryParam("name") String name) { 
		
		Stock stock = new Stock();
		stock.setStockCode(code);
		stock.setStockName(name);
		StockBo stockBo = (StockBo) appContext.getBean("stockBo");
		stockBo.save(stock);
		JSONArray obj = JSONArray.fromObject(stock);
		return Response.status(200).entity(obj.toString(4)).build(); 
	}
	
	@POST
	@Path("/post")
	public Response postStock(@QueryParam("code") String code, 
			@QueryParam("name") String name) { 
		StockBo stockBo = (StockBo) appContext.getBean("stockBo");
		Stock stock = stockBo.findByStockCode(code);
		stock.setStockName(name);
		stockBo.save(stock);
		JSONArray obj = JSONArray.fromObject(stock);
		return Response.status(200).entity(obj.toString(4)).build(); 
	}
	
	@DELETE
	@Path("/delete")
	public Response deleteStock(@QueryParam("code") String code) { 
		StockBo stockBo = (StockBo) appContext.getBean("stockBo");
		Stock stock = stockBo.findByStockCode(code);
		stockBo.delete(stock);
		stock.setStockId(Long.MIN_VALUE);
		JSONObject obj = JSONObject.fromObject(stock);
		return Response.status(200).entity(obj.toString(4)).build(); 
	}

}
