myApp.controller('FirstCtrl', ['$scope', '$routeParams', 'initPeople', '$location',
    function($scope, $routeParams, initPeople, $location) {
        console.log('route Params', $routeParams);

        console.log(initPeople);

        $scope.viewHeading = 'View1';

        $scope.people = initPeople.data;

        $scope.goToRoute1 = function() {
            $location.path('/first');
        }
        $scope.goToRoute2 = function() {
            var obj = {
                param1: 'Value1',
                param2: 'Value2'
            };

            $location.path('/second').search(obj);
        }
        $scope.goToRoute3 = function() {
            $location.path('/third/PRVN/Richmond');
        }

    }
]);
