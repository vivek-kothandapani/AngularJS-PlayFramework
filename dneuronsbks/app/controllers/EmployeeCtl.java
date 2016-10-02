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
import controllers.beans.EmployeeVo;
import controllers.beans.codebeans.CodeMasterVo;
import controllers.beans.codebeans.CodeVo;
import controllers.forms.EmployeeForm;
import controllers.forms.CustomerForm;
import controllers.forms.User;
import controllers.managers.AccountingCodeManager;
import controllers.managers.EmployeeManager;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import static play.libs.Json.toJson;
import views.html.login.*;
import views.html.dashboard.*;
import views.html.dashboard.employee.*;

public class EmployeeCtl extends Controller {

	//Get account type codes for this account
	public static Result init() {
		if (SessionMaster.validateSession(session())) {
			ObjectNode result = Json.newObject();
			
			List<CodeVo>  codeVoList = AccountingCodeManager.getEmployeeCodes();
			
			CodeMasterVo codeMasterVo = new CodeMasterVo();
			codeMasterVo.setCodeVoList(codeVoList);
			
			result.put("resultdata", Json.toJson(codeMasterVo));
			
			return ok(result);
		}
		return redirect("/login");
	}

	public static Result getEmployees() {
		if (SessionMaster.validateSession(session())) {
			ObjectNode result = Json.newObject();
			
			List<EmployeeVo>  employeeVoList = EmployeeManager.findAllEmployeesByAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			
			if(employeeVoList != null && employeeVoList.size() >0){
				result.put("resultdata", Json.toJson(employeeVoList));
			}
			
			return ok(result);
		}
		return redirect("/login");
	}
	
	public static Result getEmployeeByName() {
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			ObjectNode result = Json.newObject();
			
			String displayName = json.findPath("displayName").asText();
			
			EmployeeVo  employeeVo = EmployeeManager.findEmployeeByName(displayName ,session(Constants.CLIENT_ACCOUNT_ID) );
			CodeVo codeVo = AccountingCodeManager.getCodeById(employeeVo.getCodeId());
			employeeVo.setCodeVo(codeVo);
			if(employeeVo != null ){
				result.put("resultdata", Json.toJson(employeeVo));
			}
			return ok(result);
		}
		return redirect("/login");
	}

	public static Result validateName() {
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			EmployeeVo employeeVo = new EmployeeVo();
			employeeVo.setDisplayName(json.findPath("displayName").asText());
			employeeVo.setAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			if (!StringUtils.isEmpty(json.findPath("displayName").asText())) {

				if (EmployeeManager.validateUsername(employeeVo)) {
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

	public static Result suggestEmployee() {
		
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			String searchText = json.findPath("search").asText();
			ObjectNode result = Json.newObject();
			
			List<EmployeeVo>  employeeVoList = EmployeeManager.suggestEmployee(searchText,session(Constants.CLIENT_ACCOUNT_ID) );
			
			if(employeeVoList != null && employeeVoList.size() >0){
				result.put("resultdata", Json.toJson(employeeVoList));
			}
			
			return ok(result);
		}
		return redirect("/login");
	}
	
	
	public static Result add() {
		
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			
			Form<EmployeeForm> employeeForm = new Form<EmployeeForm>(
					EmployeeForm.class);
			EmployeeForm fEmployeeForm = employeeForm.bindFromRequest().get();
			
			EmployeeVo employeeVo = new EmployeeVo();
			employeeVo.setAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			employeeVo.setCreatedBy(session(Constants.ACCOUNT_ID));
			employeeVo.setModifiedBy(session(Constants.ACCOUNT_ID));
			
			if(EmployeeManager.add(employeeVo,fEmployeeForm) != null){
				result.put("resultdata", Json.toJson(employeeVo));
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
				List<EmployeeVo> employees =  EmployeeManager.findAllEmployeesByAccountId(session(Constants.CLIENT_ACCOUNT_ID));
				
				if(employees == null)
				{
					employees = new ArrayList<EmployeeVo>();
				}
				
				return ok(landing.render("yoursite.com" , employees));
		}
		return redirect("/login");
	}
}
