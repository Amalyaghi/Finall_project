


package View;

import Controller.ControllerFacade;
import Controller.Sell_itemC;
import DBConnection.connectSingleton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author YaghiAmal
 */
public class Sell_item {
    
    private JFrame frame;
    private JLabel label;
    private JLabel quantity;
    private JTextField quantitytext;
    private JLabel enter;
    private JTextField entertext;
    private String name;
    private JButton sell;
    ResultSet rs;
    connectSingleton c = connectSingleton.getInstance();
    //Sell_itemC se;

    public Sell_item(final String name) throws SQLException, ClassNotFoundException {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Sell an item");

        label = new JLabel("please select item you want to sell:");
        sell = new JButton("Sell");
        quantity = new JLabel("quantity");
        quantitytext = new JTextField(12);
        enter = new JLabel("Enter the paid amount : ");
        entertext = new JTextField(12);

        this.name = name;

        final JComboBox box = new JComboBox();
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(box);
        panel.add(quantity);
        panel.add(quantitytext);
        panel.add(sell);
        panel.add(enter);
        panel.add(entertext);

        frame.add(panel);

        c.connect();
        Statement st = c.getStatement();
        rs = fetch(st);
        while (rs.next()) {
            box.addItem(rs.getString("name"));
        }
        //se =new Sell_itemC();
        final ControllerFacade se = ControllerFacade.getControllerFacade();
        sell.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    se.Sell_item((String)box.getSelectedItem(),name,quantitytext.getText(),Double.parseDouble(entertext.getText()));
                    c.connect();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Sell_item.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Sell_item.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*try {
                    Statement st = c.getStatement();
                    String selectedItem = (String) box.getSelectedItem();
                   rs = fetch1(st, selectedItem);
                    if (rs.next()) {
                        String qua = rs.getString("quantity");
                        int oldQuantity = Integer.parseInt(qua);
                        System.out.println(oldQuantity);
                        int requestedQuantity = Integer.parseInt(quantitytext.getText());
                        System.out.println(requestedQuantity);
                        int newQuantity = oldQuantity - requestedQuantity;
                        System.out.println(newQuantity);
                        double paid = Double.parseDouble(entertext.getText());
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

                        String sql1 = "select * from item where name='" + box.getSelectedItem() + "'";
                        rs=st.executeQuery(sql1);
                        
                        if(rs.next()){
                        double total_price = (rs.getDouble("price") * requestedQuantity);
                        double remainder = total_price - paid;
                        st.execute("insert into invoice(customer,total_cost,total_price,remainder) values ('"
                                + name + "','" + (rs.getDouble("cost") * requestedQuantity) + "','" + total_price + "','" + remainder + "')");
                        st.execute("insert into invoice_details(item,quantity) values ('" + box.getSelectedItem() + "','" + requestedQuantity + "')");
                   
                    }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Sell_item.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter valid amount !");
                }*/

            }
           

        });

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
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new Sell_item("amal");
    }
 
}
