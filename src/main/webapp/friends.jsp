<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="css/style-print.css" type="text/css" media="print"/>

    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>

    <title>Dashka facebook | Homepage</title>
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
        <div class="column-left">
            <h3>MENU</h3>
            <a href="#skip-menu" class="hidden">Skip menu</a>
            <ul class="menu">
                <li><a href="/" class="active">Home</a></li>
                <li><a href="/friend">Friends</a></li>
                <li><a href="/message.jsp">Messages</a></li>
                <li><a href="#">Contact</a></li>
                <li class="last"><a href="authorization.jsp">Exit</a></li>
            </ul>
        </div>
        <div id="skip-menu"></div>
        <div class="column-right">
            <div class="box">
                <div class="box-top"></div>
                <div class="box-in">
                    <h2>Friends</h2>
                    <br>
                    <c:forEach items="${friends}" var="friend">
                        <p><img src="img/girl.png" class="box-infoFriends"></p>

                        <h2>${friend.name} ${friend.lastName}</h2>
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

                <hr class="noscreen"/>

                <div class="footer-info-left"><a href="/">My personal website</a>, 2008. All rights reserved.</div>
                <div class="footer-info-right"><a href="http://www.mantisatemplates.com/">Mantis-a templates</a></div>
            </div>
        </div>

        <div class="cleaner">&nbsp;</div>
    </div>
</div>
</body>
</html>