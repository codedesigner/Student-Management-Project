angular.module('studentApp.controllers', [])
    .controller('StudentListController',
        function($scope, $state, popupService, $window, Student) {
            $scope.student = Student.query();
            $scope.deleteStudent = function(student) {
                student.$delete(function() {
                    $window.location.href = '';
                });
            }
        };
}).controller('StudentViewController',
    function($scope, $stateParams, Student) {
        $scope.student = Student.get({
            id: $stateParams.id
        });
    }).controller('StudentCreateController',
    function($scope, $state, $stateParams, Student) {
        $scope.student = new Student();

        $scope.addStudent = function() {
            $scope.student.$save(function() {
                $state.go('students');
            });
        };
    }).controller('StudentEditController',
    function($scope, $state, $stateParams, Student) {
        $scope.updateStudent = function() {
            $scope.student.$update(function() {
                $state.go('students');
            });
        };

        $scope.loadStudent = function() {
            $scope.student = Student.get({
                id: $stateParams.id
            });
        };

        $scope.loadStudent();
    });