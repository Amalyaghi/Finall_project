
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
public class Update_itemC {

    connectSingleton c = connectSingleton.getInstance();

    public void Update_itemC(Item i) throws ClassNotFoundException, SQLException {
        c.connect();
        //st = c.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        Statement st = c.getStatement();
        String sql1 = "update item set  name='" + i.getName() + "', price=" + i.getPrice() + ", cost = " + i.getCost() + 
                " , quantity = " + i.getQuantity() + " where id = " +i.getId()+ " ";
        int rows = st.executeUpdate(sql1);

        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Updated successfully");

        } else {
            JOptionPane.showMessageDialog(null, "faild");

        }

    }
}
