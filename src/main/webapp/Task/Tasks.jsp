<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 4/22/2019
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Tasks</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
          name="viewport">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
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
    <%@include file="../WEB-INF/header.jsp" %>
    <!-- Left side column. contains the logo and sidebar -->
    <%@include file="../WEB-INF/saidbar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Tasks
                <small>All tasks</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
            <div>
                <a href="Tasks?addNewTask=true" class="btn btn-block btn-primary newElement">Add New
                    Task</a>
            </div>
            <div class="box">
                <div class="box-header">
                    <h3 id="box-title" class="box-title">User Tasks</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body no-padding">
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <th style="width: 10px">#</th>
                            <th>Task Category</th>
                            <th>Task Name</th>
                            <th>Assigned User</th>
                            <th>Due Date</th>
                            <th>Priority</th>
                            <th>Completed</th>
                            <th>Completed Date</th>
                            <th>Comments</th>
                            <th></th>
                        </tr>
                        <c:forEach var="item" items="${userTasks}">
                            <tr>
                                <td>${item.taskId}</td>
                                <td>${item.category.categoryName}</td>
                                <td>${item.taskDesc}</td>
                                <td>${item.user.userName}</td>
                                <td>${item.dueDate}</td>
                                <td>${item.priority.name}</td>
                                <td>
                                    <div class="col-md-2">
                                        <input type="checkbox" name="${item.completed}" value="${item.completed}" ${item.isChecked} disabled>
                                    </div>

                                    <c:if test="${item.showCompleted}">
                                        <div class="col-md-9">
                                            <a href="#" data-id="${item.taskId}" class="btn btn-block btn-primary newElement">Completed</a>
                                        </div>
                                    </c:if>
                                </td>
                                <td>${item.completedDate}</td>
                                <td>${item.remarks}</td>
                                <td>
                                    <c:if test="${item.showCompleted}">
                                        <div class="col-md-6"><a href="Tasks?updateTask=${item.taskId}" class="btn btn-block btn-primary newElement">Update Task</a>
                                        </div>
                                        <div class="col-md-6"><a href="#" data-id="${item.taskId}"  class="btn btn-block btn-primary newElement deleteBtn">Delete Task</a>
                                        </div>
                                    </c:if>
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
    <%@include file="../WEB-INF/footer.jsp" %>


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

<script src="javaScript/Tasks/tasks.js"></script>

</body>
</html>
