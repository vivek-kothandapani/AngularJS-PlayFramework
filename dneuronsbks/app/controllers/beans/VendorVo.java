package controllers.beans;

import controllers.beans.codebeans.CodeVo;

public class VendorVo {
	private String vendorId;
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
	private CodeVo codeVo;
	private String amount;
	private String stateCode;
	private String countryCode;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getVendorId() {
		return vendorId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getCodeId() {
		return codeId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getAccountUsername() {
		return accountUsername;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getTitle() {
		return title;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getStatus() {
		return status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public CodeVo getCodeVo() {
		return codeVo;
	}

	public void setCodeVo(CodeVo codeVo) {
		this.codeVo = codeVo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}


}