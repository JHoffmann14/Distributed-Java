<%--
  Created by IntelliJ IDEA.
  User: bitstudent
  Date: 2/20/2019
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../CSS/menu.css"/>
</head>
<body>
<nav>
    <ul>
        <% try{%>
        <li><a href="../index.jsp" target="container">Home</a></li>
        <li><a href="../inventory.go" target="container">Product List</a></li>
        <li><a href="../cart.go" target="container">Shopping Cart</a></li>
        <%
            }
            catch (Exception e){
                out.println(e.getMessage());
            }
        %>
    </ul>
    <input type="text" id="search" style="float: right; margin-right: 30px; margin-top: .75%;">
</nav>
</body>


<script>
    function page(option){
        var info="../"
        info += option;
        info += '.html';
        console.log(info);
    }
    function fileFail(option){
        console.log()
    }
</script>
</html>
