/**
 * Copyright 2015 yoursite
 *
 * yoursite theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
    $urlRouterProvider.otherwise("/dashboard/0");

    $ocLazyLoadProvider.config({
        // Set to true if you want to see what and when is dynamically loaded
        debug: false
    });
    
    

    $stateProvider
        .state('dashboard', {
            abstract: true,
            url: "/dashboard",
            templateUrl: "assets/dashboard/views/common/content.html",
        })
        
          .state('register', {
            abstract: true,
            url: "/dashboard",
            templateUrl: "assets/dashboard/views/common/content.html",
        })
        .state('dashboard.0', {
            url: "/0",
            controller : dashboardController,
            templateUrl: "dashboard/0",
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'cgNotify',
                            files: ['assets/dashboard/css/plugins/angular-notify/angular-notify.min.css','assets/dashboard/js/plugins/angular-notify/angular-notify.min.js']
                        }
                    ]);
                }
            }
        })
        .state('profile', {
            abstract: true,
            url: "/profile",
            templateUrl: "assets/dashboard/views/common/content.html",
        })
        .state('profile.landing', {
            url: "/landing",
            templateUrl: "profile/landing",
            controller: wizardCtrl,
            data: { pageTitle: 'Profile Update' },
            resolve: {	
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                        	
                            files: ['assets/dashboard/css/plugins/steps/jquery.steps.css']
                        },
                        {
                            files: ['assets/dashboard/js/plugins/jasny/jasny-bootstrap.min.js']
                        }
                    ]);
                }
            }
        })
        .state('profile.landing.step_one', {
            url: '/1',
            templateUrl: 'assets/dashboard/views/profile/one.html',
            controller: stepOneHandler,
            data: { pageTitle: 'Step One' }
        })
        .state('profile.landing.step_two', {
            url: '/2',
            templateUrl: 'assets/dashboard/views/profile/two.html',
            controller: stepTwoHandler,
            data: { pageTitle: 'Step Two' }
        })
        .state('profile.landing.step_three', {
            url: '/3',
            templateUrl: 'assets/dashboard/views/profile/three.html',
            controller: stepThreeHandler,
            data: { pageTitle: 'Step Three' }
        })
        .state('files', {
            reload: true,
            cache: false, //required
            url: "/files",
            templateUrl: "assets/dashboard/views/common/content.html",
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                        	 name: 'angularFileUpload',
                             files: ['assets/dashboard/js/plugins/angular-file-upload/angular-file-upload.min.js']
                        }
                    ]);
                }
            }
        })
        .state('files.1', {
            url: "/upload",
            cache: false, //required
            templateUrl: "assets/dashboard/views/files/file_upload.html",
            data: { pageTitle: 'File Upload' }            
        })
        .state('files.2', {
            url: "/2",
            cache: false, //required
            templateUrl: "assets/dashboard/views/files/all_files.html",
            data: { pageTitle: 'File Upload' }            
        })
         .state('files.3', {
            url: "/3",
            cache: false, //required
            templateUrl: "assets/dashboard/views/files/report_files.html",
            data: { pageTitle: 'File Upload' }            
        })
        .state('customer', {
            abstract: true,
            url: "/customer",
            templateUrl: "assets/dashboard/views/common/content.html",
        })
        .state('customer.landing', {
            url: "/customer",
            templateUrl: "customer/landing",
            data: { pageTitle: 'Customer' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/css/plugins/iCheck/custom.css','assets/dashboard/js/plugins/iCheck/icheck.min.js']
                        },
                        {
                            name: 'ngSanitize',
                            files: ['assets/dashboard/js/angular/angular-sanitize.min.js']
                        },
                        {
                            name: 'ui.select',
                            files: ['assets/dashboard/css/plugins/ui-select/select.css','assets/dashboard/css/plugins/ui-select/select2.css','assets/dashboard/js/plugins/ui-select/select.js']
                        }
                    ]);
                }
            }
        })
        .state('bank', {
            abstract: true,
            url: "/bank",
            templateUrl: "assets/dashboard/views/common/content.html",
        })
        .state('bank.landing', {
            url: "/bannk",
            templateUrl: "bank/landing",
            data: { pageTitle: 'Banks' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/css/plugins/iCheck/custom.css','assets/dashboard/js/plugins/iCheck/icheck.min.js']
                        },
                        {
                            name: 'ngSanitize',
                            files: ['assets/dashboard/js/angular/angular-sanitize.min.js']
                        },
                        {
                            name: 'ui.select',
                            files: ['assets/dashboard/css/plugins/ui-select/select.css','assets/dashboard/css/plugins/ui-select/select2.css','assets/dashboard/js/plugins/ui-select/select.js']
                        }
                    ]);
                }
            }
        })
        .state('vendor', {
            abstract: true,
            url: "/vendor",
            templateUrl: "assets/dashboard/views/common/content.html",
        })
        .state('vendor.landing', {
            url: "/1",
            templateUrl: "vendor/landing",
            data: { pageTitle: 'Supplier' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/css/plugins/iCheck/custom.css','assets/dashboard/js/plugins/iCheck/icheck.min.js']
                        },
                        {
                            insertBefore: '#loadBefore',
                            name: 'localytics.directives',
                            files: ['assets/dashboard/css/plugins/chosen/chosen.css','assets/dashboard/js/plugins/chosen/chosen.jquery.js','assets/dashboard/js/plugins/chosen/chosen.js']
                        },
                        {
                            name: 'ngSanitize',
                            files: ['assets/dashboard/js/angular/angular-sanitize.min.js']
                        },
                        {
                            name: 'ui.select',
                            files: ['assets/dashboard/css/plugins/ui-select/select.css','assets/dashboard/css/plugins/ui-select/select2.css','assets/dashboard/js/plugins/ui-select/select.js']
                        },
                        {
                            files: ['assets/dashboard/css/plugins/select2/select2.min.css','assets/dashboard/js/plugins/select2/select2.min.js']
                        }
                        ,
                        {
                            files: ['assets/dashboard/js/plugins/jasny/jasny-bootstrap.min.js']
                        }
                    ]);
                }
            }
        })
        .state('employee', {
            abstract: true,
            url: "/employee",
            templateUrl: "assets/dashboard/views/common/content.html",
        })
        .state('employee.landing', {
            url: "/employee",
            templateUrl: "employee/landing",
            data: { pageTitle: 'Employee' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/css/plugins/iCheck/custom.css','assets/dashboard/js/plugins/iCheck/icheck.min.js']
                        }
                        ,
                        {
                            name: 'ngSanitize',
                            files: ['assets/dashboard/js/angular/angular-sanitize.min.js']
                        },
                        {
                            name: 'ui.select',
                            files: ['assets/dashboard/css/plugins/ui-select/select.css','assets/dashboard/css/plugins/ui-select/select2.css','assets/dashboard/js/plugins/ui-select/select.js']
                        }
                    ]);
                }
            }
        })
        .state('transaction', {
            abstract: true,
            url: "/transaction",
            templateUrl: "assets/dashboard/views/common/content.html",
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/css/plugins/iCheck/custom.css','assets/dashboard/js/plugins/iCheck/icheck.min.js',]
                        },
                        {
                        	name: 'xeditable',
                            files: ['assets/dashboard/css/plugins/angular-xeditable/xeditable.css', 'assets/dashboard/js/plugins/angular-xeditable/xeditable.min.js']
                        },
                        {
                            name: 'datePicker',
                            files: ['assets/dashboard/css/plugins/datapicker/angular-datapicker.css','assets/dashboard/js/plugins/datapicker/datePicker.js']
                        },
                        {
                            name: 'localytics.directives',
                            files: ['assets/dashboard/css/plugins/chosen/chosen.css','assets/dashboard/js/plugins/chosen/chosen.jquery.js','assets/dashboard/js/plugins/chosen/chosen.js']
                        },
                        {
                            files: ['assets/dashboard/css/plugins/select2/select2.min.css','assets/dashboard/js/plugins/select2/select2.min.js']
                        }
                        ,
                        {
                            files: ['assets/dashboard/js/plugins/jasny/jasny-bootstrap.min.js']
                        }
                        ,
                        {
                        	name: 'ngDialog',
                            files: ['assets/dashboard/css/plugins/ngDialog/ngDialog.min.css','assets/dashboard/js/plugins/ngDialog/ngDialog.min.js']
                        }
                        ,
                        {
                            name: 'ngSanitize',
                            files: ['assets/dashboard/js/angular/angular-sanitize.min.js']
                        },
                        {
                            name: 'ui.select',
                            files: ['assets/dashboard/css/plugins/ui-select/select.css','assets/dashboard/css/plugins/ui-select/select2.css','assets/dashboard/js/plugins/ui-select/select.js']
                        }
                    ]);
                }
            }
        })
        .state('transaction.1', {
            url: "/1",
            templateUrl: "assets/dashboard/views/transaction/one.html",
            data: { pageTitle: 'Expense Transactions' }
        })
        .state('transaction.2', {
            url: "/2",
            templateUrl: "assets/dashboard/views/transaction/two.html",
            data: { pageTitle: 'Invoice Transactions' }
        })
        .state('transaction.3', {
            url: "/3",
            templateUrl: "assets/dashboard/views/transaction/three.html",
            data: { pageTitle: 'Other Transactions' }
        })
	    .state('usermanager', {
	        abstract: true,
	        url: "/manageuser",
	        templateUrl: "assets/dashboard/views/common/content.html",
	       
	    })
	    .state('usermanager.1', {
	        url: "manageuser/adduser",
	        templateUrl: "assets/dashboard/views/manageuser/adduser.html",
	        controller: addUserController,
	        data: { pageTitle: 'Add user' }
	    
	    })
	    .state('usermanager.2', {
	        url: "manageuser/deactivateuser",
	        templateUrl: "assets/dashboard/views/manageuser/deactivate_user.html",
	        controller: deActivateController,
	        data: { pageTitle: 'Deactivate user' }
	    
	    })
	    .state('usermanager.3', {
	        url: "manageuser/passwordreset",
	        templateUrl: "assets/dashboard/views/manageuser/password_reset.html",
	        controller: passwordResetController,
	        data: { pageTitle: 'Password reset' }
	    
	    })
	    .state('usermanager.4', {
	        url: "manageuser/reactivateuser",
	        templateUrl: "assets/dashboard/views/manageuser/reactivate_user.html",
	        controller: reActivateController,
	        data: { pageTitle: 'Reactivate user' }
	    
	    })
	    .state('usermanager.5', {
	        url: "manageuser/ownPasswordreset",
	        templateUrl: "assets/dashboard/views/manageuser/password_reset_own.html",
	        controller: passwordResetController,
	        data: { pageTitle: 'Password reset' }
	    
	    })
    
	    .state('reports', {
	        abstract: true,
	        url: "/reports",
	        templateUrl: "assets/dashboard/views/common/content.html",
	    })
      .state('reports.1', {
          url: "/1",
          templateUrl: "assets/dashboard/views/dashboard_4_1.html",
          data: { pageTitle: 'Summary' },
          resolve: {
              loadPlugin: function ($ocLazyLoad) {
                  return $ocLazyLoad.load([
                      {
                          name: 'angles',
                          files: ['assets/dashboard/js/plugins/chartJs/angles.js', 'assets/dashboard/js/plugins/chartJs/Chart.min.js']
                      },
                      {
                          name: 'angular-peity',
                          files: ['assets/dashboard/js/plugins/peity/jquery.peity.min.js', 'assets/dashboard/js/plugins/peity/angular-peity.js']
                      },
                      {
                          serie: true,
                          name: 'angular-flot',
                          files: [ 'assets/dashboard/js/plugins/flot/jquery.flot.js', 'assets/dashboard/js/plugins/flot/jquery.flot.time.js', 'assets/dashboard/js/plugins/flot/jquery.flot.tooltip.min.js', 'assets/dashboard/js/plugins/flot/jquery.flot.spline.js', 'assets/dashboard/js/plugins/flot/jquery.flot.resize.js', 'assets/dashboard/js/plugins/flot/jquery.flot.pie.js', 'assets/dashboard/js/plugins/flot/curvedLines.js', 'assets/dashboard/js/plugins/flot/angular-flot.js', ]
                      }
                  ]);
              }
          }
      })
      .state('reports.2', {
          url: "/2",
          templateUrl: "assets/dashboard/views/report/balancesheet.html",
          data: { pageTitle: 'Balance Sheet' },
          controller: balanceSheetController,
          resolve: {
              loadPlugin: function ($ocLazyLoad) {
                  return $ocLazyLoad.load([
                      {
                          name: 'angles',
                          files: ['assets/dashboard/js/plugins/chartJs/angles.js', 'assets/dashboard/js/plugins/chartJs/Chart.min.js']
                      },
                      {
                          name: 'angular-peity',
                          files: ['assets/dashboard/js/plugins/peity/jquery.peity.min.js', 'assets/dashboard/js/plugins/peity/angular-peity.js']
                      },
                      {
                          serie: true,
                          name: 'angular-flot',
                          files: [ 'assets/dashboard/js/plugins/flot/jquery.flot.js', 'assets/dashboard/js/plugins/flot/jquery.flot.time.js', 'assets/dashboard/js/plugins/flot/jquery.flot.tooltip.min.js', 'assets/dashboard/js/plugins/flot/jquery.flot.spline.js', 'assets/dashboard/js/plugins/flot/jquery.flot.resize.js', 'assets/dashboard/js/plugins/flot/jquery.flot.pie.js', 'assets/dashboard/js/plugins/flot/curvedLines.js', 'assets/dashboard/js/plugins/flot/angular-flot.js', ]
                      }
                  ]);
              }
          }
      })
       .state('reports.3', {
          url: "/3",
          templateUrl: "assets/dashboard/views/report/income_statement.html",
          data: { pageTitle: 'Income Statement' },
          controller: incomeStatementController,
          resolve: {
              loadPlugin: function ($ocLazyLoad) {
                  return $ocLazyLoad.load([
                      {
                          name: 'angles',
                          files: ['assets/dashboard/js/plugins/chartJs/angles.js', 'assets/dashboard/js/plugins/chartJs/Chart.min.js']
                      },
                      {
                          name: 'angular-peity',
                          files: ['assets/dashboard/js/plugins/peity/jquery.peity.min.js', 'assets/dashboard/js/plugins/peity/angular-peity.js']
                      },
                      {
                          serie: true,
                          name: 'angular-flot',
                          files: [ 'assets/dashboard/js/plugins/flot/jquery.flot.js', 'assets/dashboard/js/plugins/flot/jquery.flot.time.js', 'assets/dashboard/js/plugins/flot/jquery.flot.tooltip.min.js', 'assets/dashboard/js/plugins/flot/jquery.flot.spline.js', 'assets/dashboard/js/plugins/flot/jquery.flot.resize.js', 'assets/dashboard/js/plugins/flot/jquery.flot.pie.js', 'assets/dashboard/js/plugins/flot/curvedLines.js', 'assets/dashboard/js/plugins/flot/angular-flot.js', ]
                      }
                  ]);
              }
          }
      })
;
}
angular
    .module('yoursite')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });
