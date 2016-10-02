function mainFactory($http) {
	var factory = {};
	factory.getAccountInfo = function (){
		return $http.get('/accountinfo');
	}
	return factory;
}

function pageOneFactory($http) {
	
	var factory = {};
	factory.getFormOneData = function(){
		return $http.get('profile/1');
	}
	factory.submitFormOne = function (formData){
		return  $http.post('profile/submit1', formData);
	}
	return factory;
}

function pageTwoFactory($http) {
	
	var factory = {};
	factory.getFormOneData = function(){
		return $http.get('profile/2');
	}
	factory.submitFormTwo = function (formData){
		return  $http.post('profile/submit2', formData);
	}
	return factory;
}

function pageThreeFactory($http) {
	
	var factory = {};
	factory.getFormOneData = function(){
		return $http.get('profile/3');
	}
	factory.submitFormThree = function (formData){
		return  $http.post('profile/submit3', formData);
	}
	return factory;
}

/* Transaction factory */
function transactionFactory($http) {
	
	var factory = {};
	factory.getLandingData = function(){
		return $http.get('transaction/1/landing');
	}
	factory.saveTransaction = function (formData){
		return  $http.post('transaction/1/save', formData);
	}
	return factory;
}

function transactionTwoFactory($http) {
	
	var factory = {};
	factory.getLandingData = function(){
		return $http.get('transaction/2/landing');
	}
	factory.saveTransaction = function (submitData){
		return  $http.post('transaction/2/save', submitData);
	}
	return factory;
}

function addUserFactory($http) {
	
	var factory = {};
	factory.getInitialData = function(){
		return $http.get('/manageuser/getInitialData');
	}
	factory.addUser = function (formData){
		return  $http.post('/manageuser/submitadduserdata', formData);
	}
	
	factory.validateUser = function (formData){
		return  $http.post('/manageuser/validateusers', formData);
	}
	return factory;
}

function deActivateUserFactory($http){
	var factory = {};
	factory.searchUser = function(formData){
		return  $http.post('/manageuser/searchUser', formData);
	}
	factory.deactivateAccount = function(formData){
		return  $http.post('/manageuser/deactivate', formData);
	}
	return factory;
	
}

function reActivateUserFactory($http){
	var factory = {};
	factory.searchUser = function(formData){
		return  $http.post('/manageuser/searchUser', formData);
	}
	factory.reactivateAccount = function(formData){
		return  $http.post('/manageuser/reactivate', formData);
	}
	return factory;
}

function resetPassword($http){
	var factory = {};
	factory.searchUser = function(formData){
		return  $http.post('/manageuser/searchUser', formData);
	}
	factory.deactivateAccount = function(formData){
		return  $http.post('/manageuser/deactivate', formData);
	}
	factory.reset = function(formData){
		return  $http.post('/manageuser/resetPassword', formData);
	}
	return factory;
	
}

function searchClientFactory($http)
{
	var factory = {};
	factory.searchUser = function(formData){
		return  $http.post('/manageuser/searchUser', formData);
	}
	factory.setClientId = function(formData){
		return  $http.post('/manageuser/set-clientid', formData);
	}
	return factory;
}

/* Account Type codes */
function vendorFactory($http) {
	
	var factory = {};
	factory.getInitData = function(){
		return $http.get('/vendor/init');
	}
	factory.addVendor = function (formData){
		return  $http.post('/vendor/add', formData);
	}
	factory.updateVendor = function (formData){
		return  $http.post('/vendor/edit', formData);
	}
	factory.searchVendor = function (formData){
		return  $http.post('/vendor/search', formData);
	}
	factory.suggestVendorName = function (formData){
		return  $http.post('/vendor/suggest-name', formData);
	}
	factory.validateVendorName = function (formData){
		return  $http.post('/vendor/validate-name', formData);
	}
	factory.getVendorByName = function (displayName){
		return  $http.post('/vendor/getvendor-by-name',  {
		      params: {
		    	  displayName: displayName
			      }});
	}
	factory.getVendors = function (){
		return $http.get('/vendor/view');
	}
	return factory;
}

function customerFactory($http) {
	
	var factory = {};
	factory.getInitData = function(){
		return $http.get('/customer/init');
	}
	factory.addCustomer = function (formData){
		return  $http.post('/customer/add', formData);
	}
	factory.updateCustomer = function (formData){
		return  $http.post('/customer/edit', formData);
	}
	factory.searchCustomer = function (formData){
		return  $http.post('/customer/search', formData);
	}
	factory.suggestCustomerName = function (formData){
		return  $http.post('/customer/suggest-name', formData);
	}
	factory.validateCustomerName = function (formData){
		return  $http.post('/customer/validate-name', formData);
	}
	factory.getCustomerByName = function (displayName){
		return  $http.post('/customer/getcustomer-by-name',  {
		      params: {
		    	  displayName: displayName
			      }});
	}
	return factory;
}

function bankFactory($http) {
	
	var factory = {};
	factory.getInitData = function(){
		return $http.get('/bank/init');
	}
	factory.addBank = function (formData){
		return  $http.post('/bank/add', formData);
	}
	factory.searchBank = function (formData){
		return  $http.post('/bank/search', formData);
	}
	factory.suggestBankName = function (formData){
		return  $http.post('/bank/suggest-name', formData);
	}
	factory.validateBankName = function (formData){
		return  $http.post('/bank/validate-name', formData);
	}
	factory.getBankByName = function (displayName){
		return  $http.post('/bank/getbank-by-name',  {
		      params: {
		    	  displayName: displayName
			      }});
	}
	return factory;
}

function employeeFactory($http) {
	
	var factory = {};
	factory.getInitData = function(){
		return $http.get('/employee/init');
	}
	factory.addEmployee = function (formData){
		return  $http.post('/employee/add', formData);
	}
	factory.searchEmployee = function (formData){
		return  $http.post('/employee/search', formData);
	}
	factory.suggestEmployeeName = function (formData){
		return  $http.post('/employee/suggest-name', formData);
	}
	factory.validateEmployeeName = function (formData){
		return  $http.post('/employee/validate-name', formData);
	}
	factory.getEmployeeByName = function (displayName){
		return  $http.post('/employee/getemployee-by-name',  {
		      params: {
		    	  displayName: displayName
			      }});
	}
	return factory;
}

/* Accounting Code Factory */
function accountingCodeFactory($http) {
	
	var factory = {};
	factory.getInitialData = function(){
		return $http.get('/code/init');
	}
	return factory;
}

function reportingFactory($http){
	var factory = {};
	factory.getBalanceSheet = function(){
		return $http.get('/reporting/balancesheet');
	}
	
	factory.getIncomeStatement = function(){
		return $http.get('/reporting/income-statement');
	}
	return factory;
}

function fileFactory($http) {
	var factory = {};
	factory.getAllFiles = function(){
		return $http.get('/file/all-files');
	}
	factory.getReportFiles = function (){
		return  $http.get('/file/report-files');
	}
	return factory;
}


function taxRuleFactory($http) {
	var factory = {};
	factory.getAllRules = function(){
		return $http.get('/taxrule/all-rules');
	}
	factory.suggestTaxRule = function (formData){
		return  $http.post('/taxrule/suggest-rule', formData);
	}
	
	return factory;
}

angular
    .module('yoursite')
    .factory('mainFactory', mainFactory)
    .factory('oneFactory',pageOneFactory)
    .factory('twoFactory',pageTwoFactory)
    .factory('threeFactory',pageThreeFactory)
    .factory('transactionFactory',transactionFactory)
    .factory('addUserFactory',addUserFactory)
    .factory('deActivateUserFactory',deActivateUserFactory)
    .factory('resetPassword',resetPassword)
    .factory('vendorFactory',vendorFactory)
    .factory('customerFactory',customerFactory)
    .factory('bankFactory',bankFactory)
    .factory('employeeFactory',employeeFactory)
    .factory('accountingCodeFactory',accountingCodeFactory)
    .factory('reportingFactory',reportingFactory)
    .factory('reActivateUserFactory',reActivateUserFactory)
    .factory('searchClientFactory',searchClientFactory)  
    .factory('transactionTwoFactory',transactionTwoFactory)
    .factory('fileFactory',fileFactory)
    .factory('taxRuleFactory',taxRuleFactory)