var checkoutApp = angular.module('yoursiteCheckout', ['ngRoute', 'ngAnimate', 'pascalprecht.translate']).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when('/shop', {
                templateUrl: '/packages',
                controller: checkoutController
            }).
            when('/businfo', {
                templateUrl: '/checkout/businfo',
                controller: checkoutController
            }).
            when('/terms', {
                templateUrl: '/checkout/terms',
                controller: checkoutController
            }).
            when('/billing', {
                templateUrl: '/checkout/billing',
                controller: checkoutController
            }).
            when('/payment', {
                templateUrl: '/checkout/payment',
                controller: checkoutController
            }).
            when('/review', {
                templateUrl: '/checkout/review',
                controller: checkoutController
            }).
            when('/complete', {
                templateUrl: '/checkout/complete',
                controller: checkoutController
            }).
            otherwise({
                redirectTo: '/packages',
                controller: checkoutController
            });
    }]);

checkoutApp.run(function($rootScope, $location) {
    $rootScope.$on('$routeChangeSuccess', function () {})});

checkoutApp.config(['$translateProvider', function ($translateProvider) {
    $translateProvider.translations('en', translationEN); //English
    $translateProvider.translations('de', translationDE); //German
    $translateProvider.translations('es_ib', translationES_IB); //Spanish (European)
    $translateProvider.translations('es_la', translationES_LA); //Spanish (Latin)
    $translateProvider.translations('fr', translationFR); //French
    $translateProvider.translations('ja', translationJA); //Japanese
    $translateProvider.translations('it', translationIT); //Italian
    $translateProvider.translations('nl', translationNL); //Dutch
    $translateProvider.translations('pt', translationPT); //Portuguese
    $translateProvider.translations('el', translationEL); //Greek
    $translateProvider.translations('sv', translationSV); //Swedish
    $translateProvider.translations('zh', translationZH); //Chinese
    $translateProvider.translations('sl', translationSL); //Slovenian
    $translateProvider.translations('da', translationDA); //Danish
    $translateProvider.translations('no', translationNO); //Norwegian
    $translateProvider.use('en');
}]);

checkoutApp.factory("DataService", function () {

    var myStore = new shop();

    var myCart = new shoppingCart("yoursiteCheckout");

    var mySettings = new settings("yoursiteCheckout");

    myCart.addCheckoutParameters("Hosted", {});
    myCart.addCheckoutParameters("Inline", {});
    myCart.addCheckoutParameters("API", {});

    return {
        store: myStore,
        cart: myCart,
        settings: mySettings
    };
});

checkoutApp.controller('Settings', ['$translate', '$scope', function ($translate, $scope) {
    $translate.use($scope.settings.language);
    $scope.langChange = function () {$translate.use($scope.settings.language);};
}]);