package controllers.managers;

import java.util.ArrayList;
import java.util.List;

import model.db.bean.accounting.FileTable;
import model.db.service.ServicesInstances;
import model.db.service.accounting.AccountingService;
import controllers.beans.FileVo;

public class FileManager {
	
	public static List<FileVo> getAllFiles(String accountId){
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
				.getService();
		 
		 List<FileTable> fileTableList = accountingService.findAllFiles(accountId);
		 List<FileVo> fileVoList = new ArrayList<FileVo>();
		 
		 if(fileTableList != null)
		 {
			 for(FileTable fileTable : fileTableList)
			 {
				 FileVo fileVo = new FileVo();
				 fileVo.setFileId(fileTable.getFileId());
				 fileVo.setFilename(fileTable.getFilename());
				 fileVo.setFileclass(fileTable.getFileclass());
				 fileVo.setDay(fileTable.getDay());
				 fileVo.setMonth(fileTable.getMonth());
				 fileVo.setYear(fileTable.getYear());
				 fileVoList.add(fileVo);
			 }
		 }
		 
		 return fileVoList;
	}
	
	public static List<FileVo> getReportFiles(String accountId){
		AccountingService accountingService = (AccountingService) ServicesInstances.ACCOUNTING_SERVICE
				.getService();
		 List<FileTable> fileTableList = accountingService.findReportFiles(accountId);
		 List<FileVo> fileVoList = new ArrayList<FileVo>();
		 
		 if(fileTableList != null)
		 {
			 for(FileTable fileTable : fileTableList)
			 {
				 FileVo fileVo = new FileVo();
				 fileVo.setFileId(fileTable.getFileId());
				 fileVo.setFilename(fileTable.getFilename());
				 fileVo.setFileclass(fileTable.getFileclass());
				 fileVo.setDay(fileTable.getDay());
				 fileVo.setMonth(fileTable.getMonth());
				 fileVo.setYear(fileTable.getYear());
				 fileVoList.add(fileVo);
			 }
		 }
		 
		 return fileVoList;
	}
}
