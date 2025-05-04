package HRMS;




import com.mysql.jdbc.*;


import java.sql.Connection;
import java.sql.DriverManager;



public class dbconnect {

    public Connection dblink;

    public Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            dblink = DriverManager.getConnection("jdbc:mysql://localhost:3306/huntingdbms", "root", "");
            System.out.println("database connected successfully........");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dblink;
    }

}












