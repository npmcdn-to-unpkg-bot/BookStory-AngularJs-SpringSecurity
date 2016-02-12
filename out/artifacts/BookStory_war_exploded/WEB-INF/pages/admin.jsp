<%@ page contentType="text/html;charset=UTF-8" %>
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
<div id="Main">

    <div class="Register_Menu" id="registerMenu">
        <h4>
            <b>Admin Panel</b>
        </h4>
        <br>

        <form>
            <input type="text" id="hideId" name="hideId" hidden>

            <div class="input-group">
                Name of book
                <div class="input-group">
                    <input type="text" id="name" name="Name" maxlength="50"
                           placeholder="Name of book" class="form-control">
                </div>
            </div>
            <div class="input-group">
                Publish Date
                <div class="input-group">
                    <input type="text" name="publishDate" maxlength="10" id="publishDate"
                           placeholder="Publish Date" class="form-control">
                </div>
            </div>
            <div class="input-group">
                Language
                <div class="input-group">
                    <input type="text" name="language" maxlength="15" id="language"
                           placeholder="Input language of book" class="form-control">
                </div>
            </div>
            <div class="input-group">
                Select Author
                <div class="input-group">
                    <select class="form-control" style="width: 194px">
                        <option>Bahodir</option>
                        <option>Javohir</option>
                        <option>Zafar</option>
                        <option>Bekzod</option>
                    </select>
                </div>
            </div>

            <div class="input-group">
                Or Create Author
                <div class="input-group" style="padding-left: 36px">
                    <input type="button" value="create" class="btn" style="width: 111px">
                </div>
            </div>

            <div class="input-group">
                Select Genre
                <div class="input-group">
                    <select class="form-control" style="width: 194px">
                        <option>Comedy</option>
                        <option>Horror</option>
                        <option>Carton</option>
                    </select>
                </div>
            </div>
            <div class="input-group">
                Or Create Genre
                <div class="input-group" style="padding-left: 36px">
                    <input type="button" value="create" class="btn" style="width: 111px">
                </div>
            </div>

            <br>
            <br>

            <div class="input-group" id="id_form_click">
                <div class="controls">
                    <button type="button" class="btn" onclick="saveEmployee()">Ok</button>
                    <button type="reset" class="btn">Reset</button>
                </div>
            </div>
        </form>
    </div>
    <div id="table">
        <div class="alert alert-success" id="aler" hidden>
            <strong>Success </strong> data saved ...!
        </div>
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
                        <div class="form-group" id="#id_form_group" style="padding-left: 77px">
                            <input type="text" class="form-control" placeholder="Search" id="search"
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
            <tr>
            </tr>
            </tbody>
        </table>

        <div class="div-page">
            <input type="button" id="addButton" name="Add" value="Add" class="btn">
        </div>
    </div>
</div>
</body>
</html>