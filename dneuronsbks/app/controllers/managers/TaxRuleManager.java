package controllers.managers;

import java.util.ArrayList;
import java.util.List;

import model.db.bean.accounting.TaxRuleTable;
import model.db.service.ServicesInstances;
import model.db.service.accounting.AccountingService;
import play.cache.Cache;

import common.Constants;

import controllers.beans.TaxRuleVo;

public class TaxRuleManager {

	public static List<TaxRuleVo> getTaxRules(String countryCode) {
		
		@SuppressWarnings("unchecked")
		List<TaxRuleVo> taxRuleVoList = (List<TaxRuleVo>) Cache.get(Constants.CACHE_TAX_RULE_VO_LIST);
		
		if(taxRuleVoList == null)
		{
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
					.getService();
	
			List<TaxRuleTable> taxRuleTableList = accountingService.findAllRuleByCountryCode(countryCode);
			taxRuleVoList = new ArrayList<TaxRuleVo>();
	
			if (taxRuleTableList != null) {
	
				for (TaxRuleTable taxRuleTable : taxRuleTableList) {
					TaxRuleVo taxRuleVo = new TaxRuleVo();
					populateTaxRuleVo(taxRuleVo, taxRuleTable);
					taxRuleVoList.add(taxRuleVo);
				}
				Cache.set(Constants.CACHE_TAX_RULE_VO_LIST  , taxRuleVoList);
			} else {
				taxRuleVoList = null;
			}
		}
		return taxRuleVoList;
	}
	
	public static TaxRuleVo getTaxRuleById(String taxRuleId) {
		
		TaxRuleVo taxRuleVo = (TaxRuleVo)Cache.get(Constants.CACHE_TAX_RULE_VO + taxRuleId);
		
		if(taxRuleVo == null)
		{
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
					.getService();
	
			TaxRuleTable taxRuleTable = accountingService.findTaxRuleById(taxRuleId);
			taxRuleVo = new TaxRuleVo();
	
			if (taxRuleTable != null) {
				populateTaxRuleVo(taxRuleVo, taxRuleTable);
				Cache.set(Constants.CACHE_TAX_RULE_VO +  taxRuleId , taxRuleVo);
			} else {
				taxRuleVo = null;
			}
		}
		return taxRuleVo;
	}
	
public static TaxRuleVo getTaxRuleByDisplayName(String displayName) {
		
		TaxRuleVo taxRuleVo = (TaxRuleVo)Cache.get(Constants.CACHE_TAX_RULE_VO + displayName);
		
		if(taxRuleVo == null)
		{
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
					.getService();
	
			TaxRuleTable taxRuleTable = accountingService.findTaxRuleByDisplayName(displayName);
			taxRuleVo = new TaxRuleVo();
	
			if (taxRuleTable != null) {
				populateTaxRuleVo(taxRuleVo, taxRuleTable);
				Cache.set(Constants.CACHE_TAX_RULE_VO +  displayName , taxRuleVo);
			} else {
				taxRuleVo = null;
			}
		}
		return taxRuleVo;
	}

	public static void populateTaxRuleVo(TaxRuleVo taxRuleVo, TaxRuleTable taxRuleTable ){
		taxRuleVo.setTaxRuleId(taxRuleTable.getTaxRuleId());
		taxRuleVo.setDisplayName(taxRuleTable.getDisplayName());
		taxRuleVo.setPercentage(taxRuleTable.getPercentage());
		taxRuleVo.setCountryCode(taxRuleTable.getCountryCode());
		taxRuleVo.setStateCode(taxRuleTable.getStateCode());
		taxRuleVo.setRemarks(taxRuleTable.getRemarks());
	}
}
