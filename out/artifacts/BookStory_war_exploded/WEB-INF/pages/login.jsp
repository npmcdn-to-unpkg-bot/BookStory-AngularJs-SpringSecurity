<%--
  Created by IntelliJ IDEA.
  User: dexter
  Date: 2/12/16
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/assets/bower_components/angularjs/angular.js"
            type="application/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/bower_components/jquery/jquery.js"
            type="application/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/js/bootstrap.js"
            type="application/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"
            type="application/javascript"></script>
    <link href="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/css/bootstrap.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/css/bootstrap-theme.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/css/bootstrap.min.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/css/bootstrap-theme.min.css"
          rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/assets/bower_components/bootbox/boot.js"
            type="application/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/bower_components/bootbox/bootbox.js"
            type="application/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/bower_components/bootbox/bootbox.min.js"
            type="application/javascript"></script>
</head>
<body ng-controller="userController">
<div class="Register_Menu" id="registerMenu" style="padding-top: 77px">
    <h4 style="padding-left: 595px">
        <pre style="width: 200px; text-align: center">Register Form</pre>
    </h4>
    <br>

    <form style="padding-left: 600px">

        <div class="input-group">
            Email
            <div class="input-group">
                <input type="tel" name="email" maxlength="50" id="email"
                       placeholder="Email" class="form-control" ng-model="user.email">
            </div>
        </div>

        <div class="input-group">
            Password
            <div class="input-group">
                <input type="password" name="password" maxlength="50" id="password"
                       placeholder="Password" class="form-control" ng-model="user.password">
            </div>
        </div>
        <br>
        <br>

        <div class="input-group" id="id_form_click">
            <div class="controls">
                <button type="button" class="btn" ng-click="checkLogin(user)">Ok</button>
                <button type="reset" class="btn">Reset</button>
            </div>
        </div>
    </form>
</div>
<script>
    angular.module('myapp', []).controller('userController', function ($scope, $http) {
        $scope.contacts = [];
        $scope.checkLogin = function (user) {
            console.log(user);
            $http({
                url : '/users/check',
                method : 'GET',
                params : user
            }).then(function successCallback(response) {
                console.log('success');
            }, function errorCallBack(response) {
                console.log(response);
            });
        }
    });
    angular.bootstrap(document, ['myapp']);
</script>
</body>
</html>
