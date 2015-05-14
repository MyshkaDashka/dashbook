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
            <form:form action="/${id}/searchUser" method="POST" commandName="messagesForm"
                       class="register-form">
                <div class="header">
                    <h1>Search</h1>
                    <span>Enter the search.</span>
                </div>
                <div class="content">
                    <h2>Name</h2> <input type="text" class="input" placeholder="Name" name="name" value=""><br/>

                    <h2>Last Name</h2> <input type="text" class="input" placeholder="Last Name" name="lastName"
                                              value=""><br/>

                    <h2>City</h2> <input type="text" class="input" placeholder="City" name="city" value=""><br/>

                    <h2>Study</h2> <input type="text" class="input" placeholder="Study" name="study" value=""><br/>

                    <h2>Work</h2> <input type="text" class="input" placeholder="Work" name="work" value=""><br/>
                </div>
                <div class="footer">
                    <button type="submit" name="submit" class="button">Search</button>
                    <a href="/${id}"><input type="button" name="submit" value="Back to profile"
                                            class="register"/></a>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>