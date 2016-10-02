package controllers.beans;

import controllers.beans.codebeans.CodeVo;

public class TransactionVo {
	private String transactionId;
	private String fileId;
	private String accountId;
	private String accountUsername;
	private String accountantId;
	private String txCategoryId;
	private String txClassId;
	private String name;
	private String description;
	private String txType;
	private String txMode;
	private String txCategory;
	private String txClass;
	private String txSet;
	private String quantity;
	private String rate;
	private String tax;
	private String amount;
	private String balanceDue;
	private String taxType;
	private String discountPercent;
	private String status;
	private String remarks;
	private String filename;
	private String txDate;
	private String paymentDate;
	private String lastModifiedDate;
	private String referenceId;
	private String entityId;
	private String accountTypeId;
	private String accountCatId;
	private String acccountSubCatId;
	private String itemDesc;
	private VendorVo vendorVo;
	private CustomerVo customerVo;
	private CodeVo codeVo;
	private PaymentMethodVo paymentEntity;
	
	private String paymentMethod;
	private String paymentAmount;
	private String paymentEntityId;
	
	private String isNew;
	
	private String netAmount;
	
	public PaymentMethodVo getPaymentEntity() {
		return paymentEntity;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public String getPaymentEntityId() {
		return paymentEntityId;
	}
	public void setPaymentEntity(PaymentMethodVo paymentEntity) {
		this.paymentEntity = paymentEntity;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public void setPaymentEntityId(String paymentEntityId) {
		this.paymentEntityId = paymentEntityId;
	}
	
	public VendorVo getVendorVo() {
		return vendorVo;
	}
	public CodeVo getCodeVo() {
		return codeVo;
	}
	public void setVendorVo(VendorVo vendorVo) {
		this.vendorVo = vendorVo;
	}
	public void setCodeVo(CodeVo codeVo) {
		this.codeVo = codeVo;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public String getFileId() {
		return fileId;
	}
	public String getAccountId() {
		return accountId;
	}
	public String getAccountUsername() {
		return accountUsername;
	}
	public String getAccountantId() {
		return accountantId;
	}
	public String getTxCategoryId() {
		return txCategoryId;
	}
	public String getTxClassId() {
		return txClassId;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getTxType() {
		return txType;
	}
	public String getTxMode() {
		return txMode;
	}
	public String getTxCategory() {
		return txCategory;
	}
	public String getTxClass() {
		return txClass;
	}
	public String getTxSet() {
		return txSet;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getRate() {
		return rate;
	}
	public String getTax() {
		return tax;
	}
	public String getAmount() {
		return amount;
	}
	public String getBalanceDue() {
		return balanceDue;
	}
	public String getTaxType() {
		return taxType;
	}
	public String getDiscountPercent() {
		return discountPercent;
	}
	public String getStatus() {
		return status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}
	public void setAccountantId(String accountantId) {
		this.accountantId = accountantId;
	}
	public void setTxCategoryId(String txCategoryId) {
		this.txCategoryId = txCategoryId;
	}
	public void setTxClassId(String txClassId) {
		this.txClassId = txClassId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setTxType(String txType) {
		this.txType = txType;
	}
	public void setTxMode(String txMode) {
		this.txMode = txMode;
	}
	public void setTxCategory(String txCategory) {
		this.txCategory = txCategory;
	}
	public void setTxClass(String txClass) {
		this.txClass = txClass;
	}
	public void setTxSet(String txSet) {
		this.txSet = txSet;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setBalanceDue(String balanceDue) {
		this.balanceDue = balanceDue;
	}
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
	public void setDiscountPercent(String discountPercent) {
		this.discountPercent = discountPercent;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getTxDate() {
		return txDate;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public String getEntityId() {
		return entityId;
	}
	public String getAccountTypeId() {
		return accountTypeId;
	}
	public String getAccountCatId() {
		return accountCatId;
	}
	public String getAcccountSubCatId() {
		return acccountSubCatId;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public void setAccountCatId(String accountCatId) {
		this.accountCatId = accountCatId;
	}
	public void setAcccountSubCatId(String acccountSubCatId) {
		this.acccountSubCatId = acccountSubCatId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public CustomerVo getCustomerVo() {
		return customerVo;
	}
	public void setCustomerVo(CustomerVo customerVo) {
		this.customerVo = customerVo;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public String getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}
}