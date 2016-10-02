package model.db.service.accounting.helper;

import java.util.List;

import model.db.bean.accounting.ChartOfAccountTable;

public class ChartOfAccountsHelper {
	public ChartOfAccountTable findChartOfAccount(String accountId , String codeId){
		List<ChartOfAccountTable> chartOfAccountTableList = (List<ChartOfAccountTable>)ChartOfAccountTable.finder.where("lower(accountId) = :accountId and "
				+ "lower(codeId) = :codeId ")
				.setParameter("accountId", accountId)
				.setParameter("codeId", codeId)
				.findList();
		
		if(chartOfAccountTableList != null && chartOfAccountTableList.size() > 0){
			return chartOfAccountTableList.get(0);
		}else{
			return null;
		}
	}
}
