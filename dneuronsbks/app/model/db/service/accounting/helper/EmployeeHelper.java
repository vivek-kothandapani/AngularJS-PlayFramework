package model.db.service.accounting.helper;

import java.util.List;

import model.db.bean.accounting.EmployeeTable;
import controllers.beans.EmployeeVo;

public class EmployeeHelper {
	
	public boolean validateUsername(EmployeeVo employeeVo){
		List<EmployeeTable> employeeList = (List<EmployeeTable>)EmployeeTable.finder.where("lower(displayName) = :displayName and lower(accountId) = :accountId")
				.setParameter("displayName", employeeVo.getDisplayName())
				.setParameter("accountId", employeeVo.getAccountId())
				.findList();
		
		if(employeeList != null && employeeList.size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public List<EmployeeTable> suggestEmployee(String searchText, String accountId){
		List<EmployeeTable> employeeList = (List<EmployeeTable>)EmployeeTable.finder.where("lower(accountId) = :accountId and lower(displayName) LIKE :displayName")
				.setParameter("displayName", "%" + searchText + "%")
				.setParameter("accountId", accountId)
				.findList();
		
		if(employeeList != null && employeeList.size() > 0){
			return employeeList;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EmployeeTable addEmployee(EmployeeVo employeeVo){
		EmployeeTable employeeTable = new EmployeeTable();
		return employeeTable.create(employeeVo);
	}
	
	public List<EmployeeTable> findAllEmployeesByAccountId(String accountId){
		List<EmployeeTable> employeeList = (List<EmployeeTable>)EmployeeTable.finder.where("lower(accountId) = :accountId")
				.setParameter("accountId", accountId)
				.findList();
		
		if(employeeList != null && employeeList.size() > 0){
			return employeeList;
		}else{
			return null;
		}
	}
	
	public EmployeeTable findEmployeeByDisplayName(String displayName, String accountId){
		List<EmployeeTable> employeeList = (List<EmployeeTable>)EmployeeTable.finder.where("lower(displayName) = :displayName and lower(accountId) = :accountId")
				.setParameter("displayName", displayName)
				.setParameter("accountId", accountId)
				.findList();
		
		if(employeeList != null && employeeList.size() > 0){
			return employeeList.get(0);
		}else{
			return null;
		}
	}
	

	public EmployeeTable findEmployee(String employeeId, String accountId){
		List<EmployeeTable> employeeList = (List<EmployeeTable>)EmployeeTable.finder.where("lower(employeeId) = :employeeId and lower(accountId) = :accountId")
				.setParameter("employeeId", employeeId)
				.setParameter("accountId", accountId)
				.findList();
		
		if(employeeList != null && employeeList.size() > 0){
			return employeeList.get(0);
		}else{
			return null;
		}
	}
	
	

}
