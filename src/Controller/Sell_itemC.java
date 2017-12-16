
package Controller;

import DBConnection.connectSingleton;
import Model.Item;
import View.Sell_item;
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
public class Sell_itemC {
    ResultSet rs;
    connectSingleton c = connectSingleton.getInstance();

    public void Sell_item(String box , String name , String quan,double entered) {
        try {
            c.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sell_item.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Sell_item.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Statement st = c.getStatement();
            String selectedItem = (String) box;
            rs = fetch1(st, selectedItem);
            if (rs.next()) {
                String qua = rs.getString("quantity");
                int oldQuantity = Integer.parseInt(qua);
                System.out.println(oldQuantity);
                int requestedQuantity = Integer.parseInt(quan);
                System.out.println(requestedQuantity);
                int newQuantity = oldQuantity - requestedQuantity;
                System.out.println(newQuantity);
                double paid =entered;
                String sql = "update item set quantity = " + newQuantity + " where name = '" + selectedItem + "'";
                if (st.executeUpdate(sql) > 0) {

                    JOptionPane.showMessageDialog(null, "quantity is updated");

                    //System.out.println(c.rs.getInt("id"));
                    if (newQuantity < 15) {
                        JOptionPane.showMessageDialog(null, "Quantity is less than 15");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "faild");

                }

                String sql1 = "select * from item where name='" + box + "'";
                rs = st.executeQuery(sql1);

                if (rs.next()) {
                    double total_price = (rs.getDouble("price") * requestedQuantity);
                    double remainder = total_price - paid;
                    st.execute("insert into invoice(customer,total_cost,total_price,remainder) values ('"
                            + name + "','" + (rs.getDouble("cost") * requestedQuantity) + "','" + total_price + "','" + 
                            remainder + "')");
                    st.execute("insert into invoice_details(item,quantity) values ('" + box + "','" + 
                            requestedQuantity + "')");

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Sell_item.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter valid amount !");
        }

    }

    public ResultSet fetch(Statement st) {
        try {
            String sql = "select name from item";
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Sell_item.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public ResultSet fetch1(Statement st, String name) {
        try {
            String sql = "select quantity from item where name='" + name + "'";
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Sell_item.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
}
