package controllers.managers;

import java.util.ArrayList;
import java.util.List;

import model.db.bean.accounting.CustomerTable;
import model.db.service.ServicesInstances;
import model.db.service.accounting.AccountingService;
import play.cache.Cache;
import common.CommonUtils;
import common.Constants;
import controllers.beans.CustomerVo;
import controllers.forms.CustomerForm;

public class CustomerManager {
	
	public static CustomerVo getCustomerById(String customerId, String accountId)
	{
		@SuppressWarnings("unchecked")
		List<CustomerVo> customerVoList = (List<CustomerVo>) Cache.get(Constants.CACHE_CUSTOMER_VO_LIST_ACCOUNT + accountId);
   		
   		if(customerVoList == null || customerVoList.isEmpty())
   		{
   			customerVoList = findAllCustomersByAccountId(accountId);
   		}
   		CustomerVo customerVo = new CustomerVo();
		for(CustomerVo customer : customerVoList)
		{
			if(customer.getCustomerId().equalsIgnoreCase(customerId))
			{
				customerVo = customer;
			}
		}
		return customerVo;
	}
	
	public static String add(CustomerVo customerVo,CustomerForm fCustomerForm)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		if(fCustomerForm != null){
   			
   			populateCustomerVoFromCustomerForm(customerVo,fCustomerForm);
   			
   			CustomerTable customerTable = accountingService.addCustomer(customerVo);
   			customerVo.setCustomerId( customerTable.getCustomerId());
   			
   			//cache all customers for this account id
   			findAllCustomersByAccountId(customerVo.getAccountId());
   			
   			return customerVo.getCustomerId();
   		}
		return null;
	}
	
	public static boolean validateUsername(CustomerVo customerVo)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		if(customerVo != null){
   			return accountingService.validateUsername(customerVo);
   		}
		return false;
	}
	
	public static List<CustomerVo> suggestCustomer(String searchText, String accountId)
	{
   		@SuppressWarnings("unchecked")
		List<CustomerVo> customerVoList = (List<CustomerVo>) Cache.get(Constants.CACHE_CUSTOMER_VO_LIST_ACCOUNT + accountId);
   		
   		if(customerVoList == null || customerVoList.isEmpty())
   		{
   			customerVoList = findAllCustomersByAccountId(accountId);
   		}

   		List<CustomerVo> sugCustomerVoList = new ArrayList<CustomerVo>();
   		
   		if(customerVoList != null &&  !customerVoList.isEmpty() && searchText != null && accountId != null)
   		{
   			for (CustomerVo customerVo : customerVoList) {
   				
   				if(customerVo.getDisplayName().toUpperCase().contains(searchText.toUpperCase()))
   				{
   					sugCustomerVoList.add(customerVo);
   				}
			}
   		}
		return sugCustomerVoList;
	}
	
	public static List<CustomerVo> findAllCustomersByAccountId(String accountId)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		
   		List<CustomerVo> customerVoList = new ArrayList<CustomerVo>();
   		List<CustomerTable> customerTableList = accountingService.findAllCustomersByAccountId(accountId);
   		
   		if(customerTableList != null && customerTableList.size() > 0)
   		{
   			for(CustomerTable customerTable: customerTableList)
   			{
   				CustomerVo customerVo = new CustomerVo();
   				
   				populateCustomerVoFromCustomerTable(customerVo,customerTable);
	   			
	   			customerVoList.add(customerVo);
   			}
   			
   			//Add customers to cache
   			Cache.set(Constants.CACHE_CUSTOMER_VO_LIST_ACCOUNT + accountId, customerVoList);
   		}
   		else
   		{
   			customerVoList = null;
   		}
   		
   		return customerVoList;
	}
	
	public static CustomerVo findCustomerByName(String displayName , String accountId)
	{
		@SuppressWarnings("unchecked")
		CustomerVo customerVo = (CustomerVo) Cache.get(Constants.CACHE_CUSTOMER_VO_ACCOUNT + accountId + displayName);
		
		if(customerVo == null )
		{
	   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
	   		
	   		CustomerTable customerTable = accountingService.findCustomerByDisplayName(displayName , accountId);
	   		customerVo = new CustomerVo();
	   		if(customerTable != null )
	   		{
	   			populateCustomerVoFromCustomerTable(customerVo,customerTable);
	   			
	   			//Add customers to cache
	   			Cache.set(Constants.CACHE_CUSTOMER_VO_ACCOUNT + accountId + displayName , customerVo);
	   		}
		}
   		return customerVo;
	}
	
	public static void populateCustomerVoFromCustomerTable(CustomerVo customerVo , CustomerTable customerTable)
	{
			customerVo.setCustomerId(customerTable.getCustomerId());
			customerVo.setAccountId(customerTable.getAccountId());
			customerVo.setCompanyName(customerTable.getCompanyName());
			customerVo.setAccountUsername(customerTable.getAccountUsername());
			customerVo.setFirstname(customerTable.getFirstname());
			customerVo.setLastname(customerTable.getLastname());
			customerVo.setEmail(customerTable.getEmail());
			customerVo.setPhone(customerTable.getPhone());
			customerVo.setDisplayName(customerTable.getDisplayName());
			customerVo.setTitle(customerTable.getTitle());
			customerVo.setCodeId(customerTable.getCodeId());
			customerVo.setRemarks(customerTable.getRemarks());
			customerVo.setStatus(customerTable.getStatus());
			customerVo.setCreatedDate(customerTable.getCreatedDate());
			customerVo.setModifiedDate(customerTable.getModifiedDate());
			customerVo.setCreatedBy(customerTable.getCreatedBy());
			customerVo.setModifiedBy(customerTable.getModifiedBy());
			
			customerVo.setAmount(customerTable.getAmount());
			customerVo.setStateCode(customerTable.getStateCode());
			customerVo.setCountryCode(customerTable.getCountryCode());
	}
	
	public static void populateCustomerVoFromCustomerForm(CustomerVo customerVo , CustomerForm customerForm)
	{
		    customerVo.setCompanyName(customerForm.companyName);
			customerVo.setAccountUsername(customerForm.accountUsername);
			customerVo.setFirstname(customerForm.firstName);
			customerVo.setLastname(customerForm.lastName);
			customerVo.setEmail(customerForm.email);
			customerVo.setPhone(customerForm.phone);
			customerVo.setDisplayName(customerForm.displayName);
			customerVo.setTitle(customerForm.title);
			if(customerForm.codeVo != null)
			customerVo.setCodeId(customerForm.codeVo.getCodeId());
			customerVo.setRemarks(customerForm.remarks);
			customerVo.setStatus(customerForm.status);
			customerVo.setAmount(customerForm.amount);
			customerVo.setStateCode(customerForm.stateCode);
			customerVo.setCountryCode(customerForm.countryCode);
			//customerVo.setCreatedDate(CommonUtils.currentDateStr());
			//customerVo.setModifiedDate(CommonUtils.currentDateStr());
	}
	
	public static String update (CustomerVo customerVo, CustomerForm customerForm){
		
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
		
		if(customerForm != null){
			populateCustomerVoFromCustomerForm(customerVo,customerForm);
			customerVo.setCustomerId(customerForm.customerId);
			accountingService.updateCustomer(customerVo);
			
			Cache.remove(Constants.CACHE_CUSTOMER_VO_LIST_ACCOUNT + customerVo.getAccountId());
   			Cache.remove(Constants.CACHE_VENDOR_VO_ACCOUNT + customerVo.getAccountId() + customerVo.getDisplayName());
   			
   			//cache all customers for this account id
   			findAllCustomersByAccountId(customerVo.getAccountId());
   			
   			return customerVo.getCustomerId();
		}
		
		return null;
	}
	
	public static void updateTable(String oldAmount, String amount, String customerId, String accountId, String userName , boolean isDebit)
	{
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
		
		CustomerTable customerTable = accountingService.findCustomer(customerId, accountId);
		
		customerTable.getAmount();
		String newAmount = CommonUtils.addAmount(customerTable.getAmount(), amount , isDebit);
		customerTable.setAmount(newAmount);
		customerTable.save("accounting");
		
		Cache.remove(Constants.CACHE_CUSTOMER_VO_LIST_ACCOUNT + accountId);
		Cache.remove(Constants.CACHE_CUSTOMER_VO_ACCOUNT + accountId + customerTable.getDisplayName());
	}
}
