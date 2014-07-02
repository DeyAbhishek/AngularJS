var myApp = angular.module('myApp', ['ngRoute']);
myApp.run(['$http', '$templateCache',
    function($http, $templateCache) {
        $http.get('partials/view1.html', {
            cache: $templateCache
        });
        $http.get('partials/view2.html', {
            cache: $templateCache
        });
        $http.get('partials/view3.html', {
            cache: $templateCache
        });

    }
]);

myApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider
            .when('/first', {
                templateUrl: 'partials/view1.html',
                controller: 'FirstCtrl',
                resolve: {
                    initPeople: ['$http',
                        function($http) {
                            return $http({
                                method: 'GET',
                                url: 'server/someData.json'
                            });
                        }
                    ]
                }
            })
            .when('/second', {
                templateUrl: 'partials/view2.html',
                controller: 'SecondCtrl'
            })
            .when('/third/:name/:city', {
                templateUrl: 'partials/view3.html',
                controller: 'ThirdCtrl'
            })
            .otherwise({
                redirectTo: '/first'
            });

    }
]);
