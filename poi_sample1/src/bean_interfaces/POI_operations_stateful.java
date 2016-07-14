/**
 * 
 */
package bean_interfaces;

import java.util.List;

import objests_interfaces.POI_IF;

/**
 * @author Olga
 *
 */
public interface POI_operations_stateful {
	
	public void modifyPoiList(String operation, POI_IF p);
	
	public List <? extends POI_IF> get_pois_of_user ();

}
