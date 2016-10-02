package model.db.service.profile.helper;

import java.util.List;

import model.db.bean.products.Skus;
import model.db.bean.profile.AccountInfo;
import model.db.bean.profile.EntitleMentInfo;

import org.apache.commons.lang3.RandomStringUtils;

import play.libs.mailer.Email;
import play.libs.mailer.MailerPlugin;
import play.db.ebean.Model;
import common.Constants;
import controllers.ControllerUtils;
import controllers.beans.AddUserVO;
import controllers.beans.SignupVO;

public class AddUserHelper {
	
	public boolean validateUsername(AddUserVO addUserVO){
		System.out.println("insdie helper");
		List<AccountInfo> accountInfoList = (List<AccountInfo>)AccountInfo.finder.where("lower(username) = :username")
				.setParameter("username", addUserVO.getUserName())
				.findList();
		
		if(accountInfoList != null && accountInfoList.size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean deactivateUser(String userNameOrId,String reason){
		List<AccountInfo> accountInfoList = (List<AccountInfo>)AccountInfo.finder.where("lower(username) = :username")
				.setParameter("username", userNameOrId)
				.findList();
		System.out.println(userNameOrId + reason);
		if(accountInfoList != null && accountInfoList.size() > 0){
			AccountInfo account = accountInfoList.get(0);
			account.setStatus("Deactivated");
			account.setReason(reason);
			account.save("profile");
			return true;
		}else{
			return false;
		}
	}
	
	public boolean reactivateUser(String userNameOrId,String reason){
		List<AccountInfo> accountInfoList = (List<AccountInfo>)AccountInfo.finder.where("lower(username) = :username")
				.setParameter("username", userNameOrId)
				.findList();
		System.out.println(userNameOrId + reason);
		if(accountInfoList != null && accountInfoList.size() > 0){
			AccountInfo account = accountInfoList.get(0);
			account.setStatus("Reactivated");
			account.setReason(reason);
			account.save("profile");
			return true;
		}else{
			return false;
		}
	}
	
	public boolean resetPassword(String userNameOrId){
		List<AccountInfo> accountInfoList = (List<AccountInfo>)AccountInfo.finder.where("lower(username) = :username")
				.setParameter("username", userNameOrId)
				.findList();
		if(accountInfoList != null && accountInfoList.size() > 0){
			AccountInfo account = accountInfoList.get(0);
			String email = account.getEmail();
			String pass = generatePassword();
			String encryptedPassword = ControllerUtils.hashPassword(userNameOrId, pass);
			if(sendTempPassEmail(email, pass,account.getUsername())){
				account.setPassword(encryptedPassword);
				account.setTempPass("true");
				account.save("profile");
			}
			return true;
		}else{
			return false;
		}
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean addUser(AddUserVO addUserVO){
		System.out.println("inside add user");
		List<AccountInfo> accountInfoList = (List<AccountInfo>)AccountInfo.finder.where("lower(username) = :username")
				.setParameter("username", addUserVO.getUserName())
				.findList();
		List<Skus> skuList = (List<Skus>)new Model.Finder("default",String.class, Skus.class)
				.where("lower(name) = :name")
				.setParameter("name", "Basic")
				.findList();
		AccountInfo accountInfo = null;
		String email = null;
		String tempPassword = null;
		if (accountInfoList == null || accountInfoList.size() <= 0) {
			email = addUserVO.getEmail();
			tempPassword = generatePassword();
			String encryptedPassword = ControllerUtils.hashPassword(addUserVO.getUserName(), tempPassword);
			accountInfo = new AccountInfo();
			accountInfo.setUsername(addUserVO.getUserName());
			accountInfo.setPhoneNumber(addUserVO.getPhoneNumber());
			accountInfo.setFirstName(addUserVO.getFirstName());
			accountInfo.setLastName(addUserVO.getLastName());
			accountInfo.setRole(addUserVO.getRole());
			accountInfo.setEmail(email);
			accountInfo.setStatus(Constants.ACNT_STATUS_NEW);
			accountInfo.setPassword(encryptedPassword);
			accountInfo.setCompanyName(addUserVO.getCompanyName());
			
		}else{
			System.out.println("update");
			return false;
		}
		EntitleMentInfo entitlementInfo = null;
		if(accountInfo.getEntitlementId() != null){
			entitlementInfo = EntitleMentInfo.finder.byId(Integer.valueOf(accountInfo.getEntitlementId()));
		}else{
			entitlementInfo = new EntitleMentInfo();
		}
				
		if(skuList != null && skuList.size() > 0){
			Skus sku = skuList.get(0);
			entitlementInfo.setSku(sku.getId());
			entitlementInfo.save("profile");
		}
		accountInfo.setEntitlementId(String.valueOf(entitlementInfo.getEntitlementId()));
		boolean sentMail = sendTempPassEmail(email,tempPassword , addUserVO.getUserName());
		if(sentMail){
		accountInfo.setTempPass("true");
		accountInfo.save("profile");
		return true;
		}
		
		
		
		return false;
	}
	
	private boolean sendTempPassEmail(String email,String tempPassword, String username){
		Email emailSender = new Email();
			emailSender.setSubject("Your yoursite.com User Account Password");
			emailSender.setFrom("support@yoursite.com");
			emailSender.addTo(email);
			emailSender.setBodyText("Account Details");
			emailSender.setBodyHtml(EmailSender.passwordResetBody(username,tempPassword));
			try{
				MailerPlugin.send(emailSender);
			}catch(Exception e){
				System.out.println("some error occured");
				return false;
			}
		return true;
	}
	
	private boolean sendActivationEmail(String email, String username,String actiationid,String host,String protocol){
		Email emailSender = new Email();
			emailSender.setSubject("Your yoursite.com User Account Password");
			emailSender.setFrom("support@yoursite.com");
			emailSender.addTo(email);
			emailSender.setBodyText("Account Details");
			emailSender.setBodyHtml(EmailSender.ActivationBody(username,actiationid,host,protocol));
			try{
				MailerPlugin.send(emailSender);
			}catch(Exception e){
				System.out.println("some error occured");
				return false;
			}
		return true;
	}
	
	
	private String generatePassword() {
		return RandomStringUtils.randomAlphabetic(16);

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean addOwnUser(SignupVO signupVO,String host){
		List<AccountInfo> accountInfoList = (List<AccountInfo>)AccountInfo.finder.where("lower(username) = :username")
				.setParameter("username", signupVO.getName())
				.findList();
		if(accountInfoList.isEmpty()){
			String activationId = generatePassword();
			System.out.println(signupVO.getName());
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setUsername(signupVO.getName());
			accountInfo.setEmail(signupVO.getEmail());
			accountInfo.setPassword(signupVO.getPassword());
			accountInfo.setPhoneNumber(signupVO.getPhno());
			accountInfo.setActivationId(activationId);
			accountInfo.setRole(Constants.Role.CLIENT.toString());
			accountInfo.setCompanyName("NO NAME");
			sendActivationEmail(signupVO.getEmail(),signupVO.getName(),activationId,host,signupVO.getProtocol());
			accountInfo.save("profile");
		}else{
			System.out.println("account already exist");
			return false;
		}
		return true;
		
	}
	public boolean activateUser(String ActivationId,String username){
	
		List<AccountInfo> accountInfoList = (List<AccountInfo>)AccountInfo.finder.where("lower(username) = :username")
				.setParameter("username", username)
				.findList();
		if(accountInfoList.isEmpty()){
			return false;
		}else{
			
			AccountInfo account = accountInfoList.get(0);
			
			System.out.println(account.getActivationId().equals(ActivationId));
			if(account.getActivationId().equals(ActivationId)){
				account.setStatus("NEW");
				account.save("profile");
				return true;
			}
			return false;
		}
	}
	
	

}
