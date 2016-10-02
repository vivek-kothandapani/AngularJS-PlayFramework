package controllers.managers;

import java.util.ArrayList;
import java.util.List;

import model.db.bean.accounting.EmployeeTable;
import model.db.service.ServicesInstances;
import model.db.service.accounting.AccountingService;
import play.cache.Cache;

import common.Constants;

import controllers.beans.EmployeeVo;
import controllers.forms.EmployeeForm;

public class EmployeeManager {
	
	public static EmployeeVo getEmployeeById(String employeeId, String accountId)
	{
		@SuppressWarnings("unchecked")
		List<EmployeeVo> employeeVoList = (List<EmployeeVo>) Cache.get(Constants.CACHE_EMPLOYEE_VO_LIST_ACCOUNT + accountId);
   		
   		if(employeeVoList == null || employeeVoList.isEmpty())
   		{
   			employeeVoList = findAllEmployeesByAccountId(accountId);
   		}
   		EmployeeVo employeeVo = new EmployeeVo();
		for(EmployeeVo employee : employeeVoList)
		{
			if(employee.getEmployeeId().equalsIgnoreCase(employeeId))
			{
				employeeVo = employee;
			}
		}
		return employeeVo;
	}
	
	public static String add(EmployeeVo employeeVo,EmployeeForm fEmployeeForm)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		if(fEmployeeForm != null){
   			
   			populateEmployeeVoFromEmployeeForm(employeeVo,fEmployeeForm);
   			
   			EmployeeTable employeeTable = accountingService.addEmployee(employeeVo);
   			employeeVo.setEmployeeId( employeeTable.getEmployeeId());
   			
   			//cache all employees for this account id
   			findAllEmployeesByAccountId(employeeVo.getAccountId());
   			
   			return employeeVo.getEmployeeId();
   		}
		return null;
	}
	
	public static boolean validateUsername(EmployeeVo employeeVo)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		if(employeeVo != null){
   			return accountingService.validateUsername(employeeVo);
   		}
		return false;
	}
	
	public static List<EmployeeVo> suggestEmployee(String searchText, String accountId)
	{
   		@SuppressWarnings("unchecked")
		List<EmployeeVo> employeeVoList = (List<EmployeeVo>) Cache.get(Constants.CACHE_EMPLOYEE_VO_LIST_ACCOUNT + accountId);
   		
   		if(employeeVoList == null || employeeVoList.isEmpty())
   		{
   			employeeVoList = findAllEmployeesByAccountId(accountId);
   		}

   		List<EmployeeVo> sugEmployeeVoList = new ArrayList<EmployeeVo>();
   		
   		if(employeeVoList != null &&  !employeeVoList.isEmpty() && searchText != null && accountId != null)
   		{
   			for (EmployeeVo employeeVo : employeeVoList) {
   				
   				if(employeeVo.getDisplayName().contains(searchText))
   				{
   					sugEmployeeVoList.add(employeeVo);
   				}
			}
   		}
		return sugEmployeeVoList;
	}
	
	public static List<EmployeeVo> findAllEmployeesByAccountId(String accountId)
	{
   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
   		
   		List<EmployeeVo> employeeVoList = new ArrayList<EmployeeVo>();
   		List<EmployeeTable> employeeTableList = accountingService.findAllEmployeesByAccountId(accountId);
   		
   		if(employeeTableList != null && employeeTableList.size() > 0)
   		{
   			for(EmployeeTable employeeTable: employeeTableList)
   			{
   				EmployeeVo employeeVo = new EmployeeVo();
   				
   				populateEmployeeVoFromEmployeeTable(employeeVo,employeeTable);
	   			
	   			employeeVoList.add(employeeVo);
   			}
   			
   			//Add employees to cache
   			Cache.set(Constants.CACHE_EMPLOYEE_VO_LIST_ACCOUNT + accountId, employeeVoList);
   		}
   		else
   		{
   			employeeVoList = null;
   		}
   		
   		return employeeVoList;
	}
	
	public static EmployeeVo findEmployeeByName(String displayName , String accountId)
	{
		EmployeeVo employeeVo = (EmployeeVo) Cache.get(Constants.CACHE_EMPLOYEE_VO_ACCOUNT + accountId + displayName);
		
		if(employeeVo == null )
		{
	   		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
	   		
	   		EmployeeTable employeeTable = accountingService.findEmployeeByDisplayName(displayName , accountId);
	   		employeeVo = new EmployeeVo();
	   		if(employeeTable != null )
	   		{
	   			populateEmployeeVoFromEmployeeTable(employeeVo,employeeTable);
	   			
	   			//Add employees to cache
	   			Cache.set(Constants.CACHE_EMPLOYEE_VO_ACCOUNT + accountId + displayName , employeeVo);
	   		}
		}
   		return employeeVo;
	}
	
	public static void populateEmployeeVoFromEmployeeTable(EmployeeVo employeeVo , EmployeeTable employeeTable)
	{
			employeeVo.setEmployeeId(employeeTable.getEmployeeId());
			employeeVo.setAccountId(employeeTable.getAccountId());
			employeeVo.setCompanyName(employeeTable.getCompanyName());
			employeeVo.setAccountUsername(employeeTable.getAccountUsername());
			employeeVo.setFirstname(employeeTable.getFirstname());
			employeeVo.setLastname(employeeTable.getLastname());
			employeeVo.setEmail(employeeTable.getEmail());
			employeeVo.setPhone(employeeTable.getPhone());
			employeeVo.setDisplayName(employeeTable.getDisplayName());
			employeeVo.setTitle(employeeTable.getTitle());
			employeeVo.setCodeId(employeeTable.getCodeId());
			employeeVo.setRemarks(employeeTable.getRemarks());
			employeeVo.setStatus(employeeTable.getStatus());
			employeeVo.setCreatedDate(employeeTable.getCreatedDate());
			employeeVo.setModifiedDate(employeeTable.getModifiedDate());
			employeeVo.setCreatedBy(employeeTable.getCreatedBy());
			employeeVo.setModifiedBy(employeeTable.getModifiedBy());
			
			employeeVo.setAmount(employeeTable.getAmount());
			employeeVo.setStateCode(employeeTable.getStateCode());
	}
	
	public static void populateEmployeeVoFromEmployeeForm(EmployeeVo employeeVo , EmployeeForm employeeForm)
	{
		    employeeVo.setCompanyName(employeeForm.companyName);
			employeeVo.setAccountUsername(employeeForm.accountUsername);
			employeeVo.setFirstname(employeeForm.firstname);
			employeeVo.setLastname(employeeForm.lastname);
			employeeVo.setEmail(employeeForm.email);
			employeeVo.setPhone(employeeForm.phone);
			employeeVo.setDisplayName(employeeForm.displayName);
			employeeVo.setTitle(employeeForm.title);
			employeeVo.setCodeId(employeeForm.codeVo.getCodeId());
			employeeVo.setRemarks(employeeForm.remarks);
			employeeVo.setStatus(employeeForm.status);
			employeeVo.setAmount(employeeForm.amount);
			employeeVo.setStateCode(employeeForm.stateCode);
			//employeeVo.setCreatedDate(CommonUtils.currentDateStr());
			//employeeVo.setModifiedDate(CommonUtils.currentDateStr());
	}
}
