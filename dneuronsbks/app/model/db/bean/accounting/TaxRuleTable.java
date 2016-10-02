package model.db.bean.accounting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Table(name = "accounting.tax_rule")
@Entity
public class TaxRuleTable extends Model {

	/**
	 *   
   `tax_rule_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(10) DEFAULT NULL,
  `country_code` varchar(10) DEFAULT NULL,
  `state_code` varchar(10) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `class` varchar(10) DEFAULT NULL,
  `display_name` varchar(255) NOT NULL,
  `percentage_one` decimal(8,5) DEFAULT NULL,
  `percentage_two` decimal(8,5) DEFAULT NULL,
  `percentage_three` decimal(8,5) DEFAULT NULL,
  `percentage_four` decimal(8,5) DEFAULT NULL,
  `percentage` decimal(8,5) DEFAULT NULL,
  `fixed_amount_one` decimal(20,5) DEFAULT NULL,
  `fixed_amount_two` decimal(20,5) DEFAULT NULL,
  `fixed_amount_three` decimal(20,5) DEFAULT NULL,
  `fixed_amount_four` decimal(20,5) DEFAULT NULL,
  `fixed_amount` decimal(20,5) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(10) unsigned DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(10) unsigned DEFAULT NULL, 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String taxRuleId;
	private String code;
	private String countryCode;
	private String stateCode;
	private String category;
	private String type;
	private String taxRuleClass;
	private String displayName;
	private String percentageOne;
	private String percentageTwo;
	private String percentageThree;
	private String percentageFour;
	private String percentage;
	private String fixedAmountOne;
	private String fixedAmountTwo;
	private String fixedAmountThree;
	private String fixedAmountFour;
	private String fixedAmount;
	private String remarks;
	private String status;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;

	public static Finder<String, TaxRuleTable> finder = new Finder<String, TaxRuleTable>(
			"accounting", String.class, TaxRuleTable.class);
	
	public TaxRuleTable() {
		super();
	}

	public TaxRuleTable create(controllers.beans.TaxRuleVo taxRuleVo) {

		//this.taxRuleId  = taxRuleVo.getTaxRuleId();
		this.code = taxRuleVo.getCode();
		this.countryCode = taxRuleVo.getCountryCode();
		this.stateCode = taxRuleVo.getStateCode();
		this.category = taxRuleVo.getCategory();
		this.type = taxRuleVo.getType();
		this.taxRuleClass = taxRuleVo.getTaxRuleClass();
		this.displayName = taxRuleVo.getDisplayName();
		this.percentageOne = taxRuleVo.getPercentageOne();
		this.percentageTwo = taxRuleVo.getPercentageTwo();
		this.percentageThree = taxRuleVo.getPercentageThree();
		this.percentageFour = taxRuleVo.getPercentageFour();
		this.percentage = taxRuleVo.getPercentage();
		this.fixedAmountOne = taxRuleVo.getFixedAmountOne();
		this.fixedAmountTwo = taxRuleVo.getFixedAmountTwo();
		this.fixedAmountThree = taxRuleVo.getFixedAmountThree();
		this.fixedAmountFour = taxRuleVo.getFixedAmountFour();
		this.fixedAmount = taxRuleVo.getFixedAmount();
		this.displayName = taxRuleVo.getDisplayName();
		this.remarks = taxRuleVo.getRemarks();
		this.status = taxRuleVo.getStatus();
		this.createdDate = taxRuleVo.getCreatedDate();
		this.createdBy = taxRuleVo.getCreatedBy();
		this.modifiedDate = taxRuleVo.getModifiedDate();
		this.modifiedBy = taxRuleVo.getModifiedBy();

		this.save("accounting");
		return this;
	}

	@Id
	@GeneratedValue
	@Column(name = "tax_rule_id")
	public String getTaxRuleId() {
		return taxRuleId;
	}

	@Column(name = "code")
	public String getCode() {
		return code;
	}

	@Column(name = "country_code")
	public String getCountryCode() {
		return countryCode;
	}

	@Column(name = "state_code")
	public String getStateCode() {
		return stateCode;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	@Column(name = "class")
	public String getTaxRuleClass() {
		return taxRuleClass;
	}

	@Column(name = "display_name")
	public String getDisplayName() {
		return displayName;
	}

	@Column(name = "percentage_one")
	public String getPercentageOne() {
		return percentageOne;
	}

	@Column(name = "percentage_two")
	public String getPercentageTwo() {
		return percentageTwo;
	}

	@Column(name = "percentage_three")
	public String getPercentageThree() {
		return percentageThree;
	}

	@Column(name = "percentage_four")
	public String getPercentageFour() {
		return percentageFour;
	}

	@Column(name = "percentage")
	public String getPercentage() {
		return percentage;
	}

	@Column(name = "fixed_amount_one")
	public String getFixedAmountOne() {
		return fixedAmountOne;
	}

	@Column(name = "fixed_amount_two")
	public String getFixedAmountTwo() {
		return fixedAmountTwo;
	}

	@Column(name = "fixed_amount_three")
	public String getFixedAmountThree() {
		return fixedAmountThree;
	}

	@Column(name = "fixed_amount_four")
	public String getFixedAmountFour() {
		return fixedAmountFour;
	}

	@Column(name = "fixed_amount")
	public String getFixedAmount() {
		return fixedAmount;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	@Column(name = "created_date")
	public String getCreatedDate() {
		return createdDate;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}

	@Column(name = "modified_date")
	public String getModifiedDate() {
		return modifiedDate;
	}

	@Column(name = "modified_by")
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setTaxRuleId(String taxRuleId) {
		this.taxRuleId = taxRuleId;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTaxRuleClass(String taxRuleClass) {
		this.taxRuleClass = taxRuleClass;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setPercentageOne(String percentageOne) {
		this.percentageOne = percentageOne;
	}

	public void setPercentageTwo(String percentageTwo) {
		this.percentageTwo = percentageTwo;
	}

	public void setPercentageThree(String percentageThree) {
		this.percentageThree = percentageThree;
	}

	public void setPercentageFour(String percentageFour) {
		this.percentageFour = percentageFour;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public void setFixedAmountOne(String fixedAmountOne) {
		this.fixedAmountOne = fixedAmountOne;
	}

	public void setFixedAmountTwo(String fixedAmountTwo) {
		this.fixedAmountTwo = fixedAmountTwo;
	}

	public void setFixedAmountThree(String fixedAmountThree) {
		this.fixedAmountThree = fixedAmountThree;
	}

	public void setFixedAmountFour(String fixedAmountFour) {
		this.fixedAmountFour = fixedAmountFour;
	}

	public void setFixedAmount(String fixedAmount) {
		this.fixedAmount = fixedAmount;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}