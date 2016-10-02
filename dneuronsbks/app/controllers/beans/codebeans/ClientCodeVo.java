package controllers.beans.codebeans;

public class ClientCodeVo {

	private String clientCodeId;
	private String accountId;
	private String codeId;
	private String status;
	private String remarks;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;

	
	public String getClientCodeId() {
		return clientCodeId;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getCodeId() {
		return codeId;
	}

	public String getStatus() {
		return status;
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