package controllers;

import java.util.ArrayList;
import java.util.List;

import model.db.service.ServicesInstances;
import model.db.service.profile.ProfileService;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import common.Constants;
import common.SessionMaster;
import controllers.beans.codebeans.CodeAccountTypeVo;
import controllers.beans.codebeans.CodeMasterVo;
import controllers.beans.codebeans.CodeVo;
import controllers.beans.VendorVo;
import controllers.forms.VendorForm;
import controllers.managers.AccountingCodeManager;
import controllers.managers.VendorManager;
import play.Logger;
import play.cache.Cached;
import play.data.Form;
import play.db.ebean.Model;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import static play.libs.Json.toJson;
import views.html.login.*;
import views.html.dashboard.*;
import views.html.dashboard.vendor.*;

public class VendorCtl extends Controller {
	
	//Get account type codes for this account
	public static Result init() {
		if (SessionMaster.validateSession(session())) {
			ObjectNode result = Json.newObject();
			
			List<CodeVo>  codeVoList = AccountingCodeManager.getVendorCodes();
			
			CodeMasterVo codeMasterVo = new CodeMasterVo();
			codeMasterVo.setCodeVoList(codeVoList);
			
			result.put("resultdata", Json.toJson(codeMasterVo));
			
			return ok(result);
		}
		return redirect("/login");
	}

	public static Result getVendors() {
		if (SessionMaster.validateSession(session())) {
			ObjectNode result = Json.newObject();
			
			List<VendorVo>  vendorVoList = VendorManager.findAllVendorsByAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			
			if(vendorVoList != null && vendorVoList.size() >0){
				result.put("resultdata", Json.toJson(vendorVoList));
			}
			
			return ok(result);
		}
		return redirect("/login");
	}
	
	public static Result getVendorByName() {
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			ObjectNode result = Json.newObject();
			
			String displayName = json.findPath("displayName").asText();
			
			VendorVo  vendorVo = VendorManager.findVendorByName(displayName ,session(Constants.CLIENT_ACCOUNT_ID) );
			CodeVo codeVo = AccountingCodeManager.getCodeById(vendorVo.getCodeId());
			vendorVo.setCodeVo(codeVo);
			if(vendorVo != null ){
				result.put("resultdata", Json.toJson(vendorVo));
			}
			return ok(result);
		}
		return redirect("/login");
	}

	public static Result validateName() {
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			VendorVo vendorVo = new VendorVo();
			vendorVo.setDisplayName(json.findPath("displayName").asText());
			vendorVo.setAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			if (!StringUtils.isEmpty(json.findPath("displayName").asText())) {

				if (VendorManager.validateUsername(vendorVo)) {
					result.put("status", "success");
					return ok(result);
				} else {
					result.put("status", "username already exist");
					return badRequest(result);
				}
			}
		}
		return redirect("/login");
	}

	public static Result suggestVendor() {
		
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			String searchText = json.findPath("search").asText();
			ObjectNode result = Json.newObject();
			
			List<VendorVo>  vendorVoList = VendorManager.suggestVendor(searchText,session(Constants.CLIENT_ACCOUNT_ID) );
			
			if(vendorVoList != null && vendorVoList.size() >0){
				result.put("resultdata", Json.toJson(vendorVoList));
			}
			
			return ok(result);
		}
		return redirect("/login");
	}
	
	
	public static Result add() {
		
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			
			Form<VendorForm> vendorForm = new Form<VendorForm>(
					VendorForm.class);
			VendorForm fVendorForm = vendorForm.bindFromRequest().get();
			
			VendorVo vendorVo = new VendorVo();
			vendorVo.setAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			vendorVo.setCreatedBy(session(Constants.ACCOUNT_ID));
			vendorVo.setModifiedBy(session(Constants.ACCOUNT_ID));
			
			if(VendorManager.add(vendorVo,fVendorForm) != null){
				result.put("resultdata", Json.toJson(vendorVo));
				return ok(result);
				
			}else{
				result.put("errorMessage", "error");
				return badRequest(result);
			}
		}
		return unauthorized(result);
	}
	
	
	
public static Result update() {
		
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			
			Form<VendorForm> vendorForm = new Form<VendorForm>(
					VendorForm.class);
			VendorForm fVendorForm = vendorForm.bindFromRequest().get();
			
			VendorVo vendorVo = new VendorVo();
			vendorVo.setAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			vendorVo.setCreatedBy(session(Constants.ACCOUNT_ID));
			vendorVo.setModifiedBy(session(Constants.ACCOUNT_ID));
			
			if(VendorManager.update(vendorVo,fVendorForm) != null){
				result.put("resultdata", Json.toJson(vendorVo));
				return ok(result);
				
			}else{
				result.put("errorMessage", "error");
				return badRequest(result);
			}
		}
		return unauthorized(result);
	}

	@Transactional(readOnly = true)
	public static Result landing() {

		controllers.beans.AccountInfo account = new controllers.beans.AccountInfo();

		if (SessionMaster.validateSession(session())) {
				List<VendorVo> vendors =  VendorManager.findAllVendorsByAccountId(session(Constants.CLIENT_ACCOUNT_ID));
				
				if(vendors == null)
				{
					vendors = new ArrayList<VendorVo>();
				}
				
				return ok(landing.render("yoursite.com" , vendors));
		}
		return redirect("/login");
	}
}
