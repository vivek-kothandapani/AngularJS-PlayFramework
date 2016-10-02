package controllers.beans;

public class TaxVo {
	private String type;
	private String tax;
	private String ammount;
	private String netAmount;
	private String percentage;
	private String fixedTax;
	public String getType() {
		return type;
	}
	public String getTax() {
		return tax;
	}
	public String getAmmount() {
		return ammount;
	}
	public String getNetAmount() {
		return netAmount;
	}
	public String getPercentage() {
		return percentage;
	}
	public String getFixedTax() {
		return fixedTax;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}
	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public void setFixedTax(String fixedTax) {
		this.fixedTax = fixedTax;
	}
}
