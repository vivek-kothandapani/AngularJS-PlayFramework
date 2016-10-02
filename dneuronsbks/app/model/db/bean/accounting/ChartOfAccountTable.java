package model.db.bean.accounting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

import play.db.ebean.Model;
@PersistenceUnit(name="accounting")
@Table(name = "chart_of_accounts")
@Entity
public class ChartOfAccountTable extends Model {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8919345284103478305L;
	private String accountId;
	private String codeId;
	private String amount;
	private String modifiedDate;
	@Id
	@GeneratedValue
	private String chartId;

	@Column(name="account_id")
	public String getAccountId() {
		return accountId;
	}

	@Column(name="account_id")
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Column(name="code_id")
	public String getCodeId() {
		return codeId;
	}

	@Column(name="code_id")
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	@Column(name="amount")
	public String getAmount() {
		return amount;
	}

	@Column(name="amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name="modified_date")
	public String getModifiedDate() {
		return modifiedDate;
	}

	@Column(name="modified_date")
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Id
	@GeneratedValue
	@Column(name="chart_id")
	public String getChartId() {
		return chartId;
	}

	@Id
	@GeneratedValue
	@Column(name="chart_id")
	public void setChartId(String chartId) {
		this.chartId = chartId;
	}
	
	public static Finder<Integer, ChartOfAccountTable> finder = new Finder<Integer, ChartOfAccountTable>("accounting",
			Integer.class, ChartOfAccountTable.class);
}
