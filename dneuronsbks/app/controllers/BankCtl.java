package controllers;

import java.util.ArrayList;
import java.util.List;

import model.db.bean.profile.AccountInfo;
import model.db.service.ServicesInstances;
import model.db.service.accounting.AccountingService;
import model.db.service.profile.ProfileService;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import common.Constants;
import common.SessionMaster;
import controllers.beans.codebeans.CodeMasterVo;
import controllers.beans.codebeans.CodeVo;
import controllers.beans.BankVo;
import controllers.beans.VendorVo;
import controllers.forms.BankForm;
import controllers.forms.User;
import controllers.forms.VendorForm;
import controllers.managers.AccountingCodeManager;
import controllers.managers.BankManager;
import controllers.managers.VendorManager;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import static play.libs.Json.toJson;
import views.html.login.*;
import views.html.dashboard.*;
import views.html.dashboard.bank.*;

public class BankCtl extends Controller {
	
	//Get account type codes for this account
	public static Result init() {
		if (SessionMaster.validateSession(session())) {
			ObjectNode result = Json.newObject();
			
			List<CodeVo>  codeVoList = AccountingCodeManager.getBankCodes();
			
			CodeMasterVo codeMasterVo = new CodeMasterVo();
			codeMasterVo.setCodeVoList(codeVoList);
			
			result.put("resultdata", Json.toJson(codeMasterVo));
			
			return ok(result);
		}
		return redirect("/login");
	}

	public static Result getBanks() {
		if (SessionMaster.validateSession(session())) {
			ObjectNode result = Json.newObject();
			
			List<BankVo>  bankVoList = BankManager.findAllBanksByAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			
			if(bankVoList != null && bankVoList.size() >0){
				result.put("resultdata", Json.toJson(bankVoList));
			}
			
			return ok(result);
		}
		return redirect("/login");
	}
	
	public static Result getBankByName() {
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			ObjectNode result = Json.newObject();
			
			String displayName = json.findPath("displayName").asText();
			
			BankVo  bankVo = BankManager.findBankByName(displayName ,session(Constants.CLIENT_ACCOUNT_ID) );
			CodeVo codeVo = AccountingCodeManager.getCodeById(bankVo.getCodeId());
			bankVo.setCodeVo(codeVo);
			if(bankVo != null ){
				result.put("resultdata", Json.toJson(bankVo));
			}
			return ok(result);
		}
		return redirect("/login");
	}

	public static Result validateName() {
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			BankVo bankVo = new BankVo();
			bankVo.setDisplayName(json.findPath("displayName").asText());
			bankVo.setAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			if (!StringUtils.isEmpty(json.findPath("displayName").asText())) {

				if (BankManager.validateUsername(bankVo)) {
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

	public static Result suggestBank() {
		
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			String searchText = json.findPath("search").asText();
			ObjectNode result = Json.newObject();
			
			List<BankVo>  bankVoList = BankManager.suggestBank(searchText,session(Constants.CLIENT_ACCOUNT_ID) );
			
			if(bankVoList != null && bankVoList.size() >0){
				result.put("resultdata", Json.toJson(bankVoList));
			}
			
			return ok(result);
		}
		return redirect("/login");
	}
	
	
	public static Result add() {
		
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			
			Form<BankForm> bankForm = new Form<BankForm>(
					BankForm.class);
			BankForm fBankForm = bankForm.bindFromRequest().get();
			
			BankVo bankVo = new BankVo();
			bankVo.setAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			bankVo.setCreatedBy(session(Constants.ACCOUNT_ID));
			bankVo.setModifiedBy(session(Constants.ACCOUNT_ID));
			
			if(BankManager.add(bankVo,fBankForm) != null){
				result.put("resultdata", Json.toJson(bankVo));
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
				List<BankVo> banks =  BankManager.findAllBanksByAccountId(session(Constants.CLIENT_ACCOUNT_ID));
				
				if(banks == null)
				{
					banks = new ArrayList<BankVo>();
				}
				
				return ok(landing.render("yoursite.com" , banks));
		}
		return redirect("/login");
	}
}
