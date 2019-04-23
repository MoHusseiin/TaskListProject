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
            <div id="headerText">
            <h1>Add New Task <small>New Task</small></h1>
            </div>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Task Data</h3>
                </div>
                <!-- /.box-header -->
                <div class="error-message" id="err">

                </div>
                <!-- form start -->
                <form role="form" action="Tasks" method="post" id="frmTask">
                    <input type="hidden" id="taskId" name="taskId" value="${task.taskId}">
                    <input type="hidden" id="catId" value="${task.category.categoryId}">
                    <input type="hidden" id="prioId" value="${task.priority.valueId}">

                    <div class="box-body">
                        <div class="form-group">
                            <label for="lstCategory">Task Category</label>
                            <select id="lstCategory" class="form-control" name="taskCategory">
                                <option value="" selected>Select Category</option>
                                <c:forEach var="item" items="${categories}">
                                    <option value="${item.categoryId}" >${item.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="txtTaskName">Task Name</label>
                            <input type="text" class="form-control" id="txtTaskName" name="TaskName" value="${task.taskDesc}" placeholder="Enter task name" required>
                        </div>
                        <div class="form-group">
                            <label for="txtAssignUser">Assigned User</label>
                            <input type="text" class="form-control" id="txtAssignUser" name="assignUser" value="${currentUser.userName}" placeholder="Assigned User" readonly>
                        </div>
                        <div class="form-group">
                            <label for="txtDueDate">Due Date</label>
                            <input type="date" class="form-control" id="txtDueDate" name="dueDate" value="${task.dueDate}" placeholder="Due Date">
                        </div>
                        <div class="form-group">
                            <label for="lstPriority">Task Category</label>
                            <select id="lstPriority" class="form-control" name="taskPriority">
                                <option value="" selected>Select Priority</option>
                                <c:forEach var="item" items="${priorities}">
                                    <option value="${item.valueId}" >${item.name}</option>
                                </c:forEach>
                            </select>

                        </div>

                        <div class="form-group">
                            <input type="checkbox" class="checkbox" id="chkIsCompleted" name="IsCompleted" value="${task.completed}" ${task.isChecked} disabled/> Is Completed
                        </div>
                        <div class="form-group">
                            <label for="txtCompletedDate">Completed Date</label>
                            <input type="text" class="form-control" id="txtCompletedDate" name="completedDate" value="${task.completedDate}" readonly>
                        </div>
                        <div class="form-group">
                            <label for="txtComments">Comments</label>
                            <textarea class="form-control" id="txtComments" name="comments" placeholder="Write Comment">${task.remarks}</textarea>
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

<script src="javaScript/Tasks/addEditTask.js"></script>
</body>
</html>
