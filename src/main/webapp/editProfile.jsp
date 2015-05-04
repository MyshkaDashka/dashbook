<%--
  Created by IntelliJ IDEA.
  User: Dashka
  Date: 27.04.2015
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="css/style-print.css" type="text/css" media="print"/>
    <link rel="stylesheet" href="css/styleLogin.css" type="text/css"/>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>

    <title>Dashka facebook | EditProfile</title>

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
            <form class="login-form" action="/editProfile" method="POST" name="editForm" novalidate>
                <div class="header">
                    <h1>Edit Profile</h1>
                    <span>Enter your personal data. </span>
                </div>
                <div class="content">
                    <input type="text" placeholder="Name" name="name" class="input username" onfocus="this.value=''"/>
                    <br/>
                    <input type="text" value="LastName" name="lastname" class="input password" onfocus="this.value=''"/>
                    <br/>
                    <input type="text" value="Phone" name="phone" class="input password" onfocus="this.value=''"/>
                </div>
                <div class="footer">
                    <input type="submit" name="submit" value="Sing In" class="button"/>
                    <a href="registration.jsp"><input type="button" name="submit" value="Registration"
                                                      class="register"/></a>
                </div>
            </form>
        </div>
        <br/>

        <div class="cleaner">&nbsp;</div>
    </div>
</div>
</body>
</html>
