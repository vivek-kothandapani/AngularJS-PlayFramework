package model.db.bean.accounting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Table(name = "accounting.file")
@Entity
public class FileTable extends Model {

	/**
	 * 
	 * 
	 file_id bigint UNSIGNED NOT NULL AUTO_INCREMENT, account_id int UNSIGNED
	 * NOT NULL, account_username varchar(255), accountant_id int UNSIGNED,
	 * filename varchar(255) not null, filetype varchar(20) not null,
	 * upload_year int UNSIGNED NOT NULL, upload_month int UNSIGNED NOT NULL,
	 * upload_day int UNSIGNED NOT NULL, upload_hour int UNSIGNED NOT NULL,
	 * upload_minute int UNSIGNED NOT NULL, upload_second int UNSIGNED NOT NULL,
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileId;
	private String accountId;
	private String accountUsername;
	private String accountantId;
	private String filename;
	private String filetype;
	private String fileclass;
	private String year;
	private String month;
	private String day;
	private String hour;
	private String minute;
	private String second;

	public FileTable() {
		super();
	}

	public FileTable create(controllers.beans.FileVo fileVo) {
		this.accountId = fileVo.getAccountId();
		this.accountUsername = fileVo.getAccountUsername();
		this.accountantId = fileVo.getAccountantId();
		this.filename = fileVo.getFilename();
		this.filetype = fileVo.getFiletype();
		this.fileclass = fileVo.getFileclass();
		this.year = fileVo.getYear();
		this.month = fileVo.getMonth();
		this.day = fileVo.getDay();
		this.hour = fileVo.getHour();
		this.minute = fileVo.getMinute();
		this.second = fileVo.getSecond();
		this.save("accounting");
		return this;
	}
	
	public static Finder<String, FileTable> finder = new Finder<String, FileTable>("accounting",
			String.class, FileTable.class);

	@Id
	@GeneratedValue
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

	@Column(name = "filename")
	public String getFilename() {
		return filename;
	}

	@Column(name = "filetype")
	public String getFiletype() {
		return filetype;
	}

	@Column(name = "fileclass")
	public String getFileclass() {
		return fileclass;
	}

	@Column(name = "upload_year")
	public String getYear() {
		return year;
	}

	@Column(name = "upload_month")
	public String getMonth() {
		return month;
	}

	@Column(name = "upload_day")
	public String getDay() {
		return day;
	}

	@Column(name = "upload_hour")
	public String getHour() {
		return hour;
	}

	@Column(name = "upload_minute")
	public String getMinute() {
		return minute;
	}

	@Column(name = "upload_second")
	public String getSecond() {
		return second;
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

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public void setFileclass(String fileclass) {
		this.fileclass = fileclass;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public void setSecond(String second) {
		this.second = second;
	}

}