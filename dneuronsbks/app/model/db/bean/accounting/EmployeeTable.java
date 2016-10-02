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

@Table(name = "accounting.employee")
@Entity
public class EmployeeTable extends Model {

	/**
	 * employee_id int UNSIGNED NOT NULL AUTO_INCREMENT, account_id int UNSIGNED
	 * NOT NULL, account_username varchar(255), code_id int UNSIGNED, firstname
	 * varchar(255), lastname varchar(255), title varchar(10), display_name
	 * varchar(255) NOT NULL, company_name varchar(255), email varchar(255),
	 * phone varchar(20), remarks varchar(255), status varchar(10), created_date
	 * datetime, created_by int UNSIGNED, modified_date datetime, modified_by
	 * int UNSIGNED,
	 */
	private static final long serialVersionUID = 1L;
	private String employeeId;
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

	public EmployeeTable() {
		super();
	}

	public EmployeeTable create(controllers.beans.EmployeeVo employee) {
		this.accountId = employee.getAccountId();
		this.companyName = employee.getCompanyName();
		this.accountUsername = employee.getAccountUsername();
		this.firstname = employee.getFirstname();
		this.lastname = employee.getLastname();
		this.email = employee.getEmail();
		this.phone = employee.getPhone();
		this.displayName = employee.getDisplayName();
		this.title = employee.getTitle();

		this.codeId = employee.getCodeId();
		this.remarks = employee.getRemarks();
		this.status = employee.getStatus();
		this.createdDate = employee.getCreatedDate();
		this.createdBy = employee.getCreatedBy();
		this.modifiedDate = employee.getModifiedDate();
		this.modifiedBy = employee.getModifiedBy();
		this.amount = employee.getAmount();
		
		this.stateCode = employee.getStateCode();
		//this.countryCode = 

		this.save("accounting");
		return this;
	}

	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	public String getEmployeeId() {
		return employeeId;
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

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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


	public static Finder<String, EmployeeTable> finder = new Finder<String, EmployeeTable>(
			"accounting", String.class, EmployeeTable.class);

}