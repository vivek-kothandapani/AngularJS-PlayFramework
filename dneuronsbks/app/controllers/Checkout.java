package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.checkout.*;
public class Checkout extends Controller {

    public static Result review() {
    	return ok(review.render("yoursite.com"));
    }
    
    public static Result terms() {
    	return ok(terms.render("yoursite.com"));
    }
    
    public static Result businfo() {
    	return ok(businfo.render("yoursite.com"));
    }
    
    public static Result billing() {
    	return ok(billing.render("yoursite.com"));
    }
    
    public static Result payment() {
    	return ok(payment.render("yoursite.com"));
    }
    
    public static Result complete() {
    	return ok(complete.render("yoursite.com"));
    }
	
}
