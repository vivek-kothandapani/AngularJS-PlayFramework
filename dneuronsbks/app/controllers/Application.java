package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import common.Constants;
import controllers.beans.AddUserVO;
import controllers.forms.PasswordDetails;
import controllers.forms.User;
import controllers.managers.ManageUserManager;
import model.db.bean.products.Skus;
import model.db.bean.profile.AccountInfo;
import model.db.service.ServicesInstances;
import model.db.service.catalog.CatalogService;
import model.db.service.profile.ProfileService;
import play.Logger;
import play.cache.Cached;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import views.html.shop.*;
import views.html.login.*;
import views.html.register.*;
import views.html.dashboard.*;
import views.html.dashboard.test.*;
public class Application extends Controller {

	@Cached(key = "home.page")
    public static Result index() {
    	return ok(index.render("yoursite.com"));
    }
	
    public static Result activation() {
    	return ok(activationlink.render());
    }
    
   @Cached(key = "package.page")
   @Transactional(readOnly=true)
   public static Result packages() {
	   CatalogService catalogService = (CatalogService) ServicesInstances.CATALOG_SERVICE.getService();
	   List<Skus> products = catalogService.getActiveProducts();		
	   return ok(packages.render("yoursite.com", products));
    }
   
   @Cached(key = "register.page")
  public static Result register() {
	   List<String> packages = ManageUserManager.getInitialData().getPackages();
	   return ok(register.render(packages));
    }
   
   @Cached(key = "terms.page")
   public static Result terms() {
 	   return ok(terms.render());
     }
	
   @Cached(key = "login.page")
   public static Result login() {
   	return ok(loginpage.render("yoursite.com","",""));
   }
   
	public static Result forgotpassword() {
		return ok(forgotpassword.render());
	}
   
   public static Result tdash() {
	   	return ok(d.render("yoursite.com"));
	   }
   
   public static Result logout() {
	    session().clear();
	   	return ok(loginpage.render("yoursite.com","",""));
   }
   
   public static Result office() {
	    Logger.debug("Office : 1");
	    String user = session(Constants.ACCOUNT_USER_NAME);
	    if(StringUtils.isNotEmpty(user))
	    {
	    	 Logger.debug("Office : 2");
	    	 return ok(office.render("yoursite.com"));
	    }
	    else
	    {
	    	Logger.debug("Office : 3");
	    	session().clear();
	    	return ok(loginpage.render("yoursite.com","",""));
	    }
  }
   
   @Transactional(readOnly=true)
   public static Result loginSubmit() {
	   
	   Form<User> userForm = new Form<User>(User.class);
	   User user = userForm.bindFromRequest().get();
	   
	   Logger.debug("Username:" + user.username);
	   //Logger.debug("Password:" + user.password);
	   
	   boolean login = false;
	   boolean isDeactivated = true;
	   boolean isValid = false;
	   AccountInfo account = new AccountInfo();
	   
	   if(StringUtils.isNotEmpty(user.username) && StringUtils.isNotEmpty(user.password))
	   {
		   String hashedPassword = ControllerUtils.hashPassword(user.username,user.password);
		  Logger.debug("Password:" + hashedPassword);
		   ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
		   account = profileService.authenticate(user.username, hashedPassword);		
		   
		   if( account != null &&( account.getTempPass() == null ||
				   account.getTempPass().equalsIgnoreCase("false") ) &&
				   	!account.getStatus().equalsIgnoreCase("Deactivated"))
		   {
			   Logger.debug("Login: success");
			   login = true;
		   }
		   if( account != null && account.getTempPass() != null &&
				   account.getTempPass().equalsIgnoreCase("true")){
			   return ok(changepassword.render());
		   }
		   if( account == null)
		   {
			   isValid = true;
			   isDeactivated = false;
		   }
		   if( account != null && account.getStatus().equalsIgnoreCase("Deactivated"))
		   {
			   isValid = false;
			   isDeactivated = true;
		   }
	   }
	  
	   if(login)
	   {
		   session(Constants.ACCOUNT_USER_NAME, user.username);
		   session(Constants.ACCOUNT_ID, account.getAccountId());
		   session(Constants.CLIENT_ACCOUNT_ID , account.getAccountId());
		   return redirect("/office");
	   } else
	   {
		   return ok(loginpage.render("yoursite.com",String.valueOf(isValid),String.valueOf(isDeactivated)));
	   }
	   
   }
	
	public static Result changePassword(){
		Form<PasswordDetails> userForm = new Form<PasswordDetails>(PasswordDetails.class);
		PasswordDetails user = userForm.bindFromRequest().get();
		if(user.newPwd.equals(user.confirmPwd)){
			 String hashedPassword = ControllerUtils.hashPassword(user.username,user.oldPwd);
			  Logger.debug("Password:" + hashedPassword);
			   ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE.getService();
			   AccountInfo account = new AccountInfo();
			   account = profileService.authenticate(user.username, hashedPassword);
			   if(account != null){
				   hashedPassword = ControllerUtils.hashPassword(user.username,user.newPwd);
				   account.setPassword(hashedPassword);
				   account.setTempPass("false");
				   account.setStatus("Reactivated");
				   account.save("profile");
				   session(Constants.ACCOUNT_USER_NAME, user.username);
				   session(Constants.ACCOUNT_ID, account.getAccountId());
				   session(Constants.CLIENT_ACCOUNT_ID , account.getAccountId());
				   return redirect("/office");
			   }
		}
		
		return redirect("/login");
	}
   
}
