<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<style>

</style>
<head>
    <title>${username}>
    </title>
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
<body ng-controller="userOrdersController" ng-init="getOrderBook()">
<div>
<span style="padding-left: 500px"> Welcome to <b>
    ${username}
</b>
    </span>
    <a href="/users" style="padding-left: 50px">Back</a>
    <a href="/logout" style="padding-left: 50px">Log out</a>
</div>
<div id="Main" style="padding-left: 120px">
    <div id="table">
        <nav class="navbar navbar-default" id="id_navbar-default">
            <div class="container-fluid">
                <div class="navbar-header" id="id_navbar_header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-2" aria-expanded="false"><span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapset navbar-collapse" id="bs-example-navbar-collapse-2">
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group" id="#id_form_group" style="padding-left: 150px">
                            <input type="text" class="form-control" placeholder="Search" id="search"
                                   ng-model="searchText"
                                   autocomplete="off">
                        </div>
                    </form>
                </div>
            </div>
        </nav>
        <table id="tableEmployee" class="table table-striped table-bordered table-hover dataTable no-footer">
            <thead>
            <tr class="gradeA even">
                <th style="text-align: center">Id</th>
                <th style="text-align: center">Name</th>
                <th style="text-align: center">Author</th>
                <th style="text-align: center">Language</th>
                <th style="text-align: center">Genre</th>
                <th style="text-align: center">Publish Date</th>
                <th style="text-align: center">Order Count</th>
                <th style="text-align: center">Remove</th>
            </tr>
            </thead>

            <tbody id="tbodyId">
            <tr ng-repeat="contact in contacts | filter: searchText">
                <td ng-bind="contact.id"></td>
                <td ng-bind="contact.name"></td>
                <td ng-bind="contact.author.firstName"></td>
                <td ng-bind="contact.language"></td>
                <td ng-bind="contact.genre.name"></td>
                <td ng-bind="contact.created_date"></td>
                <td ng-bind="contact.order_count" id='" + contact.Book.order_count + "'></td>
                <td>
                    <span class="glyphicon glyphicon-remove" ng-click="removeOrderBook(contact.id)"
                          style="cursor: pointer;" id='" + contact.Book.id + "'></span>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script>
    angular.module('myapp', []).controller("userOrdersController", function ($scope, $http) {
        $scope.contacts = [];
        $scope.getOrderBook = function () {
            $http({
                url: '/books/getBookOfUser'
            }).success(function (data) {
                $scope.contacts = data;
                console.log(data);
            })
        };
        $scope.removeOrderBook = function (id) {
            $http({
                url: '/books/removeOneBook',
                method: 'POST',
                params: {
                    id: id
                }
            }).success(function (data) {
                angular.reloadWithDebugInfo();
                console.log(data);
            })
        }
    });

    angular.bootstrap(document.body, ['myapp']);
</script>
</body>
</html>