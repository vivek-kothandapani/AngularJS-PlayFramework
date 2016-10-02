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

@Table(name = "accounting.code_sub_group")
@Entity
public class CodeSubGroupTable extends Model {

	/**
	 *CREATE TABLE accounting.code_sub_group
(
 sub_group_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 group_id int UNSIGNED,
 code varchar(255),
 name varchar(255),
 remarks varchar(255),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 modified_by int UNSIGNED,
 PRIMARY KEY (sub_group_id)
);

	 */
	private static final long serialVersionUID = 1L;
	private String subGroupId;
	private String code;
	private String name;
	private String remarks;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	private String sortOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="group_id")
	private CodeGroupTable codeGroupTable;
	
	public CodeSubGroupTable() {
		super();
	}

	public CodeSubGroupTable create(controllers.beans.codebeans.CodeSubGroupVo codeSubGroupVo) {
		this.code = codeSubGroupVo.getCode();
		this.name = codeSubGroupVo.getName();
		this.remarks = codeSubGroupVo.getRemarks();
		this.createdDate = codeSubGroupVo.getCreatedDate();
		this.createdBy = codeSubGroupVo.getCreatedBy();
		this.modifiedDate = codeSubGroupVo.getModifiedBy();
		this.modifiedBy = codeSubGroupVo.getModifiedBy();

		this.save("accounting");
		return this;
	}

	public static Finder<String, CodeSubGroupTable> finder = new Finder<String, CodeSubGroupTable>(
			"accounting", String.class, CodeSubGroupTable.class);

	@Id
	@GeneratedValue
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
	
	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
	}

	public CodeGroupTable getCodeGroupTable() {
		return codeGroupTable;
	}

	public void setCodeGroupTable(CodeGroupTable codeGroupTable) {
		this.codeGroupTable = codeGroupTable;
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

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

}