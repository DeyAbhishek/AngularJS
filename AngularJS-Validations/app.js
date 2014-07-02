var app = angular.module('myApp', []);

app.controller('MainCtrl', function($scope) {
  $scope.user = {};
  
  
  //function to submit the form after all validation has occurred	
  $scope.submitForm = function(valid) {
    // check to make sure the form is completely valid
    if (valid) {
      console.log($scope.user);
      
      var errorObj = {
        'fullName': 'Your name is required',
        'email': 'Your email is invalid'
      };
      
      
      $http.post('/someUrl', $scope.user).success(function(response){
        console.log(response);
        if(response.data.status=="SUCCESS")
        {
           $scope.errorObj = {};
        }
        else {
          $scope.errorObj = response.data.errorObj;
        }
      });
    }

  };
});
