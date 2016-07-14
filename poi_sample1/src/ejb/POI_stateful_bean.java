/**
 * 
 */
package ejb;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import bean_interfaces.POI_operations_stateful;
import dao.POI_DAO;
import objests_interfaces.POI_IF;
/**
 * @author Olga
 *
 */
@Stateful
@Local (POI_operations_stateful.class)
public class POI_stateful_bean implements POI_operations_stateful, Serializable {

	
	private static final long serialVersionUID = 8049880142287063148L;
	@EJB
	private POI_DAO dao;
	
	List <? extends POI_IF> pois_of_user = new LinkedList <POI_IF>();
	

	@SuppressWarnings("unchecked")
	@Override
	public void modifyPoiList(String operation, POI_IF p) {
		// TODO Auto-generated method stub
		String poi_id = p.getPoi_id();
		switch (operation) 
		{ 
		case ("put"):
			((List <POI_IF>)pois_of_user).add(p);
			break;
		
		case ("replace"):
			for (POI_IF pp: pois_of_user)
			{
				if (pp.getPoi_id().equals(poi_id)) {
					pois_of_user.remove(pp);
					break;
				}
			}
		((List <POI_IF>)pois_of_user).add(p);
			
			break;
		
		case ("remove"):
			for (POI_IF pp: pois_of_user)
			{
				if (pp.getPoi_id().equals(poi_id)) {
					pois_of_user.remove(pp);
					break;
				}
			}
			break;
		
		}
//		return groups_of_user;
//		logger.info("the poi list size: {}", pois_of_user.size());
		
	}


	@Override
	public List<? extends POI_IF> get_pois_of_user() {
		// TODO Auto-generated method stub
		return this.pois_of_user;
	}

}
