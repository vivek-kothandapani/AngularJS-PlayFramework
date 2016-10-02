package controllers;

import java.util.ArrayList;
import java.util.List;

import model.db.bean.profile.AccountInfo;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import common.Constants;
import common.SessionMaster;
import static play.libs.Json.toJson;
import controllers.beans.TaxRuleVo;
import controllers.beans.VendorVo;
import controllers.managers.ManageUserManager;
import controllers.managers.TaxRuleManager;
import controllers.managers.VendorManager;

public class TaxRuleCtl extends Controller {

		//Get tax rules 
		public static Result getTaxRules() {
			if (SessionMaster.validateSession(session())) {
				ObjectNode result = Json.newObject();
				
				List<TaxRuleVo>  taxRuleVoList = TaxRuleManager.getTaxRules(Constants.COUNTRY_CODE_CANADA);
				
				if(taxRuleVoList != null && taxRuleVoList.size() >0){
					result.put("resultdata", Json.toJson(taxRuleVoList));
				}
				
				return ok(result);
			}
			return redirect("/login");
		}
		
		//Suggest tax rules
		public static Result suggestTaxRule() {
			
			if (SessionMaster.validateSession(session())) {
				JsonNode json = request().body().asJson();
				String searchText = json.findPath("search").asText();
				ObjectNode result = Json.newObject();
				
				List<TaxRuleVo>  taxRuleVoList = TaxRuleManager.getTaxRules(Constants.COUNTRY_CODE_CANADA);
				List<String>  displayNameList = new ArrayList<String>();
				
				for (TaxRuleVo taxRuleVo : taxRuleVoList) {
					if(taxRuleVo.getDisplayName() != null && taxRuleVo.getDisplayName().toUpperCase().contains(searchText.toUpperCase())){
						displayNameList.add(taxRuleVo.getDisplayName());
					}
				}
				
				if(displayNameList != null && displayNameList.size() >0){
					result.put("resultdata", Json.toJson(displayNameList));
				}
				
				return ok(result);
			}
			return redirect("/login");
		}
}
