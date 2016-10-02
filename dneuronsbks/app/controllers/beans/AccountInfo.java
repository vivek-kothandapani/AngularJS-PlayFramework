package controllers.beans;

public class AccountInfo {
	private String accountId;
	private String companyName;
	private String username;
	private String status;
	private String role;
	private String lastLogin;
	
	public String getAccountId() {
		return accountId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getUsername() {
		return username;
	}
	public String getStatus() {
		return status;
	}
	public String getLastLogin() {
		return lastLogin;
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
	public void setStatus(String status) {
		this.status = status;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
