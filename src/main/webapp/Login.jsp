
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Task List</title>
    <link href="bower_components/bootstrap/dist/css/login.css" type="text/css" rel="stylesheet">
    <script src="bower_components/bootstrap/dist/js/login.js" type="text/javascript"></script>
</head>
<body>
    <div class="login-page">
        <div class="form">
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Task List </b>Project</span>
            <br/>
            <form class="login-form" method="POST" action="home">
                <input type="text" placeholder="username" name="userName"/>
                <input type="password" placeholder="password" name="password"/>
                <button>login</button>
            </form>
            <p style="color: red">${loginError}</p>
        </div>
    </div>
</body>
</html>
