package controllers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import common.Constants;

import model.db.bean.accounting.FileTable;
import play.mvc.Http.MultipartFormData.FilePart;
import controllers.beans.FileVo;

public class ControllerUtils {
	
	public static String hashPassword(String username, String password){
		
		//Adding username to hash input to prevent reverse password hacking
		String compoundPass = username + ":" + password;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = md.digest(compoundPass.getBytes("UTF-8"));
			
			return convertByteArrayToHexString(hashedBytes);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compoundPass;	
	}
	
	private static String convertByteArrayToHexString(byte[] arrayBytes) {
	    StringBuffer stringBuffer = new StringBuffer();
	    for (int i = 0; i < arrayBytes.length; i++) {
	        stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
	                .substring(1));
	    }
	    return stringBuffer.toString();
	}
	
	public static String getMonthYear() {
		String monthYear = "";

		Calendar cal = Calendar.getInstance();
		cal.setTime(cal.getTime());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		monthYear = Integer.toString(month) + "_" + Integer.toString(year);

		return monthYear;
	}

	public static String getDayMonthYear() {
		String dayMonthYear = "";

		Calendar cal = Calendar.getInstance();
		cal.setTime(cal.getTime());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		dayMonthYear = Integer.toString(day) + "_" + Integer.toString(month)
				+ "_" + Integer.toString(year);

		return dayMonthYear;
	}

	public static String getTimeDayMonthYear() {
		String dayMonthYear = "";

		Calendar cal = Calendar.getInstance();
		cal.setTime(cal.getTime());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		dayMonthYear = Integer.toString(seconds) + Constants.FILE_NAME_SEPERATOR
				+ Integer.toString(minute) + Constants.FILE_NAME_SEPERATOR
				+ Integer.toString(hour) + Constants.FILE_NAME_SEPERATOR + Integer.toString(day)
				+ Constants.FILE_NAME_SEPERATOR + Integer.toString(month) + Constants.FILE_NAME_SEPERATOR
				+ Integer.toString(year);

		return dayMonthYear;
	}
	
	public static String getThisMonthAccountTempFolderName(String accountId) {
		String folder = Constants.TEMP_FOLDER;

		folder = folder + accountId + Constants.FILE_SEPERATOR + getMonthYear();

		return folder;
	}

	public static String getThisMonthAccountRealFolderName(String accountId) {
		String folder = Constants.REAL_FOLDER;

		folder = folder + accountId + Constants.FILE_SEPERATOR + getMonthYear();

		return folder;
	}
	
	public static void setFileAttributes(FileVo fileVo, String accountId,FilePart picture)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(cal.getTime());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		
		String dayMonthYear = Integer.toString(seconds) + Constants.FILE_NAME_SEPERATOR
				+ Integer.toString(minute) + Constants.FILE_NAME_SEPERATOR
				+ Integer.toString(hour) + Constants.FILE_NAME_SEPERATOR + Integer.toString(day)
				+ Constants.FILE_NAME_SEPERATOR + Integer.toString(month) + Constants.FILE_NAME_SEPERATOR
				+ Integer.toString(year);
		
		fileVo.setYear(Integer.toString(year));
		fileVo.setMonth(Integer.toString(month));
		fileVo.setDay(Integer.toString(day));
		fileVo.setHour(Integer.toString(hour));
		fileVo.setMinute(Integer.toString(minute));
		fileVo.setSecond(Integer.toString(seconds));
		fileVo.setAccountId(accountId);
		fileVo.setFiletype(picture.getContentType());
		//fileVo.setAccountUsername(accountUsername);
		//fileVo.setAccountantId(accountantId);
		
		String monthYear = Integer.toString(month) + "_" + Integer.toString(year);
		
		String folder = Constants.TEMP_FOLDER;
		String tempFile = folder + accountId + Constants.FILE_SEPERATOR +  monthYear	+ Constants.FILE_SEPERATOR + dayMonthYear + fileVo.getFilename();
		
		fileVo.setInternalFileName(tempFile);
	}
	
	public static String getAbsoluteFileName(FileTable file)
	{
		String dayMonthYear = file.getSecond() + Constants.FILE_NAME_SEPERATOR
				+ file.getMinute() + Constants.FILE_NAME_SEPERATOR
				+ file.getHour() + Constants.FILE_NAME_SEPERATOR + file.getDay()
				+ Constants.FILE_NAME_SEPERATOR + file.getMonth() + Constants.FILE_NAME_SEPERATOR
				+ file.getYear();
		
		String monthYear = file.getMonth() + "_" + file.getYear();
		String folder = Constants.TEMP_FOLDER;
		
		return  folder + file.getAccountId() + Constants.FILE_SEPERATOR + monthYear + Constants.FILE_SEPERATOR + dayMonthYear + file.getFilename();
	}
}
