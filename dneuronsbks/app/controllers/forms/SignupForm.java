package controllers.forms;

import play.data.validation.Constraints.Required;

public class SignupForm {
	
	@Required
    public String username;
	@Required
    public String email;
	@Required
    public String password;
	@Required
    public String phno;
	@Required
    public String packageName;
	@Required
    public String policy;
	

}
