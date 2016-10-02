package controllers.forms;

import play.data.validation.Constraints.Required;

public class PasswordDetails {
	@Required
    public String username;
	@Required
    public String oldPwd;
	@Required
    public String newPwd;
	@Required
    public String confirmPwd;

}
