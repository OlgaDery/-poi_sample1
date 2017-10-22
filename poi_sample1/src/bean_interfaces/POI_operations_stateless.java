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
 * @author Olga Deryabina
 * This interface is designed to set all the method which may be used to manipulate POI_IF interface(as well as the child classes of this interface).
 * Ihe implementation of this interface is POI_stateless_bean.
 */
public interface POI_operations_stateless {
	
	// Method is used to create a new point of interest
	public POI_IF create_POI (String user_id, String poi_name, Integer main_poi_id, float lat, float longit, String town,
			String street, String building, String post_code, Integer district_index, Integer avail_index, 
			Integer status_index, Integer poi_main_cat_index, Integer poi_add_cat_index, Integer poi_sub1_index, 
			Integer poi_sub2_index,
			Integer poi_period_index, Integer rating_index, String descript, String weblink);
	
	//This method returns all the points of interests from the POIS table of the database
	public List <? extends POI_IF> select_all ();
	
	//This method returns the points of interests with specified IDs
	public List <? extends POI_IF> select_POIs_by_id (Set<String> poi_ids);
	
	//Method to get a map of POI_IF (using poi_id as a key, POI_IF as a value) from a list of POI_IF of objects implementing POI_IF
	public Map <String, POI_IF> map_of_pois (List <? extends POI_IF> pois_lst);
	
	//This method is to filter the collection of points of interest (which is being provided as a first parameter in the method).
	//The criteria for filtering (second parameter in the method) are receiving from the front end.
	public List <? extends POI_IF> select_filtered_POIs(Set <? extends POI_IF> pois_to_filter, Map <String, String []> data_to_filter);
	
	//This method creates and returns a json array from the list of POI_IF or child objects to send it to AJAX method to show these
	//points on the Google map.
	public JSONArray returnJson (List<? extends POI_IF> my_pois);
	

}
