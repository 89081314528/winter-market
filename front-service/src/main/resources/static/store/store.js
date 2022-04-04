angular.module('market').controller('storeController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:5555/core/';
    const cartContextPath = 'http://localhost:5555/cart/';

    $scope.loadProducts = function (page) {
        $http.get(contextPath + 'api/v1/products',{params: {'p': page}}).then(function (response) {
            $scope.productsList = response.data;
        });
    }

    $scope.showProductInfo = function (productId) {
        $http.get(contextPath + 'api/v1/products/' + productId).then(function (response) {
            alert(response.data.title);
        });
    }

    $scope.addToCart = function (productId) {
    if ($localStorage.winterMarketUser == null) {
    $http.get(cartContextPath + 'api/v1/cart/add/' + productId).then(function (response) {
                $scope.loadCart();
            });
    } else {
        $http.get(cartContextPath + 'api/v1/cart/add/' + productId,
         {params: {'userName': $localStorage.winterMarketUser.username}} ).then(function (response) {
            $scope.loadCart();
            });
        }
    }

    $scope.loadProducts();
});