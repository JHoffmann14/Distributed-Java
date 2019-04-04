package us.joshhoffmann.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class CartPlaceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        Enumeration paramNames = request.getParameterNames();
        String paramName;
        String purchases = "";
        while(paramNames.hasMoreElements()) {
            paramName = (String)paramNames.nextElement();
            if(paramName.equals("cartItem")) {
                String[] paramValues = request.getParameterValues(paramName);
                if(paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() == 0){
                        purchases += "Empty Cart";
                    } else {
                        purchases += paramValue;
                    }
                } else {
                    for (int i = 0; i < paramValues.length; i++ ) {
                        purchases += paramValues[i] + ",";
                    }
                    purchases = purchases.substring(0, purchases.length() - 1);
                }
            }
        }
        Cookie teas = new Cookie("cartItem", purchases);
        teas.setMaxAge(60*60*24);
        response.addCookie(teas);

        String site = new String("cart.go");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Locations", site);

        RequestDispatcher dispatcher = request.getRequestDispatcher(site);
        dispatcher.forward(request,response);


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
