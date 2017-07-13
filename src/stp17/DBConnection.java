
package stp17;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection con;
    private DBConnection()
    {}
    static
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stp17july","root","password");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static Connection getDbConnection(){
        return con;
    }
}
