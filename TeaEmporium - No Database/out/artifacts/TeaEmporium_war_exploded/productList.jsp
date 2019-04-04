<%--
  Created by IntelliJ IDEA.
  User: bitstudent
  Date: 2/20/2019
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="us.joshhoffmann.model.Tea" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tea List</title>
    <link rel="stylesheet" href="./CSS/store.css" />
</head>
<body>
<iframe name="menu" src="shared/menu.jsp" frameborder="0" style="margin-bottom: 0vh; width: 100%">
    <div id="nav-placeholder"></div>
</iframe>
<form action="cartPlace.go" method="GET">
    <table border="1">
        <%
            List teaList = (List) request.getAttribute("catalog");
            Iterator it = teaList.iterator();
            while (it.hasNext()) {
                Tea tea = (Tea) it.next();
                out.print("<tr><td value="+ tea.getId() +">" + tea.getName() + "</td><td>" + String.format("$%3.2f", tea.getPrice()) + "</td><td>Add to Cart<input type='checkbox' name='cartItem' value=" + tea.getId() + "></td></tr>");
            }
        %>
    </table>
<input type="submit" value="Submit">
</form>
</body>
</html>
