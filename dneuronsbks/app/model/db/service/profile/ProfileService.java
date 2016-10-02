package model.db.service.profile;

import java.util.ArrayList;
import java.util.List;

import common.Constants;
import model.db.bean.products.Skus;
import model.db.bean.profile.AccountInfo;
import model.db.service.profile.helper.AddUserHelper;
import model.db.service.profile.helper.CompanyInfoHelper;
import play.Logger;
import play.db.ebean.Model;
import controllers.beans.AddUserVO;
import controllers.beans.CompanyInfoVo;
import controllers.beans.SignupVO;

public class ProfileService {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AccountInfo authenticate(String username, String password) {
		Logger.debug("authenticate - start");
		List<AccountInfo> profiles = (List<AccountInfo>) new Model.Finder(
				"profile", String.class, AccountInfo.class)
				.where("lower(username) = :userName and lower(password) = :passWord")
				.setParameter("userName", username)
				.setParameter("passWord", password).findList();

		if (profiles != null && profiles.size() > 0) {
			Logger.debug("authenticate - has profile");
			return profiles.get(0);
		}
		return null;
	}
	
	public AddUserVO getInitalData(){
		AddUserVO userVo = new AddUserVO();
		List<Skus> skuList = Skus.finder.all();
		List<String> skuNames = new ArrayList<String>();
		List<String> packageNames = new ArrayList<String>();
		for(Skus skus : skuList){
			skuNames.add(skus.getName());
		}
		packageNames.add(Constants.Role.CLIENT.roleName());
		packageNames.add(Constants.Role.BOOKsuper.roleName());
		packageNames.add(Constants.Role.ACCOUNTANT.roleName());
		packageNames.add(Constants.Role.ADMIN.roleName());
		packageNames.add(Constants.Role.ROOT.roleName());
		userVo.setPackages(skuNames);
		userVo.setRoles(packageNames);
		
		return userVo;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public controllers.beans.AccountInfo getAccountInfo(String username, String accountId) {
		Logger.debug("Get Account Info - start");
		
		controllers.beans.AccountInfo cAccountInfo = new controllers.beans.AccountInfo();
		
		
		List<AccountInfo> profiles = (List<AccountInfo>) new Model.Finder(
				"profile", String.class, AccountInfo.class)
				.where("lower(username) = :userName and lower(accountId) = :accountId")
				.setParameter("userName",username)
				.setParameter("accountId",accountId).findList();

		if (profiles != null && profiles.size() > 0) {
			Logger.debug("Profile available");
			model.db.bean.profile.AccountInfo mAccountInfo = profiles.get(0);
			cAccountInfo.setAccountId(mAccountInfo.getAccountId());
			cAccountInfo.setCompanyName(mAccountInfo.getCompanyName());
			cAccountInfo.setStatus(mAccountInfo.getStatus());
			cAccountInfo.setUsername(mAccountInfo.getUsername());
			cAccountInfo.setLastLogin(mAccountInfo.getLastLogin());
			cAccountInfo.setRole(mAccountInfo.getRole());
			return cAccountInfo;
		}
		return null;
	}
	
	public boolean addUser(AddUserVO addUserVo){
		return new AddUserHelper().addUser(addUserVo);
	}
	
	public boolean addOwnUser(SignupVO signUpVo,String host){
		return new AddUserHelper().addOwnUser(signUpVo,host);
	}
	
	public boolean activateUser(String ActivationId,String username){
		return new AddUserHelper().activateUser(ActivationId,username);
	}
	
	public boolean deActivate(String usernameOrId,String reason){
		return new AddUserHelper().deactivateUser(usernameOrId, reason);
	}
	public boolean reActivate(String usernameOrId,String reason){
		return new AddUserHelper().reactivateUser(usernameOrId, reason);
	}
	
	public boolean resetPassword(String usernameOrId){
		return new AddUserHelper().resetPassword(usernameOrId);
	}
	
	public List<AccountInfo> findAllUserById(){
		return AccountInfo.finder.findList();
	}
	
	
	
	public boolean validateUsername(AddUserVO addUserVo){
		System.out.println("inside profiel");
		return new AddUserHelper().validateUsername(addUserVo);
	}

	public boolean setAccountInfo(controllers.beans.CompanyInfoVo companyInfoVo) {

		return addCompanyInfo(companyInfoVo);
	}

	public boolean setMoreAccountInfo(controllers.beans.CompanyInfoVo companyInfoVo) {

		return addMoreCompanyInfo(companyInfoVo);
	}
	
	public boolean acceptTerms(controllers.beans.CompanyInfoVo companyInfoVo) {

		return new CompanyInfoHelper().acceptTerms(companyInfoVo);
	}
	
	public CompanyInfoVo isTermsAccepted(Integer accountId) {

		return new CompanyInfoHelper().isTermsAgreed(accountId);
	}

	public CompanyInfoVo getCompanyInfo(Integer accountId) {

		return new CompanyInfoHelper().getCompanyInfo(accountId);
	}

	public CompanyInfoVo getMoreCompanyInfo(Integer accountId) {

		return new CompanyInfoHelper().getMoreCompanyInfo(accountId);
	}
	


	private boolean addCompanyInfo(
			controllers.beans.CompanyInfoVo companyInfo) {
		Logger.debug("Get Customers - start");

		new CompanyInfoHelper().createCompanyInfo(companyInfo);
		
		/*new model.db.bean.profile.CompanyInfo().create(companyInfo);*/
		return true;
	}
	private boolean addMoreCompanyInfo(
			controllers.beans.CompanyInfoVo companyInfo) {
		Logger.debug("Get Customers - start");

		new CompanyInfoHelper().createMoreCompanyInfo(companyInfo);
		
		/*new model.db.bean.profile.CompanyInfo().create(companyInfo);*/
		return true;
	}
	
	
	
}