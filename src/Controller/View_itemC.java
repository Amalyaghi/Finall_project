
package Controller;

import DBConnection.connectSingleton;
import Model.Item;
import View.Sell_item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YaghiAmal
 */
public class View_itemC {
    ResultSet rs;
    connectSingleton c = connectSingleton.getInstance();
    DefaultTableModel model;

    public DefaultTableModel View_itemC() throws ClassNotFoundException, SQLException {
        c.connect();
        Statement st = c.getStatement();
        rs = fetch(st);
        model = new DefaultTableModel(new String[]{"id", "name", "price", "cost", "quantity"}, 0);
        while (rs.next()) {

            int a = rs.getInt("id");
            String b = rs.getString("name");
            double e = rs.getDouble("price");
            double d = rs.getDouble("cost");
            int s = rs.getInt("quantity");
            model.addRow(new Object[]{a, b, e, d, s});

        }
        return model;
    }

    public ResultSet fetch(Statement st) throws SQLException {
            String sql = "select * from item";
            rs = st.executeQuery(sql);
        return rs;
    }
}
