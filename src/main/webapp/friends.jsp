<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- CSS -->
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="../css/style-print.css" type="text/css" media="print"/>
    <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon"/>
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
                <li><a href="/${id}/message">Messages</a></li>
                <li><a href="/${id}/search">Search</a></li>
                <li class="last"><a href="j_spring_security_logout">Log out</a></li>
            </ul>
        </div>
        <div id="skip-menu"></div>
        <div class="column-right">
            <div class="box">
                <div class="box-top"></div>
                <div class="box-in">
                    <h2>Friends ${client.name} ${client.lastName}</h2>
                    <br>
                    <c:forEach items="${friends}" var="friend">
                        <p><img src="../img/girl.png" class="box-infoFriends"></p>
                        <a href="/${id}/friend/${friend.id}"><h2>${friend.name} ${friend.lastName}</h2></a>
                        <br/>
                        <ul class="main-listFriend">
                            <li><strong>City: </strong> ${friend.city}</li>
                            <li><strong>Birthday: </strong> ${friend.birthday}</li>
                            <li><strong>Phone: </strong> ${friend.phone}</li>
                        </ul>
                        <hr>
                    </c:forEach>
                </div>
            </div>
            <div class="box-bottom">
                <div class="footer-info-right"><a href="http://www.mantisatemplates.com/">Mantis-a templates</a></div>
            </div>
        </div>
    </div>
</div>
</body>
