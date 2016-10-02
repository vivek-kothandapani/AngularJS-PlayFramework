package model.db.service.profile.helper;

import play.libs.mailer.MailerPlugin;
import play.mvc.Controller;

public class EmailSender extends MailerPlugin{
	
	public static String passwordResetBody(String username,String password){

	return	
			
			
			
"<html>"
	+"<body>"

	+"<table style=\"background-color: #f6f6f6; width: 100%;\">"
	    +"<tr>"
	        +"<td></td>"
	        +"<td style=\"display: block !important; max-width: 600px !important; margin: 0 auto !important; clear: both !important;\" width=\"600\">"
	            +"<div style=\"max-width: 600px; margin: 0 auto; display: block; padding: 20px;\">"
	                +"<table style=\"background: #fff; border: 1px solid #e9e9e9; border-radius: 3px;\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">"
	                    +"<tr>"
	                        +"<td style=\"font-size: 16px; color: #fff; font-weight: 500; padding: 20px; text-align: center; border-radius: 3px 3px 0 0; background: #1ab394;\">"
	                         +"   Welcome to yoursite.com!!!"
	                        +"</td>"
	                    +"</tr>"
	                    +"<tr>"
	                        +"<td  style=\"padding: 10px !important;\">"
	                            +"<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">"
	                                +"<tr>"
	                                    +"<td style=\"padding: 0 0 20px; color=\"blue\"\">"
	                                        +"<strong>Your Account Details</strong><br/><br/><br/>"
	                                    +"</td>"
	                                +"</tr>"
	                                +"<tr>"
	                                +"<td style=\"padding: 0 0 20px;\">"
	                                        +"Username: " + "<strong>"+username+"</strong>"
	                                    +"</td>"
	                                +"</tr>"
	                                +"<tr>"
	                                +"<td style=\"padding: 0 0 20px;\">"
	                                        +"Password : "+ "<strong>"+password+"</strong>"
	                                    +"</td>"
	                                +"</tr>"
	                                +"<tr>"
	                                +"<td style=\"padding: 0 0 20px;\">"
	                                + "Thanks, "
	            					+ "yoursite.com Support Team"
	                                    +"</td>"
	                                +"</tr>"
	                            +"</table>"
	                        +"</td>"
	                    +"</tr>"
	                +"</table>"
	        +"</td>"
	        +"<td></td>"
	    +"</tr>"
	+"</table>"
	+"</body>"
	+"</html>";

	}
	
	public static String ActivationBody(String username,String activationId,String activationHost,String protocol){

		return	
				
				
				
	"<html>"
		+"<body>"

		+"<table style=\"background-color: #f6f6f6; width: 100%;\">"
		    +"<tr>"
		        +"<td></td>"
		        +"<td style=\"display: block !important; max-width: 600px !important; margin: 0 auto !important; clear: both !important;\" width=\"600\">"
		            +"<div style=\"max-width: 600px; margin: 0 auto; display: block; padding: 20px;\">"
		                +"<table style=\"background: #fff; border: 1px solid #e9e9e9; border-radius: 3px;\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">"
		                    +"<tr>"
		                        +"<td style=\"font-size: 16px; color: #fff; font-weight: 500; padding: 20px; text-align: center; border-radius: 3px 3px 0 0; background: #1ab394;\">"
		                         +"   Welcome to yoursite.com"
		                        +"</td>"
		                    +"</tr>"
		                    +"<tr>"
		                        +"<td  style=\"padding: 10px !important;\">"
		                            +"<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">"
		                                +"<tr>"
		                                    +"<td style=\"padding: 0 0 20px; color=\"blue\"\">"
		                                        +"<strong>Your Account Details</strong><br/><br/><br/>"
		                                    +"</td>"
		                                +"</tr>"
		                                +"<tr>"
		                                +"<td style=\"padding: 0 0 20px;\">"
		                                        +"Username: " + "<strong>"+username+"</strong>"
		                                    +"</td>"
		                                +"</tr>"
		                                +"<tr>"
		                                +"<td style=\"padding: 0 0 20px;\">"
		                                        +"Please click on the below link to activate you account : "+ "<strong>"+protocol+"://"+activationHost+"/activationLink?username="+username+"&activtionId="+activationId+"</strong>"
		                                    +"</td>"
		                                +"</tr>"
		                                +"<tr>"
		                                +"<td style=\"padding: 0 0 20px;\">"
		                                + "Thanks, "
		            					+ "yoursite.com Support Team"
		                                    +"</td>"
		                                +"</tr>"
		                            +"</table>"
		                        +"</td>"
		                    +"</tr>"
		                +"</table>"
		        +"</td>"
		        +"<td></td>"
		    +"</tr>"
		+"</table>"
		+"</body>"
		+"</html>";

		}
	
	

}
