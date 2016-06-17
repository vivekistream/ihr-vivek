'use strict';

angular.module('ihr.timesheet', [])

.factory('TimesheetService', [ '$http', '$q', function($http, $q) {

	return {
		
		addTimesheet: function(timesheet){
			return $http.post('../iHR/api/timesheet/', timesheet)
					.then(
							function(response){
								return response.data;
							}, 
							function(errResponse){
								console.error('Error while add timesheet');
								return $q.reject(errResponse);
							}
					);
		}
	};

} ]);