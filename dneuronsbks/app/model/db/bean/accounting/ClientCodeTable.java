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

@Table(name = "accounting.client_code")
@Entity
public class ClientCodeTable extends Model {


	/**
	 *
	 *CREATE TABLE accounting.client_code
(
 account_id int UNSIGNED,
 code_id int UNSIGNED,
 remarks varchar(255),
 status varchar(10),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 mofified_by int UNSIGNED
);

	 */
	private static final long serialVersionUID = 1L;
	private String clientCodeId;
	private String accountId;
	private String codeId;
	private String status;
	private String remarks;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;

	public ClientCodeTable() {
		super();
	}

	public ClientCodeTable create(controllers.beans.codebeans.ClientCodeVo clientCodeVo) {
		this.codeId = clientCodeVo.getCodeId();
		this.accountId = clientCodeVo.getAccountId();
		this.remarks = clientCodeVo.getRemarks();
		this.createdDate = clientCodeVo.getCreatedDate();
		this.createdBy = clientCodeVo.getCreatedBy();
		this.modifiedDate = clientCodeVo.getModifiedBy();
		this.modifiedBy = clientCodeVo.getModifiedBy();

		this.save("accounting");
		return this;
	}

	public static Finder<String, ClientCodeTable> finder = new Finder<String, ClientCodeTable>(
			"accounting", String.class, ClientCodeTable.class);

	@Id
	@GeneratedValue	
	@Column(name = "client_code_id")
	public String getClientCodeId() {
		return clientCodeId;
	}

	@Column(name = "account_id")
	public String getAccountId() {
		return accountId;
	}

	@Column(name = "code_id")
	public String getCodeId() {
		return codeId;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
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
	
	public void setClientCodeId(String clientCodeId) {
		this.clientCodeId = clientCodeId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public void setStatus(String status) {
		this.status = status;
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

}