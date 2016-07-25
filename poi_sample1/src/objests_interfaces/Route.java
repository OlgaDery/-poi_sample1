/**
 * 
 */
package objests_interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olga Deryabina
 * This class is for later use.
 */
public class Route {
	private String route_id;
	private String creator_id;
	private String route_name;
	private String route_descr;
	private static String [] route_type = {
			"hiking/pedastrians", "rafting", "bike", "combined"
	};
	private Integer route_type_index;
	private String single_route_type;
	private static String [] route_duration = {
			"half-day", "one day", "two days", "tree days(hiking only)"
	};
	private String single_route_duration;
	private Integer route_duration_index;
	private static String [] diff_level = {
			"easy", "medium", "advanced", "extra complex"
	};
	private String single_diff_level;
	private Integer diff_level_index;
	
	private List<? extends POI_IF>POIs_list_for_route = new ArrayList<POI_IF> (200);
	
	
	public Route (String route_name, String route_descr, Integer route_type_index, Integer route_duration_index,
			Integer diff_level_index) {
		this.route_name = route_name;
		this.route_descr = route_descr;
		this.single_route_type = route_type[route_type_index];
		this.single_route_duration = route_duration[route_duration_index];
		this.setSingle_diff_level(diff_level[diff_level_index]);
	}
	
	public Route () {
		
	}
	
	/**
	 * @return the route_name
	 */
	public String getRoute_name() {
		return route_name;
	}

	/**
	 * @param route_name the route_name to set
	 */
	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}



	/**
	 * @return the route_descr
	 */
	public String getRoute_descr() {
		return route_descr;
	}

	/**
	 * @param route_descr the route_descr to set
	 */
	public void setRoute_descr(String route_descr) {
		this.route_descr = route_descr;
	}

	/**
	 * @return the route_type
	 */
	public String get_single_Route_type(Integer route_type_index) {
		single_route_type = route_type[route_type_index];
		return single_route_type;
	}
	
	public String get_single_diff_level(Integer diff_level_index) {
		single_diff_level = diff_level[diff_level_index];
		return single_diff_level;
	}

	/**
	 * @return the route_duration
	 */
	public String get_single_Route_duration(Integer route_duration_index) {
		single_route_duration = route_duration[route_duration_index];
		return single_route_duration;
	}

	/**
	 * @return the diff_level
	 */
	public static String[] getDiff_level() {
		return diff_level;
	}
	/**
	 * @return the rout_id
	 */
	public String getRout_id() {
		return route_id;
	}
	
	public void setRout_id(String route_id) {
		this.route_id = route_id;
	}

	/**
	 * @return the route_type
	 */
	public static String[] getRoute_type() {
		return route_type;
	}


	/**
	 * @return the route_duration
	 */
	public static String[] getRoute_duration() {
		return route_duration;
	}


	/**
	 * @return the pOIs_list_for_route
	 */
	public List<? extends POI_IF> getPOIs_list_for_route() {
		return POIs_list_for_route;
	}

	/**
	 * @param pOIs_list_for_route the pOIs_list_for_route to set
	 */
	public  void setPOIs_list_for_route(List<? extends POI_IF> POIs_list_for_route) {
		this.POIs_list_for_route = POIs_list_for_route;
	}

	public String getSingle_diff_level() {
		return single_diff_level;
	}

	public void setSingle_diff_level(String single_diff_level) {
		this.single_diff_level = single_diff_level;
	}

	public String getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}

	public Integer getDiff_level_index() {
		return diff_level_index;
	}

	public void setDiff_level_index(Integer diff_level_index) {
		this.diff_level_index = diff_level_index;
	}

	public Integer getRoute_duration_index() {
		return route_duration_index;
	}

	public void setRoute_duration_index(Integer route_duration_index) {
		this.route_duration_index = route_duration_index;
	}

	public Integer getRoute_type_index() {
		return route_type_index;
	}

	public void setRoute_type_index(Integer route_type_index) {
		this.route_type_index = route_type_index;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((POIs_list_for_route == null) ? 0 : POIs_list_for_route.hashCode());
		result = prime * result + ((creator_id == null) ? 0 : creator_id.hashCode());
		result = prime * result + ((diff_level_index == null) ? 0 : diff_level_index.hashCode());
		result = prime * result + ((route_descr == null) ? 0 : route_descr.hashCode());
		result = prime * result + ((route_duration_index == null) ? 0 : route_duration_index.hashCode());
		result = prime * result + ((route_id == null) ? 0 : route_id.hashCode());
		result = prime * result + ((route_name == null) ? 0 : route_name.hashCode());
		result = prime * result + ((route_type_index == null) ? 0 : route_type_index.hashCode());
		result = prime * result + ((single_diff_level == null) ? 0 : single_diff_level.hashCode());
		result = prime * result + ((single_route_duration == null) ? 0 : single_route_duration.hashCode());
		result = prime * result + ((single_route_type == null) ? 0 : single_route_type.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (POIs_list_for_route == null) {
			if (other.POIs_list_for_route != null)
				return false;
		} else if (!POIs_list_for_route.equals(other.POIs_list_for_route))
			return false;
		if (creator_id == null) {
			if (other.creator_id != null)
				return false;
		} else if (!creator_id.equals(other.creator_id))
			return false;
		if (diff_level_index == null) {
			if (other.diff_level_index != null)
				return false;
		} else if (!diff_level_index.equals(other.diff_level_index))
			return false;
		if (route_descr == null) {
			if (other.route_descr != null)
				return false;
		} else if (!route_descr.equals(other.route_descr))
			return false;
		if (route_duration_index == null) {
			if (other.route_duration_index != null)
				return false;
		} else if (!route_duration_index.equals(other.route_duration_index))
			return false;
		if (route_id == null) {
			if (other.route_id != null)
				return false;
		} else if (!route_id.equals(other.route_id))
			return false;
		if (route_name == null) {
			if (other.route_name != null)
				return false;
		} else if (!route_name.equals(other.route_name))
			return false;
		if (route_type_index == null) {
			if (other.route_type_index != null)
				return false;
		} else if (!route_type_index.equals(other.route_type_index))
			return false;
		if (single_diff_level == null) {
			if (other.single_diff_level != null)
				return false;
		} else if (!single_diff_level.equals(other.single_diff_level))
			return false;
		if (single_route_duration == null) {
			if (other.single_route_duration != null)
				return false;
		} else if (!single_route_duration.equals(other.single_route_duration))
			return false;
		if (single_route_type == null) {
			if (other.single_route_type != null)
				return false;
		} else if (!single_route_type.equals(other.single_route_type))
			return false;
		return true;
	}
	

}
