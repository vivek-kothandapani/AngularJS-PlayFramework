package model.db.service.accounting.helper;

import java.util.List;

import model.db.bean.accounting.BankTable;
import controllers.beans.BankVo;

public class BankHelper {
	
	public boolean validateUsername(BankVo bankVo){
		List<BankTable> bankList = (List<BankTable>)BankTable.finder.where("lower(displayName) = :displayName and lower(accountId) = :accountId")
				.setParameter("displayName", bankVo.getDisplayName())
				.setParameter("accountId", bankVo.getAccountId())
				.findList();
		
		if(bankList != null && bankList.size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public List<BankTable> suggestBank(String searchText, String accountId){
		List<BankTable> bankList = (List<BankTable>)BankTable.finder.where("lower(accountId) = :accountId and lower(displayName) LIKE :displayName")
				.setParameter("displayName", "%" + searchText + "%")
				.setParameter("accountId", accountId)
				.findList();
		
		if(bankList != null && bankList.size() > 0){
			return bankList;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BankTable addBank(BankVo bankVo){
		BankTable bankTable = new BankTable();
		return bankTable.create(bankVo);
	}
	
	public List<BankTable> findAllBanksByAccountId(String accountId){
		List<BankTable> bankList = (List<BankTable>)BankTable.finder.where("lower(accountId) = :accountId")
				.setParameter("accountId", accountId)
				.findList();
		
		if(bankList != null && bankList.size() > 0){
			return bankList;
		}else{
			return null;
		}
	}
	
	public BankTable findBankByDisplayName(String displayName, String accountId){
		List<BankTable> bankList = (List<BankTable>)BankTable.finder.where("lower(displayName) = :displayName and lower(accountId) = :accountId")
				.setParameter("displayName", displayName)
				.setParameter("accountId", accountId)
				.findList();
		
		if(bankList != null && bankList.size() > 0){
			return bankList.get(0);
		}else{
			return null;
		}
	}
	

	public BankTable findBank(String bankId, String accountId){
		List<BankTable> bankList = (List<BankTable>)BankTable.finder.where("lower(bankId) = :bankId and lower(accountId) = :accountId")
				.setParameter("bankId", bankId)
				.setParameter("accountId", accountId)
				.findList();
		
		if(bankList != null && bankList.size() > 0){
			return bankList.get(0);
		}else{
			return null;
		}
	}
	
	

}
