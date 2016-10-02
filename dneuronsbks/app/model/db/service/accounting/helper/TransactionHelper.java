package model.db.service.accounting.helper;

import java.util.List;

import model.db.bean.accounting.TransactionTable;
import controllers.beans.TransactionVo;

public class TransactionHelper {
	
	public TransactionTable addTransaction(TransactionVo transactionVo){
		TransactionTable transactionTable = new TransactionTable();
		return transactionTable.create(transactionVo);
	}
	
	public TransactionTable findTransactionById(String transactionsId , String accountId){
		List<TransactionTable> transactionTableList = (List<TransactionTable>)TransactionTable.finder.where("lower(accountId) = :accountId and "
				+ "lower(transactionId) = :transactionId")
				.setParameter("accountId", accountId)
				.setParameter("transactionId", transactionsId)
				.findList();
		
		if(transactionTableList != null && transactionTableList.size() > 0){
			return transactionTableList.get(0);
		}else{
			return null;
		}
	}
	
	public List<TransactionTable> findTransactions(String accountId , String txStatus , String transactionType){
	   List<TransactionTable> transactions = (List<TransactionTable>)TransactionTable.finder
			 .where("lower(status) = :status and lower(accountId) = :accountId and lower(txClass) = :transactionType")
			.setParameter("status",txStatus)
			.setParameter("accountId",accountId)
			.setParameter("transactionType",transactionType).findList();
		
		if(transactions != null && transactions.size() > 0){
			return transactions;
		}else{
			return null;
		}
	}
}
