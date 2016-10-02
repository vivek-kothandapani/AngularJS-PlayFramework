package common;

import org.apache.commons.lang3.StringUtils;

import play.mvc.Http.Session;

public class SessionMaster {

	public static boolean validateSession(Session session) {
		String username = session.get(Constants.ACCOUNT_USER_NAME);
		String accountId = session.get(Constants.ACCOUNT_ID);
		String clientAccountId = session.get(Constants.CLIENT_ACCOUNT_ID);
		
		return StringUtils.isNotEmpty(username)
				&& StringUtils.isNotEmpty(accountId) && StringUtils.isNotEmpty(clientAccountId);
	}
	
	public static boolean clearSession(Session session) {
		session.clear();
		return true;
	}
}
