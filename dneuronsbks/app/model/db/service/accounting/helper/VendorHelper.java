package model.db.service.accounting.helper;

import java.util.List;

import model.db.bean.accounting.VendorTable;
import controllers.beans.VendorVo;

public class VendorHelper {
	
	public boolean validateUsername(VendorVo vendorVo){
		List<VendorTable> vendorList = (List<VendorTable>)VendorTable.finder.where("lower(displayName) = :displayName and lower(accountId) = :accountId")
				.setParameter("displayName", vendorVo.getDisplayName())
				.setParameter("accountId", vendorVo.getAccountId())
				.findList();
		
		if(vendorList != null && vendorList.size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public List<VendorTable> suggestVendor(String searchText, String accountId){
		List<VendorTable> vendorList = (List<VendorTable>)VendorTable.finder.where("lower(accountId) = :accountId and lower(displayName) LIKE :displayName")
				.setParameter("displayName", "%" + searchText + "%")
				.setParameter("accountId", accountId)
				.findList();
		
		if(vendorList != null && vendorList.size() > 0){
			return vendorList;
		}else{
			return null;
		}
	}
	
	
	public VendorTable addVendor(VendorVo vendorVo){
		VendorTable vendorTable = new VendorTable();
		return vendorTable.create(vendorVo);
	}
	
	
	public VendorTable updateVendor(controllers.beans.VendorVo vendorVo){
		VendorTable vendorTable = new VendorTable();
		return vendorTable.edit(vendorVo);
	}
	
	public List<VendorTable> findAllVendorsByAccountId(String accountId){
		List<VendorTable> vendorList = (List<VendorTable>)VendorTable.finder.where("lower(accountId) = :accountId")
				.setParameter("accountId", accountId)
				.findList();
		
		if(vendorList != null && vendorList.size() > 0){
			return vendorList;
		}else{
			return null;
		}
	}
	
	public VendorTable findVendorByDisplayName(String displayName, String accountId){
		List<VendorTable> vendorList = (List<VendorTable>)VendorTable.finder.where("lower(displayName) = :displayName and lower(accountId) = :accountId")
				.setParameter("displayName", displayName)
				.setParameter("accountId", accountId)
				.findList();
		
		if(vendorList != null && vendorList.size() > 0){
			return vendorList.get(0);
		}else{
			return null;
		}
	}
	

	public VendorTable findVendor(String vendorId, String accountId){
		List<VendorTable> vendorList = (List<VendorTable>)VendorTable.finder.where("lower(vendorId) = :vendorId and lower(accountId) = :accountId")
				.setParameter("vendorId", vendorId)
				.setParameter("accountId", accountId)
				.findList();
		
		if(vendorList != null && vendorList.size() > 0){
			return vendorList.get(0);
		}else{
			return null;
		}
	}
	
	

}
