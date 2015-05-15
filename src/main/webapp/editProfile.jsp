<%--
  Created by IntelliJ IDEA.
  User: Dashka
  Date: 25.04.2015
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <!-- CSS -->
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="../css/style-print.css" type="text/css" media="print"/>
    <link rel="stylesheet" href="../css/styleRegistration.css" type="text/css"/>

    <title>Dashka facebook | Homepage</title>
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
        <div class="column-left">
            <h3>MENU</h3>
            <a href="#skip-menu" class="hidden">Skip menu</a>
            <ul class="menu">
                <li><a href="/${id}">Home</a></li>
                <li><a href="/${id}/friend">Friends</a></li>
                <li><a href="/${id}/message">Messages ${countMess}</a></li>
                <li><a href="/${id}/search">Search</a></li>
                <li class="last"><a href="j_spring_security_logout">Log out</a></li>
            </ul>
        </div>
        <div id="skip-menu"></div>
        <div class="column-right">
            <form:form action="/${id}/editProfile" method="POST" class="register-form" name="editForm">
                <div class="header">
                    <h1>Edit Profile</h1>
                    <span>Enter your personal data. </span>
                </div>
                <div class="content">
                    <h2>City: </h2><input type="text" placeholder="City" name="city" class="input"
                                          value="${client.city}"/>
                    <br/>

                    <h2>Birthday: </h2><input type="text" placeholder="Birthday" name="birthday" class="input"
                                              value="${client.birthday}"/>
                    <br/>

                    <h2>Phone: </h2><input type="text" placeholder="Phone" name="phone" class="input"
                                           value="${client.phone}"/>
                    <br/>

                    <h2>Study: </h2><input type="text" placeholder="Study" name="study" class="input"
                                           value="${client.study}"/>
                    <br/>

                    <h2>Work: </h2><input type="text" placeholder="Work" name="work" class="input"
                                          value="${client.work}"/>
                    <br/>

                    <h2>About me: </h2><textarea type="text" class="input" placeholder="About me"
                                                 name="aboutMe">${client.aboutMe}</textarea><br/>
                </div>
                <div class="footer">
                    <input type="submit" name="submit" value="Edit" class="button"/>
                    <a href="/${id}"><input type="button" name="submit" value="Back to profile"
                                            class="register"/></a>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>

