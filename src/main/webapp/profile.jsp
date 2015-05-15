<%--
  Created by IntelliJ IDEA.
  User: Dashka
  Date: 25.04.2015
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="css/style-print.css" type="text/css" media="print"/>

    <script type="text/javascript" src="js/lib/angular.min.js"></script>
    <script type="text/javascript" src="js/lib/angular-file-upload.min.js"></script>
    <script type="text/javascript" src="js/app.js"></script>
    <script type="text/javascript" src="js/controller.js"></script>

    <title>Dashka facebook | Homepage</title>
</head>
<body ng-app="App">
<div id="wrapper1" ng-controller="Controller as ctrl">
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
            <div class="box">
                <div class="box-top"></div>
                <div class="box-in">
                    <div class="edit-button">
                        <a href="/${id}/edit">Edit profile |</a>
                    <span class="fileinput-button" >
                        <span>Edit photo</span>
                        <input type="file" name="file" nv-file-select uploader="uploader" ng-click="uploader.uploadAll()">
                    </span></div>
                    <p><img src="${client.photo}" class="box-info"></p>

                    <h2>${client.name} ${client.lastName}</h2>
                    <br/>
                    <ul class="main-list">
                        <li><strong>City: </strong> ${client.city}</li>
                        <li><strong>Birthday: </strong> ${client.birthday}</li>
                        <li><strong>Phone: </strong> ${client.phone}</li>
                        <li><strong>Study: </strong> ${client.study}</li>
                        <li><strong>Work: </strong> ${client.work}</li>
                    </ul>
                    <h2>About me</h2>

                    <p>${client.aboutMe}</p>
                </div>
            </div>

            <div class="box-bottom">
                <div class="footer-info-right"><a href="http://www.mantisatemplates.com/">Mantis-a templates</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

