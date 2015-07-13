<!DOCTYPE html>
<html ng-app="app">

  <head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8" />
    <title></title>

    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
  <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />
  <link rel="stylesheet" href="style/style.css" />
    
  </head>

  <body >
  <section>
    <div ng-controller="Hello" class="container1" >
       Search: &nbsp;<input type="text" ng-model="searchText" class="form-control" placeholder="Search List" style="width: 200px;"/>
    <hr>
    <input type="text" ng-model="newRecord.chemical_id"  placeholder="ID" style="width: 200px;" />
  <input type="text" ng-model="newRecord.status"  placeholder="Status"  style="width: 200px;"/>
    <input type="text" ng-model="newRecord.location"  placeholder="Location" style="width: 200px;"/>
    <button class="btn btn-info"  ng-click="addRecord()">Add Record</button>
         		<table ng-init="predicate='location'; reverse = false;">
					<thead>
					<tr>
					<td ng-click="predicate='chemical_id'; reverse = !reverse;">Chemical ID</td>
					<td ng-click="predicate='status'; reverse = !reverse;">Status</td>
					<td ng-click="predicate= 'location'; reverse = !reverse;">Location</td>
					<td>Action</td>
					</tr>
					</thead>
					<tbody>
					<tr ng-repeat="p in user | filter : searchText | orderBy : predicate : reverse" >
					<td>{{ p.chemical_id }}</td>
					<td> {{ p.status }}</td>
					<td> {{ p.location  }} </td>
					<td><button class="btn btn-link"  ng-click="editRecord()">Edit</button>
					<button class="btn btn-link"  ng-click="deleteRecord(p.chemical_id)">Delete</button></td>
					</tr>
					</tbody>
					</table>
           
        </div>
  </section>
  <script data-require="angular.js@1.2.x" src="https://code.angularjs.org/1.2.28/angular.js" data-semver="1.2.28"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
    <script src="app.js"></script>
  </body>

</html>
