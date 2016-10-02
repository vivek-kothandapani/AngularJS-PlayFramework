package controllers.managers;

import java.util.Map;

import controllers.beans.reports.BalanceSheetVo;
import model.db.service.ServicesInstances;
import model.db.service.reporting.ReportingServices;

public class ReportingManager {
	
	public static Map<String, Map<String, Map<String, String>>> getBalanceSheet(String accountId){
		ReportingServices reportingServices = (ReportingServices) ServicesInstances.REPORTING_SERVICE
				.getService();
		return reportingServices.getBalanceSheet(accountId);
	}
	
	public static BalanceSheetVo getBalanceSheetVo(String accountId){
		ReportingServices reportingServices = (ReportingServices) ServicesInstances.REPORTING_SERVICE
				.getService();
		return reportingServices.getBalanceSheetReport(accountId);
	}
	
	
	public static Map<String, Map<String, Map<String, String>>> getIncomeStatement(String accountId){
		ReportingServices reportingServices = (ReportingServices) ServicesInstances.REPORTING_SERVICE
				.getService();
		return reportingServices.getIncomeStatement(accountId);
	}
}
