package listeners;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity_configurable.Constants_for_pois;
import model.Default;
import model.Model;
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
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	log.info("ENTER contextInitialized(sce)");
    	
    	setupWebPages(sce);
   	
    	// set the rest of attributes storing the data from singleton EJBs

    	sce.getServletContext().setAttribute("districts", Constants_for_pois.district);
    	sce.getServletContext().setAttribute("status", Constants_for_pois.status);
    	sce.getServletContext().setAttribute("spec_places", Constants_for_pois.poi_add_cat);
    	sce.getServletContext().setAttribute("period", Constants_for_pois.poi_period);
    	sce.getServletContext().setAttribute("rating", Constants_for_pois.rating);
    	sce.getServletContext().setAttribute("avail", Constants_for_pois.avail);
    	sce.getServletContext().setAttribute("poi_subcat1", Constants_for_pois.poi_sub1);
    	sce.getServletContext().setAttribute("poi_subcat2", Constants_for_pois.poi_sub2);
        
    	log.info("EXIT contextInitialized(sce)");
    }
    
    private void setupWebPages(ServletContextEvent sce) {
	    	 log.trace("ENTER setupWebPages(sce)");
	    	 
	    	 final Model defaultModel = new Default();
	
	         final Map<String, Web_page_config> webPages = new LinkedHashMap<String, Web_page_config>();
	
	         final String path = sce.getServletContext().getContextPath();
	         String[] r1 = {"guest"};
	         String[] r4 = {"admin", "contrib", "subscrib", "user", "guest"};
	         
	         final Web_page_config homePage = new Web_page_config(path + "/map/main", "page.map.title", r1 ,
	          "/WEB-INF/jsp/map.jsp", true, defaultModel);
	         
	         final Web_page_config ajaxPage = new Web_page_config(path + "/map/ajax", null, r4,
	   	         null, false, defaultModel);
	         
	         final Web_page_config how_to = new Web_page_config(path + "/map/how_to", "page.how_to.title", r4,
	                 "/WEB-INF/jsp/how_to.jsp", true, defaultModel);
	         
	         final Web_page_config contactUsPage = new Web_page_config(path + "/map/contactus", "page.contactus.title", r4, 
	                 "/WEB-INF/jsp/contactus.jsp", true, defaultModel);
	
	
	         webPages.put(homePage.getUri(), homePage);
	         webPages.put(how_to.getUri(), how_to);
	         webPages.put(contactUsPage.getUri(), contactUsPage);
	         webPages.put(ajaxPage.getUri(), ajaxPage);
	
	         sce.getServletContext().setAttribute("webPages", webPages);
	
	         log.trace("ENTER setupWebPages(sce)");
    }
    
	
}
