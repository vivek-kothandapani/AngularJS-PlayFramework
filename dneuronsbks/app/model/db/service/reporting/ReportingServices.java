package model.db.service.reporting;

import java.util.Map;

import controllers.beans.reports.BalanceSheetVo;
import model.db.service.reporting.helper.ReportingHelper;

public class ReportingServices {
	
	public Map<String, Map<String, Map<String, String>>> getBalanceSheet(String accountId){
		return new ReportingHelper().getBalanceSheet(accountId);
	}
	
	public BalanceSheetVo getBalanceSheetReport(String accountId){
		return new ReportingHelper().getBalanceSheetReport(accountId);
	}
	
	public Map<String, Map<String, Map<String, String>>> getIncomeStatement(String accountId){
		return new ReportingHelper().getIncomeStatement(accountId);
	}
}
