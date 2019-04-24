
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Users</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/MyStyle.css">

    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <%@include file="../WEB-INF/header.jsp"%>
    <!-- Left side column. contains the logo and sidebar -->
    <%@include file="../WEB-INF/saidbar.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Add New User
                <small>New User</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Quick Example</h3>
                </div>
                <!-- /.box-header -->
                <div class="error-message" id="err">

                </div>
                <!-- form start -->
                <form role="form" action="Users" method="post" id="frmUser">
                    <input type="hidden" name="UserID" value="${user.userID}">
                    <input type="hidden" name="LngLat" id="txtLngLat" value="${user.lngLat}">
                    <input type="hidden" id="UserTypeID" value="${user.userTypeId}">

                    <div class="box-body">
                        <div class="form-group">
                            <label for="txtName">Name</label>
                            <input type="text" name="Name" value="${user.name}" class="form-control" id="txtName" placeholder="Enter Name">
                        </div>
                        <div class="form-group">
                            <label for="txtUserName">User Name</label>
                            <input type="text" class="form-control" value="${user.userName}" name="UserName" id="txtUserName" placeholder="Enter user name">
                        </div>
                        <div class="form-group">
                            <label for="txtPassword">Password</label>
                            <input type="password" name="Password" value="${user.password}" class="form-control" id="txtPassword" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="txtEmail">Email</label>
                            <input type="email" name="Email" value="${user.email}" class="form-control" id="txtEmail" placeholder="Enter Email">
                        </div>
                        <div class="form-group">
                            <label for="txtPhone">Phone</label>
                            <input type="tel" name="Phone" value="${user.phone}" class="form-control" id="txtPhone" placeholder="Enter Phone">
                        </div>
                        <div class="form-group">
                            <label for="txtAddress">Address</label>
                            <input type="text" name="Address" value="${user.address}" class="form-control" id="txtAddress" placeholder="Enter Address">
                        </div>
                        <div class="form-group">
                            <label >Drop on User Location</label>
                            <div id="map"></div>
                        </div>
                        <div class="form-group">
                            <label for="slUserType">User Type</label>
                            <select id="slUserType" class="form-control" name="UserType">
                                <option value="-1" selected>Select User Type</option>
                                <option value="0" >Admin</option>
                                <option value="2" >Project Manager</option>
                                <option value="1" >Developer</option>
                            </select>

                        </div>

                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <%@include file="../WEB-INF/footer.jsp"%>


    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>

<!-- Our Scripts-->
<script src="javaScript/Users/addUser.js"></script>
<script src="javaScript/Users/userMap.js"></script>
<!-- Google Map App -->

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB0nRzrffPIPFK_cTfX0vLpVb4yR7PNKzw&callback=initMap"
        async defer></script>