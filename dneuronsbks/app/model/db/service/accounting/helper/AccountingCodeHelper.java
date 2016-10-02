package model.db.service.accounting.helper;

import java.util.List;

import model.db.bean.accounting.ClientCodeTable;
import model.db.bean.accounting.CodeAccountTypeTable;
import model.db.bean.accounting.CodeGroupTable;
import model.db.bean.accounting.CodeSubGroupTable;
import model.db.bean.accounting.CodeTable;

public class AccountingCodeHelper {
	
	public List<ClientCodeTable> findAllCodeByAccountId(String accountId){
		List<ClientCodeTable> clientCodeList = (List<ClientCodeTable>)ClientCodeTable.finder.where("lower(accountId) = :accountId")
				.setParameter("accountId", accountId)
				.findList();
		
		if(clientCodeList != null && clientCodeList.size() > 0){
			return clientCodeList;
		}else{
			return null;
		}
	}
	
	public CodeTable findCodeById(String codeId){
		List<CodeTable> codeList = (List<CodeTable>)CodeTable.finder.where("lower(codeId) = :codeId")
				.setParameter("codeId", codeId)
				.findList();
		
		if(codeList != null && codeList.size() > 0){
			return codeList.get(0);
		}else{
			return null;
		}
	}
	
	public List<CodeTable> findAllCode(){
		List<CodeTable> codeList = (List<CodeTable>)CodeTable.finder.findList();
		
		if(codeList != null && codeList.size() > 0){
			return codeList;
		}else{
			return null;
		}
	}
	
	public List<CodeTable> findAllCodeByAccounTypeId(String accountTypeId){
		List<CodeTable> codeList = (List<CodeTable>)CodeTable.finder.where("lower(accountTypeId) = :accountTypeId")
				.setParameter("accountTypeId", accountTypeId)
				.findList();
		
		if(codeList != null && codeList.size() > 0){
			return codeList;
		}else{
			return null;
		}
	}
	
	
	public List<CodeAccountTypeTable> findAllCodeAccountType(){
		List<CodeAccountTypeTable> list = (List<CodeAccountTypeTable>)CodeAccountTypeTable.finder.findList();
		
		if(list != null && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}
	
	public List<CodeAccountTypeTable> findAllCodeAccountTypeBySubGrpId(String subGroupId){
		List<CodeAccountTypeTable> list = (List<CodeAccountTypeTable>)CodeAccountTypeTable.finder.where("lower(subGroupId) = :subGroupId")
				.setParameter("subGroupId", subGroupId)
				.findList();
		
		if(list != null && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}
	
	
	
	public List<CodeSubGroupTable> findAllCodeSubGroup(){
		List<CodeSubGroupTable> list = (List<CodeSubGroupTable>)CodeSubGroupTable.finder.findList();
		
		if(list != null && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}
	
	public List<CodeGroupTable> findAllCodeGroup(){
		List<CodeGroupTable> list = (List<CodeGroupTable>)CodeGroupTable.finder.findList();
		
		if(list != null && list.size() > 0){
			return list;
		}else{
			return null;
		}
	}
}
