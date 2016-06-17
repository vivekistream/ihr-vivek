'use strict';

angular.module('ihr', [
  'ngRoute',
  'ihr.home',
  'ihr.addEmployee',
  'ihr.employee',
  'ihr.employeeDetail',
  'ihr.editEmployee',
  'ihr.master',
  'ihr.addTimesheet',
  'ihr.timesheet',
  'ihr.client',
  'ihr.healthInsurance',
  'ihr.project',
  'ihr.employeeTimesheet'
  /*,
  'ihr.timesheetDetail'
  */
])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/home'});
}]);
