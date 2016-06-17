'use strict';

angular.module('ihr.employeeTimesheet', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/employeeTimesheet/:ID', {
    templateUrl: 'app/timesheet/employee-timesheet.html',
    controller: 'EmployeeTimesheetCtrl'
  });
}])

.controller('EmployeeTimesheetCtrl', ['$scope', 'TimesheetService', 'MasterEntityService', function($scope, TimesheetService, MasterEntityService) {
	/*
	var self = this;
	self.timesheet;
	self.projectList=[];
	
	// ----- Get All Projects -----
    self.getAllProjects = function(){
    	MasterEntityService.getAllProjects()
            .then(
					       function(d) {
						        self.projectList = d;
					       },
      					function(errResponse){
      						console.error('Error while fetching Project List');
      					}
			       );
    };
    
    self.addTimesheet = function() {
    	
    	TimesheetService.addTimesheet(self.timesheet)
        .then(
  		  function(d) {
			        alert('Timesheet added successfully');			        
			        self.resetForm();
		       },
			function(errResponse){
				console.error('Error while adding Timesheet');
			}	
        );
    };
    
    self.resetForm = function() {
    	
    	self.timesheet = {};
    	$scope.addTimesheetForm.$setPristine();
    	$scope.addTimesheetForm.$setValidity();
    	$scope.addTimesheetForm.$setUntouched();
    };
    
    self.getAllProjects();
    */	
}]);