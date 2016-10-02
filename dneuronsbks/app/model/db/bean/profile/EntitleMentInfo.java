package model.db.bean.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@PersistenceUnit(name = "profile")
@Table(name = "entitlement_info")
public class EntitleMentInfo extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6742962980792964026L;

	private Integer entitlementId;
	private String entitlementList;
	private String sku;

	@Id
	@GeneratedValue
	@Column(name = "entitlement_id")
	public Integer getEntitlementId() {
		return entitlementId;
	}

	@Column(name = "entitlement_id")
	public void setEntitlementId(Integer entitlementId) {
		this.entitlementId = entitlementId;
	}

	@Column(name = "entitlement_list")
	public String getEntitlementList() {
		return entitlementList;
	}

	@Column(name = "entitlement_list")
	public void setEntitlementList(String entitlementList) {
		this.entitlementList = entitlementList;
	}

	@Column(name = "sku")
	public String getSku() {
		return sku;
	}

	@Column(name = "sku")
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public static Finder<Integer, EntitleMentInfo> finder = new Finder<Integer, EntitleMentInfo>("profile",
			Integer.class, EntitleMentInfo.class);

}
