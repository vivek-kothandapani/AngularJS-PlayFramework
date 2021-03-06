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

@Table(name = "accounting.customer")
@Entity
public class CustomerTable extends Model {

	/**
	 * customer_id int UNSIGNED NOT NULL AUTO_INCREMENT, account_id int UNSIGNED
	 * NOT NULL, account_username varchar(255), code_id int UNSIGNED, firstname
	 * varchar(255), lastname varchar(255), title varchar(10), display_name
	 * varchar(255) NOT NULL, company_name varchar(255), email varchar(255),
	 * phone varchar(20), remarks varchar(255), status varchar(10), created_date
	 * datetime, created_by int UNSIGNED, modified_date datetime, modified_by
	 * int UNSIGNED,
	 */
	private static final long serialVersionUID = 1L;
	private String customerId;
	private String displayName;
	private String accountId;
	private String codeId;
	private String companyName;
	private String accountUsername;
	private String firstname;
	private String lastname;
	private String title;
	private String email;
	private String phone;
	private String remarks;
	private String status;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	private String amount;
	private String stateCode;
	private String countryCode;

	public CustomerTable() {
		super();
	}

	public CustomerTable create(controllers.beans.CustomerVo customer) {
		
		mapCustomerVoToCustomerTable(customer);
		this.save("accounting");
		return this;
	}
	
	public CustomerTable edit(controllers.beans.CustomerVo customer) {
		
		mapCustomerVoToCustomerTable(customer);
		this.customerId = customer.getCustomerId();
		this.update("accounting");
		return this;
	}
	
	private void mapCustomerVoToCustomerTable(controllers.beans.CustomerVo customerVo){
		
		this.accountId = customerVo.getAccountId();
		this.companyName = customerVo.getCompanyName();
		this.accountUsername = customerVo.getAccountUsername();
		this.firstname = customerVo.getFirstName();
		this.lastname = customerVo.getLastName();
		this.email = customerVo.getEmail();
		this.phone = customerVo.getPhone();
		this.displayName = customerVo.getDisplayName();
		this.title = customerVo.getTitle();

		this.codeId = customerVo.getCodeId();
		this.remarks = customerVo.getRemarks();
		this.status = customerVo.getStatus();
		this.createdDate = customerVo.getCreatedDate();
		this.createdBy = customerVo.getCreatedBy();
		this.modifiedDate = customerVo.getModifiedDate();
		this.modifiedBy = customerVo.getModifiedBy();
		this.amount = customerVo.getAmount();
		
		this.stateCode = customerVo.getStateCode();
		this.countryCode = customerVo.getCountryCode(); 
	}

	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	public String getCustomerId() {
		return customerId;
	}

	@Column(name = "code_id")
	public String getCodeId() {
		return codeId;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
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

	@Column(name = "account_id")
	public String getAccountId() {
		return accountId;
	}

	@Column(name = "company_name")
	public String getCompanyName() {
		return companyName;
	}

	@Column(name = "account_username")
	public String getAccountUsername() {
		return accountUsername;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	@Column(name = "display_name")
	public String getDisplayName() {
		return displayName;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	@Column(name = "amount")
	public String getAmount() {
		return amount;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Column(name = "state_code")
	public String getStateCode() {
		return stateCode;
	}

	@Column(name = "country_code")
	public String getCountryCode() {
		return countryCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public static Finder<String, CustomerTable> finder = new Finder<String, CustomerTable>(
			"accounting", String.class, CustomerTable.class);

}