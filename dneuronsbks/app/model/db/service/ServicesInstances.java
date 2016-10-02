package model.db.service;

import model.db.service.accounting.AccountingService;
import model.db.service.catalog.CatalogService;
import model.db.service.profile.ProfileService;
import model.db.service.reporting.ReportingServices;

public enum ServicesInstances {

	CATALOG_SERVICE(new CatalogService()),
	PROFILE_SERVICE(new ProfileService()),
	ACCOUNTING_SERVICE(new AccountingService()),
	REPORTING_SERVICE(new ReportingServices());
	
	private Object service;
	
	private ServicesInstances(Object service) {
		this.service = service;
	}
	
	public Object getService() {
		return this.service;
	}
	
}