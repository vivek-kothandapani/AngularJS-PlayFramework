package common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import controllers.beans.TaxVo;

public class CommonUtils {

	public static String currentDateStr() {

		// Create an instance of SimpleDateFormat used for formatting
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT_1);

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();
		// Using DateFormat format method we can create a string
		// representation of a date with the defined format.
		String dateStr = df.format(today);

		return dateStr;
	}

	public static String formatDateString2(String dateString) {

		DateTimeFormatter formatter = DateTimeFormat.forPattern(Constants.DATE_FORMAT_2);
		DateTime dt = formatter.parseDateTime(dateString); // You get a DateTime object

		// Create a new formatter with the pattern you want
		DateTimeFormatter formatter2 = DateTimeFormat.forPattern(Constants.DATE_FORMAT_3);
		String dateStringInYourFormat = formatter2.print(dt); 
		
		return dateStringInYourFormat;
	}
	
	
	public static String convertDateToStr3(Date date)
	{
		DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT_3);
		String dateStr = df.format(date);
		return dateStr;
	}
	
	
	public static String formatDateString4(String dateString) {

		DateTimeFormatter formatter = DateTimeFormat.forPattern(Constants.DATE_FORMAT_4);
		DateTime dt = formatter.parseDateTime(dateString); // You get a DateTime object

		// Create a new formatter with the pattern you want
		DateTimeFormatter formatter2 = DateTimeFormat.forPattern(Constants.DATE_FORMAT_3);
		String dateStringInYourFormat = formatter2.print(dt); 
		
		return dateStringInYourFormat;
	}
	
	public static void processTax(TaxVo taxVo)
	{
		String amount = taxVo.getAmmount();
		String percentage = taxVo.getPercentage();
		taxVo.setTax("0");
		taxVo.setNetAmount("0");
		
		if(percentage != null && !percentage.equalsIgnoreCase("") && amount != null && !amount.equalsIgnoreCase(""))
		{
			BigDecimal bPercent = new BigDecimal(percentage);
			BigDecimal bAmount = new BigDecimal(amount);
			
			BigDecimal bAmountA = bAmount.multiply(new BigDecimal(100));
			BigDecimal bAmountB = new BigDecimal(100).add(bPercent);
			
			BigDecimal bNetAmount = bAmountA.divide(bAmountB, 5,RoundingMode.CEILING );
			BigDecimal bTax = bAmount.subtract(bNetAmount);
			
			taxVo.setTax(formatAmount(bTax));
			taxVo.setNetAmount(formatAmount(bNetAmount));
		}
	}
	
	public static String formatAmount(BigDecimal amount)
	{
		BigDecimal newAmount = amount.setScale(2, BigDecimal.ROUND_DOWN);

		DecimalFormat df = new DecimalFormat();

		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(0);
		df.setGroupingUsed(false);

		String result = df.format(newAmount);
		
		return result;
	}
	
	public static String addAmount(String a, String b , boolean isDebit) {
		
		if(a == null || a.equalsIgnoreCase(""))
		{
			a = "0";
		}
		if(b == null || b.equalsIgnoreCase(""))
		{
			b = "0";
		}
		
		BigDecimal aBigD = new BigDecimal(a);
		BigDecimal bBigD = new BigDecimal(b);
		
		BigDecimal newAmount = new BigDecimal("0");
		if(isDebit)
		{
			newAmount = aBigD.add(bBigD);
		}
		else
		{
			newAmount = aBigD.subtract(bBigD);
		}

		String result = formatAmount(newAmount);

		return result;

		/*
		 * // Create a DecimalFormat that fits your requirements
		 * DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		 * symbols.setGroupingSeparator(','); symbols.setDecimalSeparator('.');
		 * String pattern = "#,##0.0#"; DecimalFormat decimalFormat = new
		 * DecimalFormat(pattern, symbols);
		 * decimalFormat.setParseBigDecimal(true);
		 * 
		 * // parse the string BigDecimal bigDecimal = (BigDecimal)
		 * decimalFormat.parse("10,692,467,440,017.120");
		 * System.out.println(bigDecimal);
		 */
	}
}
