/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salary_management;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sachin
 */
public class Datasource {
    
    public static final String DB_NAME ="salaryManDatabase.db";
    public static final String CONNECTION_STRING ="jdbc:sqlite:C:\\Users\\Sachin\\Desktop\\ppjj123\\Salary_management\\"+DB_NAME;
    
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USERID = "userId";
    public static final String COLUMN_USERNAME = "userName";
    public static final String COLUMN_PASSWORD = "passWord";
    public static final String COLUMN_SECTIONS = "section"; 
    
    
    public static final String LOG_IN_QUERY = "SELECT "+COLUMN_USERID+','+COLUMN_USERNAME+','+COLUMN_PASSWORD+','+COLUMN_SECTIONS+" FROM "+TABLE_USERS+" WHERE ("+COLUMN_USERNAME+"=? AND "+COLUMN_PASSWORD+"=? AND "+
                                                COLUMN_SECTIONS+"=?)";
    
    private  Connection conn;
    
    public  Connection open(){
        try {
//            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            System.out.println("");
            return conn;
        } catch (SQLException e) {
            System.out.println("Exception found : "+e.getMessage());
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public void close(){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Couldn't close connection : "+e.getMessage());
        }
    }
    
    
    
}
