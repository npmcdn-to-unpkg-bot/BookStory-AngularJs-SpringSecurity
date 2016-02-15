<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title><%= request.getSession().getAttribute("username") %>
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
<body ng-controller="bookController" ng-init="allList()">
<div>
<span style="padding-left: 600px"> Welcome to <b>
    <%= request.getSession().getAttribute("username")%>
</b>
    </span>
    <a href="/logout" style="padding-left: 300px">Order List</a>

    <a href="/orders" style="padding-left: 25px">Log Out</a>
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
                <th style="text-align: center">Order</th>
            </tr>
            </thead>

            <tbody id="tbodyId">
            <tr ng-repeat="contact in contacts | filter: searchText">
                <td ng-bind="contact.Book.id"></td>
                <td ng-bind="contact.Book.name"></td>
                <td ng-bind="contact.Book.author.firstName"></td>
                <td ng-bind="contact.Book.language"></td>
                <td ng-bind="contact.Book.genre.name"></td>
                <td ng-bind="contact.Book.created_date"></td>
                <td ng-bind="contact.Book.order_count" id='" + contact.Book.order_count + "'></td>
                <td>
                    <span class="glyphicon glyphicon-saved" ng-click="orderBook(contact.Book.id)"
                          style="cursor: pointer;" id='" + contact.Book.id + "'></span>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script>
    angular.module('myapp', []).controller('bookController', function ($scope, $http) {
        $scope.contacts = [];
        $scope.allList = function () {
            $http.get('/books/allList').success(function (data) {
                $scope.contacts = data;
                console.log($scope.contacts);
            })
        };
        $scope.orderBook = function (id) {
            $http({
                url: '/books/order',
                params: {
                    id: id
                },
                method: 'POST'
            }).success(function (data) {
                console.log(data);
                angular.reloadWithDebugInfo();
            })
        }
    });
    angular.bootstrap(document, ['myapp']);
</script>
</body>
</html>