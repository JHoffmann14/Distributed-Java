package us.joshhoffmann.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTeaDB {

    public CreateTeaDB()
    {
        try
        {
            final String DB_URL = "jdbc:derby:TeaDB;create=true";

            Connection conn = DriverManager.getConnection(DB_URL);

            dropTables(conn);

            buildTeaTable(conn);

            buildCartTable(conn);

            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error creating the tea table");
            System.out.println(e.getMessage());
        }
    }

    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            Statement stmt = conn.createStatement();

            try
            {
                stmt.executeQuery("DROP TABLE Tea");
                System.out.println("Tea table dropped.");

                stmt.executeQuery("DROP TABLE Cart");
                System.out.println("Cart table dropped.");
            } catch (SQLException ex)
            {
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void buildTeaTable(Connection conn) {

        try {
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE Tea (" +
                    "ProdId VARCHAR(25) NOT NULL PRIMARY KEY, " +
                    "ProdName VARCHAR(25) NOT NULL, " +
                    "ProdType VARCHAR(25), " +
                    "Price FLOAT " +
                    ")");

            stmt.execute("CREATE TABLE Tea (" +
                    "ProdId VARCHAR(5), " +
                    "ProdName VARCHAR(50) NOT NULL PRIMARY KEY, " +
                    "ProdType VARCHAR(25), " +
                    "Price DOUBLE" +
                    ")");

            stmt.execute("INSERT INTO Tea VALUES ( " +
                    "'1', " +
                    "'Minnesota N Ice', " +
                    "'Black'," +
                    "5.50) ");

            stmt.execute("INSERT INTO Tea VALUES ( " +
                    "'2', " +
                    "'Irish Breakfast', " +
                    "'Black'," +
                    "6.00) ");

            stmt.execute("INSERT INTO Tea VALUES ( " +
                    "'3', " +
                    "'Earl Grey', " +
                    "'Black'," +
                    "7.00) ");

            stmt.execute("INSERT INTO Tea VALUES ( " +
                    "'4', " +
                    "'Blue Beauty', " +
                    "'Oolong'," +
                    "6.00) ");

            stmt.execute("INSERT INTO Tea VALUES ( " +
                    "'5', " +
                    "'Water Sprite', " +
                    "'Oolong'," +
                    "13.50) ");

            stmt.execute("INSERT INTO Tea VALUES ( " +
                    "'6', " +
                    "'Green Dragon', " +
                    "'Oolong'," +
                    "18.00) ");

            stmt.execute("INSERT INTO Tea VALUES ( " +
                    "'7', " +
                    "'Bamboo Leaf', " +
                    "'Green'," +
                    "24.00) ");

            stmt.execute("INSERT INTO Tea VALUES ( " +
                    "'8', " +
                    "'Green Mango', " +
                    "'Green'," +
                    "5.50) ");

            stmt.execute("INSERT INTO Tea VALUES ( " +
                    "'9', " +
                    "'Jasmine', " +
                    "'Green'," +
                    "5.00) ");

            System.out.println("Tea table created.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void buildCartTable(Connection conn)
    {
        try
        {
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE Cart (" +
                    "ProdId VARCHAR(5), " +
                    "ProdName VARCHAR(50) NOT NULL PRIMARY KEY, " +
                    "ProdType VARCHAR(25), " +
                    "Price DOUBLE" +
                    ")");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
