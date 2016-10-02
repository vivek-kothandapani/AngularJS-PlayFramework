package controllers.managers;

import java.util.List;

import model.db.bean.profile.AccountInfo;
import model.db.service.ServicesInstances;
import model.db.service.profile.ProfileService;
import controllers.beans.AddUserVO;
import controllers.beans.SignupVO;

public class ManageUserManager {
	
	public static boolean addUser(AddUserVO adddUserVO)
	{
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
   		if(adddUserVO != null){
   			return profileService.addUser(adddUserVO);
   		}
		return false;
	}
	
	public static boolean addOwnUser(SignupVO signupVo,String host)
	{
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
   		if(signupVo != null){
   			return profileService.addOwnUser(signupVo,host);
   		}
		return false;
	}
	
	public static boolean activateUser(String ActivationId,String username)
	{
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
   		if(ActivationId != null && username != null){
   			return profileService.activateUser(ActivationId,username);
   		}
		return false;
	}
	
	public static boolean deActivate(String userIdOrName,String reason)
	{
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
   		if(userIdOrName != null){
   			return profileService.deActivate(userIdOrName, reason);
   		}
		return false;
	}
	
	public static boolean reActivate(String userIdOrName,String reason)
	{
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
   		if(userIdOrName != null){
   			return profileService.reActivate(userIdOrName, reason);
   		}
		return false;
	}
	
	public static boolean resetPassword(String userIdOrName)
	{
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
   		if(userIdOrName != null){
   			return profileService.resetPassword(userIdOrName);
   		}
		return false;
	}
	
	public static List<AccountInfo> findAllUsersById()
	{
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
   			return profileService.findAllUserById();
	}
	
	public static boolean validateUsername(AddUserVO adddUserVO)
	{
   		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
   		if(adddUserVO != null){
   			return profileService.validateUsername(adddUserVO);
   		}
		return false;
	}
	
	public static AddUserVO getInitialData(){
		ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
		return profileService.getInitalData();
	}

}
