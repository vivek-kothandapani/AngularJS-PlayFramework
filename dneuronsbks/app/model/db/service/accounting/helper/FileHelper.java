package model.db.service.accounting.helper;

import java.util.List;

import model.db.bean.accounting.FileTable;
import controllers.beans.FileVo;

public class FileHelper {
	
	public FileVo addFile(FileVo fileVo) {
		FileTable  fileTable = new FileTable().create(fileVo);
		fileVo.setFileId(fileTable.getFileId());
		return fileVo;
	}
	
	public FileTable getFile(String username, String accountId, String fileId) {
		//Get Transactions in New Status
		List<FileTable> files = (List<FileTable>) FileTable.finder.where("lower(accountId) = :accountId and lower(fileId) = :fileId")
						.setParameter("accountId",accountId)
						.setParameter("fileId",fileId).findList();
		
		FileTable fileTable = null;
		if (!files.isEmpty())
		{
			fileTable = files.get(0);
		}
		return fileTable;
	}
	
	public List<FileTable> findAllFiles(String accountId) {
		List<FileTable> fileTableList = (List<FileTable>) FileTable.finder.where("lower(accountId) = :accountId")
						.setParameter("accountId",accountId).findList();
		
		return fileTableList;
	}
	
	public List<FileTable> findReportFiles(String accountId) {
		List<FileTable> fileTableList = (List<FileTable>) FileTable.finder.where("lower(accountId) = :accountId and lower(fileClass) = :fileClass")
						.setParameter("accountId",accountId)
						.setParameter("fileClass","REPORT").findList();
		return fileTableList;
	}
}
