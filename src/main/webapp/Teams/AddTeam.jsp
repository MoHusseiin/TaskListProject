<%--
  Created by IntelliJ IDEA.
  User: Karim
  Date: 22/04/2019
  Time: 02:20:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
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
<body>


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
                Add New Team
                <small>New Team</small>
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
                <form role="form" action="Teams" method="post" id="frmTeam">
                    <input type="hidden" name="teamId" value="${team.teamId}">

                    <div class="box-body">
                        <div class="form-group">
                            <label for="txtTeamName">Team Name</label>
                            <input type="text" class="form-control" value="${team.teamName}" name="teamName" id="txtTeamName" placeholder="Enter team name">
                        </div>
                        <div class="form-group">
                            <label for="txtProjectName">Project Name</label>
                            <input type="text" class="form-control" value="${team.projectName}" name="projectName"  id="txtProjectName" placeholder="Enter project name">
                        </div>

                        <div class="form-group">
                            <label for="slTeamUsers">Developer</label>
                            <select id="slTeamUsers" class="form-control" name="teamUserIds" multiple>

                                <%--<option value="" selected>Select User Type</option>--%>
                                <%--<option value="0" >Admin</option>--%>
                                <%--<option value="2" >Project Manager</option>--%>
                                <%--<option value="1" >Developer</option>--%>

                                <c:forEach var="item" items="${users}">

                                        <option value='${item.userID}'> ${item.userName}</option>

                                </c:forEach>


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


<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- Our Scripts-->

<script src="javaScript/Teams/addTeam.js"></script>



</body>
</html>
