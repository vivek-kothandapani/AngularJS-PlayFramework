package model.db.service.reporting.helper;

import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

import model.db.bean.accounting.ChartOfAccountTable;
import model.db.bean.accounting.CodeTable;

public class ChartOfAccountTableComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
		ChartOfAccountTable chartOfAccountTable1 = (ChartOfAccountTable)o1;
		ChartOfAccountTable chartOfAccountTable2 = (ChartOfAccountTable)o2;
		
		CodeTable code1 = CodeTable.finder.byId(chartOfAccountTable1.getCodeId());
		CodeTable code2 = CodeTable.finder.byId(chartOfAccountTable2.getCodeId());
		
		String sortOrderStr1 =  code1.getCodeAccountTypeTable().getCodeSubGroupTable().getCodeGroupTable().getSortOrder();
		String sortOrderStr2 =  code2.getCodeAccountTypeTable().getCodeSubGroupTable().getCodeGroupTable().getSortOrder();
		
		Integer sortOrder1 = -100;
		Integer sortOrder2 = -100;
		
		if(sortOrderStr1 != null && StringUtils.isNotEmpty(sortOrderStr1))
		{
			try{
				sortOrder1 = Integer.parseInt(sortOrderStr1);
			}
			catch (Exception e)
			{
				
			}
		}
		
		if(sortOrderStr2 != null && StringUtils.isNotEmpty(sortOrderStr2))
		{
			try{
				sortOrder2 = Integer.parseInt(sortOrderStr2);
			}
			catch (Exception e)
			{
				
			}
		}
		return sortOrder2.compareTo(sortOrder1);
	}
}
