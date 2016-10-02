package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.ExcelManager;

import com.fasterxml.jackson.databind.node.ObjectNode;

import common.Constants;
import common.SessionMaster;
import controllers.beans.reports.BalanceSheetVo;
import controllers.managers.ReportingManager;

public class Reporting extends Controller{
	
	public static Result getBalanceSheet() {
		if(SessionMaster.validateSession(session())){
		//Map<String, Map<String, Map<String, String>>> balanceSheet  = ReportingManager.getBalanceSheet(session(Constants.CLIENT_ACCOUNT_ID));
		
		BalanceSheetVo balanceSheetVo  = ReportingManager.getBalanceSheetVo(session(Constants.CLIENT_ACCOUNT_ID));
		ObjectNode result = Json.newObject();
		result.put("data", Json.toJson(balanceSheetVo));
		System.out.println(result);
		return ok(result);
		}
		return redirect("/login");
	}
	
	
	public static Result getIncomeStatement() {
		if(SessionMaster.validateSession(session())){
			Map<String, Map<String, Map<String, String>>> balanceSheet  = ReportingManager.getIncomeStatement(session(Constants.CLIENT_ACCOUNT_ID));
			ObjectNode result = Json.newObject();
			result.put("data", Json.toJson(balanceSheet));
			System.out.println(result);
			return ok(result);
		}
		return redirect("/login");
	}
	
	
	public static Result getSummaryReport() {
		if(SessionMaster.validateSession(session())){
			Map<String, Map<String, Map<String, String>>> balanceSheet  = ReportingManager.getIncomeStatement(session(Constants.CLIENT_ACCOUNT_ID));
			ObjectNode result = Json.newObject();
			result.put("data", Json.toJson(balanceSheet));
			System.out.println(result);
			return ok(result);
		}
		return redirect("/login");
	}
	
	public static Result save() throws IOException {
		System.out.println("fsdfs");
		Map<String, Map<String, Map<String, String>>> balanceSheet = ReportingManager
				.getBalanceSheet(session(Constants.CLIENT_ACCOUNT_ID));
		ExcelManager excelmanager = new ExcelManager();
		XSSFWorkbook workbook = excelmanager.createExcel("datasheet",
				balanceSheet);
		File file = new File("balancesheet.xlsx");
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		out.close();
		response().setContentType("application/x-download");
		response().setHeader("Content-disposition", "attachment; filename=balancesheet.xlsx");
		return ok(file);
	}

}
