package model.db.service.reporting.helper;

import java.util.Comparator;

import model.db.bean.accounting.ChartOfAccountTable;
import model.db.bean.accounting.TransactionTable;

public class TransactionTableComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		TransactionTable transactionTable1 = (TransactionTable)o1;
		TransactionTable transactionTable2 = (TransactionTable)o2;
		
		if(transactionTable2.getTxCategoryId() ==  null || transactionTable1.getTxCategoryId() == null)
		{
			return -1;
		}
		
		return transactionTable2.getTxCategoryId().compareTo(transactionTable1.getTxCategoryId());
	}
}
