package controllers.managers;

import model.db.service.ServicesInstances;
import model.db.service.profile.ProfileService;
import controllers.beans.CompanyInfoVo;

public class ProfileManager {
	
	public static controllers.beans.CompanyInfoVo getCompanyInfo(String accountId)
	{
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
   		CompanyInfoVo companyInfo = null;
   		if(accountId != null){
   			companyInfo = profileService.getCompanyInfo(Integer.parseInt(accountId));
   		}
		return companyInfo;
	}
	
	public static controllers.beans.CompanyInfoVo getMoreCompanyInfo(String accountId)
	{
		if(accountId == null){
			return new CompanyInfoVo();
		}
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
		CompanyInfoVo companyInfo = profileService.getMoreCompanyInfo(Integer.parseInt(accountId));
		return companyInfo;
	}
	
	public static boolean setCompanyInfo(controllers.beans.CompanyInfoVo companyInfoVo,String accountId)
	{
		if(accountId == null){
			return false;
		}
   		companyInfoVo.setAccountId(Integer.parseInt(accountId));
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
		return profileService.setAccountInfo(companyInfoVo);
	}

	
	public static boolean setMoreCompanyInfo(controllers.beans.CompanyInfoVo companyInfoVo,String accountId)
	{
		if(accountId == null){
			return false;
		}
   		companyInfoVo.setAccountId(Integer.parseInt(accountId));
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
		return profileService.setMoreAccountInfo(companyInfoVo);
	}
	
	public static boolean acceptTerms(controllers.beans.CompanyInfoVo companyInfoVo,String accountId)
	{
		if(accountId == null){
			return false;
		}
   		companyInfoVo.setAccountId(Integer.parseInt(accountId));
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
		return profileService.acceptTerms(companyInfoVo);
	}
	
	public static controllers.beans.CompanyInfoVo isTermsAccepted(String accountId)
	{
		if(accountId == null){
			return null;
		}
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
		return profileService.isTermsAccepted(Integer.parseInt(accountId));
	}
	
	public static controllers.beans.AccountInfo getAccount(String username, String accountId)
	{
   		controllers.beans.AccountInfo account = new controllers.beans.AccountInfo();
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
		account = profileService.getAccountInfo(username, accountId);	
		return account;
	}

}
