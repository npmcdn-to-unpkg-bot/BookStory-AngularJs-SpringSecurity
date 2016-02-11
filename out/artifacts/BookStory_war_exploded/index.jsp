<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
  <title>Registration Page</title>
  <link href="assets/css/style.css" rel="stylesheet" type="text/css">
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
<body onload="listEmployee()">
<div id="Main">

  <div class="Register_Menu" id="registerMenu">
    <h4>
      <b>REGISTRATION FORM</b>
    </h4>
    <br>

    <form>
      <input type="text" id="hideId" name="hideId" hidden>

      <div class="input-group">
        First Name
        <div class="input-group">
          <input type="text" id="firstName" name="firstName" maxlength="10"
                 placeholder="First Name" class="form-control">
        </div>
      </div>
      <div class="input-group">
        Last Name
        <div class="input-group">
          <input type="text" name="lastName" maxlength="10" id="lastName"
                 placeholder="Last Name" class="form-control">
        </div>
      </div>
      <div class="input-group">
        Mobile
        <div class="input-group">
          <input type="tel" name="mobile" maxlength="15" id="mobile"
                 placeholder="Ex : 99894...." class="form-control">
        </div>
      </div>
      <div class="input-group">
        E-mail
        <div class="input-group">
          <input type="email" autocomplete="off" maxlength="20" id="email"
                 placeholder="bahodir9293@gmail.com" class="form-control">
        </div>
      </div>
      <div class="input-group">
        Password
        <div class="input-group">
          <input type="password" autocomplete="off" id="password"
                 size="10" class="form-control"/>
        </div>
      </div>
      <div class="input-group">
        State
        <div class="input-group">
          <input type="text" id="state" name="state" placeholder="State" class="form-control" size="10">
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
            <div class="form-group" id="#id_form_group">
              <select class="form-control" id="mySelect">
                <option>5</option>
                <option>10</option>
                <option>50</option>
                <option>100</option>

                <input type="text" class="form-control" placeholder="Search" id="search"
                       autocomplete="off" oninput="getOfflineData()">
              </select>

            </div>
          </form>
        </div>
      </div>
    </nav>
    <table id="tableEmployee" class="table table-striped table-bordered table-hover dataTable no-footer">
      <thead>
      <tr class="gradeA even">
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Mobile</th>
        <th>Email</th>
        <th>State</th>
        <th>Edit</th>
        <th>Delete</th>
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

<script src="assets/js/site.js" type="application/javascript"></script>
</body>
</html>