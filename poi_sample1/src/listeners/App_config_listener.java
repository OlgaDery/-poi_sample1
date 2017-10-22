package listeners;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejb.FiltersEJB;
import model.Create_poi_model;
import model.Default;
import model.Model;
import parameters_for_filtering.Constants_for_pois;
import utils_for_servlet.Web_page_config;

/**
 * Application Lifecycle Listener implementation class App_config_listener
 *
 */
@WebListener
public class App_config_listener implements ServletContextListener {
	 private final Logger log = LoggerFactory.getLogger(getClass());


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	log.info("ENTER contextDestroyed(sce)");
        log.info("EXIT contextDestroyed(sce)");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  
    { 
    	//Here we are setting all the attributes for the application (parameters to filter points, web pages)
    	
         // TODO Auto-generated method stub
    	log.info("ENTER contextInitialized(sce)");
    	
    	setupWebPages(sce);
   	

    	sce.getServletContext().setAttribute("districts", FiltersEJB.getDistr());
    	sce.getServletContext().setAttribute("status", Constants_for_pois.status);
    	sce.getServletContext().setAttribute("spec_places", FiltersEJB.getAdd_cat());
    	sce.getServletContext().setAttribute("period", FiltersEJB.period);
    	sce.getServletContext().setAttribute("rating", Constants_for_pois.rating);
    	sce.getServletContext().setAttribute("avail", FiltersEJB.avail);
    	sce.getServletContext().setAttribute("poi_subcat1", FiltersEJB.getSubcat1());
    	sce.getServletContext().setAttribute("poi_subcat2", FiltersEJB.getSubcat2());
        
    	log.info("EXIT contextInitialized(sce)");
    }
    
    private void setupWebPages(ServletContextEvent sce) 
    {
    	//This method is to configure all the web pages for the application - to tie a certain jsp file to the url, to the model class
    	//which access the business logic level, to set the title and the visibility level.
	    	 log.info("ENTER setupWebPages(sce)");
	    	 
	    	 final Model defaultModel = new Default();
	    	 
	    	 final Model createPoint = new Create_poi_model();
	
	         final Map<String, Web_page_config> webPages = new LinkedHashMap<String, Web_page_config>();
	
	         final String path = sce.getServletContext().getContextPath();
	         
	         String[] r4 = {"admin", "contrib", "subscrib", "user", "guest"};
	         
	         final Web_page_config homePage = new Web_page_config(path + "/map/main", "page.map.title", r4 ,
	          "/WEB-INF/jsp/map.jsp", true, defaultModel);
	         
	         final Web_page_config adminPage = new Web_page_config(path + "/map/admin", "page.Admin.title", r4,
	        		 "/WEB-INF/jsp/adminPage.jsp", true, createPoint);
	         
	         final Web_page_config ajaxPage = new Web_page_config(path + "/map/ajax", null, r4,
	   	         null, false, defaultModel);
	       
	         
	         final Web_page_config contactUsPage = new Web_page_config(path + "/map/contactus", "page.contactus.title", r4, 
	                 "/WEB-INF/jsp/contactus.jsp", true, defaultModel);
	
	
	         webPages.put(homePage.getUri(), homePage);
	         webPages.put(contactUsPage.getUri(), contactUsPage);
	         webPages.put(ajaxPage.getUri(), ajaxPage);
	         webPages.put(adminPage.getUri(), adminPage);
	
	         sce.getServletContext().setAttribute("webPages", webPages);
	
	         log.info("ENTER setupWebPages(sce)");
    }
    
	
}
