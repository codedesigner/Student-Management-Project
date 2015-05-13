angular.module('studentApp', ['ui.router', 'ngResource', 'studentApp.controllers', 'studentApp.services']);

angular.module('studentApp').config(function($stateProvider) {
    $stateProvider.state('students', {
        url: '/students',
        templateUrl: 'partials/students.html',
        controller: 'StudentListController'
    }).state('viewStudent', {
        url: '/students/:id/view',
        templateUrl: 'partials/student-view.html',
        controller: 'StudentViewController'
    }).state('newStudent', {
        url: '/students/new',
        templateUrl: 'partials/student-add.html',
        controller: 'StudentCreateController'
    }).state('editStudent', {
        url: '/students/:id/edit',
        templateUrl: 'partials/student-edit.html',
        controller: 'StudentEditController'
    });
}).run(function($state) {
    $state.go('students'); //make a transition to movies state when app starts
});