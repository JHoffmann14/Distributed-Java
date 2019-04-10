import java.io.Console;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CreateTeaDB ct = new CreateTeaDB();
        outputDB();
        addContent();
        System.out.println("========================");
        outputDB();
    }

    public static  void addContent() {
        final String DB_URL = "jdbc:derby:TeaDB";
        Statement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;
        try {

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Inserting records into the table...");
            stmt2 = conn.createStatement();

          /*  String sql = "INSERT INTO Tea " +
                    "VALUES ('1', 'Minnesota N Ice', 'Black', 5.50)";
            stmt.executeUpdate(sql);*/

            stmt.close();
            stmt2.close();
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
                if (stmt2 != null) {
                    stmt2.close();
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

        public static void outputDB() {
        final String DB_URL = "jdbc:derby:TeaDB";
        Statement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;

        try {

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ProdId, ProdName, ProdType, Price FROM Tea";
            ResultSet rs = stmt.executeQuery(sql);

            stmt2 = conn.createStatement();
            sql = "SELECT ProdId, ProdName, ProdType, Price FROM Cart";
            ResultSet rs2 = stmt2.executeQuery(sql);

            System.out.println("Press the option you want");
            System.out.println("v - View list of teas");
            System.out.println("a - Add Tea");
            System.out.println("c - View Cart");
            System.out.println("e - Exit");

            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();

   //         System.out.println(rs + "  " + rs2);
            switch(option){
                case "v":
                case "V":
                    while(rs.next()) {
                        String id = rs.getString("ProdId");
                        String name = rs.getString("ProdName");
                        String type = rs.getString("ProdType");
                        double price = rs.getDouble("Price");

                        System.out.print("ID: " + id);
                        System.out.print(", Name: " + name);
                        System.out.print(", Type: " + type);
                        System.out.print(", Price: " + price);
                        System.out.println("\n");
                     }
                    rs.close();
                 //   stmt.close();
                //    conn.close();
                    return;
                case "a":
                case "A":

                    System.out.println("Please enter the id of the tea you want to add");
                    String select = (sc.nextLine());
                    while(rs.next()){
                        String checkId = rs.getString("ProdId");
                        if(checkId.equals(select)) {

                            stmt2.execute("INSERT INTO Cart SELECT ProdId, ProdName, ProdType, Price FROM Tea WHERE ProdId = '"+ checkId + "'");
                                    /*"+  rs.getString("ProdId") +", "+ rs.getString("ProdName")
                                    + ", " + rs.getString("ProdType") + ", " + rs.getString("Price") + ")");*/
                                    //"VALUES ("+ item.getString("ProdId") + ", " + item.getString("ProdName") + ", " +
                                    //    item.getString("ProdType") + ", " + item.getString("Price")+");" );
                        }
                    }
                    rs2.close();
                  //  stmt2.close();
                    return;
                case "c":
                case "C":
                    while(rs2.next()) {

                        String id = rs2.getString("ProdId");
                        String name = rs2.getString("ProdName");
                        String type = rs2.getString("ProdType");
                        double price = rs2.getDouble("Price");

                        System.out.print("ID: " + id);
                        System.out.print(", Name: " + name);
                        System.out.print(", Type: " + type);
                        System.out.print(", Price: " + price);
                        System.out.println("\n");
                    }
                    rs2.close();
                  //  stmt2.close();
                    conn.close();
                    return;
                case "e":
                case "E":
                    System.exit(0);
                default:
                    return;
            }


        } catch(SQLException se) {
            se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
            }//end try
        }
    }
