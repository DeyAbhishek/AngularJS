
var app = angular.module('app', []);

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/standard', {
	templateUrl: 'standard.html',
	controller: 'StandardController'
      }).
      when('/delivery', {
	templateUrl: 'delivery.html',
	controller: 'DeliveryController'
      }).
        when('/status', {
	templateUrl: 'status.html',
	controller: 'StatusController'
      }).
      otherwise({
	redirectTo: '/standard'
      });
}]);


app.controller('StandardController', ['$scope', '$location', function($scope, $location) {
  $scope.name = 'Standard';
  $scope.caseInfo = {};
}]);



app.controller('DeliveryController', ['$scope',
    function($scope) {
        $scope.name = "Delivery";

}
]);


app.controller('StatusController', ['$scope',
    function($scope) {
        $scope.name = "Status";

}
]);


app.controller('ProductsController', ['$scope',
    function($scope) {
        $scope.name = "Products";

}
]);


app.controller('MaterialsController', ['$scope',
    function($scope) {
        $scope.name = "Materials";

}
]);


app.controller('ManualController', ['$scope',
    function($scope) {
        $scope.name = "Manual";

}
]);
