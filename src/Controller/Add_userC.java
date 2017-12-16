
package Controller;

import DBConnection.connectSingleton;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author YaghiAmal
 */
public class Add_userC {

    connectSingleton c = connectSingleton.getInstance();

    public void Add_userC(User u) throws ClassNotFoundException, SQLException {
        c.connect();
        Statement st = c.getStatement();

        st.execute("insert into users values ('" + u.getUsername() + "','" + u.getPassword() + "')");
        JOptionPane.showMessageDialog(null, "User added successfully");
    }
}
