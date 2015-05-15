<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <!-- CSS -->
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="../css/style-print.css" type="text/css" media="print"/>
    <link rel="stylesheet" href="../css/styleRegistration.css" type="text/css"/>

    <script type="text/javascript" src="../js/lib/angular.min.js"></script>

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
            <form:form action="/${client.id}/sendMessage" method="POST" commandName="messagesForm"
                       class="register-form">
                <div class="header">
                    <h1>Send message.</h1>
                </div>
                <div class="content">
                    <h2>To:</h2><select class="input" name="to" required>
                    <c:forEach items="${friends}" var="friend">
                        <option value="${friend.id}">${friend.name} ${friend.lastName}</option>
                    </c:forEach>
                </select><br/>

                    <h2>Title:</h2><input type="text" class="input" placeholder="Title" name="title"
                                          required><br/>

                    <h2>Text:</h2><textarea class="input" placeholder="Text Message" name="TextMessage" required></textarea><br/>
                </div>
                <div class="footer">
                    <input type="submit" name="submit" class="button" ng-disabled="messagesForm.$invalid" value="Send"/>
                    <a href="/${client.id}"><input type="button" name="submit" value="Back to profile"
                                                   class="register"/></a>
                </div>
            </form:form>
        </div>
    </div>
</div>
</div>
</body>