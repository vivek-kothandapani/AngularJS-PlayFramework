package controllers.forms;

import play.data.validation.Constraints.Required;

public class User {
	@Required
    public String username;
	@Required
    public String password;
}
