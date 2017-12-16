
package Controller;

import DBConnection.connectSingleton;
import Model.Item;
import View.Add_item;
import View.Delete_item;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author YaghiAmal
 */
public class Delete_itemC {

    connectSingleton c = connectSingleton.getInstance();

    public void Delete_itemC(int i) throws ClassNotFoundException, SQLException {
        c.connect();
        Statement st = c.getStatement();

        st.execute("delete from item " + "where id = " + i + "");
        JOptionPane.showMessageDialog(null, "Deleted successfully");
    }
}
