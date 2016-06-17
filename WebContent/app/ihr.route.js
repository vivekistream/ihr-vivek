'use strict';

var ihrApp = angular.module('ihr', [ 'ngRoute' ]);

ihrApp.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/home', {
		templateUrl : 'app/home/home.html',
		controller : 'HomeCtrl'
	})

	.otherwise({
		redirectTo : '/home'
	});

} ]);