<%--
  Created by IntelliJ IDEA.
  User: bitstudent
  Date: 2/20/2019
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hoff's Tea Emporium</title>
    <link rel="stylesheet" type="text/css" href="CSS/store.css" />
  </head>
  <body>
  <iframe name="menu" src="shared/menu.jsp" frameborder="0" style="margin-bottom: 0vh; width: 100%">
    <div id="nav-placeholder"></div>
  </iframe>

  <div class="openHeader">
    <h1>Hoff's Tea Emporium</h1>
  </div>
  <div class="container">
    <div class="healthBenifits">
      <h3>Health Benifits of Green Tea</h3>
      <p></p>
      <h3>Health Benifits of Oolong Tea</h3>
      <p></p>
      <h3>Helath Benifits of Black Tea</h3>
    </div>

    <table aria-colspan="12" id="typesOfTea">
      <tr>
        <td>
          <div class="card">

              <img
                      src="images/greenTea.png"
                      alt="Green Tea"
                      style="width:100%"
              />
            <jsp:useBean id="TeaController" class="us.joshhoffmann.controller.TeaController" scope="session" />
            <div class="container">
              <h4><b>Green Tea</b></h4>
            </div>
          </div>
        </td>
        <td>
          <div class="card">
            <img
                    src="images/oolongTea.png"
                    alt="Oolong Tea"
                    style="width:100%"
            />
            <div class="container">
              <h4><b>Oolong Tea</b></h4>
            </div>
          </div>
        </td>
        <td>
          <div class="card">
            <img
                    src="images/blackTea.png"
                    alt="Black Tea"
                    style="width:100%"
            />
            <div class="container">
              <h4><b>Black Tea</b></h4>
            </div>
          </div>
        </td>
      </tr>
    </table>
  </div>
  </body>
</html>
