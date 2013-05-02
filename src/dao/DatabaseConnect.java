package dao;

import java.sql.*;
import javax.swing.*;

public class DatabaseConnect {
    
   static Connection conn = null;
    
    public static Connection ConnectDb(){
        
        try{
            Class.forName("org.sqlite.JDBC");
            if(conn == null){
            	conn= DriverManager.getConnection("jdbc:sqlite:C:\\Users\\svkt\\Documents\\NetBeansProjects\\smps\\trunk\\SMPSBar\\SPMS.sqlite");
            	//JOptionPane.showMessageDialog(null, "Connection Established");
            }            
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "DatabaseConnect exception");
            return null;
        }
        return conn;
    }
    
    
}
