(function() {
'use strict';

    angular
        .module('MainApp')
        .factory('JobService', JobService);

    JobService.$inject = ['$http', '$q', '$rootScope'];
    function JobService($http, $q, $rootScope) {
        var BASE_URL = 'http://localhost:10080/collaboration-restbackend/job/';
        var service = {};
        
        service.getAllJobs = getAllJobs;
        service.getJob = getJob;
        service.createJob = createJob;
        service.updateJob = updateJob;
        service.applyJob = applyJob;
        service.getAppliedJobs = getAppliedJobs;

        function getAllJobs() {
            return $http.get(BASE_URL).then(
                function(response) {
                    return response.data;
                },
                function(errResponse) {
                    return $q.reject(errResponse);
                }
            );
        }

        function getJob(jobId) {
            return $http.get(BASE_URL + jobId).then(
                function(response) {
                	$rootScope.selectedJob = response.data;
                    return response.data;
                },
                function(errResponse) {
                    return $q.reject(errResponse);
                }
            );
        }

        function createJob(Job) {
            return $http.post(BASE_URL, Job).then(
                getAllJobs,
                function(errResponse) {
                    return $q.reject(errResponse);
                }
            );
        }

        function updateJob(Job) {
            return $http.put(BASE_URL + Job.jobId, Job).then(
                getAllJobs,
                function(errResponse) {
                    return $q.reject(errResponse);
                }
            );
        }

        function applyJob(jobId) {
            return $http.post(BASE_URL + 'apply/' + jobId).then(
                function(response) {
                    return response.data;
                },
                function(errResponse) {
                    return $q.reject(errResponse);
                }
            );
        }
        
        function getAppliedJobs() {
        	return $http.get(BASE_URL + 'applied/').then(
        		function(response) {
        			console.log(response.data);
        			return response.data;
        		},
        		function(errResponse) {
        			return $q.reject(errResponse);
        		}
        	);
        }
        
        return service;
    }
})();