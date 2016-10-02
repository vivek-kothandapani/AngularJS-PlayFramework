package controllers.managers;

import java.util.ArrayList;
import java.util.List;

import model.db.bean.accounting.BankTable;
import model.db.service.ServicesInstances;
import model.db.service.accounting.AccountingService;
import play.cache.Cache;

import common.Constants;

import controllers.beans.BankVo;
import controllers.forms.BankForm;

public class BankManager {
	
	public static BankVo getBankById(String bankId, String accountId)
	{
		@SuppressWarnings("unchecked")
		List<BankVo> bankVoList = (List<BankVo>) Cache.get(Constants.CACHE_BANK_VO_LIST_ACCOUNT + accountId);
   		
   		if(bankVoList == null || bankVoList.isEmpty())
   		{
   			bankVoList = findAllBanksByAccountId(accountId);
   		}
   		BankVo bankVo = new BankVo();
		for(BankVo bank : bankVoList)
		{
			if(bank.getBankId().equalsIgnoreCase(bankId))
			{
				bankVo = bank;
			}
		}
		return bankVo;
	}
	
	public static String add(BankVo bankVo,BankForm fBankForm)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		if(fBankForm != null){
   			
   			populateBankVoFromBankForm(bankVo,fBankForm);
   			
   			BankTable bankTable = accountingService.addBank(bankVo);
   			bankVo.setBankId( bankTable.getBankId());
   			
   			//cache all banks for this account id
   			findAllBanksByAccountId(bankVo.getAccountId());
   			
   			return bankVo.getBankId();
   		}
		return null;
	}
	
	public static boolean validateUsername(BankVo bankVo)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		if(bankVo != null){
   			return accountingService.validateUsername(bankVo);
   		}
		return false;
	}
	
	public static List<BankVo> suggestBank(String searchText, String accountId)
	{
   		@SuppressWarnings("unchecked")
		List<BankVo> bankVoList = (List<BankVo>) Cache.get(Constants.CACHE_BANK_VO_LIST_ACCOUNT + accountId);
   		
   		if(bankVoList == null || bankVoList.isEmpty())
   		{
   			bankVoList = findAllBanksByAccountId(accountId);
   		}

   		List<BankVo> sugBankVoList = new ArrayList<BankVo>();
   		
   		if(bankVoList != null &&  !bankVoList.isEmpty() && searchText != null && accountId != null)
   		{
   			for (BankVo bankVo : bankVoList) {
   				
   				if(bankVo.getDisplayName().contains(searchText))
   				{
   					sugBankVoList.add(bankVo);
   				}
			}
   		}
		return sugBankVoList;
	}
	
	public static List<BankVo> findAllBanksByAccountId(String accountId)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		
   		List<BankVo> bankVoList = new ArrayList<BankVo>();
   		List<BankTable> bankTableList = accountingService.findAllBanksByAccountId(accountId);
   		
   		if(bankTableList != null && bankTableList.size() > 0)
   		{
   			for(BankTable bankTable: bankTableList)
   			{
   				BankVo bankVo = new BankVo();
   				
   				populateBankVoFromBankTable(bankVo,bankTable);
	   			
	   			bankVoList.add(bankVo);
   			}
   			
   			//Add banks to cache
   			Cache.set(Constants.CACHE_BANK_VO_LIST_ACCOUNT + accountId, bankVoList);
   		}
   		else
   		{
   			bankVoList = null;
   		}
   		
   		return bankVoList;
	}
	
	public static BankVo findBankByName(String displayName , String accountId)
	{
		@SuppressWarnings("unchecked")
		BankVo bankVo = (BankVo) Cache.get(Constants.CACHE_BANK_VO_ACCOUNT + accountId + displayName);
		
		if(bankVo == null )
		{
	   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
	   		
	   		BankTable bankTable = accountingService.findBankByDisplayName(displayName , accountId);
	   		bankVo = new BankVo();
	   		if(bankTable != null )
	   		{
	   			populateBankVoFromBankTable(bankVo,bankTable);
	   			
	   			//Add banks to cache
	   			Cache.set(Constants.CACHE_BANK_VO_ACCOUNT + accountId + displayName , bankVo);
	   		}
		}
   		return bankVo;
	}
	
	public static void populateBankVoFromBankTable(BankVo bankVo , BankTable bankTable)
	{
			bankVo.setBankId(bankTable.getBankId());
			bankVo.setAccountId(bankTable.getAccountId());
			bankVo.setCompanyName(bankTable.getCompanyName());
			bankVo.setAccountUsername(bankTable.getAccountUsername());
			bankVo.setFirstname(bankTable.getFirstname());
			bankVo.setLastname(bankTable.getLastname());
			bankVo.setEmail(bankTable.getEmail());
			bankVo.setPhone(bankTable.getPhone());
			bankVo.setDisplayName(bankTable.getDisplayName());
			bankVo.setTitle(bankTable.getTitle());
			bankVo.setCodeId(bankTable.getCodeId());
			bankVo.setRemarks(bankTable.getRemarks());
			bankVo.setStatus(bankTable.getStatus());
			bankVo.setCreatedDate(bankTable.getCreatedDate());
			bankVo.setModifiedDate(bankTable.getModifiedDate());
			bankVo.setCreatedBy(bankTable.getCreatedBy());
			bankVo.setModifiedBy(bankTable.getModifiedBy());
			bankVo.setCountryCode(bankTable.getCountryCode());
			bankVo.setAmount(bankTable.getAmount());
			bankVo.setStateCode(bankTable.getStateCode());
	}
	
	public static void populateBankVoFromBankForm(BankVo bankVo , BankForm bankForm)
	{
		    bankVo.setCompanyName(bankForm.companyName);
			bankVo.setAccountUsername(bankForm.accountUsername);
			bankVo.setFirstname(bankForm.firstname);
			bankVo.setLastname(bankForm.lastname);
			bankVo.setEmail(bankForm.email);
			bankVo.setPhone(bankForm.phone);
			bankVo.setDisplayName(bankForm.displayName);
			bankVo.setTitle(bankForm.title);
			bankVo.setCodeId(bankForm.codeVo.getCodeId());
			bankVo.setRemarks(bankForm.remarks);
			bankVo.setStatus(bankForm.status);
			bankVo.setAmount(bankForm.amount);
			bankVo.setStateCode(bankForm.stateCode);
			bankVo.setCountryCode(bankForm.countryCode);
			//bankVo.setCreatedDate(CommonUtils.currentDateStr());
			//bankVo.setModifiedDate(CommonUtils.currentDateStr());
	}
}
