package model.db.bean.accounting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

import model.db.bean.profile.AccountInfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Table(name = "accounting.code")
@Entity
public class CodeTable extends Model {

	/**
	 *
CREATE TABLE accounting.code
(
 code_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 account_type_id int UNSIGNED,
 code varchar(255),
 name varchar(255),
 report_ref_id int UNSIGNED,
 remarks varchar(255),
 country varchar(10),
 region varchar(10),
 status varchar(10),
 visibility varchar(10),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 modified_by int UNSIGNED,
 PRIMARY KEY (code_id)
);

	 */
	private static final long serialVersionUID = 1L;
	private String codeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="account_type_id")
	private CodeAccountTypeTable codeAccountTypeTable;
	
	private String accountTypeId;
	private String code;
	private String name;
	private String reportRefId;
	private String remarks;
	private String country;
	private String region;
	private String status;
	private String visibility;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;

	public CodeTable() {
		super();
	}

	public CodeTable create(controllers.beans.codebeans.CodeVo codeVo) {
		
		//this.codeId  = codeVo.getCodeId();
		//this.accountTypeTable = codeVo.getAccountTypeTable();
		this.reportRefId = codeVo.getReportRefId();
		this.country = codeVo.getCountry();
		this.region = codeVo.getRegion();
		this.status = codeVo.getStatus();
		this.visibility = codeVo.getVisibility();
		this.code = codeVo.getCode();
		this.name = codeVo.getName();
		this.remarks = codeVo.getRemarks();
		this.createdDate = codeVo.getCreatedDate();
		this.createdBy = codeVo.getCreatedBy();
		this.modifiedDate = codeVo.getModifiedBy();
		this.modifiedBy = codeVo.getModifiedBy();

		this.save("accounting");
		return this;
	}

	public static Finder<String, CodeTable> finder = new Finder<String, CodeTable>(
			"accounting", String.class, CodeTable.class);

	@Id
	@GeneratedValue
	@Column(name = "code_id")
	public String getCodeId() {
		return codeId;
	}
	
	@Column(name = "account_type_id")
	public String getAccountTypeId() {
		return accountTypeId;
	}
	
	@Column(name = "code")
	public String getCode() {
		return code;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	@Column(name = "report_ref_id")
	public String getReportRefId() {
		return reportRefId;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	@Column(name = "region")
	public String getRegion() {
		return region;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	@Column(name = "visibility")
	public String getVisibility() {
		return visibility;
	}
	
	
	@Column(name = "created_date")
	public String getCreatedDate() {
		return createdDate;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}

	@Column(name = "modified_date")
	public String getModifiedDate() {
		return modifiedDate;
	}

	@Column(name = "modified_by")
	public String getModifiedBy() {
		return modifiedBy;
	}
	
	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	
	public CodeAccountTypeTable getCodeAccountTypeTable() {
		return codeAccountTypeTable;
	}

	public void setCodeAccountTypeTable(CodeAccountTypeTable codeAccountTypeTable) {
		this.codeAccountTypeTable = codeAccountTypeTable;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public void setReportRefId(String reportRefId) {
		this.reportRefId = reportRefId;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}