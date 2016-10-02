package controllers.forms;

import play.data.validation.Constraints.Required;

public class ActivationForm {
	
	@Required
    public String username;
	@Required
    public String activationId;
}
