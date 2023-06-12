/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DatabaseAcc {
    static Connection con;
    public static Connection getDatabaseAcc(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/btl_nhom12","root","");
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseAcc.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseAcc.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }
}
