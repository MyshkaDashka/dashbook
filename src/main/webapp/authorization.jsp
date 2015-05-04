<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="css/style-print.css" type="text/css" media="print"/>
    <link rel="stylesheet" href="css/styleLogin.css" type="text/css"/>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>

    <title>Dashka facebook | Autorization</title>
</head>
<body>
<div id="wrapper1">
    <!-- Title -->
    <div class="title">
        <div class="title-top">
            <div class="title-left">
                <div class="title-right">
                    <div class="title-bottom">
                        <div class="title-top-left">
                            <div class="title-bottom-left">
                                <div class="title-top-right">
                                    <div class="title-bottom-right">
                                        <h1><a href="#" title="Go to homepage">Dashka <span>FACEBOOK</span> website</a>
                                        </h1>

                                        <p>This is your choice...</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Title end -->
    <hr class="noscreen"/>
    <div class="content">
        <div id="skip-menu"></div>
        <div id="wrapper">
            <div class="user-icon"></div>
            <div class="pass-icon"></div>

            <form:form class="login-form" action="/authorization" method="POST" name="authorizationForm">
                <div class="header">
                    <h1>Authorization</h1>
                    <span>Enter your login credentials in your personal profile. </span>
                </div>
                <div class="content">
                    <input type="text" placeholder="Login" name="login" class="input username" onfocus="this.value=''"
                           required/>
                    <br/>
                    <input type="password" value="Password" name="pass" class="input password" onfocus="this.value=''"
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

        <div class="cleaner">&nbsp;</div>
    </div>
</div>
</body>
</html>
