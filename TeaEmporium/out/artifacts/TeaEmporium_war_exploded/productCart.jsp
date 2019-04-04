<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.joshhoffmann.model.Tea" %>
<%--
  Created by IntelliJ IDEA.
  User: bitstudent
  Date: 2/27/2019
  Time: 7:08 PM
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
    <div id="rcorners">
        <h3>Product List</h3>
        <form action="bill.go">
            <table border="1">
                <%
                    List recs = (List) request.getAttribute("catalog");
                    Iterator it = recs.iterator();
                    double total = 0;
                    while(it.hasNext()) {
                        Tea tea = (Tea) it.next();
                        out.print("<tr class='product'><td>" + tea.getName() + "</td><td>" +
                                String.format("%3.2f", tea.getPrice()) + "</td>");
                        out.print("<td><input type='text' class='qty' value='1'></td>");
                        out.print("<td><input type='button' value='remove'></td></tr>");
                        total += tea.getPrice();
                    }
                        out.print("<tr class='total'><td>Total:</td><td>" +
                                String.format("%3.2f", total) + "</td></tr>");
                %>
            </table>
            <input type="submit" value="Update"><input type="submit" value="Purchase">
        </form>
    </div>
</div>
</body>
</html>
<script>
    $(document).alert("I got here");
</script>