package controllers.beans.codebeans;

public class CodeVo {
	private String codeId;
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
	
	//Account Type
	private String accountTypeCodeId;
	private String accountTypeCode;
	private String acoountTypeCodeName;
	//Sub Group
	private String subGroupCodeId;
	private String subGroupCode;
	private String subGroupCodeName;
	//Group
	private String groupCodeId;
	private String groupCode;
	
	
	private String amount;
	private String sortOrder;
	
	public String getAccountTypeCode() {
		return accountTypeCode;
	}

	public String getSubGroupCode() {
		return subGroupCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	public void setSubGroupCode(String subGroupCode) {
		this.subGroupCode = subGroupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	private String groupCodeName;

	public String getAccountTypeCodeId() {
		return accountTypeCodeId;
	}

	public String getAcoountTypeCodeName() {
		return acoountTypeCodeName;
	}

	public String getSubGroupCodeId() {
		return subGroupCodeId;
	}

	public String getSubGroupCodeName() {
		return subGroupCodeName;
	}

	public String getGroupCodeId() {
		return groupCodeId;
	}

	public String getGroupCodeName() {
		return groupCodeName;
	}

	public void setAccountTypeCodeId(String accountTypeCodeId) {
		this.accountTypeCodeId = accountTypeCodeId;
	}

	public void setAcoountTypeCodeName(String acoountTypeCodeName) {
		this.acoountTypeCodeName = acoountTypeCodeName;
	}

	public void setSubGroupCodeId(String subGroupCodeId) {
		this.subGroupCodeId = subGroupCodeId;
	}

	public void setSubGroupCodeName(String subGroupCodeName) {
		this.subGroupCodeName = subGroupCodeName;
	}

	public void setGroupCodeId(String groupCodeId) {
		this.groupCodeId = groupCodeId;
	}

	public void setGroupCodeName(String groupCodeName) {
		this.groupCodeName = groupCodeName;
	}

	public String getCodeId() {
		return codeId;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getReportRefId() {
		return reportRefId;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getCountry() {
		return country;
	}

	public String getRegion() {
		return region;
	}

	public String getStatus() {
		return status;
	}

	public String getVisibility() {
		return visibility;
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

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReportRefId(String reportRefId) {
		this.reportRefId = reportRefId;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}