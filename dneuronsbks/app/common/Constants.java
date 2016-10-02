package common;

public class Constants {

	public static String TEMP_FOLDER = "B:/bugatti/data/files/temp/";
	
	//public static String TEMP_FOLDER = "/app/data/files/temp/";
	//Play.application().configuration().getString("your.key")
	public static String REAL_FOLDER = "B:/bugatti/data/files/real/";
	public static String FILE_SEPERATOR = "/";
	public static String FILE_NAME_SEPERATOR = "_yoursite_";

	// Account Status
	public static String ACNT_STATUS_NEW = "NEW";
	public static String ACNT_STATUS_NEW_1 = "NEW-1";
	public static String ACNT_STATUS_NEW_2 = "NEW-2";
	public static String ACNT_STATUS_NEW_3 = "NEW-3";
	public static String CLIENT = "CLIENT";
	public static String Bsuper = "Bsuper";
	public static String BSUPER = "BSUPER";
	public static String BADMIN = "BADMIN";
	public static String ROOT = "ROOT";

	//Simple date formatter 
	public static String DATE_FORMAT_1 = "MM/dd/yyyy HH:mm:ss";
	public static String DATE_FORMAT_2 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	public static String DATE_FORMAT_3 = "yyyy-MM-dd";
	public static String DATE_FORMAT_4 = "yyyy-MM-dd' 'HH:mm:ss.S";
	
	//User session variables
	public static String ACCOUNT_USER_NAME = "connected";
	public static String ACCOUNT_ID = "account";
	public static String CLIENT_ACCOUNT_ID = "clientaccountid";
	public static String USER_ID = "userid";
	
	// Transaction status
	public static String TX_STATUS_NEW = "NEW";
	public static String TX_STATUS_EDITED = "EDITED";
	public static String TX_STATUS_CLOSED = "CLOSED";
	
	//File Upload
	public static String FILE_UPLOAD_FIELD_NAME = "file";
	
	//Cache Keys
	//Global Objects
	public static String CACHE_ACCOUNTING_CODE_GLOBAL = "cache.accounting.code.global";
	public static String CACHE_ACCOUNTING_VENDOR_CODE_GLOBAL = "cache.accounting.vendor.code.global";
	public static String CACHE_ACCOUNTING_VENDOR_CODE_ACNT_TYPE_GLOBAL = "cache.accounting.vendor.acnt.type.code.global";
	public static String CACHE_ACCOUNTING_VENDOR_CODE_ACNT_TYPE_DROP_DOWN_GLOBAL = "cache.accounting.vendor.acnt.type.drop.down.global";
	
	public static String CACHE_ACCOUNTING_BANK_CODE_GLOBAL = "cache.accounting.bank.code.global";
	public static String CACHE_ACCOUNTING_CUSTOMER_CODE_GLOBAL = "cache.accounting.customer.code.global";
	public static String CACHE_ACCOUNTING_EMPLOYEE_CODE_GLOBAL = "cache.accounting.employee.code.global";
	
	public static String CACHE_TAX_RULE_VO_LIST = "cache.tax.rule.vo.list.global";
	public static String CACHE_TAX_RULE_VO = "cache.tax.rule.vo.";
	
	//Account specific objects
	public static String CACHE_VENDOR_VO_LIST_ACCOUNT = "cache.vendor.vo.list.account.";
	public static String CACHE_VENDOR_VO_ACCOUNT = "cache.vendor.vo.account.";
	
	public static String CACHE_BANK_VO_LIST_ACCOUNT = "cache.bank.vo.list.account.";
	public static String CACHE_BANK_VO_ACCOUNT = "cache.bank.vo.account.";
	
	public static String CACHE_CUSTOMER_VO_LIST_ACCOUNT = "cache.customer.vo.list.account.";
	public static String CACHE_CUSTOMER_VO_ACCOUNT = "cache.customer.vo.account.";
	
	public static String CACHE_EMPLOYEE_VO_LIST_ACCOUNT = "cache.employee.vo.list.account.";
	public static String CACHE_EMPLOYEE_VO_ACCOUNT = "cache.employee.vo.account.";
	
	//Accounting code constants
	public static String ACCOUNTING_CODE_SUB_GRP_EXPENSES_ID = "12";
	public static String ACCOUNTING_CODE_SUB_GRP_INVOICE_ID = "15";
	
	
	public static String ACCOUNTING_CODE_Amounts_payable_and_accrued_liabilities ="245";
	public static String ACCOUNTING_CODE_Accounts_receivable = "9";
	
	public static String ACCOUNTING_CODE_Deposits_in_Canadian_banks_and_institutions ="3";
	public static String ACCOUNTING_CODE_Cash ="2";
	
	public static String ACCOUNTING_CODE_Credit_card_loans = "264";
	
	public static String ACCOUNTING_CODE_Retained_earnings_deficit ="345";
	
	
	//Bank codes
	public static String ACCOUNTING_CODE_ACCOUNT_TYPE_ASSET_CASH_AND_DEPOSIT = "12";
	
	//Employee codes
	public static String ACCOUNTING_CODE_ACCOUNT_TYPE_ASSET_Salaries_and_wages = "128";
	
	//Invoice Code/Revenue code
	
	// File Class - Inovoice/Expense/Payroll
	public static enum FileClass {
		EXPENSE_BILL("1"), INVOICE("2"),REPORT("3"), OTHERS(
				"0");

		private String type;

		FileClass(String aFileClass) {
			this.type = aFileClass;
		}

		public String getText() {
			return this.type;
		}

		public static FileClass fromString(String aFileClass) {
			if (aFileClass != null) {
				for (FileClass b : FileClass.values()) {
					if (aFileClass.equalsIgnoreCase(b.type)) {
						return b;
					}
				}
			}
			return OTHERS;
		}
	}
	
	// User roles
	public static enum Role {
		
		CLIENT("CLIENT"),BOOKsuper("Bsuper"),ACCOUNTANT("BSUPER"),ADMIN("BADMIN"),ROOT("ROOT");
		
		private String roleName;
		
		Role(String rolename){
			this.roleName = rolename;
		}
		
		public String roleName(){
			return this.roleName;
		}

	}
	
	//Country Code
	public static String COUNTRY_CODE_CANADA ="CA";
}
