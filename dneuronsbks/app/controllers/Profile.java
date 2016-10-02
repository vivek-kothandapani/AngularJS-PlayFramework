package controllers;

import model.db.bean.profile.AccountInfo;
import model.db.service.ServicesInstances;
import model.db.service.profile.ProfileService;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import common.Constants;
import common.SessionMaster;
import controllers.beans.CompanyInfoVo;
import controllers.managers.ProfileManager;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import static play.libs.Json.toJson;
import views.html.login.*;
import views.html.dashboard.*;
import views.html.dashboard.profile.*;

public class Profile extends Controller {
	
	@Transactional(readOnly = true)
	public static Result landing() {
		if (SessionMaster.validateSession(session())) {
				return ok(landing.render("yoursite.com"));
		}
		return redirect("/login");
	}
   	
	@Transactional(readOnly=true)
    public static Result one() {
		
		Logger.debug("Profile one : 1");
		if(SessionMaster.validateSession(session()))
   		{
			Logger.debug("Profile one : 2");
   			CompanyInfoVo companyInfoVo = ProfileManager.getCompanyInfo(session(Constants.CLIENT_ACCOUNT_ID));
   			ObjectNode result = Json.newObject();
			if( companyInfoVo != null)
 		   	{
				Logger.debug("Profile one : 3");
				 result.put("city", companyInfoVo.getCity());
				 result.put("companyAddress1", companyInfoVo.getCompanyAddress1());
				 result.put("companyAddress2", companyInfoVo.getCompanyAddress2());
				 result.put("companyName", companyInfoVo.getCompanyName());
				 result.put("country", companyInfoVo.getCountry());
				 result.put("phoneNumber", companyInfoVo.getPhoneNumber());
				 result.put("postaCode", companyInfoVo.getPostalCode());
				 result.put("province", companyInfoVo.getProvince());
				 result.put("email", companyInfoVo.getEmail());
				 return ok(result);
 		   	}else{
 		   	Logger.debug("Profile one : 4");
 		   		return ok(result);
 		   	}
   		}
		Logger.debug("Profile one : 5");
   		return redirect("/login");
    }

    public static Result submitOne() {
    	JsonNode json = request().body().asJson();
		Logger.debug("Submitting Company Details");
   		controllers.beans.CompanyInfoVo companyInfo = new controllers.beans.CompanyInfoVo();
   		companyInfo.setCity(json.findPath("city").asText());
   		companyInfo.setCompanyAddress1(json.findPath("companyAddress1").asText());
   		companyInfo.setCompanyAddress2(json.findPath("companyAddress2").asText());
   		companyInfo.setCompanyName(json.findPath("companyName").asText());
   		companyInfo.setCountry(json.findPath("country").asText());
   		companyInfo.setPhoneNumber(json.findPath("phoneNumber").asText());
   		companyInfo.setProvince(json.findPath("province").asText());
   		companyInfo.setPostalCode(json.findPath("postaCode").asText());
   		companyInfo.setEmail(json.findPath("email").asText());
   		if(SessionMaster.validateSession(session()))
   		{
   			ObjectNode result = Json.newObject();
			if(ProfileManager.setCompanyInfo(companyInfo,session(Constants.CLIENT_ACCOUNT_ID)))
 		   	{
				 result.put("status", "OK");
				 return ok(result);
 		   	}else{
 		   	return badRequest();
 		   	}
   		}
   		return redirect("/login");
    }
	
	@Transactional(readOnly=true)
    public static Result two() {
   		
   		if(SessionMaster.validateSession(session()))
   		{
   			CompanyInfoVo companyInfoVo = ProfileManager.getMoreCompanyInfo(session(Constants.CLIENT_ACCOUNT_ID));
			if( companyInfoVo != null)
 		   	{
				ObjectNode result = Json.newObject();
				 result.put("industry", companyInfoVo.getIndustry());
				 result.put("whatWeSell", companyInfoVo.getWhatWeSell());
				 result.put("companyType", companyInfoVo.getCompanyType());
				 result.put("legalCompanyName", companyInfoVo.getLegalCompanyName());
				 result.put("legalCompanyAddress1", companyInfoVo.getLegalCompanyAddress1());
				 result.put("legalCompanyAddress2", companyInfoVo.getLegalCompanyAddress2());
				 result.put("legalCity", companyInfoVo.getLegalCity());
				 result.put("legalPostaCode", companyInfoVo.getLegalPostaCode());
				 result.put("legalProvince", companyInfoVo.getLegalProvince());
				 result.put("legalCountry", companyInfoVo.getLegalCountry());
				 result.put("status", "OK");
				 return ok(result);
 		   	}
   		}
   		return redirect("/login");
    }
	
    public static Result submitTwo() {
    	
    	JsonNode json = request().body().asJson();
    	System.out.println(json);
    	controllers.beans.CompanyInfoVo companyInfo = new controllers.beans.CompanyInfoVo();
   		companyInfo.setLegalCity(json.findPath("legalCity").asText());
   		companyInfo.setLegalCompanyAddress1(json.findPath("legalCompanyAddress1").asText());
   		companyInfo.setLegalCompanyAddress2(json.findPath("legalCompanyAddress2").asText());
   		companyInfo.setIndustry(json.findPath("industry").asText());
   		companyInfo.setWhatWeSell(json.findPath("whatWeSell").asText());
   		companyInfo.setCompanyType(json.findPath("companyType").asText());
   		companyInfo.setLegalCompanyName(json.findPath("legalCompanyName").asText());
   		companyInfo.setLegalPostaCode(json.findPath("legalPostaCode").asText());
   		companyInfo.setLegalProvince(json.findPath("legalProvince").asText());
   		companyInfo.setLegalCountry(json.findPath("legalCountry").asText());
    	
   		if(SessionMaster.validateSession(session()))
   		{
			if(ProfileManager.setMoreCompanyInfo(companyInfo, session(Constants.CLIENT_ACCOUNT_ID)))
 		   	{
				 return ok();
 		   	}
   		}
   		return redirect("/login");
    }
	
	@Transactional(readOnly=true)
    public static Result three() {
   		
   		if(SessionMaster.validateSession(session()))
   		{
   			ObjectNode result = Json.newObject();
   			controllers.beans.CompanyInfoVo companyInfo = new controllers.beans.CompanyInfoVo();
   			companyInfo = ProfileManager.isTermsAccepted(session(Constants.CLIENT_ACCOUNT_ID));
   			result.put("terms", companyInfo.getTermsAgreed());
   			return ok(result);
   		}
   		return redirect("/login");
    }
	
	 public static Result submitThree() {
		 controllers.beans.CompanyInfoVo companyInfo = new controllers.beans.CompanyInfoVo();
	    	JsonNode json = request().body().asJson();
	    	System.out.println(json);
	    	companyInfo.setTermsAgreed(json.findPath("terms").asText());	    	
	   		if(SessionMaster.validateSession(session()))
	   		{
	   			if(ProfileManager.acceptTerms(companyInfo,session(Constants.CLIENT_ACCOUNT_ID))){
	   				ObjectNode result = Json.newObject();
	   				result.put("status", "ok");
	   				return ok(result);
	   			}
	   		}
	   		return redirect("/login");
	    }
		
}
