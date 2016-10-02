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

@Table(name = "accounting.code_account_type")
@Entity
public class CodeAccountTypeTable extends Model {

	/**
	 *
CREATE TABLE accounting.code_account_type
(
 account_type_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 sub_group_id int UNSIGNED,
 code varchar(255),
 name varchar(255),
 remarks varchar(255),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 modified_by int UNSIGNED,
 PRIMARY KEY (account_type_id)
);

	 */
	private static final long serialVersionUID = 1L;
	private String accountTypeId;
	private String code;
	private String name;
	private String remarks;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	private String subGroupId;
	private String sortOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sub_group_id")
	private CodeSubGroupTable codeSubGroupTable;
	
	public CodeSubGroupTable getCodeSubGroupTable() {
		return codeSubGroupTable;
	}

	public void setCodeSubGroupTable(CodeSubGroupTable codeSubGroupTable) {
		this.codeSubGroupTable = codeSubGroupTable;
	}

	public CodeAccountTypeTable() {
		super();
	}

	public CodeAccountTypeTable create(controllers.beans.codebeans.CodeAccountTypeVo codeAccountTypeVo) {
		this.code = codeAccountTypeVo.getCode();
		this.name = codeAccountTypeVo.getName();
		this.remarks = codeAccountTypeVo.getRemarks();
		this.createdDate = codeAccountTypeVo.getCreatedDate();
		this.createdBy = codeAccountTypeVo.getCreatedBy();
		this.modifiedDate = codeAccountTypeVo.getModifiedBy();
		this.modifiedBy = codeAccountTypeVo.getModifiedBy();

		this.save("accounting");
		return this;
	}

	public static Finder<String, CodeAccountTypeTable> finder = new Finder<String, CodeAccountTypeTable>(
			"accounting", String.class, CodeAccountTypeTable.class);

	@Id
	@GeneratedValue
	@Column(name = "account_type_id")
	public String getAccountTypeId() {
		return accountTypeId;
	}
	
	@Column(name = "sub_group_id")
	public String getSubGroupId() {
		return subGroupId;
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
	
	@Column(name = "sort_order")
	public String getSortOrder() {
		return sortOrder;
	}
	
	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
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
	
	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}