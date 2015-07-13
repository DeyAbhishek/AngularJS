var app = angular.module('app', ['ngRoute']);

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/temperature', {
	templateUrl: 'temperature.jsp',
	controller: 'TemperatureController'
      }).
      when('/DO', {
	templateUrl: 'DO.jsp',
	controller: 'DOController'
      }).
        when('/pH', {
	templateUrl: 'pH.jsp',
	controller: 'pHController'
      }).
      when('/conductivity', {
    		templateUrl: 'conductivity.jsp',
    		controller: 'ConductivityController'
    	      }).
      when('/salinity', {
    		templateUrl: 'salinity.jsp',
    		controller: 'SalinityController'
    	      }).
      when('/turbidity', {
    		templateUrl: 'turbidity.jsp',
    		controller: 'TurbidityController'
    	      }).
      when('/light', {
    		templateUrl: 'light.jsp',
    		controller: 'LightController'
	      }).
      otherwise({
	redirectTo: '/temperature'
      });
}]);



//We don't need Controllers as of now

app.controller('TemperatureController', ['$scope', '$location', function($scope, $location) {
  $scope.name = 'Temperature';
  $scope.caseInfo = {};
}]);


app.controller('DOController', ['$scope',
    function($scope) {
        $scope.name = "DO";

}
]);


app.controller('pHController', ['$scope',
    function($scope) {
        $scope.name = "pH";

}
]);


app.controller('ConductivityController', ['$scope',
    function($scope) {
        $scope.name = "";

}
]);


app.controller('SalinityController', ['$scope',
    function($scope) {
        $scope.name = "";

}
]);


app.controller('TurbidityController', ['$scope',
    function($scope) {
        $scope.name = "";

}
]);

app.controller('LightController', ['$scope',
                                       function($scope) {
                                           $scope.name = "Light";

                                   }
                                   ]);




app.controller( 'Hello', ['$scope', '$http', 
    function($scope, $http) {
   
	$http.get('http://localhost:8888/RESTfulCalibrationDemo/rest/Standards/').
        success(function(data) {
            $scope.user = data;
            console.log($scope.user);
        });
	
	
	$scope.addRecord = function(){
		
		$http.post('http://localhost:8888/RESTfulCalibrationDemo/rest/Standards/', $scope.newRecord).
		success(function(data){
			$scope.user = data; //This part displays the newly added data in the table instantaneously
		}				
		);

		$scope.newRecord = null;
		console.log("Complete");
		
	};
	
$scope.deleteRecord = function(chemicalID){
		
		$http.delete('http://localhost:8888/RESTfulCalibrationDemo/rest/Standards/' + chemicalID).
		success(function(data){
			console.log("Complete");
		}				
		);
	
	};
	

}]);



