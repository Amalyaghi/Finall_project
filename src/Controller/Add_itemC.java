

package Controller;

import DBConnection.connectSingleton;
import Model.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author YaghiAmal
 */
public class Add_itemC {

    connectSingleton c = connectSingleton.getInstance();

    public void Add_itemC(Item i) throws ClassNotFoundException, SQLException {
        c.connect();
        Statement st = c.getStatement();

        st.execute("insert into item values (" + i.getId() + ",'" + i.getName() + "'," + i.getPrice() + "," + i.getCost() +
                "," + i.getQuantity() + ")");
        JOptionPane.showMessageDialog(null, "Successfully added");

    }
}
