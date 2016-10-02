package controllers.beans;

import java.util.List;

public class TxMasterVo {
	private String accountId;
	private String accountUsername;
	private String accountantId;
	private List<TransactionVo> newTxList;
	private List<TransactionVo> editedTxList;
	
	public String getAccountId() {
		return accountId;
	}
	public String getAccountUsername() {
		return accountUsername;
	}
	public String getAccountantId() {
		return accountantId;
	}
	public List<TransactionVo> getNewTxList() {
		return newTxList;
	}
	public void setNewTxList(List<TransactionVo> newTxList) {
		this.newTxList = newTxList;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}
	public void setAccountantId(String accountantId) {
		this.accountantId = accountantId;
	}
	public List<TransactionVo> getEditedTxList() {
		return editedTxList;
	}
	public void setEditedTxList(List<TransactionVo> editedTxList) {
		this.editedTxList = editedTxList;
	}
	
}