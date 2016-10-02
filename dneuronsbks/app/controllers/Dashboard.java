package controllers;

import model.db.bean.profile.AccountInfo;
import model.db.service.ServicesInstances;
import model.db.service.profile.ProfileService;

import org.apache.commons.lang3.StringUtils;

import common.Constants;

import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import static play.libs.Json.toJson;
import views.html.login.*;
import views.html.dashboard.*;
import views.html.dashboard.common.*;
import views.html.dashboard.common.one.*;
import views.html.dashboard.common.two.*;
import views.html.dashboard.common.three.*;
import views.html.dashboard.common.four.*;

public class Dashboard extends Controller {

	@Transactional(readOnly = true)
	public static Result accountInfo() {

		String username = session(Constants.ACCOUNT_USER_NAME);
		String accountClientId = session(Constants.CLIENT_ACCOUNT_ID);
		String accountId = session(Constants.ACCOUNT_ID);
		controllers.beans.AccountInfo account = new controllers.beans.AccountInfo();

		if (StringUtils.isNotEmpty(username)
				&& StringUtils.isNotEmpty(accountId) && StringUtils.isNotEmpty(accountClientId)) {
			ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE
					.getService();
			account = profileService.getAccountInfo(username, accountId);

			if (account != null) {
				Logger.debug("Login: success");
				return ok(toJson(account));
			}
		}

		return ok(toJson(account));
	}

	@Transactional(readOnly = true)
	public static Result getNavgiationHtml() {

		String username = session(Constants.ACCOUNT_USER_NAME);
		String accountClientId = session(Constants.CLIENT_ACCOUNT_ID);
		String accountId = session(Constants.ACCOUNT_ID);
		controllers.beans.AccountInfo account = new controllers.beans.AccountInfo();

		if (StringUtils.isNotEmpty(username)
				&& StringUtils.isNotEmpty(accountId) && StringUtils.isNotEmpty(accountClientId)) {
			ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE
					.getService();
			account = profileService.getAccountInfo(username, accountId);

			if (account != null) {
				
				if (account.getRole().equalsIgnoreCase(Constants.Role.CLIENT.roleName())) {
					
					if(accountClientId.equalsIgnoreCase(accountId))
					{
						return ok(views.html.dashboard.common.navigation.render("yoursite.com",
								account));
					}
					else
					{
						session().clear();
						return redirect("/login");
					}
				}
				else if (account.getRole().equalsIgnoreCase(Constants.Role.BOOKsuper.roleName())) {
					return ok(views.html.dashboard.common.one.navigation.render("yoursite.com",
							account));
				}
				else if (account.getRole().equalsIgnoreCase(Constants.Role.ACCOUNTANT.roleName())) {
					return ok(views.html.dashboard.common.two.navigation.render("yoursite.com",
							account));
				}
				else if (account.getRole().equalsIgnoreCase(Constants.Role.ADMIN.roleName())) {
					return ok(views.html.dashboard.common.three.navigation.render("yoursite.com",
							account));
				}
				else if (account.getRole().equalsIgnoreCase(Constants.Role.ROOT.roleName())) {
					return ok(views.html.dashboard.common.four.navigation.render("yoursite.com",
							account));
				}
			} else {
				session().clear();
				return redirect("/login");
			}
		}

		return redirect("/login");
	}

	@Transactional(readOnly = true)
	public static Result getTopnavbarHtml() {

		String username = session(Constants.ACCOUNT_USER_NAME);
		String accountClientId = session(Constants.CLIENT_ACCOUNT_ID);
		String accountId = session(Constants.ACCOUNT_ID);
		controllers.beans.AccountInfo account = new controllers.beans.AccountInfo();

		if (StringUtils.isNotEmpty(username)
				&& StringUtils.isNotEmpty(accountId) && StringUtils.isNotEmpty(accountClientId) ) {
			ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE
					.getService();
			account = profileService.getAccountInfo(username, accountId);

			Boolean sameAccountIds = true;
			if(!accountClientId.equalsIgnoreCase(accountId))
			{
				sameAccountIds = false;
			}
			
			if (account != null) {
				
				if (account.getRole().equalsIgnoreCase(Constants.CLIENT)) {
					
					if(sameAccountIds)
					{
						return ok(views.html.dashboard.common.topnavbar.render("yoursite.com",
								account,true,""));
					}
					else
					{
						session().clear();
						return redirect("/login");
					}
				}
				else if (account.getRole().equalsIgnoreCase(Constants.Bsuper)) {
					return ok(views.html.dashboard.common.one.topnavbar.render("yoursite.com",
							account,sameAccountIds, accountClientId ));
				}
				else if (account.getRole().equalsIgnoreCase(Constants.BSUPER)) {
					return ok(views.html.dashboard.common.two.topnavbar.render("yoursite.com",
							account,sameAccountIds, accountClientId));
				}
				else if (account.getRole().equalsIgnoreCase(Constants.BADMIN)) {
					return ok(views.html.dashboard.common.three.topnavbar.render("yoursite.com",
							account,sameAccountIds, accountClientId));
				}
				else if (account.getRole().equalsIgnoreCase(Constants.ROOT)) {
					return ok(views.html.dashboard.common.four.topnavbar.render("yoursite.com",
							account,sameAccountIds, accountClientId));
				}
			} else {
				session().clear();
				return redirect("/login");
			}
		}

		return redirect("/login");
	}

	@Transactional(readOnly = true)
	public static Result getDashboardZero() {

		String username = session(Constants.ACCOUNT_USER_NAME);
		String accountClientId = session(Constants.CLIENT_ACCOUNT_ID);
		String accountId = session(Constants.ACCOUNT_ID);
		controllers.beans.AccountInfo account = new controllers.beans.AccountInfo();

		if (StringUtils.isNotEmpty(username)
				&& StringUtils.isNotEmpty(accountId) && StringUtils.isNotEmpty(accountClientId)) {
			ProfileService profileService = (ProfileService) ServicesInstances.PROFILE_SERVICE
					.getService();
			account = profileService.getAccountInfo(username, accountId);

			if (account != null) {
				if (account.getRole().equalsIgnoreCase(Constants.CLIENT)) {
					if(accountClientId.equalsIgnoreCase(accountId))
					{
						return ok(dashboardzero.render("yoursite.com",
								account));
					}
					else
					{
						session().clear();
						return redirect("/login");
					}
				}
				else if (account.getRole().equalsIgnoreCase(Constants.Bsuper)) {
					return ok(dashboardone.render("yoursite.com",
							account));
				}
				else if (account.getRole().equalsIgnoreCase(Constants.BSUPER)) {
					return ok(dashboardtwo.render("yoursite.com",
							account));
				}
				else if (account.getRole().equalsIgnoreCase(Constants.BADMIN)) {
					return ok(dashboardthree.render("yoursite.com",
							account));
				}
				else if (account.getRole().equalsIgnoreCase(Constants.ROOT)) {
					return ok(dashboardfour.render("yoursite.com",
							account));
				}
			} else {
				session().clear();
				return redirect("/login");
			}
		}

		return redirect("/login");
	}
}
