package model.db.service.accounting.helper;

import java.util.List;

import model.db.bean.accounting.CustomerTable;
import controllers.beans.CustomerVo;

public class CustomerHelper {
	
	public boolean validateUsername(CustomerVo customerVo){
		List<CustomerTable> customerList = (List<CustomerTable>)CustomerTable.finder.where("lower(displayName) = :displayName and lower(accountId) = :accountId")
				.setParameter("displayName", customerVo.getDisplayName())
				.setParameter("accountId", customerVo.getAccountId())
				.findList();
		
		if(customerList != null && customerList.size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public List<CustomerTable> suggestCustomer(String searchText, String accountId){
		List<CustomerTable> customerList = (List<CustomerTable>)CustomerTable.finder.where("lower(accountId) = :accountId and lower(displayName) LIKE :displayName")
				.setParameter("displayName", "%" + searchText + "%")
				.setParameter("accountId", accountId)
				.findList();
		
		if(customerList != null && customerList.size() > 0){
			return customerList;
		}else{
			return null;
		}
	}
	
	
	public CustomerTable addCustomer(CustomerVo customerVo){
		CustomerTable customerTable = new CustomerTable();
		return customerTable.create(customerVo);
	}
	
	public CustomerTable updateCustomer(CustomerVo customerVo){
		CustomerTable customerTable = new CustomerTable();
		return customerTable.edit(customerVo);
	}
	
	
	public List<CustomerTable> findAllCustomersByAccountId(String accountId){
		List<CustomerTable> customerList = (List<CustomerTable>)CustomerTable.finder.where("lower(accountId) = :accountId")
				.setParameter("accountId", accountId)
				.findList();
		
		if(customerList != null && customerList.size() > 0){
			return customerList;
		}else{
			return null;
		}
	}
	
	public CustomerTable findCustomerByDisplayName(String displayName, String accountId){
		List<CustomerTable> customerList = (List<CustomerTable>)CustomerTable.finder.where("lower(displayName) = :displayName and lower(accountId) = :accountId")
				.setParameter("displayName", displayName)
				.setParameter("accountId", accountId)
				.findList();
		
		if(customerList != null && customerList.size() > 0){
			return customerList.get(0);
		}else{
			return null;
		}
	}
	

	public CustomerTable findCustomer(String customerId, String accountId){
		List<CustomerTable> customerList = (List<CustomerTable>)CustomerTable.finder.where("lower(customerId) = :customerId and lower(accountId) = :accountId")
				.setParameter("customerId", customerId)
				.setParameter("accountId", accountId)
				.findList();
		
		if(customerList != null && customerList.size() > 0){
			return customerList.get(0);
		}else{
			return null;
		}
	}
	
	

}
