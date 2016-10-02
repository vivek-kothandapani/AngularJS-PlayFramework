package controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import common.Constants;
import common.SessionMaster;

import controllers.beans.codebeans.CodeMasterVo;
import controllers.beans.codebeans.CodeVo;
import controllers.beans.CustomerVo;
import controllers.forms.CustomerForm;
import controllers.managers.AccountingCodeManager;
import controllers.managers.CustomerManager;

import views.html.dashboard.customer.*;

public class CustomerCtl extends Controller {

	// Get account type codes for this account
	public static Result init() {
		if (SessionMaster.validateSession(session())) {
			ObjectNode result = Json.newObject();

			List<CodeVo> codeVoList = AccountingCodeManager.getCustomerCodes();

			CodeMasterVo codeMasterVo = new CodeMasterVo();
			codeMasterVo.setCodeVoList(codeVoList);

			result.put("resultdata", Json.toJson(codeMasterVo));

			return ok(result);
		}
		return redirect("/login");
	}

	public static Result getCustomers() {
		if (SessionMaster.validateSession(session())) {
			ObjectNode result = Json.newObject();

			List<CustomerVo> customerVoList = CustomerManager
					.findAllCustomersByAccountId(session(Constants.CLIENT_ACCOUNT_ID));

			if (customerVoList != null && customerVoList.size() > 0) {
				result.put("resultdata", Json.toJson(customerVoList));
			}

			return ok(result);
		}
		return redirect("/login");
	}

	public static Result getCustomerByName() {
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			ObjectNode result = Json.newObject();

			String displayName = json.findPath("displayName").asText();

			CustomerVo customerVo = CustomerManager.findCustomerByName(
					displayName, session(Constants.CLIENT_ACCOUNT_ID));
			CodeVo codeVo = AccountingCodeManager.getCodeById(customerVo
					.getCodeId());
			customerVo.setCodeVo(codeVo);
			if (customerVo != null) {
				result.put("resultdata", Json.toJson(customerVo));
			}
			return ok(result);
		}
		return redirect("/login");
	}

	public static Result validateName() {
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			CustomerVo customerVo = new CustomerVo();
			customerVo.setDisplayName(json.findPath("displayName").asText());
			customerVo.setAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			if (!StringUtils.isEmpty(json.findPath("displayName").asText())) {

				if (CustomerManager.validateUsername(customerVo)) {
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

	public static Result suggestCustomer() {

		if (SessionMaster.validateSession(session())) {
			JsonNode json = request().body().asJson();
			String searchText = json.findPath("search").asText();
			ObjectNode result = Json.newObject();

			List<CustomerVo> customerVoList = CustomerManager.suggestCustomer(
					searchText, session(Constants.CLIENT_ACCOUNT_ID));

			if (customerVoList != null && customerVoList.size() > 0) {
				result.put("resultdata", Json.toJson(customerVoList));
			}

			return ok(result);
		}
		return redirect("/login");
	}

	public static Result add() {

		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {

			Form<CustomerForm> customerForm = new Form<CustomerForm>(
					CustomerForm.class);
			CustomerForm fCustomerForm = customerForm.bindFromRequest().get();

			CustomerVo customerVo = new CustomerVo();
			customerVo.setAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			customerVo.setCreatedBy(session(Constants.ACCOUNT_ID));
			customerVo.setModifiedBy(session(Constants.ACCOUNT_ID));

			if (CustomerManager.add(customerVo, fCustomerForm) != null) {
				result.put("resultdata", Json.toJson(customerVo));
				return ok(result);

			} else {
				result.put("errorMessage", "error");
				return badRequest(result);
			}
		}
		return unauthorized(result);
	}

	public static Result update() {

		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			Form<CustomerForm> customerForm = new Form<CustomerForm>(
					CustomerForm.class);
			CustomerForm fCustomerForm = customerForm.bindFromRequest().get();

			CustomerVo customerVo = new CustomerVo();
			customerVo.setAccountId(session(Constants.CLIENT_ACCOUNT_ID));
			customerVo.setCreatedBy(session(Constants.ACCOUNT_ID));
			customerVo.setModifiedBy(session(Constants.ACCOUNT_ID));

			if (CustomerManager.update(customerVo, fCustomerForm) != null) {
				result.put("resultdata", Json.toJson(customerVo));
				return ok(result);

			} else {
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
			List<CustomerVo> customers = CustomerManager
					.findAllCustomersByAccountId(session(Constants.CLIENT_ACCOUNT_ID));

			if (customers == null) {
				customers = new ArrayList<CustomerVo>();
			}

			return ok(landing.render("yoursite.com", customers));
		}
		return redirect("/login");
	}
}
