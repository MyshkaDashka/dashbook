<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="css/style-print.css" type="text/css" media="print"/>
    <link rel="stylesheet" href="css/styleLogin.css" type="text/css"/>

    <title>Dashka facebook | Autorization</title>
</head>
<body>
<div id="wrapper1">
    <!-- Title -->
    <div class="title">
        <div class="title-top">
        </div>
    </div>
    <!-- Title end -->
    <div class="content">
        <div id="skip-menu"></div>
        <div id="wrapper">
            <form:form class="login-form" action="/j_spring_security_check" method="POST" name="authorizationForm">
                <div class="header">
                    <h2>${msgSuccess}</h2>

                    <h1>Authorization</h1>
                    <span>Enter your login credentials in your personal profile. </span>

                </div>
                <div class="content">
                    <input type="text" placeholder="Login" name="j_username" class="input username"
                           onfocus="this.value=''"
                           required/>
                    <br/>
                    <input type="password" value="Password" name="j_password" class="input password"
                           onfocus="this.value=''"
                           required/>
                </div>
                <div class="footer">
                    <button type="submit" name="submit" class="button" ng-disabled="authorizationForm.$invalid"> Sing
                        in
                    </button>
                    <a href="registration.jsp"><input type="button" name="submit" value="Registration"
                                                      class="register"/></a>
                </div>
            </form:form>
        </div>
        <br/>
    </div>
</div>
</body>
