/**
 * 
 */
package bean_interfaces;

import java.util.List;
import java.util.Map;

import objests_interfaces.POI_IF;

/**
 * @author Olga
 *
 */
public interface POI_operations_singl {
	
	
	public Map <String, POI_IF> map_of_pois ();
	
	//stores all the approved pois during the app lifecycle
	public List <? extends POI_IF> getAllPublishedPoints ();
	
	public void uploadPsFromDB ();
	

}
