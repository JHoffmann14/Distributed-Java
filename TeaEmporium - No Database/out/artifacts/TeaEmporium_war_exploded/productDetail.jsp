<%@ page import="us.joshhoffmann.model.Tea" %><%--
  Created by IntelliJ IDEA.
  User: bitstudent
  Date: 3/6/2019
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hoff's Tea Emporium</title>
    <link rel="stylesheet" href="CSS/store.css" />
</head>
<body>
<iframe name="menu" src="shared/menu.jsp" frameborder="0" style="margin-bottom: 0vh; width: 100%;">
    <div id="nav-placeholder"></div>
</iframe>
<div class="card">

    <img
            src="images/greenTea.png"
            alt="Green Tea"
            style="width:100%"
    />
    <jsp:useBean id="TeaController" class="us.joshhoffmann.controller.TeaController" scope="session" />
    <div class="container">
        <%
            Tea tea = (Tea) request.getAttribute("detail");
            out.print("<h4><b>"+tea.getName()+"</b></h4>");
            out.print("<h4>"+String.format("%3.2f", tea.getPrice())+"</h4>");
        %>
    </div>
</div>
</body>
</html>
