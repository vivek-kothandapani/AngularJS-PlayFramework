package model.db.bean.accounting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

import model.db.bean.profile.AccountInfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Table(name = "accounting.transaction")
@Entity
public class TransactionTable extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	private String paymentMethod;
	private String paymentAmount;
	private String paymentEntityId;
	
	private String netAmount;

	public TransactionTable() {
		super();
	}

	public TransactionTable create(controllers.beans.TransactionVo transactionVo) {
		//this.transactionId = transactionVo.getAccountId();
		this.fileId = transactionVo.getFileId();
		this.accountId = transactionVo.getAccountId();
		this.accountUsername = transactionVo.getAccountUsername();
		this.accountantId = transactionVo.getAccountantId();
		this.txCategoryId = transactionVo.getTxCategoryId();
		this.txClassId = transactionVo.getTxClassId();
		this.name = transactionVo.getName();
		this.description = transactionVo.getDescription();
		this.txType = transactionVo.getTxType();
		this.txMode = transactionVo.getTxMode();
		this.txCategory = transactionVo.getTxCategory();
		this.txClass = transactionVo.getTxClass();
		this.txSet = transactionVo.getTxSet();
		this.quantity = transactionVo.getQuantity();
		this.rate = transactionVo.getRate();
		this.tax = transactionVo.getTax();
		this.amount = transactionVo.getAmount();
		this.balanceDue = transactionVo.getBalanceDue();
		this.taxType = transactionVo.getTaxType();
		this.discountPercent = transactionVo.getDiscountPercent();
		this.status = transactionVo.getStatus();
		this.remarks = transactionVo.getRemarks();
		this.filename = transactionVo.getFilename();
		
		this.txDate = transactionVo.getTxDate();
		this.paymentDate = transactionVo.getPaymentDate();
		this.lastModifiedDate = transactionVo.getLastModifiedDate();
		this.referenceId = transactionVo.getReferenceId();
		this.entityId = transactionVo.getEntityId();
		this.accountTypeId = transactionVo.getAccountTypeId();
		this.accountCatId = transactionVo.getAccountCatId();
		this.acccountSubCatId = transactionVo.getAcccountSubCatId();
		this.itemDesc = transactionVo.getItemDesc();
		
		this.paymentAmount = transactionVo.getPaymentAmount();
		this.paymentEntityId = transactionVo.getPaymentEntityId();
		this.paymentMethod = transactionVo.getPaymentMethod();
		
		this.netAmount = transactionVo.getNetAmount();
		
		this.save("accounting");
		return this;
	}

	public static Finder<String, TransactionTable> finder = new Finder<String, TransactionTable>("accounting",
			String.class, TransactionTable.class);


	@Id
	@GeneratedValue
	@Column(name = "transaction_id")
	public String getTransactionId() {
		return transactionId;
	}

	@Column(name = "file_id")
	public String getFileId() {
		return fileId;
	}

	@Column(name = "account_id")
	public String getAccountId() {
		return accountId;
	}

	@Column(name = "account_username")
	public String getAccountUsername() {
		return accountUsername;
	}

	@Column(name = "accountant_id")
	public String getAccountantId() {
		return accountantId;
	}

	@Column(name = "tx_category_id")
	public String getTxCategoryId() {
		return txCategoryId;
	}

	@Column(name = "tx_class_id")
	public String getTxClassId() {
		return txClassId;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	@Column(name = "tx_type")
	public String getTxType() {
		return txType;
	}

	@Column(name = "tx_mode")
	public String getTxMode() {
		return txMode;
	}

	@Column(name = "tx_category")
	public String getTxCategory() {
		return txCategory;
	}

	@Column(name = "tx_class")
	public String getTxClass() {
		return txClass;
	}

	@Column(name = "tx_set")
	public String getTxSet() {
		return txSet;
	}

	@Column(name = "quantity")
	public String getQuantity() {
		return quantity;
	}

	@Column(name = "rate")
	public String getRate() {
		return rate;
	}

	@Column(name = "tax")
	public String getTax() {
		return tax;
	}

	@Column(name = "amount")
	public String getAmount() {
		return amount;
	}

	@Column(name = "balance_due")
	public String getBalanceDue() {
		return balanceDue;
	}

	@Column(name = "tax_type")
	public String getTaxType() {
		return taxType;
	}

	@Column(name = "discount_percent")
	public String getDiscountPercent() {
		return discountPercent;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}
	
	@Column(name = "filename")
	public String getFilename() {
		return filename;
	}

	@Column(name = "tx_date")
	public String getTxDate() {
		return txDate;
	}

	@Column(name = "payment_date")
	public String getPaymentDate() {
		return paymentDate;
	}

	@Column(name = "last_modified_date")
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	@Column(name = "reference_id")
	public String getReferenceId() {
		return referenceId;
	}

	@Column(name = "entity_id")
	public String getEntityId() {
		return entityId;
	}

	@Column(name = "account_type_id")
	public String getAccountTypeId() {
		return accountTypeId;
	}

	@Column(name = "account_cat_id")
	public String getAccountCatId() {
		return accountCatId;
	}

	@Column(name = "account_sub_cat_id")
	public String getAcccountSubCatId() {
		return acccountSubCatId;
	}
	
	@Column(name = "item_description")
	public String getItemDesc() {
		return itemDesc;
	}
	
	@Column(name = "payment_method")
	public String getPaymentMethod() {
		return paymentMethod;
	}

	@Column(name = "payment_amount")
	public String getPaymentAmount() {
		return paymentAmount;
	}

	@Column(name = "payment_entity_id")
	public String getPaymentEntityId() {
		return paymentEntityId;
	}

	@Column(name = "net_amount")
	public String getNetAmount() {
		return netAmount;
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
	
	public void setFilename(String filename) {
		this.filename = filename;
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

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}
	
}