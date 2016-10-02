package model.db.service.reporting.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.db.bean.accounting.ChartOfAccountTable;
import model.db.bean.accounting.CodeAccountTypeTable;
import model.db.bean.accounting.CodeGroupTable;
import model.db.bean.accounting.CodeSubGroupTable;
import model.db.bean.accounting.CodeTable;
import model.db.bean.accounting.TransactionTable;
import common.CommonUtils;
import controllers.beans.codebeans.CodeAccountTypeVo;
import controllers.beans.codebeans.CodeGroupVo;
import controllers.beans.codebeans.CodeSubGroupVo;
import controllers.beans.codebeans.CodeVo;
import controllers.beans.codebeans.util.CodeGroupVoComparator;
import controllers.beans.reports.BalanceSheetVo;

public class ReportingHelper {
	
	@SuppressWarnings("unchecked")
	public Map<String, Map<String, Map<String, String>>> getBalanceSheet(String accountId){
		Map<String, Map<String, Map<String, String>>> groups = new TreeMap<String, Map<String, Map<String, String>>>();
		
		List<ChartOfAccountTable> chartOfAccount = (List<ChartOfAccountTable>)
				ChartOfAccountTable.finder.where("lower(accountId) = :accountId")
		.setParameter("accountId", accountId).findList();
		
		if(chartOfAccount!= null && chartOfAccount.size() > 0){
			Collections.sort(chartOfAccount, new ChartOfAccountTableComparator());
			
			for(ChartOfAccountTable chart : chartOfAccount){
				
				CodeTable code = CodeTable.finder.byId(chart.getCodeId());
				
				CodeAccountTypeTable codeAccountType = code.getCodeAccountTypeTable();
				CodeSubGroupTable codeSubGroup = codeAccountType.getCodeSubGroupTable();
				CodeGroupTable codeGroup = codeSubGroup.getCodeGroupTable();
				
				if(groups.get(codeGroup.getName()) == null)
				{
					//Creating Group-Sub Group-AccountType First Time
					Map<String, Map<String, String>> subGroup = new HashMap<String, Map<String,String>>();
					Map<String, String> accountType = new HashMap<String, String>();
					
					accountType.put(codeAccountType.getName(), chart.getAmount());
					subGroup.put(codeSubGroup.getName(), accountType);
					groups.put(codeGroup.getName(), subGroup);
				}
				else
				{
					//Editing Sub Group-AccountType
					Map<String, Map<String, String>> subGroups = groups.get(codeGroup.getName());
					
					if(subGroups.get(codeSubGroup.getName()) == null)
					{
						Map<String, String> accountType = new HashMap<String, String>();
						accountType.put(codeAccountType.getName(), chart.getAmount());
						subGroups.put(codeSubGroup.getName(), accountType);
					}
					else
					{
						Map<String, String> accountTypes = subGroups.get(codeSubGroup.getName());
						
						if(accountTypes.get(codeAccountType.getName()) == null)
						{
							accountTypes.put(codeAccountType.getName(), chart.getAmount());
						}
						else
						{
							String newAmount = CommonUtils.addAmount(accountTypes.get(codeAccountType.getName()),chart.getAmount() , true);
							accountTypes.put(codeAccountType.getName(), newAmount);	
						}
					}
					
				}
			}
		}
		
		return groups;
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
	
	public static void populateCodeGroupVo(CodeGroupVo codeGroupVo, CodeGroupTable codeGroupTable ){
		
		codeGroupVo.setGroupId(codeGroupTable.getGroupId());
		codeGroupVo.setCode(codeGroupTable.getCode());
		codeGroupVo.setName(codeGroupTable.getName());
		codeGroupVo.setRemarks(codeGroupTable.getRemarks());
		codeGroupVo.setSortOrder(codeGroupTable.getSortOrder());
		codeGroupVo.setCreatedDate(codeGroupTable.getCreatedDate());
		codeGroupVo.setModifiedDate(codeGroupTable.getModifiedDate());
	}
	
   public static void populateCodeSubGroupVo(CodeSubGroupVo codeSubGroupVo, CodeSubGroupTable codeSubGroupTable ){
		
	    codeSubGroupVo.setSubGroupId(codeSubGroupTable.getSubGroupId());
	    codeSubGroupVo.setCode(codeSubGroupTable.getCode());
	    codeSubGroupVo.setName(codeSubGroupTable.getName());
	    codeSubGroupVo.setRemarks(codeSubGroupTable.getRemarks());
	    codeSubGroupVo.setSortOrder(codeSubGroupTable.getSortOrder());
	    codeSubGroupVo.setCreatedDate(codeSubGroupTable.getCreatedDate());
	    codeSubGroupVo.setModifiedDate(codeSubGroupTable.getModifiedDate());
	}
   
   public static void populateCodeAccountTypeVo( CodeAccountTypeVo codeAccountTypeVo, CodeAccountTypeTable codeAccountTypeTable ){
		
	   codeAccountTypeVo.setAccountTypeId(codeAccountTypeTable.getAccountTypeId());
	   codeAccountTypeVo.setCode(codeAccountTypeTable.getCode());
	   codeAccountTypeVo.setName(codeAccountTypeTable.getName());
	   codeAccountTypeVo.setRemarks(codeAccountTypeTable.getRemarks());
	   codeAccountTypeVo.setSortOrder(codeAccountTypeTable.getSortOrder());
	   codeAccountTypeVo.setCreatedDate(codeAccountTypeTable.getCreatedDate());
	   codeAccountTypeVo.setModifiedDate(codeAccountTypeTable.getModifiedDate());
	}
	
	
	@SuppressWarnings("unchecked")
	public BalanceSheetVo getBalanceSheetReport(String accountId){
		Map<String, Integer> codeGroupVoIdMap = new HashMap<String, Integer>();
		
		List<ChartOfAccountTable> chartOfAccount = (List<ChartOfAccountTable>)
				ChartOfAccountTable.finder.where("lower(accountId) = :accountId")
		.setParameter("accountId", accountId).findList();
		
		List<CodeGroupVo> codeGroupVoList = new ArrayList<CodeGroupVo>();
		
		if(chartOfAccount!= null && chartOfAccount.size() > 0){
			Collections.sort(chartOfAccount, new ChartOfAccountTableComparator());
			
			for(ChartOfAccountTable chart : chartOfAccount){
				
				CodeTable code = CodeTable.finder.byId(chart.getCodeId());
				CodeAccountTypeTable codeAccountType = code.getCodeAccountTypeTable();
				CodeSubGroupTable codeSubGroup = codeAccountType.getCodeSubGroupTable();
				CodeGroupTable codeGroup = codeSubGroup.getCodeGroupTable();
				
				if(codeGroupVoIdMap.get(codeGroup.getGroupId()) == null)
				{
					//Creating Group-Sub Group-AccountType First Time
					CodeVo  codeVo = new CodeVo();
					CodeAccountTypeVo codeAccountTypeVo = new CodeAccountTypeVo();
					CodeSubGroupVo codeSubGroupVo = new CodeSubGroupVo();
					CodeGroupVo codeGroupVo = new CodeGroupVo();
					
					populateCodeVo(codeVo,code);
					populateCodeAccountTypeVo(codeAccountTypeVo,codeAccountType);
					populateCodeSubGroupVo(codeSubGroupVo,codeSubGroup);
					populateCodeGroupVo(codeGroupVo,codeGroup);
					
					List<CodeVo> codeVoList = new ArrayList<CodeVo>();
					List<CodeAccountTypeVo> codeAccountTypeVoList = new ArrayList<CodeAccountTypeVo>();
					List<CodeSubGroupVo> codeSubGroupVoList = new ArrayList<CodeSubGroupVo>();
					
					codeVo.setAmount(chart.getAmount());
					codeVoList.add(codeVo);
					codeAccountTypeVo.setCodeVoList(codeVoList);
					Map<String, Integer> codeVoIdMap = new HashMap<String, Integer>();
					codeVoIdMap.put(codeVo.getCodeId(), codeVoList.size());
					codeAccountTypeVo.setCodeVoIdMap(codeVoIdMap);
					codeAccountTypeVo.setAmount(chart.getAmount());
					
					codeAccountTypeVoList.add(codeAccountTypeVo);
					codeSubGroupVo.setCodeAccountTypeVoList(codeAccountTypeVoList);
					Map<String, Integer> codeAccountTypeVoIdMap = new HashMap<String, Integer>();
					codeAccountTypeVoIdMap.put(codeAccountTypeVo.getAccountTypeId(), codeAccountTypeVoList.size());
					codeSubGroupVo.setCodeAccountTypeVoIdMap(codeAccountTypeVoIdMap);
					codeSubGroupVo.setAmount(chart.getAmount());
					
					codeSubGroupVoList.add(codeSubGroupVo);
					codeGroupVo.setCodeSubGroupVoList(codeSubGroupVoList);
					Map<String, Integer> codeSubGroupVoIdMap = new HashMap<String, Integer>();
					codeSubGroupVoIdMap.put(codeSubGroupVo.getSubGroupId(), codeSubGroupVoList.size());
					codeGroupVo.setCodeSubGroupVoIdMap(codeSubGroupVoIdMap);
					codeGroupVo.setAmount(chart.getAmount());
					
					codeGroupVoList.add(codeGroupVo);
					codeGroupVoIdMap.put(codeGroup.getGroupId(), codeGroupVoList.size());
				}
				else
				{
					Integer codeGroupVoListIndex = codeGroupVoIdMap.get(codeGroup.getGroupId());
					CodeGroupVo codeGroupVo = codeGroupVoList.get(codeGroupVoListIndex - 1);
					Map<String, Integer> codeSubGroupVoIdMap = codeGroupVo.getCodeSubGroupVoIdMap();
					
					if(codeSubGroupVoIdMap.get(codeSubGroup.getSubGroupId()) == null)
					{
						CodeVo  codeVo = new CodeVo();
						CodeAccountTypeVo codeAccountTypeVo = new CodeAccountTypeVo();
						CodeSubGroupVo codeSubGroupVo = new CodeSubGroupVo();
						
						populateCodeVo(codeVo,code);
						populateCodeAccountTypeVo(codeAccountTypeVo,codeAccountType);
						populateCodeSubGroupVo(codeSubGroupVo,codeSubGroup);
						
						List<CodeVo> codeVoList = new ArrayList<CodeVo>();
						List<CodeAccountTypeVo> codeAccountTypeVoList = new ArrayList<CodeAccountTypeVo>();
						List<CodeSubGroupVo> codeSubGroupVoList = codeGroupVo.getCodeSubGroupVoList();
						
						codeVo.setAmount(chart.getAmount());
						codeVoList.add(codeVo);
						codeAccountTypeVo.setCodeVoList(codeVoList);
						Map<String, Integer> codeVoIdMap = new HashMap<String, Integer>();
						codeVoIdMap.put(codeVo.getCodeId(), codeVoList.size());
						codeAccountTypeVo.setCodeVoIdMap(codeVoIdMap);
						codeAccountTypeVo.setAmount(chart.getAmount());
						
						codeAccountTypeVoList.add(codeAccountTypeVo);
						codeSubGroupVo.setCodeAccountTypeVoList(codeAccountTypeVoList);
						Map<String, Integer> codeAccountTypeVoIdMap = new HashMap<String, Integer>();
						codeAccountTypeVoIdMap.put(codeAccountTypeVo.getAccountTypeId(), codeAccountTypeVoList.size());
						codeSubGroupVo.setCodeAccountTypeVoIdMap(codeAccountTypeVoIdMap);
						codeSubGroupVo.setAmount(chart.getAmount());
						
						codeSubGroupVoList.add(codeSubGroupVo);
						//codeGroupVo.setCodeSubGroupVoList(codeSubGroupVoList);
						codeSubGroupVoIdMap.put(codeSubGroupVo.getSubGroupId(), codeSubGroupVoList.size());
						//codeGroupVo.setCodeSubGroupVoIdMap(codeSubGroupVoIdMap);
						codeGroupVo.setAmount(CommonUtils.addAmount(chart.getAmount(),codeGroupVo.getAmount() , true) );
					}
					else
					{
						Integer codeSubGroupVoListIndex = codeSubGroupVoIdMap.get(codeSubGroup.getSubGroupId());
						List<CodeSubGroupVo> codeSubGroupVoList = codeGroupVo.getCodeSubGroupVoList();
						CodeSubGroupVo codeSubGroupVo = codeSubGroupVoList.get(codeSubGroupVoListIndex - 1);
						Map<String, Integer> codeAccountTypeVoIdMap = codeSubGroupVo.getCodeAccountTypeVoIdMap();
						
						if(codeAccountTypeVoIdMap.get(codeAccountType.getAccountTypeId()) == null)
						{
							CodeVo  codeVo = new CodeVo();
							CodeAccountTypeVo codeAccountTypeVo = new CodeAccountTypeVo();
							
							populateCodeVo(codeVo,code);
							populateCodeAccountTypeVo(codeAccountTypeVo,codeAccountType);
							
							List<CodeVo> codeVoList = new ArrayList<CodeVo>();
							List<CodeAccountTypeVo> codeAccountTypeVoList = codeSubGroupVo.getCodeAccountTypeVoList();
							
							codeVo.setAmount(chart.getAmount());
							codeVoList.add(codeVo);
							codeAccountTypeVo.setCodeVoList(codeVoList);
							Map<String, Integer> codeVoIdMap = new HashMap<String, Integer>();
							codeVoIdMap.put(codeVo.getCodeId(), codeVoList.size());
							codeAccountTypeVo.setCodeVoIdMap(codeVoIdMap);
							codeAccountTypeVo.setAmount(chart.getAmount());
							
							codeAccountTypeVoList.add(codeAccountTypeVo);
							//codeSubGroupVo.setCodeAccountTypeVoList(codeAccountTypeVoList);
							codeAccountTypeVoIdMap.put(codeAccountTypeVo.getAccountTypeId(), codeAccountTypeVoList.size());
							//codeSubGroupVo.setCodeAccountTypeVoIdMap(codeAccountTypeVoIdMap);
							
							codeSubGroupVo.setAmount(CommonUtils.addAmount(chart.getAmount(),codeSubGroupVo.getAmount() , true));
							codeGroupVo.setAmount(CommonUtils.addAmount(chart.getAmount(),codeGroupVo.getAmount() , true) );
							
						}
						else
						{
							Integer codeAccountTypeVoListIndex = codeAccountTypeVoIdMap.get(codeAccountType.getAccountTypeId());
							List<CodeAccountTypeVo> codeAccountTypeVoList = codeSubGroupVo.getCodeAccountTypeVoList();
							CodeAccountTypeVo codeAccountTypeVo = codeAccountTypeVoList.get(codeAccountTypeVoListIndex - 1);
							Map<String, Integer> codeVoIdMap = codeAccountTypeVo.getCodeVoIdMap();
							
							if(codeVoIdMap.get(code.getCodeId()) == null)
							{
								CodeVo  codeVo = new CodeVo();
								
								populateCodeVo(codeVo,code);
								populateCodeAccountTypeVo(codeAccountTypeVo,codeAccountType);
								
								List<CodeVo> codeVoList = codeAccountTypeVo.getCodeVoList();
								
								codeVo.setAmount(chart.getAmount());
								
								codeVoList.add(codeVo);
								//codeAccountTypeVo.setCodeVoList(codeVoList);
								codeVoIdMap.put(codeVo.getCodeId(), codeVoList.size());
								
								//codeAccountTypeVo.setCodeVoIdMap(codeVoIdMap);
								
								codeAccountTypeVo.setAmount(CommonUtils.addAmount(chart.getAmount(),codeAccountTypeVo.getAmount() , true));
								codeSubGroupVo.setAmount(CommonUtils.addAmount(chart.getAmount(),codeSubGroupVo.getAmount() , true));
								codeGroupVo.setAmount(CommonUtils.addAmount(chart.getAmount(),codeGroupVo.getAmount() , true) );
							}
						}
					}
					
				}
			}
		}
		
		Collections.sort(codeGroupVoList, new CodeGroupVoComparator());
		
		BalanceSheetVo balanceSheetVo = new BalanceSheetVo();
		balanceSheetVo.setCodeGroupVoList(codeGroupVoList);
		balanceSheetVo.setCodeGroupVoIdMap(codeGroupVoIdMap);
		return balanceSheetVo;
	}
	
	
	public Map<String, Map<String, Map<String, String>>> getIncomeStatement(String accountId){
		Map<String, Map<String, Map<String, String>>> groups = new HashMap<String, Map<String, Map<String, String>>>();
		
		List<TransactionTable> transactionTableList = (List<TransactionTable>)
				TransactionTable.finder.where("lower(accountId) = :accountId")
		.setParameter("accountId", accountId).findList();
		
		Collections.sort(transactionTableList, new TransactionTableComparator());
		
		if(transactionTableList!= null && transactionTableList.size() > 0){
			for(TransactionTable transactionTable : transactionTableList){
				
				if(transactionTable.getTxCategoryId() == null )
				{
					continue;
				}
				
				CodeTable code = CodeTable.finder.byId(transactionTable.getTxCategoryId());
				
				CodeAccountTypeTable codeAccountType = code.getCodeAccountTypeTable();
				CodeSubGroupTable codeSubGroup = codeAccountType.getCodeSubGroupTable();
				CodeGroupTable codeGroup = codeSubGroup.getCodeGroupTable();
				
				if(groups.get(codeGroup.getName()) == null)
				{
					//Creating Group-Sub Group-AccountType First Time
					Map<String, Map<String, String>> subGroup = new HashMap<String, Map<String,String>>();
					Map<String, String> accountType = new HashMap<String, String>();
					
					accountType.put(codeAccountType.getName(), transactionTable.getAmount());
					subGroup.put(codeSubGroup.getName(), accountType);
					groups.put(codeGroup.getName(), subGroup);
				}
				else
				{
					//Editing Sub Group-AccountType
					Map<String, Map<String, String>> subGroups = groups.get(codeGroup.getName());
					
					if(subGroups.get(codeSubGroup.getName()) == null)
					{
						Map<String, String> accountType = new HashMap<String, String>();
						accountType.put(codeAccountType.getName(), transactionTable.getAmount());
						subGroups.put(codeSubGroup.getName(), accountType);
					}
					else
					{
						Map<String, String> accountTypes = subGroups.get(codeSubGroup.getName());
						
						if(accountTypes.get(codeAccountType.getName()) == null)
						{
							accountTypes.put(codeAccountType.getName(), transactionTable.getAmount());
						}
						else
						{
							String newAmount = CommonUtils.addAmount(accountTypes.get(codeAccountType.getName()),transactionTable.getAmount() , true);
							accountTypes.put(codeAccountType.getName(), newAmount);	
						}
					}
					
				}
			}
		}
		return groups;
	}
}