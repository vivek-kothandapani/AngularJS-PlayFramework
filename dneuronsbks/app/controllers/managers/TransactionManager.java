package controllers.managers;

import java.util.ArrayList;
import java.util.List;

import model.db.bean.accounting.ChartOfAccountTable;
import model.db.bean.accounting.CustomerTable;
import model.db.bean.accounting.TransactionTable;
import model.db.bean.accounting.VendorTable;
import model.db.service.ServicesInstances;
import model.db.service.accounting.AccountingService;
import play.Logger;
import play.db.jpa.Transactional;
import common.CommonUtils;
import common.Constants;
import controllers.beans.codebeans.CodeVo;
import controllers.beans.CustomerVo;
import controllers.beans.TaxRuleVo;
import controllers.beans.TaxVo;
import controllers.beans.TransactionVo;
import controllers.beans.TxMasterVo;
import controllers.beans.VendorVo;
import controllers.forms.TxMasterForm;

public class TransactionManager {
	
	public static TxMasterVo getExpenseTransactions(String accountId, String username)
	{
		TxMasterVo txMasterVo = new TxMasterVo();
		Logger.debug( "Transaction Type : " + Constants.FileClass.fromString("1").toString());
		txMasterVo = getTransactions( accountId,  username ,  Constants.FileClass.fromString("1").toString());
		return txMasterVo;
	}
	
	public static TxMasterVo getInvoiceTransactions(String accountId, String username)
	{
		TxMasterVo txMasterVo = new TxMasterVo();
		Logger.debug( "Transaction Type : " + Constants.FileClass.fromString("2").toString());
		txMasterVo = getTransactions( accountId,  username ,  Constants.FileClass.fromString("2").toString());
		return txMasterVo;
	}
	
	public static TxMasterVo getTransactions(String accountId, String username , String transactionType)
	{
		TxMasterVo txMasterVo = new TxMasterVo();
		
		txMasterVo.setAccountId(accountId);
		txMasterVo.setAccountUsername(username);
		
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
				.getService();
		
		List<TransactionTable> newTransactions = accountingService.getTransactionTableNewList(accountId , transactionType);
		
		List<TransactionVo>  newTxList = new ArrayList<TransactionVo>();
		
		if(newTransactions != null)
		{
			for(TransactionTable transaction : newTransactions )
			{
				TransactionVo transactionVo = populateTransactionVo(transaction, accountId);
				newTxList.add(transactionVo);
			}
		}
		txMasterVo.setNewTxList(newTxList);
		
		List<TransactionTable> editedTransactions = accountingService.getTransactionTableEditedList(accountId , transactionType);
		List<TransactionVo>  editedTxList = new ArrayList<TransactionVo>();
		if(editedTransactions != null)
		{
			for(TransactionTable transaction : editedTransactions )
			{
				TransactionVo transactionVo = populateTransactionVo(transaction, accountId);
				editedTxList.add(transactionVo);
			}
		}
		txMasterVo.setEditedTxList(editedTxList);
		
		return txMasterVo;
	}
	
	
	private static TransactionVo populateTransactionVo (TransactionTable transaction, String accountId)
	{
		TransactionVo transactionVo = new TransactionVo();
		
		transactionVo.setTransactionId(transaction.getTransactionId());
		transactionVo.setFileId(transaction.getFileId());
		transactionVo.setAccountId(transaction.getAccountId());
		transactionVo.setAccountUsername(transaction.getAccountUsername());
		transactionVo.setAccountantId(transaction.getAccountantId());
		transactionVo.setTxCategoryId(transaction.getTxCategoryId());
		
		if(transaction.getTxCategoryId() != null && !transaction.getTxCategoryId().isEmpty())
		{
			CodeVo codeVo = AccountingCodeManager.getCodeById(transaction.getTxCategoryId());
			transactionVo.setCodeVo(codeVo);
		}
		
		transactionVo.setTxClassId(transaction.getTxClassId());
		transactionVo.setName(transaction.getName());
		transactionVo.setDescription(transaction.getDescription());
		transactionVo.setTxType(transaction.getTxType());
		transactionVo.setTxMode(transaction.getTxMode());
		transactionVo.setTxCategory(transaction.getTxCategory());
		transactionVo.setTxClass(transaction.getTxClass());
		transactionVo.setTxSet(transaction.getTxSet());
		transactionVo.setQuantity(transaction.getQuantity());
		transactionVo.setRate(transaction.getRate());
		transactionVo.setTax(transaction.getTax());
		transactionVo.setNetAmount(transaction.getNetAmount());
		transactionVo.setAmount(transaction.getAmount());
		transactionVo.setBalanceDue(transaction.getBalanceDue());
		transactionVo.setTaxType(transaction.getTaxType());
		transactionVo.setDiscountPercent(transaction.getDiscountPercent());
		transactionVo.setStatus(transaction.getStatus());
		transactionVo.setRemarks(transaction.getRemarks());
		transactionVo.setFilename(transaction.getFilename());
		
		if(transaction.getTxDate() != null && !transaction.getTxDate().isEmpty())
		{
			transactionVo.setTxDate(CommonUtils.formatDateString4(transaction.getTxDate()));
		}
		
		transactionVo.setPaymentDate(transaction.getPaymentDate());
		transactionVo.setLastModifiedDate(transaction.getLastModifiedDate());
		transactionVo.setReferenceId(transaction.getReferenceId());
		transactionVo.setEntityId(transaction.getEntityId());
		
		if(transaction.getEntityId() != null && !transaction.getEntityId().isEmpty())
		{
			
			if(transactionVo.getTxClass().equalsIgnoreCase(Constants.FileClass.fromString("1").toString()))
			{
				VendorVo vendorVo = VendorManager.getVendorById(transaction.getEntityId(), accountId);
				transactionVo.setVendorVo(vendorVo);
			}
			else
			{
				CustomerVo CustomerVo = CustomerManager.getCustomerById(transaction.getEntityId(), accountId);
				transactionVo.setCustomerVo(CustomerVo);
			}
		}
		
		transactionVo.setAccountTypeId(transaction.getAccountTypeId());
		transactionVo.setAccountCatId(transaction.getAccountCatId());
		transactionVo.setAcccountSubCatId(transaction.getAcccountSubCatId());
		transactionVo.setItemDesc(transaction.getItemDesc());
		
		transactionVo.setPaymentMethod(transaction.getPaymentMethod());
		transactionVo.setPaymentAmount(transaction.getPaymentAmount());
		transactionVo.setPaymentEntityId(transaction.getPaymentEntityId());
		
		return transactionVo;
	}
	
	
	@Transactional
	public static TxMasterForm saveExpenseTransaction(TxMasterForm fTxMasterForm, String clientAccountId, String userName)
	{
		TransactionManager txManager = new TransactionManager();
		com.avaje.ebean.Ebean.beginTransaction();
		try
		{
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
			List<TransactionVo> fTransactionVoList = fTxMasterForm.newTxList;
			Logger.debug( "Transaction Id : 0 ");
			for(TransactionVo fTransactionVo : fTransactionVoList)
			{
			
				Logger.debug( "Transaction Id : 1 ");
				
				boolean isMethodOfPaymenetSelected = fTransactionVo.getPaymentEntity() != null && fTransactionVo.getPaymentEntity().getType() != null;
				if(!isMethodOfPaymenetSelected
						|| fTransactionVo.getCodeVo() == null || fTransactionVo.getCodeVo().getCodeId() == null
						|| fTransactionVo.getReferenceId() == null || fTransactionVo.getTxDate() == null 
						|| fTransactionVo.getVendorVo() == null || fTransactionVo.getVendorVo().getVendorId() == null)
				{
					continue;
				}
				
				fTransactionVo.setPaymentMethod( fTransactionVo.getPaymentEntity().getType());
				
				
				//Transaction in DB
				TransactionTable transactionTable = accountingService.findTransactionTable(fTransactionVo.getTransactionId(), clientAccountId);
				
				Logger.debug( "Transaction Id : 2 ");
				if(transactionTable == null)
				{
					if(fTransactionVo.getIsNew().equalsIgnoreCase("TRUE"))
					{
						Logger.debug( "Transaction Id : 3 ");
						transactionTable = new TransactionTable();
						transactionTable.setAccountId(clientAccountId);
						transactionTable.setTxClass("EXPENSE_BILL");
						transactionTable.setStatus("NEW");
						transactionTable.setFilename(fTransactionVo.getFilename());
						
						if(fTransactionVo.getFileId() != null && !fTransactionVo.getFileId().isEmpty())
						{
							Logger.debug( "Transaction Id : 4 ");
							transactionTable.setFileId(fTransactionVo.getFileId());
						}
					}
					else
					{
						continue;
					}
				}
				
				Logger.debug( "Transaction Id : 5 ");
				String txDBStatus = transactionTable.getStatus();
				
				//Update Vendor transaction details if not paid
				/*  { "type" : "0", "name" : "Not Paid"},
			        { "type" : "1", "name" : "Cash"},
			        { "type" : "2", "name" : "Check"},
			        { "type" : "3", "name" : "Master Card"},
			        { "type" : "4", "name" : "Visa"},
			        { "type" : "5", "name" : "E-Check"}*/
				try 
				{
					if(txDBStatus.equalsIgnoreCase(Constants.TX_STATUS_NEW))
					{
						Logger.debug( "Transaction Id : 6 ");
						String oldAmount = "0";
						String amount = fTransactionVo.getAmount();
						String vendorId = fTransactionVo.getVendorVo().getVendorId();
						boolean isDebit = true;
						
						//Amount not paid
						if( fTransactionVo.getPaymentMethod().equalsIgnoreCase("0"))
						{
							isDebit = true;
							//Add amount to Vendor account
							txManager.updateVendorTable(oldAmount, amount, vendorId,clientAccountId,userName , isDebit);
							
							//Add amount to Account payable 
							String coaCodeId = Constants.ACCOUNTING_CODE_Amounts_payable_and_accrued_liabilities;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
							
							//Subract amount from Equity
							 coaCodeId = Constants.ACCOUNTING_CODE_Retained_earnings_deficit;
							 isDebit = false;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
						}
						//Amount paid
						else if (fTransactionVo.getPaymentMethod().equalsIgnoreCase("1") )
						{
							//Add amount to Account payable 
							String coaCodeId = Constants.ACCOUNTING_CODE_Cash;
							isDebit = false;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
							
							//Subract amount from Equity
							 coaCodeId = Constants.ACCOUNTING_CODE_Retained_earnings_deficit;
							 isDebit = false;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
						}
						else if (fTransactionVo.getPaymentMethod().equalsIgnoreCase("2") )
						{
							//Add amount to Account payable 
							isDebit = false;
							String coaCodeId = Constants.ACCOUNTING_CODE_Deposits_in_Canadian_banks_and_institutions;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
							
							//Subract amount from Equity
							 coaCodeId = Constants.ACCOUNTING_CODE_Retained_earnings_deficit;
							 isDebit = false;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
						}
						else if (fTransactionVo.getPaymentMethod().equalsIgnoreCase("3") || fTransactionVo.getPaymentMethod().equalsIgnoreCase("4") 
								|| fTransactionVo.getPaymentMethod().equalsIgnoreCase("5"))
						{
							//Add amount to Account payable 
							String coaCodeId = Constants.ACCOUNTING_CODE_Credit_card_loans;
							isDebit = true;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
							
							//Subract amount from Equity
							 coaCodeId = Constants.ACCOUNTING_CODE_Retained_earnings_deficit;
							 isDebit = false;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
						}
						
						//Update tax details
						txManager.processTax(transactionTable, fTransactionVo);
						
						//Update transaction details
						txManager.updateTransactionTable(transactionTable,fTransactionVo,clientAccountId,userName,fTransactionVo.getVendorVo().getVendorId(),Constants.TX_STATUS_EDITED);
					}
				}
				catch (Exception e)
				{
					Logger.debug("Error : " + e.getMessage());
				}
			}
			com.avaje.ebean.Ebean.commitTransaction();
		}
		catch (Exception e)
		{
			Logger.debug("Error : " + e.getMessage());
			com.avaje.ebean.Ebean.rollbackTransaction();
		}
		
		return fTxMasterForm;
	}
	
	private void processTax(TransactionTable transactionTable,TransactionVo fTransactionVo)
	{
		String taxRuleDisplayName = fTransactionVo.getTaxType();
		
		if(taxRuleDisplayName != null && !taxRuleDisplayName.equalsIgnoreCase("") && fTransactionVo.getAmount() != null && !fTransactionVo.getAmount().equalsIgnoreCase("") )
		{
			TaxRuleVo taxRuleVo = TaxRuleManager.getTaxRuleByDisplayName(taxRuleDisplayName);
			
			TaxVo taxVo = new TaxVo();
			taxVo.setAmmount(fTransactionVo.getAmount());
			taxVo.setPercentage(taxRuleVo.getPercentage());
			
			CommonUtils.processTax(taxVo);
			
			transactionTable.setTax(taxVo.getTax());
			transactionTable.setNetAmount(taxVo.getNetAmount());
			transactionTable.setTaxType(taxRuleDisplayName);
		}
	}
	
	@Transactional
	public static TxMasterForm saveInvoiceTransaction(TxMasterForm fTxMasterForm, String clientAccountId, String userName)
	{
		TransactionManager txManager = new TransactionManager();
		com.avaje.ebean.Ebean.beginTransaction();
		try
		{
			AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
			List<TransactionVo> fTransactionVoList = fTxMasterForm.newTxList;
			
			for(TransactionVo fTransactionVo : fTransactionVoList)
			{
				boolean isMethodOfPaymenetSelected = fTransactionVo.getPaymentMethod() != null || ( fTransactionVo.getPaymentEntity() != null && fTransactionVo.getPaymentEntity().getType() != null);
				if(!isMethodOfPaymenetSelected
						|| fTransactionVo.getCodeVo() == null || fTransactionVo.getCodeVo().getCodeId() == null
						|| fTransactionVo.getReferenceId() == null || fTransactionVo.getTxDate() == null 
						|| fTransactionVo.getCustomerVo() == null || fTransactionVo.getCustomerVo().getCustomerId() == null
						)
				{
					continue;
				}
				
				if(fTransactionVo.getPaymentMethod() == null || fTransactionVo.getPaymentMethod().trim().equalsIgnoreCase(""))
				{
					fTransactionVo.setPaymentMethod( fTransactionVo.getPaymentEntity().getType());
				}
				
				
				//Transaction in DB
				TransactionTable transactionTable = accountingService.findTransactionTable(fTransactionVo.getTransactionId(), clientAccountId);
				
				if(transactionTable == null)
				{
					if(fTransactionVo.getIsNew().equalsIgnoreCase("TRUE"))
					{
						Logger.debug( "Transaction Id : 3 ");
						transactionTable = new TransactionTable();
						transactionTable.setAccountId(clientAccountId);
						transactionTable.setTxClass("INVOICE");
						transactionTable.setStatus("NEW");
						transactionTable.setFilename(fTransactionVo.getFilename());
						
						if(fTransactionVo.getFileId() != null && !fTransactionVo.getFileId().isEmpty())
						{
							Logger.debug( "Transaction Id : 4 ");
							transactionTable.setFileId(fTransactionVo.getFileId());
						}
					}
					else
					{
						continue;
					}
				}
				
				
				String txDBStatus = transactionTable.getStatus();
				
				//Update Vendor transaction details if not paid
				/*  { "type" : "0", "name" : "Not Paid"},
			        { "type" : "1", "name" : "Cash"},
			        { "type" : "2", "name" : "Check"},
			        { "type" : "3", "name" : "Master Card"},
			        { "type" : "4", "name" : "Visa"},
			        { "type" : "5", "name" : "E-Check"}*/
				try 
				{
				
					if(txDBStatus.equalsIgnoreCase(Constants.TX_STATUS_NEW))
					{
						String oldAmount = "0";
						String amount = fTransactionVo.getAmount();
						String customerId = fTransactionVo.getCustomerVo().getCustomerId();
						boolean isDebit = true;
						
						//Amount not paid
						if( fTransactionVo.getPaymentMethod().equalsIgnoreCase("0"))
						{
							isDebit = true;
							//Add amount to Vendor account
							txManager.updateCustomerTable(oldAmount, amount, customerId,clientAccountId,userName , isDebit);
							
							//Add amount to Account payable 
							String coaCodeId = Constants.ACCOUNTING_CODE_Accounts_receivable;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
							
							//Add amount from Equity
							 coaCodeId = Constants.ACCOUNTING_CODE_Retained_earnings_deficit;
							 isDebit = true;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
						}
						//Amount paid
						else if (fTransactionVo.getPaymentMethod().equalsIgnoreCase("1") )
						{
							//Add amount to Account payable 
							String coaCodeId = Constants.ACCOUNTING_CODE_Cash;
							isDebit = true;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
							
							//Add amount from Equity
							 coaCodeId = Constants.ACCOUNTING_CODE_Retained_earnings_deficit;
							 isDebit = true;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
							
						}
						else if (fTransactionVo.getPaymentMethod().equalsIgnoreCase("2") )
						{
							//Add amount to Account payable 
							isDebit = true;
							String coaCodeId = Constants.ACCOUNTING_CODE_Deposits_in_Canadian_banks_and_institutions;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
							
							//Add amount from Equity
							 coaCodeId = Constants.ACCOUNTING_CODE_Retained_earnings_deficit;
							 isDebit = true;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
						}
						else if (fTransactionVo.getPaymentMethod().equalsIgnoreCase("3") || fTransactionVo.getPaymentMethod().equalsIgnoreCase("4") 
								|| fTransactionVo.getPaymentMethod().equalsIgnoreCase("5"))
						{
							//Add amount to Account payable 
							String coaCodeId = Constants.ACCOUNTING_CODE_Credit_card_loans;
							isDebit = false;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
							
							//Add amount from Equity
							 coaCodeId = Constants.ACCOUNTING_CODE_Retained_earnings_deficit;
							 isDebit = true;
							txManager.updateChartOfAccounts(amount, clientAccountId, userName , coaCodeId , isDebit);
						}
						
						//Update tax details
						txManager.processTax(transactionTable, fTransactionVo);
						
						//Update transaction details
						txManager.updateTransactionTable(transactionTable,fTransactionVo,clientAccountId,userName , fTransactionVo.getCustomerVo().getCustomerId(),Constants.TX_STATUS_EDITED);
					}
				}
				catch (Exception e)
				{
					Logger.debug("Error : " + e.getMessage());
				}
			}
			com.avaje.ebean.Ebean.commitTransaction();
		}
		catch (Exception e)
		{
			Logger.debug("Error : " + e.getMessage());
			com.avaje.ebean.Ebean.rollbackTransaction();
		}
		
		return fTxMasterForm;
	}
	
	private void updateTransactionTable(TransactionTable transactionTable, TransactionVo fTransactionVo,String accountId, String userName,
			String entityId, String status)
	{
		transactionTable.setAmount(fTransactionVo.getAmount());
		transactionTable.setEntityId(entityId);
		transactionTable.setAccountUsername(userName);
		transactionTable.setTxDate(CommonUtils.formatDateString2(fTransactionVo.getTxDate()));
		transactionTable.setTxCategoryId(fTransactionVo.getCodeVo().getCodeId());
		transactionTable.setPaymentMethod(fTransactionVo.getPaymentMethod());
		transactionTable.setRemarks(fTransactionVo.getRemarks());
		transactionTable.setReferenceId(fTransactionVo.getReferenceId());
		transactionTable.setStatus(status);
		transactionTable.save("accounting");
	}
	
	private void updateVendorTable(String oldAmount, String amount, String vendorId, String accountId, String userName , boolean isDebit)
	{
		VendorManager.updateTable(oldAmount, amount, vendorId, accountId, userName, isDebit);
	}
	
	private void updateCustomerTable(String oldAmount, String amount, String customerId, String accountId, String userName , boolean isDebit)
	{
		CustomerManager.updateTable(oldAmount, amount, customerId, accountId, userName, isDebit);
	}
	
	private void updateChartOfAccounts(String amount , String accountId, String userName  , String coaCodeId , boolean isDebit)
	{
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE.getService();
		ChartOfAccountTable coaTable = accountingService.findChartOfAccount(accountId, coaCodeId);
		
		String baseAmount = "0";
		String newAmount = "0";
		
		if(coaTable == null)
		{
			newAmount = CommonUtils.addAmount(baseAmount, amount , isDebit );
			coaTable = new ChartOfAccountTable();
			coaTable.setAccountId(accountId);
			coaTable.setCodeId(coaCodeId);
			coaTable.setAmount(newAmount);
			coaTable.save("accounting");
		}
		else
		{
			newAmount = CommonUtils.addAmount(coaTable.getAmount(), amount , isDebit);
			coaTable.setAmount(newAmount);
			coaTable.save("accounting");
		}
	}
}
