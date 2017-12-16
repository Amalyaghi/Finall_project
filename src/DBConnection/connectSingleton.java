/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author YaghiAmal
 */
public class connectSingleton {
    
    /*  Connection conn;
     Statement st;
     ResultSet rs;

     public void connect() {
     try {
          
     String driver= "com.mysql.jdbc.Driver";

     Class.forName(driver);
     //  String db = "jdbc:odbc:ww";

     String db = "jdbc:mysql://localhost/supermarket";

     conn = DriverManager.getConnection(db, "root", "");
     //   st = conn.createStatement();
     st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            
     } catch (SQLException ex) {
     Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
     Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
     }
     }

     public void disconnect() {
     try {
     conn.close();
     st.close();
     rs.close();
     } catch (Exception ex) {
     }
     }*/
    private static connectSingleton jdbc = new connectSingleton();
    private Connection conn;
    private Statement st;
    private ResultSet rs;

    private connectSingleton() {
    }

    public static connectSingleton getInstance() {
        if (jdbc == null) {
            jdbc = new connectSingleton();
        }
        return jdbc;
    }

    public void connect() throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.jdbc.Driver";

        Class.forName(driver);
        //  String db = "jdbc:odbc:ww";

        String db = "jdbc:mysql://localhost/supermarket";

        conn = DriverManager.getConnection(db, "root", "");
        //   st = conn.createStatement();
        st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    }

    public void disconnect() {
        try {
            conn.close();
            st.close();
            rs.close();
        } catch (Exception ex) {
        }
    }
    
    public Statement getStatement() throws SQLException{
        if(st == null){
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
        }
        return st;
    }
    
    public Connection getConnection(){
       return conn;
    }
    

}
