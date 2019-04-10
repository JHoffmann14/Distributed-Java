package us.joshhoffmann.controller;

import us.joshhoffmann.model.CreateTeaDB;
import us.joshhoffmann.model.Tea;
import us.joshhoffmann.model.TeaCatalog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeaController extends HttpServlet {

    CreateTeaDB ct = new CreateTeaDB();
  /*  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TeaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/
  private String RESULT_PAGE = "productList.jsp";
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

  }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        TeaCatalog shop = new TeaCatalog();

        List<Tea> result = shop.getAllTeas();

        request.setAttribute("catalog", result);

        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request,response);

        /*TeaCatalog nameService = new TeaCatalog();
        RequestDispatcher dispatcher = null;

        String id = request.getParameter("id");
        String search = request.getParameter("search");
        if (id != null) {
            Tea name = TeaCatalog.getTea(Integer.parseInt(id));
            request.setAttribute("name", name);
            dispatcher =
                    request.getRequestDispatcher("/nameDetail.jsp");
        } else if (search != null) {
            List<Tea> nameList = TeaCatalog.findTeas(search);
            request.setAttribute("nameList", nameList);
            dispatcher =
                    request.getRequestDispatcher("/nameList.jsp");
        } else {
            List<Tea> nameList = nameService.getAllTeas();
            request.setAttribute("nameList", nameList);
            dispatcher =
                    request.getRequestDispatcher("/nameList.jsp");
        }

        dispatcher.forward(request, response);*/

    }
    public String getServletInfo() { return "Main Controller"; }

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }*/

}
