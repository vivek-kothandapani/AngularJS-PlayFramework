package controllers.beans.codebeans;

import java.util.List;
import java.util.Map;


public class CodeSubGroupVo {

	private String subGroupId;
	private String groupId;
	private String code;
	private String name;
	private String remarks;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	private String sortOrder;
	private String amount;
	private Map<String,Integer> codeAccountTypeVoIdMap;
	private List<CodeAccountTypeVo> codeAccountTypeVoList;

	public String getSubGroupId() {
		return subGroupId;
	}

	public String getGroupId() {
		return groupId;
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

	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
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

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public List<CodeAccountTypeVo> getCodeAccountTypeVoList() {
		return codeAccountTypeVoList;
	}

	public void setCodeAccountTypeVoList(List<CodeAccountTypeVo> codeAccountTypeVoList) {
		this.codeAccountTypeVoList = codeAccountTypeVoList;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Map<String,Integer> getCodeAccountTypeVoIdMap() {
		return codeAccountTypeVoIdMap;
	}

	public void setCodeAccountTypeVoIdMap(Map<String,Integer> codeAccountTypeVoIdMap) {
		this.codeAccountTypeVoIdMap = codeAccountTypeVoIdMap;
	}
}