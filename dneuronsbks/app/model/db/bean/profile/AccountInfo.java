package model.db.bean.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
@PersistenceUnit(name="profile")
@Entity
@Table(name="account_info")
public class AccountInfo extends Model{
	
	
	private static final long serialVersionUID = 1L;
	private String accountId;
	private String companyName;
	private String username;
	private String password;
	private String addressId;
	private String legalInfoId;
	private String entitlementId;
	private String reportInfoId;
	private String status;
	private String role;
	private String lastLogin;
	private String profileInfoId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String reason;
	private String tempPass;
	private String isAccountVerified;
	private String activationId;
	
	
	@Id
	@GeneratedValue
	@Column(name="account_id")
	public String getAccountId() {
		return accountId;
	}
	
	@Column(name="company_name")
	public String getCompanyName() {
		return companyName;
	}
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	
	@Column(name="address_id")
	public String getAddressId() {
		return addressId;
	}
	
	@Column(name="legal_info_id")
	public String getLegalInfoId() {
		return legalInfoId;
	}
	
	@Column(name="entitlement_id")
	public String getEntitlementId() {
		return entitlementId;
	}
	
	@Column(name="report_info_id")
	public String getReportInfoId() {
		return reportInfoId;
	}
	
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public void setLegalInfoId(String legalInfoId) {
		this.legalInfoId = legalInfoId;
	}
	public void setEntitlementId(String entitlementId) {
		this.entitlementId = entitlementId;
	}
	public void setReportInfoId(String reportInfoId) {
		this.reportInfoId = reportInfoId;
	}

	@Column(name="status")
	public String getStatus() {
		return status;
	}

	@Column(name="role")
	public String getRole() {
		return role;
	}

	@Column(name="last_login")
	public String getLastLogin() {
		return lastLogin;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@Column(name="profile_info_id")
	public String getProfileInfoId() {
		return profileInfoId;
	}
	
	@Column(name="profile_info_id")
	public void setProfileInfoId(String profileInfoId) {
		this.profileInfoId = profileInfoId;
	}

	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}

	@Column(name="first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}

	@Column(name="last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Column(name="phone_number")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	@Column(name="email")
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="reason")
	public String getReason() {
		return reason;
	}

	@Column(name="reason")
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name="temp_pass")
	public String getTempPass() {
		return tempPass;
	}

	@Column(name="temp_pass")
	public void setTempPass(String tempPass) {
		this.tempPass = tempPass;
	}

	@Column(name="is_account_verified")
	public String getIsAccountVerified() {
		return isAccountVerified;
	}

	@Column(name="is_account_verified")	
	public void setIsAccountVerified(String isAccountVerified) {
		this.isAccountVerified = isAccountVerified;
	}

	@Column(name="activation_id")	
	public String getActivationId() {
		return activationId;
	}

	@Column(name="activation_id")	
	public void setActivationId(String activationId) {
		this.activationId = activationId;
	}

	public static Finder<Integer, AccountInfo> finder = new Finder<Integer, AccountInfo>("profile",
			Integer.class, AccountInfo.class);


}