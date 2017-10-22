/**
 * 
 */
package ejb;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.POI_DAO;

import objests_interfaces.POI_IF;

/**
 * @author Olga
 *
 */
@Singleton
@Local(bean_interfaces.POI_operations_singl.class)
@Startup


public class POI_singleton_bean implements bean_interfaces.POI_operations_singl, Serializable {

	@EJB
	private POI_DAO dao;
	
	@EJB
	private FiltersEJB constantsForPoints;
	
//	static private User_DAO userDAO;
	
	
	private static final long serialVersionUID = -2917123133502552810L;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	private final ReadLock readLock = rwLock.readLock(); 
	
	
	//This list contains the published points. Visible for anyone, may by modified by admin only.
	private List <POI_IF> published = new LinkedList <POI_IF>();
	
	
	@PostConstruct
	private void postConstruct() {
		
	        logger.info("ENTER postConstruct()");
	        
	        logger.info("EXIT postConstruct()");
	    }
	
	
	@Override
	public Map<String, POI_IF> map_of_pois() 
	{
		
				return null;
	
	}

	@Override
	public List<? extends POI_IF> getAllPublishedPoints() 
	{
		// TODO The get method the list of published points 
		logger.info("enter getAllPublishedPoints()");
		readLock.lock();
		try 
		{
			return published;
		} finally {
			logger.info("exit getAllPublishedPoints()");
			readLock.unlock();
		}
		
	}


	
	@Override
	public void uploadPsFromDB() 
	{
		logger.info("enter uploadPsFromDB()");
		// TODO This method is being called from the POSTCONSTRUCT method to fill the singleton lists up
		//when the app is starting.
		try{
			
	        List <?extends POI_IF> temp_pois2 = dao.select_all_POIs();
	        published.addAll(temp_pois2);
	       
	        
	        //here the lists and sets with the filtering params available for all the users are being filled up.
	        for (POI_IF p : temp_pois2) 
	        {
	        	FiltersEJB.getMain_categories().add(p.getSingle_poi_main_cat());
	        //	logger.info("main cats: {}", Constants_for_pois.getMain_categories().size());
	        	
	        	FiltersEJB.getSubcat1().add(p.getSingle_poi_sub1());
	        	FiltersEJB.getSubcat2().add(p.getSingle_poi_sub2());
	        	FiltersEJB.getDistr().add(p.getSingle_district());
				logger.info("districts: {}", FiltersEJB.getDistr().size());
				
				FiltersEJB.getStat().add(p.getSingle_status());
				FiltersEJB.getAdd_cat().add(p.getSingle_poi_add_cat());
				FiltersEJB.getPeriod().add(p.getSingle_poi_period());
	        }
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		} finally {
			 logger.info("all points: {}", published.size());
		}
		
	}


	}
