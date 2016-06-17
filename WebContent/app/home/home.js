'use strict';

angular.module('ihr.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
	console.log('Inside Routeprovider');	
 
	$routeProvider.when('/home', {
	    templateUrl: 'app/home/home.html',
	    controller: 'HomeCtrl'
	 });
	
}])

.controller('HomeCtrl', ['$scope','$rootScope', /*'HomeService',*/ function($scope,$rootScope/*,HomeService*/) {
	/*
	this.loadUserProfile = function() {
		console.log('Inside HomeController');
		HomeService.loadUserProfile().then(
			       function(data) {
				        $rootScope.userProfile = data;
				        console.log('Inside HomeController: User Profile Success');
			       },
					function(errResponse){
						console.error('Error while fetching Currencies');
					}
	       );
	};
	
	if(!$rootScope.userProfile) {
		this.loadUserProfile();
	}
	*/
	
}])

/*
.factory('HomeService', ['$http', '$q','$location', function($http, $q,$location){
	return {
		
		loadUserProfile: function() {
			console.log('Inside HomeService');
			var pathUri = ""+$location.absUrl();
			var codeIndex = pathUri.indexOf("code=");
			var code = pathUri.substring(codeIndex+5,pathUri.indexOf("#/"));
			console.log('Code on URL'+code);
				return  $http({
				        method : "GET",
				        url : "/iHRWeb/api/userProfile"
				    }).then(
								function(response){
									console.log('Inside Service:Sucess'+response.data);
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while fetching users');
									return $q.reject(errResponse);
								}
						);
		}
	}
		
}])
*/
;