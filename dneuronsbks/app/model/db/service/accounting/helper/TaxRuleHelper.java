package model.db.service.accounting.helper;

import java.util.List;

import model.db.bean.accounting.ClientCodeTable;
import model.db.bean.accounting.CodeAccountTypeTable;
import model.db.bean.accounting.CodeGroupTable;
import model.db.bean.accounting.CodeSubGroupTable;
import model.db.bean.accounting.CodeTable;
import model.db.bean.accounting.TaxRuleTable;

public class TaxRuleHelper {
	
	public List<TaxRuleTable> findAllRuleByCountryCode(String countryCode){
		List<TaxRuleTable> taxRuleTableList = (List<TaxRuleTable>)TaxRuleTable.finder.where("lower(countryCode) = :countryCode")
				.setParameter("countryCode", countryCode)
				.findList();
		
		if(taxRuleTableList != null && taxRuleTableList.size() > 0){
			return taxRuleTableList;
		}else{
			return null;
		}
	}
	
	public TaxRuleTable findTaxRuleById(String taxRuleId){
		List<TaxRuleTable> taxRuleTableList = (List<TaxRuleTable>)TaxRuleTable.finder.where("lower(taxRuleId) = :taxRuleId")
				.setParameter("taxRuleId", taxRuleId)
				.findList();
		
		if(taxRuleTableList != null && taxRuleTableList.size() > 0){
			return taxRuleTableList.get(0);
		}else{
			return null;
		}
	}
	
	
	public TaxRuleTable findTaxRuleByDisplayName(String displayName){
		List<TaxRuleTable> taxRuleTableList = (List<TaxRuleTable>)TaxRuleTable.finder.where("lower(displayName) = :displayName")
				.setParameter("displayName", displayName)
				.findList();
		
		if(taxRuleTableList != null && taxRuleTableList.size() > 0){
			return taxRuleTableList.get(0);
		}else{
			return null;
		}
	}
	
	
}
