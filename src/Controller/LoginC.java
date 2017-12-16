
package Controller;

import View.Login;
import View.Services;
import DBConnection.connectSingleton;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author YaghiAmal
 */
public class LoginC {
    ResultSet rs;
    connectSingleton c = connectSingleton.getInstance();

    public void LoginC(User user) throws SQLException, ClassNotFoundException {
        c.connect();
        Statement st = c.getStatement();
        rs = fetch(user.getUsername(),user.getPassword());

        if (rs.next()) {

            new Services();
        } else {
            JOptionPane.showMessageDialog(null, "Login failed !! please check your username and password :)");
        }
    }

   public ResultSet fetch(String username , String password) throws SQLException {
  
         Statement sta = c.getStatement();
          String sql = "select * from users where username =  '" + username+ "' and password = '" + password + "'";
          rs = sta.executeQuery(sql);
   
       return rs;
   }
}