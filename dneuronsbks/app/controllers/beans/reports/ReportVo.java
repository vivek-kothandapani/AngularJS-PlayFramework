package controllers.beans.reports;

public class ReportVo {
	private String generatedDate;
	private String generatedTime;
	private String asOfDate;
	private String asOfTime;
	private String companyName;
	private String companyLogo;
	private String reportName;
	private String reportType;
	
	public String getGeneratedDate() {
		return generatedDate;
	}
	public String getGeneratedTime() {
		return generatedTime;
	}
	public String getAsOfDate() {
		return asOfDate;
	}
	public String getAsOfTime() {
		return asOfTime;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getCompanyLogo() {
		return companyLogo;
	}
	public String getReportName() {
		return reportName;
	}
	public String getReportType() {
		return reportType;
	}
	public void setGeneratedDate(String generatedDate) {
		this.generatedDate = generatedDate;
	}
	public void setGeneratedTime(String generatedTime) {
		this.generatedTime = generatedTime;
	}
	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}
	public void setAsOfTime(String asOfTime) {
		this.asOfTime = asOfTime;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
}