(function () {
    angular
        .module('market', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })
            .when('/store', {
                templateUrl: 'store/store.html',
                controller: 'storeController'
            })
            .when('/cart', {
                templateUrl: 'cart/cart.html',
                controller: 'cartController'
            })
            .when('/orders', {
                templateUrl: 'orders/orders.html',
                controller: 'ordersController'
            })
            .when('/registration', {
                templateUrl: 'registration/registration.html',
                controller: 'registrationController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
        if ($localStorage.winterMarketUser) {
            try {
                let jwt = $localStorage.winterMarketUser.token;
                let payload = JSON.parse(atob(jwt.split('.')[1]));
                let currentTime = parseInt(new Date().getTime() / 1000);
                if (currentTime > payload.exp) {
                    console.log("Token is expired!!!");
                    delete $localStorage.winterMarketUser;
                    $http.defaults.headers.common.Authorization = '';
                }
            } catch (e) {
            }

            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.winterMarketUser.token;
        }

        if (!$localStorage.winterMarketGuestCartId) {
            $http.get('http://localhost:5555/cart/api/v1/cart/generate_uuid')
                .then(function successCallback(response) {
                    $localStorage.winterMarketGuestCartId = response.data.value;
                });
        }
    }
})();

angular.module('market').controller('indexController', function ($rootScope, $scope, $http, $location, $localStorage) {
        $scope.mergeCart = function () {
                $http.get('http://localhost:5555/cart/' + 'api/v1/cart/' + $localStorage.winterMarketGuestCartId +
                '/mergeCart').then(function (response) {
                });
        }
    $scope.tryToAuth = function () {
        $http.post('http://localhost:5555/auth/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.winterMarketUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;

                    $location.path('/');
                    $scope.mergeCart();
                }
            }, function errorCallback(response) {
            });
    };

   $rootScope.admin = function () {
       alert("!!!!!!!!!!");
       $http.get('http://localhost:5555/core/api/v1/roles/admin?role=admin')
                   .then(function successCallback(response) {
                       alert("success");
                   }, function errorCallback(response) {
                       alert("error");
                   });
   };

    $rootScope.tryToLogout = function () {
        $scope.clearUser();
        $scope.user = null;
        $location.path('/');
    };

    $scope.clearUser = function () {
        delete $localStorage.winterMarketUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $rootScope.isUserLoggedIn = function () {
        if ($localStorage.winterMarketUser) {
            return true;
        } else {
            return false;
        }
    };
});