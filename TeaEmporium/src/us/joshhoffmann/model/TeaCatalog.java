package us.joshhoffmann.model;

import javax.servlet.http.HttpServlet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeaCatalog extends HttpServlet {
    private static List<Tea> teaList = new ArrayList<>();
    private int nextProductNumber;

    public TeaCatalog() {
            //nextProductNumber = 1;
        /*    teaList.add(new Tea(1,"Minnesota N'Ice","Black",5.50));
            teaList.add(new Tea(2,"Irish Breakfast","Black",6.00));
            teaList.add(new Tea(3,"Earl Grey","Black",7.00));
            teaList.add(new Tea(4,"Blue Beauty","Oolong",6.00));
            teaList.add(new Tea(5,"Water Sprite","Oolong",13.50));
            teaList.add(new Tea(6,"Green Dragon","Oolong",18.00));
            teaList.add(new Tea(7,"Bamboo Leaf","Green",24.00));
            teaList.add(new Tea(8,"Green Mango","Green",5.50));
            teaList.add(new Tea(9,"Jasmine","Green",5.00));*/

        CreateTeaDB ct = new CreateTeaDB();
        addTeas();

}

    public static void addTeas() {
        final String DB_URL = "jdbc:derb:TeaDB";
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DB_URL);
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
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static Tea getTea(int id) {
        Tea theTea = null;

        for (Tea teaName : teaList){
            if (teaName.getId() == id ) {
                theTea = teaName;
            }
        }
        return theTea;
    }

    public List<Tea> getAllTeas() { return teaList; }

    public static List<Tea> findTeas(String search){
        search = search.toLowerCase();
        List<Tea> theList = new ArrayList<>();
        for (Tea teaName : teaList){
            if (teaName.getName().toLowerCase().startsWith(search)) {
                theList.add(teaName);
            }
        }
        return theList;
    }
}
