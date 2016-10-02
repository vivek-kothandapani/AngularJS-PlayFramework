package controllers.beans.codebeans;

import java.util.List;
import java.util.Map;

public class CodeAccountTypeVo {
	private String accountTypeId;
	private String subGroupId;
	private String code;
	private String name;
	private String remarks;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	private String amount;
	private String sortOrder;
	private Map<String,Integer> codeVoIdMap;
	private List<CodeVo> codeVoList;

	public List<CodeVo> getCodeVoList() {
		return codeVoList;
	}

	public void setCodeVoList(List<CodeVo> codeVoList) {
		this.codeVoList = codeVoList;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public String getSubGroupId() {
		return subGroupId;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getRemarks() {
		return remarks;
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

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
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

	public Map<String,Integer> getCodeVoIdMap() {
		return codeVoIdMap;
	}

	public void setCodeVoIdMap(Map<String,Integer> codeVoIdMap) {
		this.codeVoIdMap = codeVoIdMap;
	}
}