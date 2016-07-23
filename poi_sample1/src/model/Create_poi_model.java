/**
 * 
 */
package model;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean_interfaces.POI_operations_stateless;
import entity_configurable.Constants_for_pois;

/**
 * @author Olga
 *
 */
public class Create_poi_model implements Model {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private InitialContext context;
	
	public Create_poi_model ()
	{
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			logger.info("naming exception()");
		}
		
	}


	/* (non-Javadoc)
	 * @see model.Model#process(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void process(HttpServletRequest request) 
	{
		// TODO Auto-generated method stub
		logger.info("enter process");
		POI_operations_stateless po;
		
		if (request.getParameter("uploadPs")!= null) 
		{
			
	//		Path path = Paths.get("c:/opt", "pois.txt");
			try 
			{
				Path path1 = Paths.get(request.getParameter("path"));//"c:/opt/pois.txt");
				List <String> lines = Files.readAllLines(path1);
				po = (POI_operations_stateless) context.lookup("java:global/poi_app/POI_stateless_bean");
				for (String line : lines)
				{
					
					String [] data = line.split("&");
					logger.info("name: {}", data[0]);
					logger.info("long: {}", data[1]);
					logger.info("lat: {}", data[2]);
					logger.info("distr: {}", data[4]);
					logger.info("avail: {}", data[5]);
					logger.info("main cat: {}", data[6]);
					logger.info("add cat: {}", data[7]);
					logger.info("sub1: {}", data[8]);
					logger.info("sub2: {}", data[9]);
					logger.info("period: {}", data[10]);
					logger.info("rating: {}", data[11]);
					logger.info("descr: {}", data[12]);
					
					po.create_POI
					("admin", data[0], 0, 
							Float.parseFloat(data[1]), 
							Float.parseFloat(data[2]), 
							"n/a", 
							"n/a", 
							"n/a", 
							"n/a", 
							 Arrays.asList(Constants_for_pois.district).indexOf(data[4]), 
     						 Arrays.asList(Constants_for_pois.avail).indexOf(data[5]),
     						 Arrays.asList(Constants_for_pois.status).indexOf(data[3]), 
     						 Arrays.asList(Constants_for_pois.poi_main_cat).indexOf(data[6]),
     						 Arrays.asList(Constants_for_pois.poi_add_cat).indexOf(data[7]),
     						 Arrays.asList(Constants_for_pois.poi_sub1).indexOf(data[8]),
     						 Arrays.asList(Constants_for_pois.poi_sub2).indexOf(data[9]), 
     						 Arrays.asList(Constants_for_pois.poi_period).indexOf(data[10]),
     						 (Integer.valueOf(data[11])),
							 data[12], 
							 "n/a");
				};
				logger.info("data inserted");
				request.setAttribute("success_message", "your data succesfully inserted");
				
				
			} catch (Exception e) {
				logger.info(e.getMessage(), e);
			}
			
		}
		
		logger.info("exit process");


	}

}
