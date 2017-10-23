/**
 * 
 */
package model;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean_interfaces.POI_operations_singl;
import bean_interfaces.POI_operations_stateless;
import parameters_for_filtering.Constants_for_pois;

/**
 * @author Olga Deryabina
 * This class is to process the text file with points of interest and to store them to the database. The absolute path 
 * to the file is provided by user and receiving as a request parameter.
 */
public class Create_poi_model implements Model {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	private bean_interfaces.POI_operations_stateless po;
	private InitialContext context;
	private POI_operations_singl pointSingl;
	
	public Create_poi_model (){
		try {
			context = new InitialContext();
			po = (POI_operations_stateless)context.lookup("java:global/poi_sample/POI_stateless_bean");
			pointSingl = (POI_operations_singl)context.lookup("java:global/poi_sample/POI_singleton_bean");
			
		} catch (Exception e) {
			
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
		
		if (request.getParameter("uploadPs")!= null) 
		{
			
			try 
			{
			
				URL url = new URL ("http://localhost:8080/poi_sample/poi.txt");
				logger.info("url: {}", url);
				List <String> lines = new LinkedList <String>();
				BufferedReader in = new BufferedReader(
					        new InputStreamReader(url.openStream()));
				 		
					        String line;
					        while ((line = in.readLine()) != null) {
					        	System.out.println(line);
					        	lines.add(line);
					        }
					        in.close();
				
				logger.info("size: {}", lines.size());
				for (String line1 : lines) 
				{
					String [] data = line1.split("&");
					try {
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
						logger.info("data inserted");
						
						
					} catch (Exception e) {
						logger.info(e.getMessage(), e);
					}	
		     
				}
				
				
				try {
			        pointSingl.uploadPsFromDB();
					logger.info("data uploaded");
					request.setAttribute("success_message", "your data succesfully inserted");
					
				} catch (Exception e) {
						// TODO Auto-generated catch block
					logger.info(e.getMessage(), e);
					request.setAttribute("success_message", "the error occures");
				}
				
				
				
			} catch (MalformedURLException e) {
				logger.info(e.getMessage(), e);
				request.setAttribute("success_message", "the path is wrong");	
			} catch (Exception e) {
				logger.info(e.getMessage(), e);
				request.setAttribute("success_message", "the error occures");
			}
		}
		
		logger.info("exit process");


	}

}
