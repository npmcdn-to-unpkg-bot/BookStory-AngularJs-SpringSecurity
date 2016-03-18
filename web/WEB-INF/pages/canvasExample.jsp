<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="assets/html2canvas.js"></script>
    <script src="assets/html2canvas.svg.js"></script>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/assets/bower_components/angularjs/angular.js"
            type="application/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/bower_components/jquery/dist/jquery.js"
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
<style>

</style>
<body>
<img src="assets/images/data2.png">
<br>
<button id="scan" onclick="myClick()" class="btn">Click me</button>
<script>
    function myClick() {
        console.log('click');
        html2canvas(document.body, {
            onrendered: function (canvas) {
                var box = bootbox.dialog({
                    title: '<h2 class="fixCenter" id="bugName"> Send Bug form</h2> <br>' +
                    '<textarea placeholder="Description" id="bug"> </textarea>',
                    animate: true,
                    message: 'salom',
                    buttons: [{
                        label: 'cancel',
                        callback: function () {
                        }
                    },
                        {
                            label: 'ok',
                            callback: function () {
                            }
                        }]
                });
                box.bind('shown.bs.modal', function () {
                    box.find("input").focus();
                });
            }
        })
    }
</script>
</body>
</html>

