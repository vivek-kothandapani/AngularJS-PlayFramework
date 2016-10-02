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
import java.util.List;
import java.util.Map;

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
import controllers.forms.CustomerForm;
import controllers.managers.FileManager;
import controllers.managers.ReportingManager;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import static play.libs.Json.toJson;
import views.html.login.*;
import views.html.dashboard.*;
import views.html.dashboard.profile.*;

public class FileCtl extends Controller {

	public static Result doIt(String fileClass) {
		if (SessionMaster.validateSession(session())) {
			MultipartFormData body = request().body().asMultipartFormData();
			FilePart picture = body.getFile(Constants.FILE_UPLOAD_FIELD_NAME);
			if (picture != null) {
				String fileName = picture.getFilename();
				File file = picture.getFile();

				FileVo fileVo = new FileVo();
				fileVo.setFilename(fileName);
				fileVo.setFileclass(Constants.FileClass.fromString(fileClass).toString());
				
				ControllerUtils.setFileAttributes(fileVo, session(Constants.CLIENT_ACCOUNT_ID),picture );

				File newFile = new File(fileVo.getInternalFileName());

				Logger.debug("FileName : " + fileVo.getInternalFileName());

				try {
					InputStream isFile = new FileInputStream(file);

					byte[] byteFile = IOUtils.toByteArray(isFile);

					FileUtils.writeByteArrayToFile(newFile, byteFile);

					isFile.close();
				} catch (FileNotFoundException fne) {
					Logger.debug("Error : " + fne.getMessage());
					return status(500, "File not found");
				} catch (IOException ioe) {
					Logger.debug("Error : " + ioe.getMessage());
					return status(500, "IO Exception");
				}

				// Save file to File Table
				addFile(fileVo);
				
				// Save transaction to Transaction table
				TransactionVo transactionVo = new TransactionVo();
				transactionVo.setFileId(fileVo.getFileId());
				transactionVo.setAccountId(fileVo.getAccountId());
				transactionVo.setFilename(fileVo.getFilename());
				transactionVo.setStatus(Constants.TX_STATUS_NEW);
				transactionVo.setTxClass(Constants.FileClass.fromString(fileClass).toString());
				addTransaction(transactionVo);
				
				return ok("File Upoaded");
			} else {
				return status(400, "Missing File");
			}
		}
		return redirect("/login");
	}
	
	
	public static Result getAllFiles() {
		if(SessionMaster.validateSession(session())){
			List<FileVo> fileVoList  = FileManager.getAllFiles(session(Constants.CLIENT_ACCOUNT_ID));
			ObjectNode result = Json.newObject();
			result.put("resultdata", Json.toJson(fileVoList));
			System.out.println(result);
			return ok(result);
		}
		return redirect("/login");
	}
	
	public static Result getReportFiles() {
		if(SessionMaster.validateSession(session())){
			List<FileVo> fileVoList  = FileManager.getReportFiles(session(Constants.CLIENT_ACCOUNT_ID));
			ObjectNode result = Json.newObject();
			result.put("resultdata", Json.toJson(fileVoList));
			System.out.println(result);
			return ok(result);
		}
		return redirect("/login");
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
