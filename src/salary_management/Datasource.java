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
    
    public static final String TABLE_STAFF_INFORMATION = "staff_information";
    public static final String COLUMN_STAFF_USERID = "userId";
    public static final String COLUMN_STAFF_FIRST_NAME = "first_name";
    public static final String COLUMN_STAFF_LAST_NAME = "last_name";
    public static final String COLUMN_STAFF_DATE_OF_BIRTH = "date_of_birth";
    public static final String COLUMN_STAFF_EMAIL = "email";
    public static final String COLUMN_STAFF_CONTACT_NUMBER = "contact_num";
    public static final String COLUMN_STAFF_ADDRESS1 = "address1";
    public static final String COLUMN_STAFF_ADDRESS2 = "address2";
    public static final String COLUMN_STAFF_NIC_NUMBER = "nic_number";
    public static final String COLUMN_STAFF_POSTAL_CODE = "postal_code";
    public static final String COLUMN_STAFF_DESIGNATION = "designation";
    public static final String COLUMN_STAFF_DEPARTMENT = "department";
    public static final String COLUMN_STAFF_BASIC_SALARY = "basic_salary";
    public static final String COLUMN_STAFF_REGISTER_DATE = "register_date";
    public static final String COLUMN_STAFF_IMAGE = "image";
    
    
    
    
    
    
    public static final String LOG_IN_QUERY = "SELECT "+COLUMN_USERID+','+COLUMN_USERNAME+','+COLUMN_PASSWORD+','+COLUMN_SECTIONS+" FROM "+TABLE_USERS+" WHERE ("+COLUMN_USERNAME+"=? AND "+COLUMN_PASSWORD+"=? AND "+
                                                COLUMN_SECTIONS+"=?)";
    
    public static final String CREATE_EMPLOYEE_QUERY = "INSERT INTO "+TABLE_STAFF_INFORMATION+"("+COLUMN_STAFF_FIRST_NAME+','+COLUMN_STAFF_LAST_NAME+','+COLUMN_STAFF_DATE_OF_BIRTH+','+
                                                        COLUMN_STAFF_EMAIL+','+COLUMN_STAFF_CONTACT_NUMBER+','+COLUMN_STAFF_ADDRESS1+','+COLUMN_STAFF_ADDRESS2+','+COLUMN_STAFF_NIC_NUMBER+','+
                                                        COLUMN_STAFF_POSTAL_CODE+','+COLUMN_STAFF_DESIGNATION+','+COLUMN_STAFF_DEPARTMENT+','+COLUMN_STAFF_BASIC_SALARY+','+COLUMN_STAFF_REGISTER_DATE+','+
                                                        COLUMN_STAFF_IMAGE+") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
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
