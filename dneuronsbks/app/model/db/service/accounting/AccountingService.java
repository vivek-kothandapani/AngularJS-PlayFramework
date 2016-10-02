package model.db.service.accounting;

import java.util.List;

import model.db.bean.accounting.BankTable;
import model.db.bean.accounting.ChartOfAccountTable;
import model.db.bean.accounting.ClientCodeTable;
import model.db.bean.accounting.CodeAccountTypeTable;
import model.db.bean.accounting.CodeGroupTable;
import model.db.bean.accounting.CodeSubGroupTable;
import model.db.bean.accounting.CodeTable;
import model.db.bean.accounting.CustomerTable;
import model.db.bean.accounting.EmployeeTable;
import model.db.bean.accounting.FileTable;
import model.db.bean.accounting.TaxRuleTable;
import model.db.bean.accounting.TransactionTable;
import model.db.bean.accounting.VendorTable;
import model.db.service.accounting.helper.AccountingCodeHelper;
import model.db.service.accounting.helper.BankHelper;
import model.db.service.accounting.helper.ChartOfAccountsHelper;
import model.db.service.accounting.helper.CustomerHelper;
import model.db.service.accounting.helper.EmployeeHelper;
import model.db.service.accounting.helper.FileHelper;
import model.db.service.accounting.helper.TaxRuleHelper;
import model.db.service.accounting.helper.TransactionHelper;
import model.db.service.accounting.helper.VendorHelper;
import common.Constants;
import controllers.beans.BankVo;
import controllers.beans.CustomerVo;
import controllers.beans.EmployeeVo;
import controllers.beans.FileVo;
import controllers.beans.TransactionVo;
import controllers.beans.TxMasterVo;
import controllers.beans.VendorVo;

public class AccountingService {
	
	//Chart of accounts 
	public ChartOfAccountTable findChartOfAccount(String accountId, String codeId){
		return new ChartOfAccountsHelper().findChartOfAccount(accountId,codeId);
	}

	//transactions services
	public boolean addTransaction(TransactionVo transactionVo) {
		new TransactionHelper().addTransaction(transactionVo);
		return true;
	}
	
	public List<TransactionTable> getTransactionTableNewList(String accountId , String transactionType) {
		return new TransactionHelper().findTransactions(accountId, Constants.TX_STATUS_NEW , transactionType);
	}
	
	public List<TransactionTable> getTransactionTableEditedList(String accountId , String transactionType) {
		return new TransactionHelper().findTransactions(accountId, Constants.TX_STATUS_EDITED , transactionType);
	}
	
	public TransactionTable findTransactionTable(String transactionsId, String accountId){
		return new TransactionHelper().findTransactionById(transactionsId, accountId);
	}
	
	//file services
	public boolean addFile(FileVo fileVo) {
		new FileHelper().addFile(fileVo);
		return true;
	}
	
	public FileTable getFile(String username, String accountId, String fileId) {
		return new FileHelper().getFile(username, accountId, fileId);
	}
	
	//vendor services
	public boolean validateUsername(VendorVo vendorVo){
		return new VendorHelper().validateUsername(vendorVo);
	}
	
	public VendorTable findVendor(String vendorId, String accountId){
		return new VendorHelper().findVendor(vendorId,accountId);
	}
	
	public List<VendorTable> suggestVendor(String searchText, String accountId){
		return new VendorHelper().suggestVendor(searchText,accountId);
	}
	
	public VendorTable addVendor(VendorVo vendorVo){
		return new VendorHelper().addVendor(vendorVo);
	}
	
	public VendorTable updateVendor(VendorVo vendorVo){
		return new VendorHelper().updateVendor(vendorVo);
	}
	
	
	public List<VendorTable> findAllVendorsByAccountId(String accountId){
		return new VendorHelper().findAllVendorsByAccountId(accountId);
	}
	
	public VendorTable findVendorByDisplayName(String displayName, String accountId){
		return new VendorHelper().findVendorByDisplayName( displayName, accountId);
	}
	
	
	//customer services
	public boolean validateUsername(CustomerVo customerVo){
		return new CustomerHelper().validateUsername(customerVo);
	}
	
	public CustomerTable findCustomer(String customerId, String accountId){
		return new CustomerHelper().findCustomer(customerId,accountId);
	}
	
	public List<CustomerTable> suggestCustomer(String searchText, String accountId){
		return new CustomerHelper().suggestCustomer(searchText,accountId);
	}
	
	public CustomerTable addCustomer(CustomerVo customerVo){
		return new CustomerHelper().addCustomer(customerVo);
	}
	
	public CustomerTable updateCustomer(CustomerVo customerVo){
		return new CustomerHelper().updateCustomer(customerVo);
	}
	
	public List<CustomerTable> findAllCustomersByAccountId(String accountId){
		return new CustomerHelper().findAllCustomersByAccountId(accountId);
	}
	
	public CustomerTable findCustomerByDisplayName(String displayName, String accountId){
		return new CustomerHelper().findCustomerByDisplayName( displayName, accountId);
	}
	
	//bank services
	public boolean validateUsername(BankVo bankVo){
		return new BankHelper().validateUsername(bankVo);
	}
	
	public BankTable findBank(String bankId, String accountId){
		return new BankHelper().findBank(bankId,accountId);
	}
	
	public List<BankTable> suggestBank(String searchText, String accountId){
		return new BankHelper().suggestBank(searchText,accountId);
	}
	
	public BankTable addBank(BankVo bankVo){
		return new BankHelper().addBank(bankVo);
	}
	
	public List<BankTable> findAllBanksByAccountId(String accountId){
		return new BankHelper().findAllBanksByAccountId(accountId);
	}
	
	public BankTable findBankByDisplayName(String displayName, String accountId){
		return new BankHelper().findBankByDisplayName( displayName, accountId);
	}
	
	//employee services
	
	public boolean validateUsername(EmployeeVo employeeVo){
		return new EmployeeHelper().validateUsername(employeeVo);
	}
	
	public EmployeeTable findEmployee(String employeeId, String accountId){
		return new EmployeeHelper().findEmployee(employeeId,accountId);
	}
	
	public List<EmployeeTable> suggestEmployee(String searchText, String accountId){
		return new EmployeeHelper().suggestEmployee(searchText,accountId);
	}
	
	public EmployeeTable addEmployee(EmployeeVo employeeVo){
		return new EmployeeHelper().addEmployee(employeeVo);
	}
	
	public List<EmployeeTable> findAllEmployeesByAccountId(String accountId){
		return new EmployeeHelper().findAllEmployeesByAccountId(accountId);
	}
	
	public EmployeeTable findEmployeeByDisplayName(String displayName, String accountId){
		return new EmployeeHelper().findEmployeeByDisplayName( displayName, accountId);
	}
	
	//accounting code services
	public List<ClientCodeTable> findAllCodeByAccountId(String accountId){
		return new AccountingCodeHelper().findAllCodeByAccountId(accountId);
	}
	
	public List<CodeTable> findAllCode(){
		return new AccountingCodeHelper().findAllCode();
	}
	
	public List<CodeTable> findAllCodeByAccounTypeId(String accountTypeId){
		return new AccountingCodeHelper().findAllCodeByAccounTypeId(accountTypeId);
	}
	
	public List<CodeAccountTypeTable> findAllCodeAccountType(){
		return new AccountingCodeHelper().findAllCodeAccountType();
	}
	
	public List<CodeAccountTypeTable> findAllCodeAccountTypeBySubGrpId(String subGrpId){
		return new AccountingCodeHelper().findAllCodeAccountTypeBySubGrpId(subGrpId);
	}
	
	public List<CodeSubGroupTable> findAllCodeSubGroup(){
		return new AccountingCodeHelper().findAllCodeSubGroup();
	}
	
	public List<CodeGroupTable> findAllCodeGroup(){
		return new AccountingCodeHelper().findAllCodeGroup();
	}
	//File services
	public List<FileTable> findAllFiles(String accountId){
		return new FileHelper().findAllFiles(accountId);
	}
	
	public List<FileTable> findReportFiles(String accountId){
		return new FileHelper().findReportFiles(accountId);
	}
	
	//Tax Rule service
	public List<TaxRuleTable> findAllRuleByCountryCode(String countryCode){
		return new TaxRuleHelper().findAllRuleByCountryCode(countryCode);
	}
	
	public TaxRuleTable findTaxRuleById(String taxRuleId){
		return new TaxRuleHelper().findTaxRuleById(taxRuleId);
	}
	
	public TaxRuleTable findTaxRuleByDisplayName(String displayName){
		return new TaxRuleHelper().findTaxRuleByDisplayName(displayName);
	}
}