<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="css/style-print.css" type="text/css" media="print"/>
    <link rel="stylesheet" href="css/styleRegistration.css" type="text/css"/>
    <script type="text/javascript" src="js/lib/angular.min.js"></script>

    <title>Dashka facebook | Registration</title>
</head>
<body>
<div id="wrapper1">
    <!-- Title -->
    <div class="title">
        <div class="title-top">
        </div>
    </div>
    <!-- Title end -->
    <hr class="noscreen"/>
    <div class="content">
        <div id="skip-menu"></div>
        <div id="wrapper">
            <div class="user-icon"></div>
            <div class="pass-icon"></div>
            <form:form action="/registrations" method="POST" commandName="registrationForm" class="register-form">
                <div class="header">
                    <h1>Registration</h1>
                    <span>Enter the details for registration. </span>
                </div>
                <div class="content">
                    <h2>Name:</h2><input type="text" class="input username" placeholder="Name" name="name" value="${user.name}" required>
                    <br/>
                    <h2>Surname:</h2><input type="text" class="input username" placeholder="Surname" name="lastName" value="${user.lastName}"
                                            required><br/>
                    <h2>Login or e-mail:</h2><input type="text" class="input username" placeholder="Login or e-mail"
                                                    name="email" value="${user.login}" required> <br/>  ${error}
                    <h2>Password:</h2><input type="password" class="input username" placeholder="Password" name="pass"
                                             required> <br/>
                </div>
                <div class="footer">
                    <button type="submit" name="submit" class="button" ng-disabled="registrationForm.$invalid">
                        Registration
                    </button>
                    <a href="authorization.jsp"><input type="button" name="submit" value="Back to authorization"
                                                       class="register"/></a>
                </div>
            </form:form>
        </div>
        <br/>
    </div>
</div>
</body>
