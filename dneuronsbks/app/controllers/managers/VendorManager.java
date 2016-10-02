package controllers.managers;

import java.util.ArrayList;
import java.util.List;

import model.db.bean.accounting.VendorTable;
import model.db.service.ServicesInstances;
import model.db.service.accounting.AccountingService;
import play.cache.Cache;
import common.CommonUtils;
import common.Constants;
import controllers.beans.VendorVo;
import controllers.forms.VendorForm;

public class VendorManager {
	
	public static VendorVo getVendorById(String vendorId, String accountId)
	{
		@SuppressWarnings("unchecked")
		List<VendorVo> vendorVoList = (List<VendorVo>) Cache.get(Constants.CACHE_VENDOR_VO_LIST_ACCOUNT + accountId);
   		
   		if(vendorVoList == null || vendorVoList.isEmpty())
   		{
   			vendorVoList = findAllVendorsByAccountId(accountId);
   		}
   		VendorVo vendorVo = new VendorVo();
		for(VendorVo vendor : vendorVoList)
		{
			if(vendor.getVendorId().equalsIgnoreCase(vendorId))
			{
				vendorVo = vendor;
			}
		}
		return vendorVo;
	}
	
	public static String add(VendorVo vendorVo,VendorForm fVendorForm)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		if(fVendorForm != null){
   			
   			populateVendorVoFromVendorForm(vendorVo , fVendorForm);
   			
   			VendorTable vendorTable = accountingService.addVendor(vendorVo);
   			vendorVo.setVendorId( vendorTable.getVendorId());
   			
   			//cache all vendors for this account id
   			findAllVendorsByAccountId(vendorVo.getAccountId());
   			
   			return vendorVo.getVendorId();
   		}
		return null;
	}
	
	public static String update(VendorVo vendorVo,VendorForm fVendorForm)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		if(fVendorForm != null){
   			
   			populateVendorVoFromVendorForm(vendorVo , fVendorForm);
   			vendorVo.setVendorId( fVendorForm.vendorId);
   			accountingService.updateVendor(vendorVo);
   			
   			Cache.remove(Constants.CACHE_VENDOR_VO_LIST_ACCOUNT + vendorVo.getAccountId());
   			Cache.remove(Constants.CACHE_VENDOR_VO_ACCOUNT + vendorVo.getAccountId() + vendorVo.getDisplayName());
   			
   			//cache all vendors for this account id
   			findAllVendorsByAccountId(vendorVo.getAccountId());
   			
   			return vendorVo.getVendorId();
   		}
		return null;
	}
	
	public static boolean validateUsername(VendorVo vendorVo)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		if(vendorVo != null){
   			return accountingService.validateUsername(vendorVo);
   		}
		return false;
	}
	
	public static List<VendorVo> suggestVendor(String searchText, String accountId)
	{
   		@SuppressWarnings("unchecked")
		List<VendorVo> vendorVoList = (List<VendorVo>) Cache.get(Constants.CACHE_VENDOR_VO_LIST_ACCOUNT + accountId);
   		
   		if(vendorVoList == null || vendorVoList.isEmpty())
   		{
   			vendorVoList = findAllVendorsByAccountId(accountId);
   		}

   		List<VendorVo> sugVendorVoList = new ArrayList<VendorVo>();
   		
   		if(vendorVoList != null &&  !vendorVoList.isEmpty() && searchText != null && accountId != null)
   		{
   			for (VendorVo vendorVo : vendorVoList) {
   				
   				if(vendorVo.getDisplayName().toUpperCase().contains(searchText.toUpperCase()))
   				{
   					sugVendorVoList.add(vendorVo);
   				}
			}
   		}
		return sugVendorVoList;
	}
	
	public static List<VendorVo> findAllVendorsByAccountId(String accountId)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		
   		List<VendorVo> vendorVoList = new ArrayList<VendorVo>();
   		List<VendorTable> vendorTableList = accountingService.findAllVendorsByAccountId(accountId);
   		
   		if(vendorTableList != null && vendorTableList.size() > 0)
   		{
   			for(VendorTable vendorTable: vendorTableList)
   			{
   				VendorVo vendorVo = new VendorVo();
   				
   				populateVendorVoFromVendorTable(vendorVo,vendorTable);
	   			
	   			vendorVoList.add(vendorVo);
   			}
   			
   			//Add vendors to cache
   			Cache.set(Constants.CACHE_VENDOR_VO_LIST_ACCOUNT + accountId, vendorVoList);
   		}
   		else
   		{
   			vendorVoList = null;
   		}
   		
   		return vendorVoList;
	}
	
	public static VendorVo findVendorByName(String displayName , String accountId)
	{
		VendorVo vendorVo = (VendorVo) Cache.get(Constants.CACHE_VENDOR_VO_ACCOUNT + accountId + displayName);
		
		if(vendorVo == null )
		{
	   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
	   		
	   		VendorTable vendorTable = accountingService.findVendorByDisplayName(displayName , accountId);
	   		vendorVo = new VendorVo();
	   		if(vendorTable != null )
	   		{
	   			populateVendorVoFromVendorTable(vendorVo,vendorTable);
	   			//Add vendors to cache
	   			Cache.set(Constants.CACHE_VENDOR_VO_ACCOUNT + accountId + displayName , vendorVo);
	   		}
		}
   		return vendorVo;
	}
	
	public static void populateVendorVoFromVendorTable(VendorVo vendorVo , VendorTable vendorTable)
	{
			vendorVo.setVendorId(vendorTable.getVendorId());
			vendorVo.setAccountId(vendorTable.getAccountId());
			vendorVo.setCompanyName(vendorTable.getCompanyName());
			vendorVo.setAccountUsername(vendorTable.getAccountUsername());
			vendorVo.setFirstname(vendorTable.getFirstname());
			vendorVo.setLastname(vendorTable.getLastname());
			vendorVo.setEmail(vendorTable.getEmail());
			vendorVo.setPhone(vendorTable.getPhone());
			vendorVo.setDisplayName(vendorTable.getDisplayName());
			vendorVo.setTitle(vendorTable.getTitle());
			vendorVo.setCodeId(vendorTable.getCodeId());
			vendorVo.setRemarks(vendorTable.getRemarks());
			vendorVo.setStatus(vendorTable.getStatus());
			vendorVo.setCreatedDate(vendorTable.getCreatedDate());
			vendorVo.setModifiedDate(vendorTable.getModifiedDate());
			vendorVo.setCreatedBy(vendorTable.getCreatedBy());
			vendorVo.setModifiedBy(vendorTable.getModifiedBy());
			
			vendorVo.setAmount(vendorTable.getAmount());
			vendorVo.setStateCode(vendorTable.getStateCode());
			vendorVo.setCountryCode(vendorTable.getCountryCode());
	}
	
	public static void populateVendorVoFromVendorForm(VendorVo vendorVo , VendorForm vendorForm)
	{
		    vendorVo.setCompanyName(vendorForm.companyName);
			vendorVo.setAccountUsername(vendorForm.accountUsername);
			vendorVo.setFirstname(vendorForm.firstname);
			vendorVo.setLastname(vendorForm.lastname);
			vendorVo.setEmail(vendorForm.email);
			vendorVo.setPhone(vendorForm.phone);
			vendorVo.setDisplayName(vendorForm.displayName);
			vendorVo.setTitle(vendorForm.title);
			if(vendorForm.codeVo != null)
			vendorVo.setCodeId(vendorForm.codeVo.getCodeId());
			vendorVo.setRemarks(vendorForm.remarks);
			vendorVo.setStatus(vendorForm.status);
			vendorVo.setAmount(vendorForm.amount);
			vendorVo.setStateCode(vendorForm.stateCode);
			vendorVo.setCountryCode(vendorForm.countryCode);
			//vendorVo.setCreatedDate(CommonUtils.currentDateStr());
			//vendorVo.setModifiedDate(CommonUtils.currentDateStr());
	}
	
	
	public static void updateTable(String oldAmount, String amount, String vendorId, String accountId, String userName , boolean isDebit)
	{
			
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
		VendorTable vendorTable = accountingService.findVendor(vendorId, accountId);
		
		vendorTable.getAmount();
		String newAmount = CommonUtils.addAmount(vendorTable.getAmount(), amount , isDebit);
		vendorTable.setAmount(newAmount);
		vendorTable.save("accounting");
		
		Cache.remove(Constants.CACHE_VENDOR_VO_LIST_ACCOUNT + accountId);
		Cache.remove(Constants.CACHE_VENDOR_VO_ACCOUNT + accountId + vendorTable.getDisplayName());
		
	}
	
}
