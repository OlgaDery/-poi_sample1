package objests_interfaces;

import java.io.Serializable;

public interface POI_IF extends Serializable {

	/**
	 * @return the poi_id
	 */
	String getPoi_id();
	
	/**
	 * @return the poi_name
	 */	
	
	String getPoi_name();

	/**
	 * @return the poi_lat
	 */
	float getPoi_lat();

	/**
	 * @return the poi_lng
	 */
	float getPoi_lng();
	
	/**
	 * @return the main_poi_id
	 */
	Integer getMain_poi_id();

	/**
	 * @return the town
	 */
	String getTown();


	String getStreet();

	/**
	 * @return the building
	 */
	String getBuilding();

	/**
	 * @return the post_code
	 */
	String getPost_code();

	/**
	 * @return the single_status
	 */
	String getSingle_status();
	
	void setSingle_status(String status);
	
	/**
	 * @return the single_poi_sub2
	 */
	String getSingle_poi_sub2();
	

	void setSingle_poi_sub2(String subcat2);
	/**
	 * @return the single_district
	 */
	String getSingle_district();
	
	
	void setSingle_district(String district);

	/**
	 * @return the single_avail
	 */
	String getSingle_avail();
	
	void setSingle_avail(String avail);

	/**
	 * @return the single_poi_main_cat
	 */
	String getSingle_poi_main_cat();
	
	void setSingle_poi_main_cat(String mainCat);

	/**
	 * @return the single_poi_add_cat
	 */
	String getSingle_poi_add_cat();
	
	void setSingle_poi_add_cat(String addCat);

	/**
	 * @return the single_poi_sub1
	 */
	String getSingle_poi_sub1();
	
	void setSingle_poi_sub1(String sub1);

	/**
	 * @return the single_poi_period
	 */
	String getSingle_poi_period();
	
	void setSingle_poi_period(String period);

	/**
	 * @return the district_index
	 */
	Integer getDistrict_index();

	/**
	 * @return the avail_index
	 */
	Integer getAvail_index();

	/**
	 * @return the status_index
	 */
	Integer getStatus_index();

	/**
	 * @return the poi_main_cat_index
	 */
	Integer getPoi_main_cat_index();

	/**
	 * @return the poi_add_cat_index
	 */
	Integer getPoi_add_cat_index();

	/**
	 * @return the poi_sub1_index
	 */
	Integer getPoi_sub1_index();

	/**
	 * @return the poi_sub2_index
	 */
	Integer getPoi_sub2_index();

	/**
	 * @return the poi_period_index
	 */
	Integer getPoi_period_index();

	/**
	 * @return the rating_index
	 */
	Integer getRating_index();

	/**
	 * @return the descript
	 */
	String getDescript();

	/**
	 * @return the weblink
	 */
	String getWeblink();
	
	void setPendStatus(String pendStatus);
	
	String getPendStatus();
	
	void setCreator_id(String creatorID);
	
	String getCreator_id();


}