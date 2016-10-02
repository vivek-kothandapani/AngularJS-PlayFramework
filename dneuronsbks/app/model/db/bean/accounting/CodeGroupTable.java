package model.db.bean.accounting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

import model.db.bean.profile.AccountInfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Table(name = "accounting.code_group")
@Entity
public class CodeGroupTable extends Model {

	/**
	 *CREATE TABLE accounting.code_group
(
 group_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 code varchar(255),
 name varchar(255),
 remarks varchar(255),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 modified_by int UNSIGNED,
 PRIMARY KEY (group_id)
);

	 */
	private static final long serialVersionUID = 1L;
	private String groupId;
	private String code;
	private String name;
	private String remarks;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	private String sortOrder;

	public CodeGroupTable() {
		super();
	}

	public CodeGroupTable create(controllers.beans.codebeans.CodeGroupVo codeGroupVo) {
		this.code = codeGroupVo.getCode();
		this.name = codeGroupVo.getName();
		this.remarks = codeGroupVo.getRemarks();
		this.createdDate = codeGroupVo.getCreatedDate();
		this.createdBy = codeGroupVo.getCreatedBy();
		this.modifiedDate = codeGroupVo.getModifiedBy();
		this.modifiedBy = codeGroupVo.getModifiedBy();
		this.setSortOrder(codeGroupVo.getSortOrder());

		this.save("accounting");
		return this;
	}

	public static Finder<String, CodeGroupTable> finder = new Finder<String, CodeGroupTable>(
			"accounting", String.class, CodeGroupTable.class);

	@Id
	@GeneratedValue
	@Column(name = "group_id")
	public String getGroupId() {
		return groupId;
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
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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