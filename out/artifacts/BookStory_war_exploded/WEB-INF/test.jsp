<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<script>
    var app = angular.module('app', [
        'ngRoute'
    ]);
    app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {
                    templateUrl: '../index.jsp',
                    controller: 'bookController'
                })
                .when("/login", {
                    templateUrl: 'pages/login.jsp',
                    controller: 'myController'
                })
                .when('/admin', {
                    templateUrl: 'pages/admin.jsp',
                    controller: 'bookController'
                });
    }]);

    angular.bootstrap(document, ['app']);
</script>
</body>
</html>
