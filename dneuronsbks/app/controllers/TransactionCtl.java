package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import model.db.bean.accounting.FileTable;
import model.db.bean.profile.AccountInfo;
import model.db.service.ServicesInstances;
import model.db.service.accounting.AccountingService;
import model.db.service.profile.ProfileService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.node.ObjectNode;

import common.Constants;
import common.SessionMaster;
import controllers.beans.FileVo;
import controllers.beans.TransactionVo;
import controllers.beans.TxMasterVo;
import controllers.beans.VendorVo;
import controllers.forms.CustomerForm;
import controllers.forms.TxMasterForm;
import controllers.forms.VendorForm;
import controllers.managers.TransactionManager;
import controllers.managers.VendorManager;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import static play.libs.Json.toJson;
import views.html.login.*;
import views.html.dashboard.*;

public class TransactionCtl extends Controller {

	public boolean clearSession() {
		return true;
	}

	@Transactional(readOnly = true)
	public static Result getLandingDataOne() {

		String username = session(Constants.ACCOUNT_USER_NAME);
		String accountId = session(Constants.CLIENT_ACCOUNT_ID);
		if (StringUtils.isNotEmpty(username)
				&& StringUtils.isNotEmpty(accountId)) {
			return ok(toJson(TransactionManager.getExpenseTransactions(accountId,username )));
		}
		return ok();
	}
	
	@Transactional(readOnly = true)
	public static Result getLandingDataTwo() {

		String username = session(Constants.ACCOUNT_USER_NAME);
		String accountId = session(Constants.CLIENT_ACCOUNT_ID);
		if (StringUtils.isNotEmpty(username)
				&& StringUtils.isNotEmpty(accountId)) {
			return ok(toJson(TransactionManager.getInvoiceTransactions(accountId,username )));
		}
		return ok();
	}
	
	@Transactional(readOnly = true)
	public static Result getFile(String fileId) {

		String username = session(Constants.ACCOUNT_USER_NAME);
		String accountId = session(Constants.CLIENT_ACCOUNT_ID);

		if (StringUtils.isNotEmpty(username)
				&& StringUtils.isNotEmpty(accountId)) {
			
			FileTable file = getFile(username,accountId,fileId);
			String absoluteFileName = "";
			
			if(file != null)
			{
				absoluteFileName = ControllerUtils.getAbsoluteFileName(file);
			}
			else
			{
				return ok(toJson("failed"));
			}
			
			response().setContentType(file.getFiletype());  
			response().setHeader("Content-disposition","inline; filename=" + absoluteFileName); 
			return ok(new File(absoluteFileName));
		}

		return ok(toJson("failed"));
	}
	
	@Transactional
    public static Result saveExpense() {
		
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			
			Form<TxMasterForm> txMasterForm = new Form<TxMasterForm>(
					TxMasterForm.class);
			TxMasterForm fTxMasterForm = txMasterForm.bindFromRequest().get();
			
			TransactionManager.saveExpenseTransaction(fTxMasterForm, session(Constants.CLIENT_ACCOUNT_ID) , session(Constants.ACCOUNT_USER_NAME));
			
			String username = session(Constants.ACCOUNT_USER_NAME);
			String accountId = session(Constants.CLIENT_ACCOUNT_ID);
			if (StringUtils.isNotEmpty(username)
					&& StringUtils.isNotEmpty(accountId)) {
				return ok(toJson(TransactionManager.getExpenseTransactions(accountId,username )));
			}
			
			return ok();
		}
		return unauthorized(result);
	}
	
	@Transactional
    public static Result saveInvoice() {
		
		ObjectNode result = Json.newObject();
		if (SessionMaster.validateSession(session())) {
			
			Form<TxMasterForm> txMasterForm = new Form<TxMasterForm>(
					TxMasterForm.class);
			TxMasterForm fTxMasterForm = txMasterForm.bindFromRequest().get();
			
			TransactionManager.saveInvoiceTransaction(fTxMasterForm, session(Constants.CLIENT_ACCOUNT_ID) , session(Constants.ACCOUNT_USER_NAME));
			
			String username = session(Constants.ACCOUNT_USER_NAME);
			String accountId = session(Constants.CLIENT_ACCOUNT_ID);
			if (StringUtils.isNotEmpty(username)
					&& StringUtils.isNotEmpty(accountId)) {
				return ok(toJson(TransactionManager.getInvoiceTransactions(accountId,username )));
			}
			
			return ok();
		}
		return unauthorized(result);
	}
	
	
	public static FileTable getFile(String username, String accountId , String fileId) {
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
				.getService();
		
		return accountingService.getFile( username,  accountId,  fileId);
		
	}
	
	public static boolean addFile(FileVo fileVo) {
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
				.getService();
		
		accountingService.addFile(fileVo);
		
		return true;
	}
	
	public static boolean addTransaction(TransactionVo transactionVo) {
		
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
				.getService();
		
		accountingService.addTransaction(transactionVo);
		
		return true;
	}

}
