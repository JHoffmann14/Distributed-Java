package us.joshhoffmann.controller;

import us.joshhoffmann.model.CreateTeaDB;
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

        // Create new Database
        CreateTeaDB teaDB = new CreateTeaDB();

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
/*

public static void main(String[] args) {
    CreateTeaDB ct = new CreateTeaDB();

    outputDB();

    addContent();
    System.out.println("==============================");

    outputDB();
}
    public static void addContent() {
        final String DB_URL = "jdbc:derby:TeadDB";
        Statement stmt = null;
        Connection conn = null;
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se3) {
                se3.printStackTrace();
            }
        }
    }

    public static void outputDB () {
        final String DB_URL = "jdbc:derby:CoffeeDB";
        Statement stmt = null;
        Connection conn = null;
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ProdID, Name, Type, Price FROM Tea";
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                //Retrieve by column name
                String id = rs.getString("ProdNum");
                double price = rs.getDouble("Price");
                String description = rs.getString("Description");

                //Display values
                System.out.print("ID: " + id.trim());
                System.out.print(", Price: " + price);
                System.out.println(", Description: " + description);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }
}
 */