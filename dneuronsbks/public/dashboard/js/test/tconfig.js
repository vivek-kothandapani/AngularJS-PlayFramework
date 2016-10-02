/**
 * Copyright 2015 yoursite
 *
 * yoursite theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
    $urlRouterProvider.otherwise("/dashboards/dashboard_1");

    $ocLazyLoadProvider.config({
        // Set to true if you want to see what and when is dynamically loaded
        debug: false
    });

    $stateProvider

        .state('dashboards', {
            abstract: true,
            url: "/dashboards",
            templateUrl: "assets/dashboard/views/test/common/tcontent.html",
        })
        .state('dashboards.dashboard_1', {
            url: "/dashboard_1",
            templateUrl: "assets/dashboard/views/dashboard_1.html",
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {

                            serie: true,
                            name: 'angular-flot',
                            files: [ 'assets/dashboard/js/plugins/flot/jquery.flot.js', 'assets/dashboard/js/plugins/flot/jquery.flot.time.js', 'assets/dashboard/js/plugins/flot/jquery.flot.tooltip.min.js', 'assets/dashboard/js/plugins/flot/jquery.flot.spline.js', 'assets/dashboard/js/plugins/flot/jquery.flot.resize.js', 'assets/dashboard/js/plugins/flot/jquery.flot.pie.js', 'assets/dashboard/js/plugins/flot/curvedLines.js', 'assets/dashboard/js/plugins/flot/angular-flot.js', ]
                        },
                        {
                            name: 'angles',
                            files: ['assets/dashboard/js/plugins/chartJs/angles.js', 'assets/dashboard/js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angular-peity',
                            files: ['assets/dashboard/js/plugins/peity/jquery.peity.min.js', 'assets/dashboard/js/plugins/peity/angular-peity.js']
                        }
                    ]);
                }
            }
        })
        .state('dashboards.dashboard_2', {
            url: "/dashboard_2",
            templateUrl: "assets/dashboard/views/dashboard_2.html",
            data: { pageTitle: 'Dashboard 2' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ 'assets/dashboard/js/plugins/flot/jquery.flot.js', 'assets/dashboard/js/plugins/flot/jquery.flot.time.js', 'assets/dashboard/js/plugins/flot/jquery.flot.tooltip.min.js', 'assets/dashboard/js/plugins/flot/jquery.flot.spline.js', 'assets/dashboard/js/plugins/flot/jquery.flot.resize.js', 'assets/dashboard/js/plugins/flot/jquery.flot.pie.js', 'assets/dashboard/js/plugins/flot/curvedLines.js', 'assets/dashboard/js/plugins/flot/angular-flot.js', ]
                        },
                        {
                            files: ['assets/dashboard/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js','assets/dashboard/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js']
                        }
                    ]);
                }
            }
        })
        .state('dashboards.dashboard_3', {
            url: "/dashboard_3",
            templateUrl: "assets/dashboard/views/dashboard_3.html",
            data: { pageTitle: 'Dashboard 3' },
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
                            name: 'ui.checkbox',
                            files: ['assets/dashboard/js/bootstrap/angular-bootstrap-checkbox.js']
                        }
                    ]);
                }
            }
        })
        .state('dashboards_top', {
            abstract: true,
            url: "/dashboards_top",
            templateUrl: "assets/dashboard/views/common/content_top_navigation.html",
        })
        .state('dashboards_top.dashboard_4', {
            url: "/dashboard_4",
            templateUrl: "assets/dashboard/views/dashboard_4.html",
            data: { pageTitle: 'Dashboard 4' },
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
        .state('dashboards.dashboard_4_1', {
            url: "/dashboard_4_1",
            templateUrl: "assets/dashboard/views/dashboard_4_1.html",
            data: { pageTitle: 'Dashboard 4' },
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
      
        .state('layouts', {
            url: "/layouts",
            templateUrl: "assets/dashboard/views/test/tlayouts.html",
            data: { pageTitle: 'Layouts' },
        })
        .state('charts', {
            abstract: true,
            url: "/charts",
            templateUrl: "assets/dashboard/views/test/common/tcontent.html",
        })
        .state('charts.flot_chart', {
            url: "/flot_chart",
            templateUrl: "assets/dashboard/views/graph_flot.html",
            data: { pageTitle: 'Flot chart' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ 'assets/dashboard/js/plugins/flot/jquery.flot.js', 'assets/dashboard/js/plugins/flot/jquery.flot.time.js', 'assets/dashboard/js/plugins/flot/jquery.flot.tooltip.min.js', 'assets/dashboard/js/plugins/flot/jquery.flot.spline.js', 'assets/dashboard/js/plugins/flot/jquery.flot.resize.js', 'assets/dashboard/js/plugins/flot/jquery.flot.pie.js', 'assets/dashboard/js/plugins/flot/curvedLines.js', 'assets/dashboard/js/plugins/flot/angular-flot.js', ]
                        }
                    ]);
                }
            }
        })
        .state('charts.rickshaw_chart', {
            url: "/rickshaw_chart",
            templateUrl: "assets/dashboard/views/graph_rickshaw.html",
            data: { pageTitle: 'Rickshaw chart' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            reconfig: true,
                            serie: true,
                            files: ['assets/dashboard/js/plugins/rickshaw/vendor/d3.v3.js','assets/dashboard/js/plugins/rickshaw/rickshaw.min.js']
                        },
                        {
                            reconfig: true,
                            name: 'angular-rickshaw',
                            files: ['assets/dashboard/js/plugins/rickshaw/angular-rickshaw.js']
                        }
                    ]);
                }
            }
        })
        .state('charts.peity_chart', {
            url: "/peity_chart",
            templateUrl: "assets/dashboard/views/graph_peity.html",
            data: { pageTitle: 'Peity graphs' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'angular-peity',
                            files: ['assets/dashboard/js/plugins/peity/jquery.peity.min.js', 'assets/dashboard/js/plugins/peity/angular-peity.js']
                        }
                    ]);
                }
            }
        })
        .state('charts.sparkline_chart', {
            url: "/sparkline_chart",
            templateUrl: "assets/dashboard/views/graph_sparkline.html",
            data: { pageTitle: 'Sparkline chart' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/js/plugins/sparkline/jquery.sparkline.min.js']
                        }
                    ]);
                }
            }
        })
        .state('charts.chartjs_chart', {
            url: "/chartjs_chart",
            templateUrl: "assets/dashboard/views/chartjs.html",
            data: { pageTitle: 'Chart.js' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angles',
                            files: ['assets/dashboard/js/plugins/chartJs/angles.js']
                        }
                    ]);
                }
            }
        })
        .state('mailbox', {
            abstract: true,
            url: "/mailbox",
            templateUrl: "assets/dashboard/views/test/common/tcontent.html",
        })
        .state('mailbox.inbox', {
            url: "/inbox",
            templateUrl: "assets/dashboard/views/mailbox.html",
            data: { pageTitle: 'Mail Inbox' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/css/plugins/iCheck/custom.css','assets/dashboard/js/plugins/iCheck/icheck.min.js']
                        }
                    ]);
                }
            }
        })
        .state('mailbox.email_view', {
            url: "/email_view",
            templateUrl: "assets/dashboard/views/mail_detail.html",
            data: { pageTitle: 'Mail detail' }
        })
        .state('mailbox.email_compose', {
            url: "/email_compose",
            templateUrl: "assets/dashboard/views/mail_compose.html",
            data: { pageTitle: 'Mail compose' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/css/plugins/summernote/summernote.css','assets/dashboard/css/plugins/summernote/summernote-bs3.css','assets/dashboard/js/plugins/summernote/summernote.min.js']
                        },
                        {
                            name: 'summernote',
                            files: ['assets/dashboard/css/plugins/summernote/summernote.css','assets/dashboard/css/plugins/summernote/summernote-bs3.css','assets/dashboard/js/plugins/summernote/summernote.min.js','assets/dashboard/js/plugins/summernote/angular-summernote.min.js']
                        }
                    ]);
                }
            }
        })
        .state('mailbox.email_template', {
            url: "/email_template",
            templateUrl: "assets/dashboard/views/email_template.html",
            data: { pageTitle: 'Mail compose' }
        })
        .state('widgets', {
            url: "/widgets",
            templateUrl: "assets/dashboard/views/widgets.html",
            data: { pageTitle: 'Widhets' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ 'assets/dashboard/js/plugins/flot/jquery.flot.js', 'assets/dashboard/js/plugins/flot/jquery.flot.time.js', 'assets/dashboard/js/plugins/flot/jquery.flot.tooltip.min.js', 'assets/dashboard/js/plugins/flot/jquery.flot.spline.js', 'assets/dashboard/js/plugins/flot/jquery.flot.resize.js', 'assets/dashboard/js/plugins/flot/jquery.flot.pie.js', 'assets/dashboard/js/plugins/flot/curvedLines.js', 'assets/dashboard/js/plugins/flot/angular-flot.js', ]
                        },
                        {
                            files: ['assets/dashboard/css/plugins/iCheck/custom.css','assets/dashboard/js/plugins/iCheck/icheck.min.js']
                        },
                        {
                            files: ['assets/dashboard/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js','assets/dashboard/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js']
                        },
                        {
                            name: 'ui.checkbox',
                            files: ['assets/dashboard/js/bootstrap/angular-bootstrap-checkbox.js']
                        }
                    ]);
                }
            }
        })
        .state('forms', {
            abstract: true,
            url: "/forms",
            templateUrl: "assets/dashboard/views/test/common/tcontent.html",
        })
        .state('forms.basic_form', {
            url: "/basic_form",
            templateUrl: "assets/dashboard/views/form_basic.html",
            data: { pageTitle: 'Basic form' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/css/plugins/iCheck/custom.css','assets/dashboard/js/plugins/iCheck/icheck.min.js']
                        }
                    ]);
                }
            }
        })
        .state('forms.advanced_plugins', {
            url: "/advanced_plugins",
            templateUrl: "assets/dashboard/views/form_advanced.html",
            data: { pageTitle: 'Advanced form' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'ui.knob',
                            files: ['assets/dashboard/js/plugins/jsKnob/jquery.knob.js','assets/dashboard/js/plugins/jsKnob/angular-knob.js']
                        },
                        {
                            files: ['assets/dashboard/css/plugins/ionRangeSlider/ion.rangeSlider.css','assets/dashboard/css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css','assets/dashboard/js/plugins/ionRangeSlider/ion.rangeSlider.min.js']
                        },
                        {
                            insertBefore: '#loadBefore',
                            name: 'localytics.directives',
                            files: ['assets/dashboard/css/plugins/chosen/chosen.css','assets/dashboard/js/plugins/chosen/chosen.jquery.js','assets/dashboard/js/plugins/chosen/chosen.js']
                        },
                        {
                            name: 'nouislider',
                            files: ['assets/dashboard/css/plugins/nouslider/jquery.nouislider.css','assets/dashboard/js/plugins/nouslider/jquery.nouislider.min.js','assets/dashboard/js/plugins/nouslider/angular-nouislider.js']
                        },
                        {
                            name: 'datePicker',
                            files: ['assets/dashboard/css/plugins/datapicker/angular-datapicker.css','assets/dashboard/js/plugins/datapicker/datePicker.js']
                        },
                        {
                            files: ['assets/dashboard/js/plugins/jasny/jasny-bootstrap.min.js']
                        },
                        {
                            name: 'ui.switchery',
                            files: ['assets/dashboard/css/plugins/switchery/switchery.css','assets/dashboard/js/plugins/switchery/switchery.js','assets/dashboard/js/plugins/switchery/ng-switchery.js']
                        },
                        {
                            name: 'colorpicker.module',
                            files: ['assets/dashboard/css/plugins/colorpicker/colorpicker.css','assets/dashboard/js/plugins/colorpicker/bootstrap-colorpicker-module.js']
                        },
                        {
                            name: 'ngImgCrop',
                            files: ['assets/dashboard/js/plugins/ngImgCrop/ng-img-crop.js','assets/dashboard/css/plugins/ngImgCrop/ng-img-crop.css']
                        }

                    ]);
                }
            }
        })
        .state('forms.wizard', {
            url: "/wizard",
            templateUrl: "assets/dashboard/views/form_wizard.html",
            controller: wizardCtrl,
            data: { pageTitle: 'Wizard form' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/css/plugins/steps/jquery.steps.css']
                        }
                    ]);
                }
            }
        })
        .state('forms.wizard.step_one', {
            url: '/step_one',
            templateUrl: 'assets/dashboard/views/wizard/step_one.html',
            data: { pageTitle: 'Wizard form' }
        })
        .state('forms.wizard.step_two', {
            url: '/step_two',
            templateUrl: 'assets/dashboard/views/wizard/step_two.html',
            data: { pageTitle: 'Wizard form' }
        })
        .state('forms.wizard.step_three', {
            url: '/step_three',
            templateUrl: 'assets/dashboard/views/wizard/step_three.html',
            data: { pageTitle: 'Wizard form' }
        })
        .state('forms.file_upload', {
            url: "/file_upload",
            templateUrl: "assets/dashboard/views/form_file_upload.html",
            data: { pageTitle: 'File upload' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/css/plugins/dropzone/basic.css','assets/dashboard/css/plugins/dropzone/dropzone.css','assets/dashboard/js/plugins/dropzone/dropzone.js']
                        }
                    ]);
                }
            }
        })
        .state('forms.text_editor', {
            url: "/text_editor",
            templateUrl: "assets/dashboard/views/form_editors.html",
            data: { pageTitle: 'Text editor' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'summernote',
                            files: ['assets/dashboard/css/plugins/summernote/summernote.css','assets/dashboard/css/plugins/summernote/summernote-bs3.css','assets/dashboard/js/plugins/summernote/summernote.min.js','assets/dashboard/js/plugins/summernote/angular-summernote.min.js']
                        }
                    ]);
                }
            }
        })
        .state('app', {
            abstract: true,
            url: "/app",
            templateUrl: "assets/dashboard/views/test/common/tcontent.html",
        })
        .state('app.contacts', {
            url: "/contacts",
            templateUrl: "assets/dashboard/views/contacts.html",
            data: { pageTitle: 'Contacts' }
        })
        .state('app.profile', {
            url: "/profile",
            templateUrl: "assets/dashboard/views/profile.html",
            data: { pageTitle: 'Profile' }
        })
        .state('app.projects', {
            url: "/projects",
            templateUrl: "assets/dashboard/views/projects.html",
            data: { pageTitle: 'Projects' }
        })
        .state('app.project_detail', {
            url: "/project_detail",
            templateUrl: "assets/dashboard/views/project_detail.html",
            data: { pageTitle: 'Project detail' }
        })
        .state('app.file_manager', {
            url: "/file_manager",
            templateUrl: "assets/dashboard/views/file_manager.html",
            data: { pageTitle: 'File manager' }
        })
        .state('app.calendar', {
            url: "/calendar",
            templateUrl: "assets/dashboard/views/calendar.html",
            data: { pageTitle: 'Calendar' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            insertBefore: '#loadBefore',
                            files: ['assets/dashboard/css/plugins/fullcalendar/fullcalendar.css','assets/dashboard/js/plugins/fullcalendar/fullcalendar.min.js','assets/dashboard/js/plugins/fullcalendar/gcal.js']
                        },
                        {
                            name: 'ui.calendar',
                            files: ['assets/dashboard/js/plugins/fullcalendar/calendar.js']
                        }
                    ]);
                }
            }
        })
        .state('app.faq', {
            url: "/faq",
            templateUrl: "assets/dashboard/views/faq.html",
            data: { pageTitle: 'FAQ' }
        })
        .state('app.timeline', {
            url: "/timeline",
            templateUrl: "assets/dashboard/views/timeline.html",
            data: { pageTitle: 'Timeline' }
        })
        .state('app.pin_board', {
            url: "/pin_board",
            templateUrl: "assets/dashboard/views/pin_board.html",
            data: { pageTitle: 'Pin board' }
        })
        .state('app.invoice', {
            url: "/invoice",
            templateUrl: "assets/dashboard/views/invoice.html",
            data: { pageTitle: 'Invoice' }
        })
        .state('pages', {
            abstract: true,
            url: "/pages",
            templateUrl: "assets/dashboard/views/test/common/tcontent.html",
        })
        .state('pages.search_results', {
            url: "/search_results",
            templateUrl: "assets/dashboard/views/search_results.html",
            data: { pageTitle: 'Search results' }
        })
        .state('pages.empy_page', {
            url: "/empy_page",
            templateUrl: "assets/dashboard/views/empty_page.html",
            data: { pageTitle: 'Empty page' }
        })
        .state('ui', {
            abstract: true,
            url: "/ui",
            templateUrl: "assets/dashboard/views/test/common/tcontent.html",
        })
        .state('ui.typography', {
            url: "/typography",
            templateUrl: "assets/dashboard/views/typography.html",
            data: { pageTitle: 'Typography' }
        })
        .state('ui.icons', {
            url: "/icons",
            templateUrl: "assets/dashboard/views/icons.html",
            data: { pageTitle: 'Icons' }
        })
        .state('ui.buttons', {
            url: "/buttons",
            templateUrl: "assets/dashboard/views/buttons.html",
            data: { pageTitle: 'Buttons' }
        })
        .state('ui.tabs_panels', {
            url: "/tabs_panels",
            templateUrl: "assets/dashboard/views/tabs_panels.html",
            data: { pageTitle: 'Tabs and panels' }
        })
        .state('ui.notifications_tooltips', {
            url: "/notifications_tooltips",
            templateUrl: "assets/dashboard/views/notifications.html",
            data: { pageTitle: 'Notifications and tooltips' }
        })
        .state('ui.badges_labels', {
            url: "/badges_labels",
            templateUrl: "assets/dashboard/views/badges_labels.html",
            data: { pageTitle: 'Badges and labels and progress' }
        })
        .state('ui.video', {
            url: "/video",
            templateUrl: "assets/dashboard/views/video.html",
            data: { pageTitle: 'Responsible Video' }
        })
        .state('grid_options', {
            url: "/grid_options",
            templateUrl: "assets/dashboard/views/test/tgrid_options.html",
            data: { pageTitle: 'Grid options' }
        })
        .state('miscellaneous', {
            abstract: true,
            url: "/miscellaneous",
            templateUrl: "assets/dashboard/views/test/common/tcontent.html",
        })
        .state('miscellaneous.google_maps', {
            url: "/google_maps",
            templateUrl: "assets/dashboard/views/google_maps.html",
            data: { pageTitle: 'Google maps' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'ui.event',
                            files: ['assets/dashboard/js/plugins/uievents/event.js']
                        },
                        {
                            name: 'ui.map',
                            files: ['assets/dashboard/js/plugins/uimaps/ui-map.js']
                        },
                    ]);
                }
            }
        })
        .state('miscellaneous.code_editor', {
            url: "/code_editor",
            templateUrl: "assets/dashboard/views/code_editor.html",
            data: { pageTitle: 'Code Editor' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            files: ['assets/dashboard/css/plugins/codemirror/codemirror.css','assets/dashboard/css/plugins/codemirror/ambiance.css','assets/dashboard/js/plugins/codemirror/codemirror.js','assets/dashboard/js/plugins/codemirror/mode/javascript/javascript.js']
                        },
                        {
                            name: 'ui.codemirror',
                            files: ['assets/dashboard/js/plugins/ui-codemirror/ui-codemirror.min.js']
                        }
                    ]);
                }
            }
        })
        .state('miscellaneous.modal_window', {
            url: "/modal_window",
            templateUrl: "assets/dashboard/views/modal_window.html",
            data: { pageTitle: 'Modal window' }
        })
        .state('miscellaneous.chat_view', {
            url: "/chat_view",
            templateUrl: "assets/dashboard/views/chat_view.html",
            data: { pageTitle: 'Chat view' }
        })
        .state('miscellaneous.nestable_list', {
            url: "/nestable_list",
            templateUrl: "assets/dashboard/views/nestable_list.html",
            data: { pageTitle: 'Nestable List' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'ui.tree',
                            files: ['assets/dashboard/css/plugins/uiTree/angular-ui-tree.min.css','assets/dashboard/js/plugins/uiTree/angular-ui-tree.min.js']
                        },
                    ]);
                }
            }
        })
        .state('miscellaneous.notify', {
            url: "/notify",
            templateUrl: "assets/dashboard/views/notify.html",
            data: { pageTitle: 'Notifications for angularJS' },
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
        .state('miscellaneous.timeline_2', {
            url: "/timeline_2",
            templateUrl: "assets/dashboard/views/timeline_2.html",
            data: { pageTitle: 'Timeline version 2' }
        })
        .state('miscellaneous.forum_view', {
            url: "/forum_view",
            templateUrl: "assets/dashboard/views/forum_view.html",
            data: { pageTitle: 'Forum - general view' }
        })
        .state('miscellaneous.forum_post_view', {
            url: "/forum_post_view",
            templateUrl: "assets/dashboard/views/forum_post_view.html",
            data: { pageTitle: 'Forum - post view' }
        })
        .state('tables', {
            abstract: true,
            url: "/tables",
            templateUrl: "assets/dashboard/views/test/common/tcontent.html",
        })
        .state('tables.static_table', {
            url: "/static_table",
            templateUrl: "assets/dashboard/views/table_basic.html",
            data: { pageTitle: 'Static table' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'angular-peity',
                            files: ['assets/dashboard/js/plugins/peity/jquery.peity.min.js', 'assets/dashboard/js/plugins/peity/angular-peity.js']
                        },
                        {
                            files: ['assets/dashboard/css/plugins/iCheck/custom.css','assets/dashboard/js/plugins/iCheck/icheck.min.js']
                        }
                    ]);
                }
            }
        })
        .state('tables.data_tables', {
            url: "/data_tables",
            templateUrl: "assets/dashboard/views/table_data_tables.html",
            data: { pageTitle: 'Data Tables' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            seria: true,
                            files: ['assets/dashboard/css/plugins/dataTables/dataTables.bootstrap.css','assets/dashboard/js/plugins/dataTables/jquery.dataTables.js','assets/dashboard/js/plugins/dataTables/dataTables.bootstrap.js']
                        },
                        {
                            name: 'datatables',
                            files: ['assets/dashboard/js/plugins/dataTables/angular-datatables.min.js']
                        }
                    ]);
                }
            }
        })
        .state('tables.nggrid', {
            url: "/nggrid",
            templateUrl: "assets/dashboard/views/nggrid.html",
            data: { pageTitle: 'ng Grid' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'ngGrid',
                            files: ['assets/dashboard/js/plugins/nggrid/ng-grid-2.0.3.min.js']
                        },
                        {
                            insertBefore: '#loadBefore',
                            files: ['assets/dashboard/js/plugins/nggrid/ng-grid.css']
                        }
                    ]);
                }
            }
        })
        .state('gallery', {
            abstract: true,
            url: "/gallery",
            templateUrl: "assets/dashboard/views/test/common/tcontent.html",
        })
        .state('gallery.basic_gallery', {
            url: "/basic_gallery",
            templateUrl: "assets/dashboard/views/basic_gallery.html",
            data: { pageTitle: 'Lightbox Gallery' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: ['assets/dashboard/js/plugins/blueimp/jquery.blueimp-gallery.min.js','assets/dashboard/css/plugins/blueimp/css/blueimp-gallery.min.css']
                        }
                    ]);
                }
            }
        })
        .state('gallery.bootstrap_carousel', {
            url: "/bootstrap_carousel",
            templateUrl: "assets/dashboard/views/carousel.html",
            data: { pageTitle: 'Bootstrap carousel' }
        })
        .state('css_animations', {
            url: "/css_animations",
            templateUrl: "assets/dashboard/views/test/tcss_animation.html",
            data: { pageTitle: 'CSS Animations' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            reconfig: true,
                            serie: true,
                            files: ['assets/dashboard/js/plugins/rickshaw/vendor/d3.v3.js','assets/dashboard/js/plugins/rickshaw/rickshaw.min.js']
                        },
                        {
                            reconfig: true,
                            name: 'angular-rickshaw',
                            files: ['assets/dashboard/js/plugins/rickshaw/angular-rickshaw.js']
                        }
                    ]);
                }
            }

        });
}
angular
    .module('yoursite')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });
