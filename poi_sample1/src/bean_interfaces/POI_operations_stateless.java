/**
 * 
 */
package bean_interfaces;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;

import objests_interfaces.POI_IF;

/**
 * @author Olga
 *
 */
public interface POI_operations_stateless {
	
	//poi_id is generated automatically
	public POI_IF create_POI (String user_id, String poi_name, Integer main_poi_id, float lat, float longit, String town,
			String street, String building, String post_code, Integer district_index, Integer avail_index, 
			Integer status_index, Integer poi_main_cat_index, Integer poi_add_cat_index, Integer poi_sub1_index, 
			Integer poi_sub2_index,
			Integer poi_period_index, Integer rating_index, String descript, String weblink);
	
	//creator_id is always the same, poi_id is used for lookup
	
	public POI_IF modifyPublishedPoi (String creator_id, String poi_id, String poi_name, Integer main_poi_id, float lat, float longit, String town,
			String street, String building, String post_code, Integer district_index, Integer avail_index, 
			Integer status_index, Integer poi_main_cat_index, Integer poi_add_cat_index, Integer poi_sub1_index, 
			Integer poi_sub2_index,
			Integer poi_period_index, Integer rating_index, String descript, String weblink, String modify_by);
	
	public POI_IF modifyPendingPoi(String poi_id, String poi_name, Integer main_poi_id, float lat, float longit,
			String town, String street, String building, String post_code, Integer district_index, Integer avail_index,
			Integer status_index, Integer poi_main_cat_index, Integer poi_add_cat_index, Integer poi_sub1_index,
			Integer poi_sub2_index, Integer poi_period_index, Integer rating_index, String descript, String weblink, String modified_by); 
	
	public List <? extends POI_IF> select_all ();
	
	public POI_IF deletePendingPoi (String poi_id);
	
	public List <? extends POI_IF> select_POIs_by_id (Set<String> poi_ids);
	
	public List <? extends POI_IF> select_filtered_POIs(Set <? extends POI_IF> pois_to_filter, Map <String, String []> data_to_filter);
	
	public Map <String, POI_IF> map_of_pois (List <? extends POI_IF> pois_lst);
	
	public JSONArray returnJson (List<? extends POI_IF> my_pois);
	
	public List<POI_IF> selectPoisToShow (Map <String, String []> data);
	
	

}
