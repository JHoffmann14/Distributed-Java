package us.joshhoffmann.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "productDetail")
public class TeaDetailController extends HttpServlet {
    private String RESULT_PAGE = "productDetail.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration paramNames = request.getParameterNames();
        String paramName;
        String itemDetail = "";
        while (paramNames.hasMoreElements()) {
            paramName = (String) paramNames.nextElement();
            if (paramName.equals("detail")) {
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValues.length == 0) {
                        itemDetail += "No such tea is available";
                    } else {
                        itemDetail += paramValue;
                    }
                } else {
                    for (int i = 0; i < paramValues.length; i++) {
                        itemDetail += paramValues[i] + ",";
                    }
                    itemDetail = itemDetail.substring(0, itemDetail.length() - 1);
                }
            }
        }
        Cookie item = new Cookie("detail", itemDetail);
        item.setMaxAge(60 * 60 * 24);
        response.addCookie(item);

        String site = new String("productDetail.jsp");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Locations", site);
    }
}
