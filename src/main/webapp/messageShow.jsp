<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <!-- CSS -->
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="../css/style-print.css" type="text/css" media="print"/>

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
            <div class="box">
                <div class="box-top"></div>
                <div class="box-in">
                    <br>
                    <table class="table-info">
                        <tr>
                            <th><a href="/${id}/msgunread"> Unread </a></th>
                            <th><a href="/${id}/message"> Inbox </a></th>
                            <th><a href="/${id}/msgsent"> Sent </a></th>
                            <th><a href="/${id}/sendmessage">
                                <button type="button" name="button" class="myButton"> Send message</button>
                            </a></th>
                        </tr>
                    </table>

                    <br>
                    <table class="table-show" border>
                        <tr>
                            <th>From</th>
                            <th>To</th>
                            <th>Title</th>
                            <th>Date</th>
                        </tr>
                        <c:forEach items="${unreadMessDTO}" var="msgU">
                            <tr class="table-show-unread">
                                <td>
                                    <a href="/${id}/friend/${msgU.idFriend}">${msgU.nameFriend} ${msgU.lastNameFriend}</a>
                                </td>
                                <td>
                                    <a href="/${id}"> ${client.name} ${client.lastName}</a>
                                </td>
                                <td>
                                    <a href="/${id}/message/${msgU.message.id}"> ${msgU.message.title} </a>
                                </td>
                                <td>
                                        ${msgU.message.date}
                                </td>
                            </tr>
                        </c:forEach>
                        <c:forEach items="${readMessDTO}" var="msg">
                            <tr>
                                <td>
                                    <a href="/${id}/friend/${msg.idFriend}"> ${msg.nameFriend} ${msg.lastNameFriend}</a>
                                </td>
                                <td>
                                    <a href="/${id}"> ${client.name} ${client.lastName}</a>
                                </td>
                                <td>
                                    <a href="/${id}/message/${msg.message.id}"> ${msg.message.title} </a>
                                </td>
                                <td>
                                        ${msg.message.date}
                                </td>
                            </tr>
                        </c:forEach>
                        <c:forEach items="${sentMessDTO}" var="msgS">
                            <tr>
                                <td>
                                    <a href="/${id}">${client.name} ${client.lastName} </a>
                                </td>
                                <td>
                                    <a href="/${id}/friend/${msgS.idFriend}"> ${msgS.nameFriend} ${msgS.lastNameFriend}</a>
                                </td>
                                <td>
                                    <a href="/${id}/message/${msgS.message.id}"> ${msgS.message.title} </a>
                                </td>
                                <td>
                                        ${msgS.message.date}
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="box-bottom">
                <hr class="noscreen"/>
                <div class="footer-info-right"><a href="http://www.mantisatemplates.com/">Mantis-a templates</a></div>
            </div>
        </div>
    </div>
</div>
</body>

