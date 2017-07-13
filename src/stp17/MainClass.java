package stp17;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        PreparedStatement pst=null;
        Connection c=null;
        CallableStatement cst=null;
        ResultSet rs=null;
        int flag=0;
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter user name");
            String u=sc.nextLine();
            System.out.println("Enter password");
            String pass=sc.next();
            c=DBConnection.getDbConnection();
            cst=c.prepareCall("call myproc()");
            rs=cst.executeQuery();
            while(rs.next())
            {
                String temp=rs.getString("password");
                if(temp.equals(pass))
                {
                    System.out.println("User Verified");
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("Invalid User");
            }
        }
        catch(Exception e)
        {
            System.out.println("Exceptionin main class"+e);
        }
        finally{
            try{
                if(rs!=null)
                    rs.close();
                if(pst!=null)
                    pst.close();
                if(c!=null)
                    c.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    
}
