<%--
  Created by IntelliJ IDEA.
  User: Karim
  Date: 22/04/2019
  Time: 02:20:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Teams</title>


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
                Teams
                <small>All Teams</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
            <div>
                <a href="Teams?addNewTeam=true" class="btn btn-block btn-primary newElement">Add New Team</a>
            </div>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Striped Full Width Table</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body no-padding">
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <th style="width: 10px">#</th>
                            <th>Team Name</th>
                            <th>Project Name</th>
                            <th>Developer Nums</th>

                            <th>Settings</th>
                        </tr>
                        <c:forEach var="item" items="${teams}">
                            <tr>
                                <td>${item.teamId}</td>
                                <td>${item.teamName}</td>
                                <td>${item.projectName}</td>
                                <td>${item.developerNums}</td>
                                <td>
                                    <div class="col-md-3"><a href="Teams?updateTeam=${item.teamId}" class="btn btn-block btn-primary newElement">Update Team</a>
                                    </div>
                                    <div class="col-md-3"><a data-id="${item.teamId}"  class="btn btn-block btn-primary newElement deleteBtn">Delete Team</a>
                                    </div>

                                    <div class="col-md-3"><a data-id="${item.teamId}"  class="btn btn-block btn-primary newElement mapBtn" data-toggle="modal" data-target="#myModal">Show Team Locations</a>
                                    </div>

                                </td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
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

<script src="javaScript/Teams/Teams.js"></script>
<script src="javaScript/Teams/teamMap.js"></script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB0nRzrffPIPFK_cTfX0vLpVb4yR7PNKzw&callback=initMap"
        async defer></script>



<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">


                <div id="map"></div>


                <%--<script async defer--%>
                        <%--src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB0nRzrffPIPFK_cTfX0vLpVb4yR7PNKzw&callback=initMap">--%>

                <%--</script>--%>




            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>





</body>
</html>
