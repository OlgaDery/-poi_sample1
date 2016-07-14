/**
 * 
 */
package entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import objests_interfaces.Route;


/**
 * @author Olga
 *
 */
@Entity(name = "Route_entity")
@Table(name = "drafts_routes")
@Access(AccessType.FIELD)
@NamedQueries({
 //       @NamedQuery(name = Route_entity.QUERY_SELECT_R_OF_USER, query = "SELECT r FROM Route_entity r WHERE r.creator_id =:user_id ORDER BY r.route_name"),

        })
public class Route_entity extends Route implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1777172463888687603L;
	public static final String QUERY_SELECT_R_OF_USER = "find_r_of_user";
	public Route_entity() {
		
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "route_id", length = 30, nullable = false, unique = true)
	private Integer route_id;
//	@Column(name = "creator_id", length = 100, nullable = false)
//	private String creator_id;
	@Column(name = "route_name", length = 50, nullable = false)
	private String route_name;
	@Column(name = "route_descr", length = 200, nullable = false)
	private String route_descr;
	@Column(name = "route_type_index", length = 1, nullable = false)
	private Integer route_type_index;
	@Column(name = "route_duration_index", length = 1, nullable = false)
	private Integer route_duration_index;
	@Column(name = "diff_level_index", length = 1, nullable = false)
	private Integer diff_level_index;
	@ManyToMany
	@JoinTable
	(
	      name ="POIS_FOR_DRAFTS_ROUTES",
	      joinColumns = {@JoinColumn(name="route_id", referencedColumnName="route_id")},
	      inverseJoinColumns = {@JoinColumn(name="poi_id", referencedColumnName="poi_id", unique = true)}
	)
	private List<POI_entity> POIs_for_route;
	/**
	 * @return the route_id
	 */
	public Integer getRoute_id() {
		return route_id;
	}
	/**
	 * @param route_id the route_id to set
	 */
	public void setRoute_id(Integer route_id) {
		this.route_id = route_id;
	}
	/**
//	 * @return the creator_id
//	 */
//	public String getCreator_id() {
//		return creator_id;
//	}
//	/**
//	 * @param creator_id the creator_id to set
//	 */
//	public void setCreator_id(String creator_id) 
//	{
//		this.creator_id = creator_id;
//	}
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
	 * @return the route_type_index
	 */
	public Integer getRoute_type_index() {
		return route_type_index;
	}
	/**
	 * @param route_type_index the route_type_index to set
	 */
	public void setRoute_type_index(Integer route_type_index) {
		this.route_type_index = route_type_index;
	}
	/**
	 * @return the route_duration_index
	 */
	public Integer getRoute_duration_index() {
		return route_duration_index;
	}
	/**
	 * @param route_duration_index the route_duration_index to set
	 */
	public void setRoute_duration_index(Integer route_duration_index) {
		this.route_duration_index = route_duration_index;
	}
	/**
	 * @return the diff_level_index
	 */
	public Integer getDiff_level_index() {
		return diff_level_index;
	}
	/**
	 * @param diff_level_index the diff_level_index to set
	 */
	public void setDiff_level_index(Integer diff_level_index) {
		this.diff_level_index = diff_level_index;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the querySelectROfUser
	 */
	public static String getQuerySelectROfUser() {
		return QUERY_SELECT_R_OF_USER;
	}
	/**
	 * @return the pOIs_list_for_route
	 */
	public List<POI_entity> getPOIs_for_route() {
		return POIs_for_route;
	}
	/**
	 * @param pOIs_list_for_route the pOIs_list_for_route to set
	 */
	public void setPOIs_for_route(List<POI_entity> pOIs_for_route) {
		POIs_for_route = pOIs_for_route;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
		// TODO Auto-generated method stub
	
	

}
