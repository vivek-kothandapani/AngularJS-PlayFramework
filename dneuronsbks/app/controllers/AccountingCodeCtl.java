package controllers;

import java.util.List;

import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import common.SessionMaster;

import controllers.beans.codebeans.CodeVo;
import controllers.managers.AccountingCodeManager;

public class AccountingCodeCtl extends Controller {
	//Get all codes 
	public static Result init() {
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			ObjectNode result = Json.newObject();
			
			List<CodeVo>  codeVoList = AccountingCodeManager.getCodes();
			
			if(codeVoList != null && codeVoList.size() >0){
				Logger.debug("Vendor - 0");
				result.put("resultdata", Json.toJson(codeVoList));
			}
			
			return ok(result);
		}
		return redirect("/login");
	}
}
