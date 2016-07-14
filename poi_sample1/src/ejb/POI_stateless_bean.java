/**
 * 
 */
package ejb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean_interfaces.POI_operations_stateless;
import dao.POI_DAO;
import entity_configurable.Constants_for_pois;
import objests_interfaces.POI_IF;

/**
 * @author Olga
 *
 */
@Stateless
@Local(POI_operations_stateless.class)

public class POI_stateless_bean implements POI_operations_stateless, Serializable{

	
	private static final long serialVersionUID = 5546944327882890353L;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	
	@EJB
	private POI_DAO dao;
	
	
	@Override
	public POI_IF create_POI(String user_id, String poi_name, Integer main_poi_id, float lat, float longit, String town,
			String street, String building, String post_code, Integer district_index, Integer avail_index,
			Integer status_index, Integer poi_main_cat_index, Integer poi_add_cat_index, Integer poi_sub1_index,
			Integer poi_sub2_index, Integer poi_period_index, Integer rating_index, String descript, String weblink) {
		// TODO Auto-generated method stub
		
		try {
			POI_IF p = dao.save(user_id, poi_name, main_poi_id, lat, longit, town, street, building, post_code, district_index, avail_index,
					status_index, poi_main_cat_index, poi_add_cat_index, poi_sub1_index, poi_sub2_index, poi_period_index, rating_index, descript, weblink);
			return p;
		} finally {
			logger.info("exit");
		}
	}
	
	@Override
	public POI_IF modifyPublishedPoi(String creator_id, String poi_id, String poi_name, Integer main_poi_id, float lat, float longit,
			String town, String street, String building, String post_code, Integer district_index, Integer avail_index,
			Integer status_index, Integer poi_main_cat_index, Integer poi_add_cat_index, Integer poi_sub1_index,
			Integer poi_sub2_index, Integer poi_period_index, Integer rating_index, String descript, String weblink, String modified_by) {
		// TODO Auto-generated method stub
		try {
			logger.info("enter modify published poi");
			
			POI_IF p = dao.updatePublPoi(creator_id, poi_id, poi_name, main_poi_id, lat, 
					longit, town, street, building, post_code, district_index, avail_index, status_index, poi_main_cat_index, poi_add_cat_index, poi_sub1_index, poi_sub2_index, poi_period_index, rating_index, descript, weblink, modified_by);
			
			return p;
		} finally {
			logger.info("exit");
		}
	}
	
	@Override
	public POI_IF modifyPendingPoi(String poi_id, String poi_name, Integer main_poi_id, float lat, float longit,
			String town, String street, String building, String post_code, Integer district_index, Integer avail_index,
			Integer status_index, Integer poi_main_cat_index, Integer poi_add_cat_index, Integer poi_sub1_index,
			Integer poi_sub2_index, Integer poi_period_index, Integer rating_index, String descript, String weblink, String modified_by) {
		// TODO Auto-generated method stub
		
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<POI_IF> select_POIs_by_id(Set<String> poi_ids) {
		// TODO Auto-generated method stub
		List<? extends POI_IF> pois_by_ids = dao.select_pois_by_id(poi_ids);
		return (List<POI_IF>) pois_by_ids;
	}
	

	@Override
	public List<POI_IF> selectPoisToShow (Map <String, String []> data) 
	{
		
		return null;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends POI_IF> select_filtered_POIs(Set <? extends POI_IF> pois_to_filter, Map <String, String []> data_to_filter) {
		// TODO Auto-generated method stub
		List <? extends POI_IF> my_pois = new LinkedList <POI_IF> ();
		Set <? extends POI_IF> temp_set1 = new HashSet <POI_IF>();
		Set <? extends POI_IF> temp_set2 = new HashSet <POI_IF>();
		((Set <POI_IF>)temp_set1).addAll(pois_to_filter);
		
		logger.info("source table size: {}", pois_to_filter.size());
		
		
		 Set <String> param_names1 = data_to_filter.keySet();
		 String [] param_values = new String[0];
		 List <String> values1 = new LinkedList<String>();
		 Integer count = 0;
		 for (String name : param_names1)
		  {
			  logger.info(name);
			  if (name.equals("main_poi_id[]")) 
			  {
				  count = count+1;
				  
				  continue;
			  }
			  else
			  {
				  if (name.equals("avail[]")) 
				  {
				  param_values = data_to_filter.get(name);
				  values1 = Arrays.asList(param_values);
				  for (POI_IF p : temp_set1)
				  {
					  if (values1.contains(Constants_for_pois.avail[p.getAvail_index()])) {
						  ((Set <POI_IF>)temp_set2).add(p);
					  }
					  
				  }
				  temp_set1.clear();
				  ((Set <POI_IF>)temp_set1).addAll(temp_set2);
				  temp_set2.clear();
				  count = count+1;
				  if (count == data_to_filter.size()) 
				  {
					  logger.info("we are done");
					  break;
				  }
				  else
					  continue;

				  }
				  else
				  {
					  if (name.equals("status[]")) 
					  {
						  param_values = data_to_filter.get(name);
						  values1 = Arrays.asList(param_values);
						  for (POI_IF p : temp_set1)
						  {
							  if (values1.contains(Constants_for_pois.status[p.getStatus_index()])) {
								  ((Set <POI_IF>)temp_set2).add(p);
							  }
							  
						  }
						  temp_set1.clear();
						  ((Set <POI_IF>)temp_set1).addAll(temp_set2);
						  temp_set2.clear();
						
						  count = count+1;
						  if (count == data_to_filter.size()) 
						  {
							  logger.info("we are done");
							  break;
						  }
						  else
							  continue;
						 
						  }
					  else
					  {
						  if (name.equals("district[]")) 
					  {
							  param_values = data_to_filter.get(name);
							  values1 = Arrays.asList(param_values);
							  for (POI_IF p : temp_set1)
							  {
								  if (values1.contains(Constants_for_pois.district[p.getDistrict_index()])) {
									  ((Set <POI_IF>)temp_set2).add(p);
								  }
								  
							  }
							  temp_set1.clear();
							  ((Set <POI_IF>)temp_set1).addAll(temp_set2);
							  temp_set2.clear();
							  count = count+1;
							  if (count == data_to_filter.size()) 
							  {
								  logger.info("we are done");
								  break;
							  }
							  else
								  continue;
							  
							  }
						  else
						  {
							  if (name.equals("spec_places[]")) 
							  {
								  param_values = data_to_filter.get(name);
								  values1 = Arrays.asList(param_values);
								  for (POI_IF p : temp_set1)
								  {
									  if (values1.contains(Constants_for_pois.poi_add_cat[p.getPoi_add_cat_index()])) {
										  ((Set <POI_IF>)temp_set2).add(p);
									  }
									  
								  }
								  temp_set1.clear();
								  ((Set <POI_IF>)temp_set1).addAll(temp_set2);
								  temp_set2.clear();
								  count = count+1;
								  if (count == data_to_filter.size()) 
								  {
									  logger.info("we are done");
									  break;
								  }
								  else
									  continue;
								  
								  }
							  else {
								  if (name.equals("poi_subc1[]")) 
								  {
									  param_values = data_to_filter.get(name);
									  values1 = Arrays.asList(param_values);
									  for (POI_IF p : temp_set1)
									  {
										  if (values1.contains(Constants_for_pois.poi_sub1[p.getPoi_sub1_index()])) {
											  ((Set <POI_IF>)temp_set2).add(p);
										  }
										  
									  }
									  temp_set1.clear();
									  ((Set <POI_IF>)temp_set1).addAll(temp_set2);
									  temp_set2.clear();
									  count = count+1;
									  if (count == data_to_filter.size()) 
									  {
										  logger.info("we are done");
										  break;
									  }
									  else
										  continue;

									  }
								  else 
								  {
									  if (name.equals("poi_subc2[]")) 
									  {
										  param_values = data_to_filter.get(name);
										  values1 = Arrays.asList(param_values);
										  for (POI_IF p : temp_set1)
										  {
											  if (values1.contains(Constants_for_pois.poi_sub2[p.getPoi_sub2_index()])) {
												  ((Set <POI_IF>)temp_set2).add(p);
											  }
											  
										  }
										  temp_set1.clear();
										  ((Set <POI_IF>)temp_set1).addAll(temp_set2);
										  temp_set2.clear();
										  count = count+1;
										  if (count == data_to_filter.size()) 
										  {
											  logger.info("we are done");
											  break;
										  }
										  else
											  continue;
										 
										  }
																	  else
																	  {
											  if (name.equals("period[]")) {
												  param_values = data_to_filter.get(name);
												  values1 = Arrays.asList(param_values);
												  for (POI_IF p : temp_set1)
												  {
													  if (values1.contains(Constants_for_pois.poi_period[p.getPoi_period_index()])) {
														  ((Set <POI_IF>)temp_set2).add(p);
													  }
													  
												  }
												  temp_set1.clear();
												  ((Set <POI_IF>)temp_set1).addAll(temp_set2);
												  temp_set2.clear();
												 
												  count = count+1;
												  if (count == data_to_filter.size()) 
												  {
													  logger.info("we are done");
													  break;
												  }
												  else
													  continue;
												  
											  }
											  else
											  {
											  if (name.equals("rating[]")) {
												  param_values = data_to_filter.get(name);
												  values1 = Arrays.asList(param_values);
												  for (POI_IF p : temp_set1)
												  {
													  if (values1.contains(p.getRating_index().toString())) {
														  ((Set <POI_IF>)temp_set2).add(p);
													  }
													  
												  }
												  temp_set1.clear();
												  ((Set <POI_IF>)temp_set1).addAll(temp_set2);
												  temp_set2.clear();
												 
												  count = count+1;
												  if (count == data_to_filter.size()) 
												  {
													  logger.info("we are done");
													  break;
												  }
												  else
													  continue;
												  
											  }
											  else
												  logger.info("error with data");
												 
											  }
											  }
											  }
											  }
											  }
											  }
											  }
											  }
										  }
		 ((List <POI_IF>)my_pois).addAll(temp_set1);

		
		return my_pois;
	}


	@Override
	public POI_IF deletePendingPoi(String poi_id) {
	
		return null;
	}

	@Override
	public Map<String, POI_IF> map_of_pois(List<?extends POI_IF> pois_lst) {
		// TODO Auto-generated method stub
		Map<String, POI_IF> map_of_pois = new HashMap <String, POI_IF>();
		for (POI_IF pe : pois_lst) {
			map_of_pois.put(pe.getPoi_id(), pe);
		}
		return map_of_pois;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONArray returnJson(List<?extends POI_IF> my_pois) {
		// TODO Auto-generated method stub
		JSONArray lst = new JSONArray();
		for (POI_IF p : my_pois) 
		{
			JSONObject js_obj = new JSONObject();
			js_obj.put("poi_id", p.getPoi_id());
			js_obj.put("poi_name", p.getPoi_name());
			js_obj.put("poi_lat", p.getPoi_lat());
			js_obj.put("poi_lng", p.getPoi_lng());
	//		js_obj.put("poi_type", p.getSingle_poi_sub1());
	//		js_obj.put("poi_subtype", p.getSingle_poi_sub2());
			
			lst.add(js_obj);
		}
		
		return lst;
	}

	
	@Override
	public List<? extends POI_IF> select_all() {
		// TODO Auto-generated method stub
		List<? extends POI_IF> pois = dao.select_all_POIs();
		return pois;
	}


}
