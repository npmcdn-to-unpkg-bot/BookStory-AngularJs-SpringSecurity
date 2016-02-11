/**
 * Created by dexter on 2/10/16.
 */
var data = new Map();
$('#addButton').click(function () {
    $('#registerMenu').toggle(1000);
});

function saveEmployee() {
    var hideId = $('#hideId').val();
    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var mobile = $('#mobile').val();
    var email = $('#email').val();
    var password = $('#password').val();
    var state = $('#state').val();
    if (firstName == "" || lastName == "" || mobile == "" || email == "" || password == "" || state == "") {
        alert("Fill the all area...!");
    }
    else {
        $('#load').show();
        $.ajax({
            url: "/employee/add",
            type: "POST",
            data: {
                hideId: hideId,
                firstName: firstName,
                lastName: lastName,
                mobile: mobile,
                email: email,
                password: password,
                state: state
            },
            success: function (response) {

                console.log(response);
                if (response.id != hideId) {
                    var app = "'<tr id=" + response.id + ">" + response.id +
                        "<td>" + response.id + "</td>" +
                        "<td>" + response.firstName + "</td>" +
                        "<td>" + response.lastName + "</td>" +
                        "<td>" + response.mobile + "</td>" +
                        "<td>" + response.email + "</td>" +
                        "<td>" + response.state + "</td>" +
                        "<td>" + "<a class='glyphicon glyphicon-pencil' href='#' id='" + response.id + "' onclick='getEmployee(" + response.id + ")'>" + "</a>" + "</td>" +
                        "<td>" + "<a class='glyphicon glyphicon-remove' href='#' id='" + response.id + "' onclick='deleteEmployee(" + response.id + ")'>" + "</a>" + "</td>" +
                        "</tr>'";
                    $('#tableEmployee tbody').append(app);
                    data.set(response.id, response);
                    $('#aler').fadeIn(2000).fadeOut(2000);
                    $('#registerMenu form')[0].reset();
                    $('.page').remove();
                    $('#load').hide();
                }
                else {
                    var allTd = $('table tbody tr#' + response.id + " td");
                    allTd.eq(0).html(response.id);
                    allTd.eq(1).html(response.firstName);
                    allTd.eq(2).html(response.lastName);
                    allTd.eq(3).html(response.mobile);
                    allTd.eq(4).html(response.email);
                    allTd.eq(5).html(response.state);
                    data.set(response.id, response);
                    $('#registerMenu form')[0].reset();
                    $('#aler').fadeIn(2000).fadeOut(2000);
                    $('#load').hide();
                }
            }
        })
    }
}
function listEmployee() {
    $('table tbody tr').remove();
    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var mobile = $('#mobile').val();
    var email = $('#email').val();
    var password = $('#password').val();
    var state = $('#state').val();
    $('#load').show();
    $.ajax({
        url: '/employee/allList',
        data: 'POST',
        success: function (response) {
            var obj = JSON.parse(response);
            console.log(obj);
            $.each(obj, function (key, value) {
                data.set(value.id, value);
                var app = "'<tr id=" + value.id + ">" + value.id +
                    "<td>" + value.id + "</td>" +
                    "<td>" + value.firstName + "</td>" +
                    "<td>" + value.lastName + "</td>" +
                    "<td>" + value.mobile + "</td>" +
                    "<td>" + value.email + "</td>" +
                    "<td>" + value.state + "</td>" +
                    "<td>" + "<a class='glyphicon glyphicon-pencil' href='#' id='" + value.id + "' onclick='getEmployee(" + value.id + ")'>" + "</a>" + "</td>" +
                    "<td>" + "<a class='glyphicon glyphicon-remove' href='#' id='" + value.id + "' onclick='deleteEmployee(" + value.id + ")'>" + "</a>" + "</td>" +
                    "</tr>'";
                $('#tableEmployee tbody').append(app);
            });
            $('#load').hide();
            console.log("data online...");
        },
        error: function (error) {
            alert(error);
            $('#load').hide();
        }
    })
}

function deleteEmployee(id) {
    var hideId = $('#hideId').val();
    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var mobile = $('#mobile').val();
    var email = $('#email').val();
    var password = $('#password').val();
    var state = $('#state').val();
    $('#load').show();
    bootbox.confirm({
        size: 'small',
        message: "Are you sure…",
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: '/employee/delete',
                    type: 'POST',
                    data: {
                        id: id
                    },
                    success: function (response) {
                        data.delete(id);
                        console.log(response);
                        $('#' + id).remove();
                        $('#load').hide();
                        $('.page').remove();
                        $('#registerMenu form')[0].reset();
                    },
                    error: function (error) {
                        alert("Error: " + error);
                        $('#load').hide();
                    }
                })
            }
            else {
                $('#load').hide();
            }
        }
    });
}

function getEmployee(id) {
    $('#load').show();
    console.log(id);
    $.ajax({
        url: '/employee/getElementById',
        type: 'POST',
        data: {
            id: id
        },
        success: function (obj) {
            $('#hideId').val(obj.id);
            $('#firstName').val(obj.firstName);
            $('#lastName').val(obj.lastName);
            $('#mobile').val(obj.mobile);
            $('#email').val(obj.email);
            $('#state').val(obj.state);
            $('#load').hide();
        },
        error: function (error) {
            alert("Error: " + error);
            $('#load').hide();
        }
    });
}

function getOnlineData() {
    $('table tbody tr').remove();
    var text = $('#search').val();
    var test = false;
    $('.page').remove();

    if (text.length > 0) {
        $('#load').show();
        $.ajax({
            url: '/employee/getSearchEmployees',
            type: 'POST',
            data: {
                text: text
            },
            success: function (result) {
                var obj = JSON.parse(result);
                alert(typeof obj == 'object');
                if (typeof obj == 'object') {
                    $.each(obj, function (key, value) {
                        var app = "'<tr id=" + value.id + ">" + value.id +
                            "<td>" + value.id + "</td>" +
                            "<td>" + value.firstName + "</td>" +
                            "<td>" + value.lastName + "</td>" +
                            "<td>" + value.mobile + "</td>" +
                            "<td>" + value.email + "</td>" +
                            "<td>" + value.state + "</td>" +
                            "<td>" + "<a class='glyphicon glyphicon-pencil' href='#' id='" + value.id + "' onclick='getEmployee(" + value.id + ")'>" + "</a>" + "</td>" +
                            "<td>" + "<a class='glyphicon glyphicon-remove' href='#' id='" + value.id + "' onclick='deleteEmployee(" + value.id + ")'>" + "</a>" + "</td>" +
                            "</tr>'";
                        $('#tableEmployee tbody').append(app);
                        test = true;
                        $('#load').hide();
                    });
                }
                else {
                    console.log('employee not found...');
                    $('#load').hide();
                }
            },
            error: function (error) {
                alert('error ' + error);
                $('#load').hide();
            }
        });
        if (!test) {
            $('#load').hide();
        }
    }
    else {
        getOfflineData();
    }
}

function getOfflineData() {
    $('table tbody tr').remove();
    var tex = $('#search').val();
    var bol = false;
    if (tex.length > 0) {
        $('#load').show();
        var c = 0;
        console.log(data);
        data.forEach(function (value, key) {
            var searchText = data.get(key);
            var firstName = searchText.firstName;
            var lastName = searchText.lastName;
            var mobile = searchText.mobile;
            var email = searchText.email;
            var state = searchText.state;
            if (firstName.toLowerCase().indexOf(tex.toLowerCase()) > -1
                || lastName.toLowerCase().indexOf(tex.toLowerCase()) > -1
                || mobile.toLowerCase().indexOf(tex.toLowerCase()) > -1
                || email.toLowerCase().indexOf(tex.toLowerCase()) > -1
                || state.toLowerCase().indexOf(tex.toLowerCase()) > -1) {
                bol = true;
                var app = "'<tr id=" + value.id + ">" + value.id +
                    "<td>" + value.id + "</td>" +
                    "<td>" + value.firstName + "</td>" +
                    "<td>" + value.lastName + "</td>" +
                    "<td>" + value.mobile + "</td>" +
                    "<td>" + value.email + "</td>" +
                    "<td>" + value.state + "</td>" +
                    "<td>" + "<a class='glyphicon glyphicon-pencil' href='#' id='" + value.id + "' onclick='getEmployee(" + value.id + ")'>" + "</a>" + "</td>" +
                    "<td>" + "<a class='glyphicon glyphicon-remove' href='#' id='" + value.id + "' onclick='deleteEmployee(" + value.id + ")'>" + "</a>" + "</td>" +
                    "</tr>'";
                $('#tableEmployee tbody').append(app);
                c++;
            }
            $('#load').hide();
        });
        $('.page').remove();
        if (!bol) {
            getOnlineData();
            console.log("data online");
        }
    }
    else {
        $('#load').show();
        $('table tbody tr').remove();
        data.forEach(function (value, key) {
            var app = "'<tr id=" + value.id + ">" + value.id +
                "<td>" + value.id + "</td>" +
                "<td>" + value.firstName + "</td>" +
                "<td>" + value.lastName + "</td>" +
                "<td>" + value.mobile + "</td>" +
                "<td>" + value.email + "</td>" +
                "<td>" + value.state + "</td>" +
                "<td>" + "<a class='glyphicon glyphicon-pencil' href='#' id='" + value.id + "' onclick='getEmployee(" + value.id + ")'>" + "</a>" + "</td>" +
                "<td>" + "<a class='glyphicon glyphicon-remove' href='#' id='" + value.id + "' onclick='deleteEmployee(" + value.id + ")'>" + "</a>" + "</td>" +
                "</tr>'";
            $('#tableEmployee tbody').append(app);
            $('.page').remove();
            $('#load').hide();
            console.log("offline data...");
        });
    }
}