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
<body>
<div class="Register_Menu" id="registerMenu" style="padding-top: 77px">
    <h4 style="padding-left: 595px">
        <pre style="width: 200px; text-align: center">Register Form</pre>
    </h4>
    <br>

    <form style="padding-left: 600px" action="/users/add" , method="get">

        <div class="input-group">
            First Name
            <div class="input-group">
                <input type="text" id="firstName" name="firstName" maxlength="50"
                       placeholder="First Name" class="form-control" ng-model="user.firstName">
            </div>
        </div>
        <div class="input-group">
            Email
            <div class="input-group">
                <input type="email" name="email" maxlength="50" id="email"
                       placeholder="Email" class="form-control" ng-model="user.email">
            </div>
        </div>

        <div class="input-group">
            Mobile
            <div class="input-group">
                <input type="tel" name="mobile" maxlength="50" id="mobile"
                       placeholder="Mobile" class="form-control" ng-model="user.mobile">
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
                <button type="submit" class="btn">Ok</button>
                <button type="reset" class="btn">Reset</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
