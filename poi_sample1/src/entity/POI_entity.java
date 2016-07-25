/**
 * 
 */
package entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import objests_interfaces.POI_IF;
import parameters_for_filtering.Constants_for_pois;


/**
 * @author Olga Deryabina
 * This entity class is the implementation of the POI_IF interface. It maps the Java object with all the necessary attributes to
 * the database table and allows to work with the database using JPA functionality. It contains the native methods to manipulate the
 * entity objects as far as some methods inherited from POI_IF interface to create the objects with extra attributes and to convert
 * them to POI_IF to manipulate them on the front end.
 */
@Entity(name = "POI_entity")
@Table(name = "pois")
@Access(AccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = POI_entity.QUERY_SELECT_ALL_P, query = "SELECT ps FROM POI_entity ps")
  
})
public class POI_entity implements POI_IF
{
	private static final long serialVersionUID = -3734214797018809479L;
	public static final String QUERY_SELECT_ALL_P = "select_all_pois";
    public static final String QUERY_SELECT_P_OF_USER = "find_p_of_user";
   

	public POI_entity ()
	{
		
	}
	@Id
	@Column (name = "poi_id", length = 100, nullable = false, unique = true)
	private String poi_id;
	@Column(name = "creator_id", length = 30, nullable = false)
	private String creator_id;
	@Column(name = "poi_name", length = 50, nullable = false)
	private String poi_name;
	@Column(name = "main_poi_id", length = 30, nullable = true)
	private Integer main_poi_id;
	@Column(name = "lat", length = 10, precision = 7, nullable = false)
	private float poi_lat;
	@Column(name = "longit", length = 10, precision = 7, nullable = false)
	private float poi_lng;
	@Column(name = "town", length = 30, nullable = false)
	private String town;
	@Column(name = "street", length = 30, nullable = true)
	private String street;
	@Column(name = "building", length = 20, nullable = true)
	private String building;
	@Column(name = "post_code", length = 10, nullable = true)
	private String post_code;
	@Column(name = "district_index", length = 2, nullable = false)
	private Integer district_index;
	@Column(name = "avail_index", length = 2, nullable = false)
	private Integer avail_index;
	@Column(name = "status_index", length = 2, nullable = false)
	private Integer status_index;
	@Column(name = "poi_main_cat_index", length = 2, nullable = false)
	private Integer poi_main_cat_index;
	@Column(name = "poi_add_cat_index", length = 2, nullable = false)
	private Integer poi_add_cat_index;
	@Column(name = "poi_sub1_index", length = 2, nullable = false)
	private Integer poi_sub1_index;
	@Column(name = "poi_sub2_index", length = 2, nullable = false)
	private Integer poi_sub2_index;
	@Column(name = "poi_period_index", length = 2, nullable = false)
	private Integer poi_period_index;
	@Column(name = "rating", length = 1, nullable = false)
	private Integer rating_index;
	@Column(name = "descript", length = 200, nullable = false)
	private String descript;
	@Column(name = "weblink", length = 50, nullable = true)
	private String weblink;
	@Temporal(TemporalType.DATE)
	@Column (name = "create_date", length = 12, nullable = true)
	private Date creation_date;
	@Temporal(TemporalType.DATE)
	@Column (name = "modified", length = 12, nullable = true)
	private Date modifDate;
	@Column(name = "modified_by", length = 100, nullable = true)
	private String modified_by;
	
	/**
	 * @return the poi_id
	 */
	public String getPoi_id() {
		return poi_id;
	}
	/**
	 * @param poi_id the poi_id to set
	 */
	public void setPoi_id(String poi_id) {
		this.poi_id = poi_id;
	}
	/**
	 * @return the creator_id
	 */
	@Override
	public String getCreator_id() {
		return creator_id;
	}
	/**
	 * @param creator_id the creator_id to set
	 */
	
	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}
	/**
	 * @return the poi_name
	 */
	public String getPoi_name() {
		return poi_name;
	}
	/**
	 * @param poi_name the poi_name to set
	 */
	public void setPoi_name(String poi_name) {
		this.poi_name = poi_name;
	}
	/**
	 * @return the main_poi_id
	 */
	public Integer getMain_poi_id() {
		return main_poi_id;
	}
	/**
	 * @param main_poi_id the main_poi_id to set
	 */
	public void setMain_poi_id(Integer main_poi_id) {
		this.main_poi_id = main_poi_id;
	}
	/**
	 * @return the lat
	 */
	public float getPoi_lat() {
		return poi_lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setPoi_lat(float poi_lat) {
		this.poi_lat = poi_lat;
	}
	/**
	 * @return the longit
	 */
	public float getPoi_lng() {
		return poi_lng;
	}
	/**
	 * @param longit the longit to set
	 */
	public void setPoi_lng(float poi_lng) {
		this.poi_lng = poi_lng;
	}
	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}
	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}
	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}
	/**
	 * @return the post_code
	 */
	public String getPost_code() {
		return post_code;
	}
	/**
	 * @param post_code the post_code to set
	 */
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	/**
	 * @return the district_index
	 */
	public Integer getDistrict_index() {
		return district_index;
	}
	/**
	 * @param district_index the district_index to set
	 */
	public void setDistrict_index(Integer district_index) {
		this.district_index = district_index;
	}
	/**
	 * @return the avail_index
	 */
	public Integer getAvail_index() {
		return avail_index;
	}
	/**
	 * @param avail_index the avail_index to set
	 */
	public void setAvail_index(Integer avail_index) {
		this.avail_index = avail_index;
	}
	/**
	 * @return the status_index
	 */
	public Integer getStatus_index() {
		return status_index;
	}
	/**
	 * @param status_index the status_index to set
	 */
	public void setStatus_index(Integer status_index) {
		this.status_index = status_index;
	}
	/**
	 * @return the poi_main_cat_index
	 */
	public Integer getPoi_main_cat_index() {
		return poi_main_cat_index;
	}
	/**
	 * @param poi_main_cat_index the poi_main_cat_index to set
	 */
	public void setPoi_main_cat_index(Integer poi_main_cat_index) {
		this.poi_main_cat_index = poi_main_cat_index;
	}
	/**
	 * @return the poi_add_cat_index
	 */
	public Integer getPoi_add_cat_index() {
		return poi_add_cat_index;
	}
	/**
	 * @param poi_add_cat_index the poi_add_cat_index to set
	 */
	public void setPoi_add_cat_index(Integer poi_add_cat_index) {
		this.poi_add_cat_index = poi_add_cat_index;
	}
	/**
	 * @return the poi_sub1_index
	 */
	public Integer getPoi_sub1_index() {
		return poi_sub1_index;
	}
	/**
	 * @param poi_sub1_index the poi_sub1_index to set
	 */
	public void setPoi_sub1_index(Integer poi_sub1_index) {
		this.poi_sub1_index = poi_sub1_index;
	}
	/**
	 * @return the poi_sub2_index
	 */
	public Integer getPoi_sub2_index() {
		return poi_sub2_index;
	}
	/**
	 * @param poi_sub2_index the poi_sub2_index to set
	 */
	public void setPoi_sub2_index(Integer poi_sub2_index) {
		this.poi_sub2_index = poi_sub2_index;
	}
	/**
	 * @return the poi_period_index
	 */
	public Integer getPoi_period_index() {
		return poi_period_index;
	}
	/**
	 * @param poi_period_index the poi_period_index to set
	 */
	public void setPoi_period_index(Integer poi_period_index) {
		this.poi_period_index = poi_period_index;
	}
	/**
	 * @return the rating_index
	 */
	public Integer getRating_index() {
		return rating_index;
	}
	/**
	 * @param rating_index the rating_index to set
	 */
	public void setRating_index(Integer rating_index) {
		this.rating_index = rating_index;
	}
	/**
	 * @return the descript
	 */
	public String getDescript() {
		return descript;
	}
	/**
	 * @param descript the descript to set
	 */
	public void setDescript(String descript) {
		this.descript = descript;
	}
	/**
	 * @return the weblink
	 */
	public String getWeblink() {
		return weblink;
	}
	/**
	 * @param weblink the weblink to set
	 */
	public void setWeblink(String weblink) {
		this.weblink = weblink;
	}
	
	/**
	 * @return the creation_date
	 */
	public Date getCreation_date() {
		return creation_date;
	}
	/**
	 * @param creation_date the creation_date to set
	 */
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
	/**
	 * @return the modifDate
	 */
	public Date getModifDate() {
		return modifDate;
	}
	/**
	 * @param modifDate the modifDate to set
	 */
	public void setModifDate(Date modifDate) {
		this.modifDate = modifDate;
	}
	/**
	 * @return the modified_by
	 */
	public String getModified_by() {
		return modified_by;
	}
	/**
	 * @param modified_by the modified_by to set
	 */
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	
	@Override
	/**
	 * @return the pendStatus
	 */
	public String getPendStatus() {
		return "newMod";
	}
	
	
	@Override
	public String getSingle_status() {
		// TODO Auto-generated method stub
		return Constants_for_pois.status[this.status_index];
	}
	
	@Override
	public String getSingle_poi_sub2() {
		// TODO Auto-generated method stub
		return Constants_for_pois.poi_sub2[this.poi_sub2_index];
	}
	
	@Override
	public String getSingle_district() {
		// TODO Auto-generated method stub
		return Constants_for_pois.district[this.district_index];
	}
	
	@Override
	public String getSingle_avail() {
		// TODO Auto-generated method stub
		return Constants_for_pois.avail[this.avail_index];
	}
	
	@Override
	public String getSingle_poi_main_cat() {
		// TODO Auto-generated method stub
		return Constants_for_pois.poi_main_cat[this.poi_main_cat_index];
	}
	
	@Override
	public String getSingle_poi_add_cat() {
		// TODO Auto-generated method stub
		return Constants_for_pois.poi_add_cat[this.poi_add_cat_index];
	}
	
	@Override
	public String getSingle_poi_sub1() {
		// TODO Auto-generated method stub
		return Constants_for_pois.poi_sub1[this.poi_sub1_index];
	}
	
	@Override
	public String getSingle_poi_period() {
		// TODO Auto-generated method stub
		return Constants_for_pois.poi_period[this.poi_period_index];
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((avail_index == null) ? 0 : avail_index.hashCode());
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((creator_id == null) ? 0 : creator_id.hashCode());
		result = prime * result + ((descript == null) ? 0 : descript.hashCode());
		result = prime * result + ((district_index == null) ? 0 : district_index.hashCode());
		result = prime * result + ((main_poi_id == null) ? 0 : main_poi_id.hashCode());
		result = prime * result + ((poi_add_cat_index == null) ? 0 : poi_add_cat_index.hashCode());
		result = prime * result + ((poi_id == null) ? 0 : poi_id.hashCode());
		result = prime * result + Float.floatToIntBits(poi_lat);
		result = prime * result + Float.floatToIntBits(poi_lng);
		result = prime * result + ((poi_main_cat_index == null) ? 0 : poi_main_cat_index.hashCode());
		result = prime * result + ((poi_name == null) ? 0 : poi_name.hashCode());
		result = prime * result + ((poi_period_index == null) ? 0 : poi_period_index.hashCode());
		result = prime * result + ((poi_sub1_index == null) ? 0 : poi_sub1_index.hashCode());
		result = prime * result + ((poi_sub2_index == null) ? 0 : poi_sub2_index.hashCode());
		result = prime * result + ((post_code == null) ? 0 : post_code.hashCode());
		result = prime * result + ((rating_index == null) ? 0 : rating_index.hashCode());
		result = prime * result + ((status_index == null) ? 0 : status_index.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
		result = prime * result + ((weblink == null) ? 0 : weblink.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		POI_entity other = (POI_entity) obj;
		if (creator_id == null) {
			if (other.creator_id != null)
				return false;
		} else if (!creator_id.equals(other.creator_id))
			return false;
		if (poi_id == null) {
			if (other.poi_id != null)
				return false;
		} else if (!poi_id.equals(other.poi_id))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "POI_entity [poi_id=" + poi_id + ", creator_id=" + creator_id + ", poi_name=" + poi_name
				+ ", main_poi_id=" + main_poi_id + ", poi_lat=" + poi_lat + ", poi_lng=" + poi_lng + ", town=" + town
				+ ", street=" + street + ", building=" + building + ", post_code=" + post_code + ", district_index="
				+ district_index + ", avail_index=" + avail_index + ", status_index=" + status_index
				+ ", poi_main_cat_index=" + poi_main_cat_index + ", poi_add_cat_index=" + poi_add_cat_index
				+ ", poi_sub1_index=" + poi_sub1_index + ", poi_sub2_index=" + poi_sub2_index + ", poi_period_index="
				+ poi_period_index + ", rating_index=" + rating_index + ", descript=" + descript + ", weblink="
				+ weblink + ", creation_date=" + creation_date + ", modifDate=" + modifDate + ", modified_by="
				+ modified_by + "]";
	}
	
	
}
