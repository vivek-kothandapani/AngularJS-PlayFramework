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
@Table(name = "profile_info")
public class ProfileInfo extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7881149689302607962L;

	private Integer profileId;
	private String craBusNumber;
	private String craBusRT;
	private String qstRegNumber;
	private String craPayrollAcnt;
	private String craPayrollRp;
	private String mrqPayrollAcnt;
	private String yourIndustry;
	private String companyType;
	private String whatWeSell;

	@Id
	@GeneratedValue
	@Column(name = "profile_info_id")
	public Integer getProfileId() {
		return profileId;
	}

	@Id
	@GeneratedValue
	@Column(name = "profile_info_id")
	public void setProfileId(Integer accountId) {
		this.profileId = accountId;
	}

	@Column(name = "cra_bus_number")
	public String getCraBusNumber() {
		return craBusNumber;
	}

	@Column(name = "cra_bus_number")
	public void setCraBusNumber(String craBusNumber) {
		this.craBusNumber = craBusNumber;
	}

	@Column(name = "cra_bus_rt")
	public String getCraBusRT() {
		return craBusRT;
	}

	@Column(name = "cra_bus_rt")
	public void setCraBusRT(String craBusRT) {
		this.craBusRT = craBusRT;
	}

	@Column(name = "qst_reg_number")
	public String getQstRegNumber() {
		return qstRegNumber;
	}

	@Column(name = "qst_reg_number")
	public void setQstRegNumber(String qstRegNumber) {
		this.qstRegNumber = qstRegNumber;
	}

	@Column(name = "cra_payroll_acnt")
	public String getCraPayrollAcnt() {
		return craPayrollAcnt;
	}

	@Column(name = "cra_payroll_acnt")
	public void setCraPayrollAcnt(String craPayrollAcnt) {
		this.craPayrollAcnt = craPayrollAcnt;
	}

	@Column(name = "cra_payroll_rp")
	public String getCraPayrollRp() {
		return craPayrollRp;
	}

	@Column(name = "cra_payroll_rp")
	public void setCraPayrollRp(String craPayrollRp) {
		this.craPayrollRp = craPayrollRp;
	}

	@Column(name = "mrq_payroll_acnt")
	public String getMrqPayrollAcnt() {
		return mrqPayrollAcnt;
	}

	@Column(name = "mrq_payroll_acnt")
	public void setMrqPayrollAcnt(String mrqPayrollAcnt) {
		this.mrqPayrollAcnt = mrqPayrollAcnt;
	}

	@Column(name = "your_industry")
	public String getYourIndustry() {
		return yourIndustry;
	}

	@Column(name = "your_industry")
	public void setYourIndustry(String yourIndustry) {
		this.yourIndustry = yourIndustry;
	}
	@Column(name = "company_type")
	public String getCompanyType() {
		return companyType;
	}

	@Column(name = "company_type")
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	@Column(name = "what_we_sell")
	public String getWhatWeSell() {
		return whatWeSell;
	}

	@Column(name = "what_we_sell")
	public void setWhatWeSell(String whatWeSell) {
		this.whatWeSell = whatWeSell;
	}

	
	public static Finder<Integer, ProfileInfo> finder = new Finder<Integer, ProfileInfo>("profile",
			Integer.class, ProfileInfo.class);

}
