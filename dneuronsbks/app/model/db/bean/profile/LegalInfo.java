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
@Table(name = "legal_info")
public class LegalInfo extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer legalInfoId;
	private String companyName;
	private String legealAddressId;
	private String termsAgreed;
	

	
	@Id
	@GeneratedValue
	@Column(name = "legal_info_id")
	public Integer getLegalInfoId() {
		return legalInfoId;
	}

	@Id
	@GeneratedValue
	@Column(name = "legal_info_id")
	public void setLegalInfoId(Integer accountId) {
		this.legalInfoId = accountId;
	}

	@Column(name = "company_name")
	public String getCompanyName() {
		return companyName;
	}

	

	@Column(name = "company_name")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "legal_address_id")
	public String getLegealAddressId() {
		return legealAddressId;
	}

	@Column(name = "legal_address_id")
	public void setLegealAddressId(String legealAddressId) {
		this.legealAddressId = legealAddressId;
	}

	@Column(name = "terms_agreed")
	public String getTermsAgreed() {
		return termsAgreed;
	}

	@Column(name = "terms_agreed")
	public void setTermsAgreed(String termsAgreed) {
		this.termsAgreed = termsAgreed;
	}
	
	public static Finder<Integer, LegalInfo> finder = new Finder<Integer, LegalInfo>("profile",
			Integer.class, LegalInfo.class);

}
