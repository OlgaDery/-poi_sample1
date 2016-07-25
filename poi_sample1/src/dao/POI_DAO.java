/**
 * 
 */
package dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import entity.POI_entity;
import objests_interfaces.POI_IF;

/**
 * @author Olga Deryabina
 * This class is specially designed to inject EntityManager to perform the manipulations with the POI_entity objects. 
 * They are called from the POI_stateless_bean class.
 */
@Stateless
@LocalBean
public class POI_DAO {
private final Logger logger = LoggerFactory.getLogger(getClass());

	
	@PersistenceContext
	private EntityManager em;

	public POI_IF save (String user_id, String poi_name, Integer main_poi_id, float lat, float longit, String town,
			String street, String building, String post_code, Integer district_index, Integer avail_index,
			Integer status_index, Integer poi_main_cat_index, Integer poi_add_cat_index, Integer poi_sub1_index,
			Integer poi_sub2_index, Integer poi_period_index, Integer rating_index, String descript, String weblink) 
	{
		//Creating a new POI_entity using provided parameters and inserting them to the database.
		try {
			logger.info("enter save(value)");
			POI_entity p = new POI_entity();
			p.setPoi_id(UUID.randomUUID().toString());
			p.setCreator_id(user_id);
			p.setCreation_date(new Date());
			p.setPoi_name(poi_name);
			p.setMain_poi_id(main_poi_id);
			p.setPoi_lat(lat);
			p.setPoi_lng(longit);
			p.setBuilding(building);
			p.setTown(town);
			p.setStreet(street);
			p.setStatus_index(status_index);
			p.setPost_code(post_code);
			p.setDistrict_index(district_index);
			p.setAvail_index(avail_index);
			p.setPoi_add_cat_index(poi_add_cat_index);
			p.setPoi_main_cat_index(poi_main_cat_index);
			p.setPoi_period_index(poi_period_index);
			p.setPoi_sub1_index(poi_sub1_index);
			p.setPoi_sub2_index(poi_sub2_index);	
			p.setRating_index(rating_index);
			p.setDescript(descript);
			p.setWeblink(weblink);
			em.persist(p);
			
			return (POI_IF)p;
			
		
		} finally {
			logger.info("exit save(value)");
		}
	
	}
	
	
	public POI_entity finddPoiEntity (String poiID) 
	//Searching for a certain point of interest by ID
	{
		logger.info("enter finddPoiEntity (String poiID) ");
		POI_entity p = em.find(POI_entity.class, poiID);
		
		logger.info("exit finddPoiEntity (String poiID) ");
		return p;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<? extends POI_IF> select_all_POIs() 
	{
		//Selecting all the points of interest from the database
		logger.info("enter select_all_POIs()");
		// TODO Auto-generated method stub
		try {
			List<POI_entity> all_p = em.createNamedQuery(POI_entity.QUERY_SELECT_ALL_P).getResultList();
			for (POI_entity p : all_p) 
			{
				p.getSingle_avail();
				p.getSingle_district();
				p.getSingle_poi_add_cat();
				p.getSingle_poi_main_cat();
				p.getSingle_poi_period();
				p.getSingle_poi_sub1();
				p.getSingle_poi_sub2();
				p.getSingle_status();
			}
			return (List<? extends POI_IF>)all_p;
			
		} finally {
			logger.info("exit select_all_POIs()");
		
		}
		
	}

	
	public List<POI_IF> select_pois_by_id (Set<String> poi_ids) 
	{
		logger.info("enter select_pois_by_id (Set<String> poi_ids) ");
		try {
			List <POI_IF> my_pois = new LinkedList <POI_IF>();
			for (String id : poi_ids) 
			{
					POI_entity p = em.find(POI_entity.class, id);
					p.getSingle_avail();
					p.getSingle_district();
					p.getSingle_poi_add_cat();
					p.getSingle_poi_main_cat();
					p.getSingle_poi_period();
					p.getSingle_poi_sub1();
					p.getSingle_poi_sub2();
					p.getSingle_status();
				
					my_pois.add((POI_IF)p);
			}
			
			return my_pois;
		} finally {
			logger.info("exit poisOfGroup (String group_id)");
		}
	}
	
	
	public POI_IF updatePublPoi (String creator_id, String poi_id, String poi_name, Integer main_poi_id, float lat, float longit, String town,
			String street, String building, String post_code, Integer district_index, Integer avail_index,
			Integer status_index, Integer poi_main_cat_index, Integer poi_add_cat_index, Integer poi_sub1_index,
			Integer poi_sub2_index, Integer poi_period_index, Integer rating_index, String descript, String weblink, String modified_by) 
	{ 
		//updating a POI_entity in the database
		logger.info("enter updatePublPoi");
		POI_entity p = null;
		try {
			p = em.find(POI_entity.class, poi_id);
			p.setPoi_name(poi_name);
			p.setMain_poi_id(main_poi_id);
			p.setPoi_lat(lat);
			p.setPoi_lng(longit);
			p.setTown(town);
			p.setStreet(street);
			p.setBuilding(building);
			p.setPost_code(post_code);
			p.setDistrict_index(district_index);
			p.setAvail_index(avail_index);
			p.setStatus_index(status_index);
			p.setPoi_main_cat_index(poi_main_cat_index);
			p.setPoi_add_cat_index(poi_add_cat_index);
			p.setPoi_sub1_index(poi_sub1_index);
			p.setPoi_sub2_index(poi_sub2_index);
			p.setPoi_period_index(poi_period_index);
			p.setRating_index(rating_index);
			p.setDescript(descript);
			p.setWeblink(weblink);
			p.setModifDate(new Date());
			p.setModified_by(modified_by);
			
			em.flush();
			
			p.getSingle_avail();
			p.getSingle_district();
			p.getSingle_poi_add_cat();
			p.getSingle_poi_main_cat();
			p.getSingle_poi_period();
			p.getSingle_poi_sub1();
			p.getSingle_poi_sub2();
			p.getSingle_status();
			return (POI_IF) p;
			
		} finally {
			logger.info ("exit updatePublPoi()");
		}	
		
	}
	

}
