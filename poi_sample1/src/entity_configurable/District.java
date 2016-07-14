package entity_configurable;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DISTRICTS database table.
 * 
 */
@Entity(name = "District")
@Table(name="DISTRICTS")
@NamedQuery(name=District.GET_ALL_DISTR, query="SELECT d FROM District d")
public class District implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1547310878622802376L;

	public static final String GET_ALL_DISTR = "find_all_distr";

	@Id
	@Column(name="DISTR_INDEX")
	private Integer distrIndex;

	@Column(name="DISTR_NAME")
	private String distrName;

	@Column(name="SHOW_FOR_FILTERS")
	private Integer showForFilters;

	public District() {
	}
	
	public District (Integer distrIndex, String distrName, Integer showForFilters) {
		this.distrIndex = distrIndex;
		this.distrName = distrName;
		this.showForFilters = showForFilters;
	}

	public Integer getDistrIndex() {
		return this.distrIndex;
	}

	public void setDistrIndex(Integer distrIndex) {
		this.distrIndex = distrIndex;
	}

	public String getDistrName() {
		return this.distrName;
	}

	public void setDistrName(String distrName) {
		this.distrName = distrName;
	}

	public Integer getShowForFilters() {
		return this.showForFilters;
	}

	public void setShowForFilters(Integer showForFilters) {
		this.showForFilters = showForFilters;
	}

}