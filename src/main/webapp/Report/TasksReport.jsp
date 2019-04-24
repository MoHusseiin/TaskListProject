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


            <div class="box">
                <div class="box-header">
                    <h3 id="box-title" class="box-title">Tasks</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body no-padding">
                    <fieldset class="col-lg-3 col-xs-6">
                        <legend>Search by User</legend>
                        <form id="byUser" action="TasksReport" method="get">
                            <div>
                                <select id="lstUsers" class="form-control" name="user" required>
                                    <option value="" selected>Select User</option>
                                    <c:forEach var="item" items="${allUserRpt}">
                                        <option value="${item.userID}">${item.name}</option>
                                    </c:forEach>
                                </select>
                                <div class="radio">
                                    <label for="rdUserAsc">
                                        <input type="radio" name="rdUsers" id="rdUserAsc"
                                               value="asc" checked="">
                                        Ascending
                                    </label>
                                    <label for="rdUserDesc">
                                        <input type="radio" name="rdUsers" id="rdUserDesc"
                                               value="desc">
                                        Descending
                                    </label>
                                </div>
                                <div>
                                    <input type="submit" value="Search By User">
                                </div>

                            </div>
                        </form>
                    </fieldset>

                    <fieldset class="col-lg-3 col-xs-6">
                        <legend>Search by Priority</legend>
                        <form id="byPriority" action="TasksReport" method="get">
                            <div>
                                <select id="lstPriority" class="form-control" name="priority" required>
                                    <option value="" selected>Select Priority</option>
                                    <c:forEach var="item" items="${prioritiesRpt}">
                                        <option value="${item.valueId}">${item.name}</option>
                                    </c:forEach>
                                </select>
                                <div class="radio">
                                    <label for="rdPriorityAsc">
                                        <input type="radio" name="rdPriority" id="rdPriorityAsc"
                                               value="asc" checked>
                                        Ascending
                                    </label>
                                    <label for="rdPriorityDesc">
                                        <input type="radio" name="rdPriority" id="rdPriorityDesc"
                                               value="desc">
                                        Descending
                                    </label>
                                </div>
                                <div>
                                    <input type="submit" value="Search By Priority">
                                </div>
                            </div>
                        </form>
                    </fieldset>

                    <fieldset class="col-lg-3 col-xs-6">
                        <legend>Search by Team</legend>
                        <form id="byTeam" action="TasksReport" method="get">
                            <div>
                                <select id="lstTeams" class="form-control" name="team" required>
                                    <option value="" selected>Select Team</option>
                                    <c:forEach var="item" items="${allTeamsRpt}">
                                        <option value="${item.teamId}">${item.teamName}</option>
                                    </c:forEach>
                                </select>
                                <%--<div class="radio">--%>
                                    <%--<label for="rdTeamsAsc">--%>
                                        <%--<input type="radio" name="rdTeams" id="rdTeamsAsc"--%>
                                               <%--value="asc" checked>--%>
                                        <%--Ascending--%>
                                    <%--</label>--%>
                                    <%--<label for="rdTeamsDesc">--%>
                                        <%--<input type="radio" name="rdTeams" id="rdTeamsDesc"--%>
                                               <%--value="desc">--%>
                                        <%--Descending--%>
                                    <%--</label>--%>
                                <%--</div>--%>
                                <div>
                                    <input type="submit" value="Search By Team">
                                </div>
                            </div>
                        </form>
                    </fieldset>

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
                        </tr>
                        <c:forEach var="item" items="${allTasksRpt}">
                            <tr>
                                <td>${item.taskId}</td>
                                <td>${item.category.categoryName}</td>
                                <td>${item.taskDesc}</td>
                                <td>${item.user.userName}</td>
                                <td>${item.dueDate}</td>
                                <td>${item.priority.name}</td>
                                <td>
                                    <div class="col-md-2">
                                        <input type="checkbox" name="${item.taskId}"
                                               value="${item.completed}" ${item.isChecked} disabled>
                                    </div>
                                </td>
                                <td>${item.completedDate}</td>
                                <td>${item.remarks}</td>
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

</body>
</html>