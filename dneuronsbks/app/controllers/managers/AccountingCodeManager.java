package controllers.managers;

import java.util.ArrayList;
import java.util.List;

import model.db.bean.accounting.ClientCodeTable;
import model.db.bean.accounting.CodeAccountTypeTable;
import model.db.bean.accounting.CodeGroupTable;
import model.db.bean.accounting.CodeSubGroupTable;
import model.db.bean.accounting.CodeTable;
import model.db.service.ServicesInstances;
import model.db.service.accounting.AccountingService;
import play.cache.Cache;

import common.Constants;

import controllers.beans.codebeans.ClientCodeVo;
import controllers.beans.codebeans.CodeAccountTypeVo;
import controllers.beans.codebeans.CodeVo;

public class AccountingCodeManager {
	
	public static CodeVo  getCodeById(String codeId)
	{
		List<CodeVo> codeVoList = getCodes();
		CodeVo codeVo = new CodeVo();
		for(CodeVo cVo : codeVoList)
		{
			if(cVo.getCodeId().equalsIgnoreCase(codeId))
			{
				codeVo = cVo;
			}
		}
		return codeVo;
	}

	public static List<ClientCodeVo> getAccountCodeList(String accountId) {
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
				.getService();

		List<ClientCodeTable> clientCodeTableList = accountingService
				.findAllCodeByAccountId(accountId);
		List<ClientCodeVo> clientCodeVoList = new ArrayList<ClientCodeVo>();

		if (clientCodeTableList != null) {

			for (ClientCodeTable clientCodeTable : clientCodeTableList) {
				ClientCodeVo clientCodeVo = new ClientCodeVo();
				clientCodeVo.setAccountId(clientCodeTable.getAccountId());
				clientCodeVo.setCodeId(clientCodeTable.getCodeId());
				clientCodeVo.setCreatedBy(clientCodeTable.getCreatedBy());
				clientCodeVo.setCreatedDate(clientCodeTable.getCreatedDate());
				clientCodeVo.setModifiedBy(clientCodeTable.getModifiedBy());
				clientCodeVo.setModifiedDate(clientCodeTable.getModifiedDate());
				clientCodeVoList.add(clientCodeVo);
			}
		} else {
			clientCodeVoList = null;
		}
		return clientCodeVoList;
	}

	public static List<CodeVo> getCodes() {
		
		@SuppressWarnings("unchecked")
		List<CodeVo> codeVoList = (List<CodeVo>) Cache.get(Constants.CACHE_ACCOUNTING_CODE_GLOBAL);
		
		if(codeVoList == null || codeVoList.isEmpty())
		{
		
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
					.getService();
	
			List<CodeTable> codeTableList = accountingService.findAllCode();
			List<CodeAccountTypeTable> codeAccountTypeList = accountingService
					.findAllCodeAccountType();
			List<CodeSubGroupTable> codeSubGroupList = accountingService
					.findAllCodeSubGroup();
			List<CodeGroupTable> codeGroupList = accountingService
					.findAllCodeGroup();
	
			codeVoList = new ArrayList<CodeVo>();
	
			if (codeTableList != null && codeAccountTypeList != null
					&& codeSubGroupList != null && codeGroupList != null) {
	
				for (CodeTable codeTable : codeTableList) {
					CodeVo codeVo = new CodeVo();
					populateCodeVo(codeVo,codeTable);
					codeVoList.add(codeVo);
				}
				
				Cache.set(Constants.CACHE_ACCOUNTING_CODE_GLOBAL, codeVoList);
				
			} else {
				codeVoList = null;
			}
		}
		return codeVoList;
	}
	
	public static void populateCodeVo(CodeVo codeVo, CodeTable codeTable ){
		codeVo.setCodeId(codeTable.getCodeId());
		codeVo.setCode(codeTable.getCode());
		codeVo.setName(codeTable.getName());
		codeVo.setCreatedDate(codeTable.getCreatedDate());
		codeVo.setModifiedDate(codeTable.getModifiedDate());

		codeVo.setAccountTypeCode(codeTable.getCodeAccountTypeTable().getCode());
		codeVo.setAccountTypeCodeId(codeTable.getCodeAccountTypeTable().getAccountTypeId());
		codeVo.setAcoountTypeCodeName(codeTable.getCodeAccountTypeTable().getName());
		
		codeVo.setSubGroupCode(codeTable.getCodeAccountTypeTable().getCodeSubGroupTable().getCode());
		codeVo.setSubGroupCodeId(codeTable.getCodeAccountTypeTable().getCodeSubGroupTable().getSubGroupId());
		codeVo.setSubGroupCodeName(codeTable.getCodeAccountTypeTable().getCodeSubGroupTable().getName());
		
		codeVo.setGroupCode(codeTable.getCodeAccountTypeTable().getCodeSubGroupTable().getCodeGroupTable().getCode());
		codeVo.setGroupCodeId(codeTable.getCodeAccountTypeTable().getCodeSubGroupTable().getCodeGroupTable().getGroupId());
		codeVo.setGroupCodeName(codeTable.getCodeAccountTypeTable().getCodeSubGroupTable().getCodeGroupTable().getName());
	}
	
	public static List<CodeVo> getVendorCodes() {
		
		@SuppressWarnings("unchecked")
		List<CodeVo> codeVoList = (List<CodeVo>) Cache.get(Constants.CACHE_ACCOUNTING_VENDOR_CODE_GLOBAL);
		
		if(codeVoList == null || codeVoList.isEmpty())
		{
		
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
					.getService();
	
			List<CodeTable> codeTableList = accountingService.findAllCode();
			codeVoList = new ArrayList<CodeVo>();
	
			if (codeTableList != null ) {
	
				for (CodeTable codeTable : codeTableList) {
					
					if(codeTable.getCodeAccountTypeTable().getCodeSubGroupTable().getSubGroupId().equalsIgnoreCase(Constants.ACCOUNTING_CODE_SUB_GRP_EXPENSES_ID))
					{
						CodeVo codeVo = new CodeVo();
						populateCodeVo(codeVo,codeTable);
						codeVoList.add(codeVo);
					}
				}
				
				Cache.set(Constants.CACHE_ACCOUNTING_VENDOR_CODE_GLOBAL, codeVoList);
				
			} else {
				codeVoList = null;
			}
		}
		return codeVoList;
	}
	
	public static List<CodeVo> getCustomerCodes() {
		
		@SuppressWarnings("unchecked")
		List<CodeVo> codeVoList = (List<CodeVo>) Cache.get(Constants.CACHE_ACCOUNTING_CUSTOMER_CODE_GLOBAL);
		
		if(codeVoList == null || codeVoList.isEmpty())
		{
		
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
					.getService();
	
			List<CodeTable> codeTableList = accountingService.findAllCode();
			codeVoList = new ArrayList<CodeVo>();
	
			if (codeTableList != null ) {
	
				for (CodeTable codeTable : codeTableList) {
					
					if(codeTable.getCodeAccountTypeTable().getCodeSubGroupTable().getSubGroupId().equalsIgnoreCase(Constants.ACCOUNTING_CODE_SUB_GRP_INVOICE_ID))
					{
						CodeVo codeVo = new CodeVo();
						populateCodeVo(codeVo,codeTable);
						codeVoList.add(codeVo);
					}
				}
				
				Cache.set(Constants.CACHE_ACCOUNTING_CUSTOMER_CODE_GLOBAL, codeVoList);
				
			} else {
				codeVoList = null;
			}
		}
		return codeVoList;
	}
	
	public static List<CodeVo> getEmployeeCodes() {
		
		@SuppressWarnings("unchecked")
		List<CodeVo> codeVoList = (List<CodeVo>) Cache.get(Constants.CACHE_ACCOUNTING_EMPLOYEE_CODE_GLOBAL);
		
		if(codeVoList == null || codeVoList.isEmpty())
		{
		
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
					.getService();
	
			List<CodeTable> codeTableList = accountingService.findAllCode();
			codeVoList = new ArrayList<CodeVo>();
	
			if (codeTableList != null ) {
	
				for (CodeTable codeTable : codeTableList) {
					
					if(codeTable.getCodeAccountTypeTable().getAccountTypeId().equalsIgnoreCase(Constants.ACCOUNTING_CODE_ACCOUNT_TYPE_ASSET_Salaries_and_wages))
					{
						CodeVo codeVo = new CodeVo();
						populateCodeVo(codeVo,codeTable);
						codeVoList.add(codeVo);
					}
				}
				
				Cache.set(Constants.CACHE_ACCOUNTING_EMPLOYEE_CODE_GLOBAL, codeVoList);
				
			} else {
				codeVoList = null;
			}
		}
		return codeVoList;
	}
	
	public static List<CodeVo> getBankCodes() {
		
		@SuppressWarnings("unchecked")
		List<CodeVo> codeVoList = (List<CodeVo>) Cache.get(Constants.CACHE_ACCOUNTING_BANK_CODE_GLOBAL);
		
		if(codeVoList == null || codeVoList.isEmpty())
		{
		
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
					.getService();
	
			List<CodeTable> codeTableList = accountingService.findAllCode();
			codeVoList = new ArrayList<CodeVo>();
	
			if (codeTableList != null ) {
	
				for (CodeTable codeTable : codeTableList) {
					
					if(codeTable.getCodeAccountTypeTable().getAccountTypeId().equalsIgnoreCase(Constants.ACCOUNTING_CODE_ACCOUNT_TYPE_ASSET_CASH_AND_DEPOSIT))
					{
						CodeVo codeVo = new CodeVo();
						populateCodeVo(codeVo,codeTable);
						codeVoList.add(codeVo);
					}
				}
				
				Cache.set(Constants.CACHE_ACCOUNTING_BANK_CODE_GLOBAL, codeVoList);
				
			} else {
				codeVoList = null;
			}
		}
		return codeVoList;
	}
	
	public static List<CodeAccountTypeVo> getVendorAccountTypeCodes() {
		
		@SuppressWarnings("unchecked")
		List<CodeAccountTypeVo> codeAccountTypeVoList = (List<CodeAccountTypeVo>) Cache.get(Constants.CACHE_ACCOUNTING_VENDOR_CODE_ACNT_TYPE_GLOBAL);
		
		if(codeAccountTypeVoList == null || codeAccountTypeVoList.isEmpty())
		{
		
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
					.getService();
	
			List<CodeAccountTypeTable> codeAccountTypeList = accountingService
					.findAllCodeAccountType();
	
			codeAccountTypeVoList = new ArrayList<CodeAccountTypeVo>();
	
			if (codeAccountTypeList != null ) {
	
				for (CodeAccountTypeTable codeAccountTypeTable : codeAccountTypeList) {
					
					if(codeAccountTypeTable.getCodeSubGroupTable().getSubGroupId().equalsIgnoreCase(Constants.ACCOUNTING_CODE_SUB_GRP_EXPENSES_ID))
					{
						CodeAccountTypeVo codeAccountTypeVo = new CodeAccountTypeVo();
						codeAccountTypeVo.setAccountTypeId(codeAccountTypeTable.getAccountTypeId());
						codeAccountTypeVo.setCode(codeAccountTypeTable.getCode());
						codeAccountTypeVo.setName(codeAccountTypeTable.getName());
						codeAccountTypeVo.setCreatedDate(codeAccountTypeTable.getCreatedDate());
						codeAccountTypeVo.setModifiedDate(codeAccountTypeTable.getModifiedDate());
						
						// Logger.debug(codeAccountTypeTable.getCodeTableList().get(0).getCode());
		
						codeAccountTypeVoList.add(codeAccountTypeVo);
					}
				}
				
				Cache.set(Constants.CACHE_ACCOUNTING_VENDOR_CODE_ACNT_TYPE_GLOBAL, codeAccountTypeVoList);
				
			} else {
				codeAccountTypeVoList = null;
			}
		}
		return codeAccountTypeVoList;
	}
	
	
	public static List<CodeAccountTypeVo> getVendorCodeDropdownList() {
		
		@SuppressWarnings("unchecked")
		List<CodeAccountTypeVo> codeAccountTypeVoList = (List<CodeAccountTypeVo>) Cache.get(Constants.CACHE_ACCOUNTING_VENDOR_CODE_ACNT_TYPE_DROP_DOWN_GLOBAL);
		
		if(codeAccountTypeVoList == null || codeAccountTypeVoList.isEmpty())
		{
		
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
	
			List<CodeAccountTypeTable> codeAccountTypeList = accountingService.findAllCodeAccountTypeBySubGrpId(Constants.ACCOUNTING_CODE_SUB_GRP_EXPENSES_ID);
	
			codeAccountTypeVoList = new ArrayList<CodeAccountTypeVo>();
	
			if (codeAccountTypeList != null ) {
	
				for (CodeAccountTypeTable codeAccountTypeTable : codeAccountTypeList) {
					CodeAccountTypeVo codeAccountTypeVo = new CodeAccountTypeVo();
					codeAccountTypeVo.setAccountTypeId(codeAccountTypeTable.getAccountTypeId());
					codeAccountTypeVo.setCode(codeAccountTypeTable.getCode());
					codeAccountTypeVo.setName(codeAccountTypeTable.getName());
					codeAccountTypeVo.setCreatedDate(codeAccountTypeTable.getCreatedDate());
					codeAccountTypeVo.setModifiedDate(codeAccountTypeTable.getModifiedDate());
					
					List<CodeTable> codeTableList = accountingService.findAllCodeByAccounTypeId(codeAccountTypeTable.getAccountTypeId());
					List<CodeVo> codeVoList = new ArrayList<CodeVo>();
					for(CodeTable codeTable : codeTableList)
					{
						CodeVo codeVo = new CodeVo();
						codeVo.setCodeId(codeTable.getCodeId());
						codeVo.setCode(codeTable.getCode());
						codeVo.setName(codeTable.getName());
						codeVoList.add(codeVo);
					}
					codeAccountTypeVo.setCodeVoList(codeVoList);
					codeAccountTypeVoList.add(codeAccountTypeVo);
				}
				
				Cache.set(Constants.CACHE_ACCOUNTING_VENDOR_CODE_ACNT_TYPE_DROP_DOWN_GLOBAL, codeAccountTypeVoList);
				
			} else {
				codeAccountTypeVoList = null;
			}
		}
		return codeAccountTypeVoList;
	}
}
