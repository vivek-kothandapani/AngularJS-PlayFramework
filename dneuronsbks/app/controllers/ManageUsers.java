package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.db.bean.profile.AccountInfo;
import model.db.service.ServicesInstances;
import model.db.service.profile.ProfileService;

import org.apache.commons.lang3.StringUtils;

import play.Logger;
import play.data.Form;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.index;
import views.html.dashboard.office;
import views.html.login.loginpage;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import common.Constants;
import common.SessionMaster;
import controllers.beans.AddUserVO;
import controllers.beans.SignupVO;
import controllers.forms.ActivationForm;
import controllers.forms.PasswordDetails;
import controllers.forms.SignupForm;
import controllers.forms.User;
import controllers.forms.Username;
import controllers.managers.ManageUserManager;

public class ManageUsers extends Controller{

	
	public static Result addUsers(){
		ObjectNode result = Json.newObject();
		return ok(result);
	}
	
	
	public static Result setClientId() {
		JsonNode json = request().body().asJson();
		String clientIdOrDisplayName = json.findPath("clientId").asText();
		ObjectNode result = Json.newObject();
		
		String username = session(Constants.ACCOUNT_USER_NAME);
		//String accountClientId = session(Constants.CLIENT_ACCOUNT_ID);
		String accountId = session(Constants.ACCOUNT_ID);
		
		controllers.beans.AccountInfo account = new controllers.beans.AccountInfo();
		AccountInfo clientAccount = new AccountInfo();
		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE
				.getService();
		account = profileService.getAccountInfo(username, accountId);
		
		
		 if (account.getRole().equalsIgnoreCase(Constants.Role.BOOKsuper.roleName()) || 
				 account.getRole().equalsIgnoreCase(Constants.Role.ACCOUNTANT.roleName()) ||
				 account.getRole().equalsIgnoreCase(Constants.Role.ADMIN.roleName()) ||
				 account.getRole().equalsIgnoreCase(Constants.Role.ROOT.roleName()))
		 {
			 
			   List<AccountInfo>  accountInfoList = ManageUserManager
						.findAllUsersById();
			   
			   for (AccountInfo accountInfo : accountInfoList) {
					if(accountInfo.getAccountId() != null && accountInfo.getAccountId().equalsIgnoreCase(clientIdOrDisplayName)){
						clientAccount = accountInfo;
						break;
					}
					if(accountInfo.getUsername() != null && accountInfo.getUsername().equalsIgnoreCase(clientIdOrDisplayName)){
						clientAccount = accountInfo;
						break;
					}
				}
			    
				session(Constants.CLIENT_ACCOUNT_ID, clientAccount.getAccountId());
		 }
		
		return ok(result);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Result searchUser() {
		JsonNode json = request().body().asJson();
		String searchText = json.findPath("search").asText();
		ObjectNode result = Json.newObject();
			List<AccountInfo> account = (List<AccountInfo>) new Model.Finder(
					"profile", String.class, AccountInfo.class)
					.where("lower(username) = :userName")
					.setParameter("userName", searchText).findList();
			if(account != null && account.size() > 0){
				
				result.put("email", account.get(0).getEmail());
				result.put("phoneNumber", account.get(0).getPhoneNumber());
			}else{
				result.put("userFound", "false");
				return badRequest(result);
			}
		return ok(result);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Result searchDeActiveUser() {
		JsonNode json = request().body().asJson();
		String searchText = json.findPath("search").asText();
		ObjectNode result = Json.newObject();
			List<AccountInfo> account = (List<AccountInfo>) new Model.Finder(
					"profile", String.class, AccountInfo.class)
					.where("lower(username) = :userName and lower(status) = :status")
					.setParameter("userName", searchText)
					.setParameter("status", "Deactivated")
					.findList();
			if(account != null && account.size() > 0){
				
				result.put("email", account.get(0).getEmail());
				result.put("phoneNumber", account.get(0).getPhoneNumber());
			}else{
				result.put("userFound", "false");
				return badRequest(result);
			}
		return ok(result);
	}
	
	public static Result suggestUsers() {
		JsonNode json = request().body().asJson();
		String searchText = json.findPath("search").asText();
		ObjectNode result = Json.newObject();
		
		if(searchText != null && !searchText.trim().equals(""))
		{
			List<AccountInfo>  accountInfo = ManageUserManager
					.findAllUsersById();
			List<String>  username = new ArrayList<String>();
			List<String>  userId = new ArrayList<String>();
			for (AccountInfo account : accountInfo) {
				if(account.getAccountId() != null && account.getAccountId().toUpperCase().contains(searchText.toUpperCase())){
					userId.add(account.getAccountId());
				}
				if(account.getUsername() != null && account.getUsername().toUpperCase().contains(searchText.toUpperCase())){
					username.add(account.getUsername());
				}
			}
			if(username != null && username.size() >0){
				result.put("resultdata", Json.toJson(username));
			}else{
				result.put("resultdata", Json.toJson(userId));
			}
		}
		return ok(result);
	}
	
	public static Result userNameValidation(){
		
		System.out.println("Hello");
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			AddUserVO addUserVo = new AddUserVO();
			System.out.println("inside validate"+ json.findPath("username").asText());
			addUserVo.setUserName(json.findPath("username").asText());
			if(!StringUtils.isEmpty(json.findPath("username").asText())){
			if(ManageUserManager.validateUsername(addUserVo)){
				result.put("status", "success");
				return ok(result);
			}else{
				result.put("status", "username already exist");
				return badRequest(result);
			}
			}
		}
		return redirect("/login");
	}
	
	
	public static Result getInitialData(){
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			AddUserVO adduserVO = ManageUserManager.getInitialData();
				result.put("role", Json.toJson(adduserVO.getRoles()));
				result.put("packageName", Json.toJson(adduserVO.getPackages()));
				return ok(result);
		}
		return redirect("/login");
	}
	
	public static Result submitAddUsers(){
		
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			
			controllers.beans.AccountInfo userAccount = new controllers.beans.AccountInfo();
			ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE
					.getService();
			userAccount = profileService.getAccountInfo(session().get(Constants.ACCOUNT_USER_NAME), session().get(Constants.ACCOUNT_ID));
			
			if(userAccount.getRole().equalsIgnoreCase(Constants.Role.ACCOUNTANT.toString()) || userAccount.getRole().equalsIgnoreCase(Constants.Role.ADMIN.toString())
				|| userAccount.getRole().equalsIgnoreCase(Constants.Role.ROOT.toString()))
			{
				JsonNode json = request().body().asJson();
				Logger.debug("Submitting Company Details"+json);
				AddUserVO addUserVo = new AddUserVO();
				addUserVo.setEmail(json.findPath("email").asText());
				addUserVo.setUserName(json.findPath("username").asText());
				addUserVo.setFirstName(json.findPath("firstName").asText());
				addUserVo.setPackageName(json.findPath("packageName").asText());
				addUserVo.setPhoneNumber(json.findPath("phoneNumber").asText());
				addUserVo.setLastName(json.findPath("lastName").asText());
				addUserVo.setRole(json.findPath("role").asText());
				
				//TODO - change this
				addUserVo.setCompanyName("NO NAME");
				
				boolean returnvalue = ManageUserManager.addUser(addUserVo);
				System.out.println(returnvalue);
				if(returnvalue){
					System.out.println("final result" + result);
					return ok(result);
					
				}else{
					result.put("errorMessage", "user already exist");
					return badRequest(result);
				}
			}
			else
			{
				result.put("errorMessage", "not authorized");
				return badRequest(result);
			}
		}

		return redirect("/login");
	}
	
	
	public static Result deactivate(){
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			
			controllers.beans.AccountInfo userAccount = new controllers.beans.AccountInfo();
			ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE
					.getService();
			userAccount = profileService.getAccountInfo(session().get(Constants.ACCOUNT_USER_NAME), session().get(Constants.ACCOUNT_ID));
			
			if(userAccount.getRole().equalsIgnoreCase(Constants.Role.ACCOUNTANT.toString()) || userAccount.getRole().equalsIgnoreCase(Constants.Role.ADMIN.toString())
				|| userAccount.getRole().equalsIgnoreCase(Constants.Role.ROOT.toString()))
			{
				JsonNode json = request().body().asJson();
				System.out.println(json);
				String searchText = json.findPath("search").asText();
				String reason = json.findPath("reason").asText();
				if(ManageUserManager.deActivate(searchText, reason)){
					result.put("status", "success");
					return ok(result);
				}else{
					result.put("errorMessage", "uable to reset your password");
					return badRequest(result);
				}
			}
			else
			{
				result.put("status", "not authorized");
			}
		}
		return redirect("/login");
	}
	
	public static Result reactivate(){
		ObjectNode result = Json.newObject();
		if (validateSession()) {
			
			controllers.beans.AccountInfo userAccount = new controllers.beans.AccountInfo();
			ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE
					.getService();
			userAccount = profileService.getAccountInfo(session().get(Constants.ACCOUNT_USER_NAME), session().get(Constants.ACCOUNT_ID));
			
			if(userAccount.getRole().equalsIgnoreCase(Constants.Role.ACCOUNTANT.toString()) || userAccount.getRole().equalsIgnoreCase(Constants.Role.ADMIN.toString())
				|| userAccount.getRole().equalsIgnoreCase(Constants.Role.ROOT.toString()))
			{
				JsonNode json = request().body().asJson();
				System.out.println(json);
				String searchText = json.findPath("search").asText();
				String reason = json.findPath("reason").asText();
				if(ManageUserManager.reActivate(searchText, reason)){
					result.put("status", "success");
					return ok(result);
				}else{
					result.put("errorMessage", "uable to reset your password");
					return badRequest(result);
				}
			}
			else
			{
				result.put("status", "not authorized");
			}
		}
		return redirect("/login");
	}
	

	
	public static Result resetPassword(){
		
			ObjectNode result = Json.newObject();
			JsonNode json = request().body().asJson();
			
			String username = "";
			
			if(json != null && json.findPath("search") != null)
			{
				username = json.findPath("search").asText();
				
				if(username.isEmpty() && SessionMaster.validateSession(session())){
					if(ManageUserManager.resetPassword(session().get(Constants.ACCOUNT_USER_NAME)))
					{
						result.put("status", "success");
						return ok(result);
					}
					result.put("errorMessage", "uable to reset your password");
					return badRequest(result);
				}
				else if(SessionMaster.validateSession(session())){
					
					controllers.beans.AccountInfo userAccount = new controllers.beans.AccountInfo();
					ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE
							.getService();
					userAccount = profileService.getAccountInfo(session().get(Constants.ACCOUNT_USER_NAME), session().get(Constants.ACCOUNT_ID));
					
					if(userAccount.getRole().equalsIgnoreCase(Constants.Role.ACCOUNTANT.toString()) || userAccount.getRole().equalsIgnoreCase(Constants.Role.ADMIN.toString())
						|| userAccount.getRole().equalsIgnoreCase(Constants.Role.ROOT.toString()))
					{
						if(ManageUserManager.resetPassword(username))
						{
							result.put("status", "success");
						}
						else
						{
							result.put("status", "failed");
						}
					}
					else
					{
						result.put("status", "not authorized");
					}
					
					return ok(result);
				}else{
					result.put("errorMessage", "uable to reset your password");
					return badRequest(result);
				}
			}
			else if (request().body().asFormUrlEncoded() != null)
			{
				final Map<String, String[]> values = request().body().asFormUrlEncoded();

				username = values.get("username")[0];
				
				if(username != null && !username.isEmpty() && ManageUserManager.resetPassword(username)){
					result.put("status", "success");
					return ok(loginpage.render("yoursite.com","resetSuccess",""));
				}else{
					result.put("errorMessage", "uable to reset your password");
					return ok(loginpage.render("yoursite.com","resetFailure",""));
				}
			}
			result.put("status", "failed");
			return badRequest(result);
	}
	
	public static Result signUp(){
		Form<SignupForm> userForm = new Form<SignupForm>(SignupForm.class);
		SignupForm signup = userForm.bindFromRequest().get();
		System.out.println(request().host());
		
		if(signup != null){
			
			SignupVO signupVO = new SignupVO();
			String hashPass = ControllerUtils.hashPassword(signup.username,signup.password);
			signupVO.setEmail(signup.email);
			signupVO.setName(signup.username);
			signupVO.setPackageName(signup.packageName);
			signupVO.setPassword(hashPass);
			signupVO.setPhno(signup.phno);
			signupVO.setPolicy(signup.policy);
			System.out.println(request().secure());
			String protocol = "http";
			if(request().secure()){
				protocol = "https";
			}
			signupVO.setProtocol(protocol);
			if(ManageUserManager.addOwnUser(signupVO, request().host())){
			return ok(loginpage.render("yoursite.com","signup",""));
			}
		}
		return badRequest();
	}


	
	public static String validateAccount() {
		String accountId = session("account");
		if(StringUtils.isNotEmpty(accountId)){
			return accountId;
		}
		return null;
	}
	
	public static Result activateAccount() {
		Form<ActivationForm> activationForm = new Form<ActivationForm>(ActivationForm.class);
		ActivationForm activation = activationForm.bindFromRequest().get();
		System.out.println("activate account");
		String activationId = activation.activationId;
		String username = activation.username;
		if(ManageUserManager.activateUser(activationId, username)){
			return ok(loginpage.render("yoursite.com","",""));
		}
		return badRequest();
	}

	public static String validateUserName() {
		String username = session("connected");
		if(StringUtils.isNotEmpty(username)){
			return username;
		}
		return null;
	}
	
	//TODO
	public static boolean validateSession()
	{
		String username = validateUserName();
   		String accountId = validateAccount();
		return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(accountId);
	}

}
