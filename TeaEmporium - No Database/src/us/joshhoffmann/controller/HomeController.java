package us.joshhoffmann.controller;

import us.joshhoffmann.model.TeaCatalog;
import us.joshhoffmann.model.Tea;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeController extends HttpServlet {
    private String RESULT_PAGE = "home.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Create a new instance of a model object
        // For some applications, we would not want to create a new one each time.
        TeaCatalog shop = new TeaCatalog();

        // Always a good idea to trim and/or validate input data
        List<Tea> result = shop.getAllTeas();

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("catalog", result);

        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Main Controller";
    }// </editor-fold>
}
