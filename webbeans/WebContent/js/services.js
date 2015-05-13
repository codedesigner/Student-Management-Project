angular.module('studentApp.services', []).factory('Student', function($resource) {
    return $resource('http://localhost:8080/webbeans/StudentServlet', {
        id: '@_id'
    }, {
        update: {
            method: 'PUT'
        }
    });
});