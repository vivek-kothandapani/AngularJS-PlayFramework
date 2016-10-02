function checkoutController($scope, $routeParams, DataService) {
    $scope.store = DataService.store;
    $scope.cart = DataService.cart;
    $scope.settings = DataService.settings;
}