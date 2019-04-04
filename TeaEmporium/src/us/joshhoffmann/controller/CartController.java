package us.joshhoffmann.controller;

import us.joshhoffmann.model.Tea;
import us.joshhoffmann.model.TeaCatalog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet")
public class CartController extends HttpServlet {
    private String RESULT_PAGE = "productCart.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        List<Tea> teas = new ArrayList();
        teas.add(new Tea(0, " ", " ", 0.0));
        if( cookies != null){
            for (int i = 0; i< cookies.length; i++) {
                cookie = cookies[i];
                out.print(cookie.getValue());
                if (cookie.getName().equals("cartItem")) {
                    teas = orderedItems(cookie.getValue());
                }
            }
        }
        request.setAttribute("catalog", teas);

        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    protected List<Tea> orderedItems(String teasNumbers) {
        List<Tea> teas = new ArrayList<>();
        TeaCatalog cat = new TeaCatalog();
        String[] nums = teasNumbers.split(",");
        for (int i=0; i<nums.length; i++) {
            teas.add(cat.getTea(Integer.parseInt(nums[i])));
        }
        return teas;
    }
}
