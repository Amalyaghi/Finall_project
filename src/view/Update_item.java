

package View;

import Controller.ControllerFacade;
import Controller.Update_itemC;
import DBConnection.connectSingleton;
import Model.Item;
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
public class Update_item {

    private JFrame frame;
    private JLabel id;
    private JTextField idtext;
    private JLabel name;
    private JTextField nametext;
    private JLabel price;
    private JTextField pricetext;
    private JLabel cost;
    private JTextField costtext;
    private JLabel quantity;
    private JTextField quantitytext;
    private JButton update_item;
    Statement st;

    connectSingleton c = connectSingleton.getInstance();
    //Update_itemC u = new Update_itemC();
    ControllerFacade u = ControllerFacade.getControllerFacade();
    public Update_item() throws SQLException {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Update item");
        id = new JLabel("id");
        idtext = new JTextField(12);
        name = new JLabel("name");
        nametext = new JTextField(12);
        price = new JLabel("price");
        pricetext = new JTextField(12);
        cost = new JLabel("cost");
        costtext = new JTextField(12);
        quantity = new JLabel("quantity");
        quantitytext = new JTextField(12);
        update_item = new JButton("Update");
        JPanel panel = new JPanel();
        panel.add(id);
        panel.add(idtext);
        panel.add(name);
        panel.add(nametext);
        panel.add(price);
        panel.add(pricetext);
        panel.add(cost);
        panel.add(costtext);
        panel.add(quantity);
        panel.add(quantitytext);
        panel.add(update_item);

        frame.add(panel);

        update_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    u.Update_itemC(new Item(Integer.parseInt(idtext.getText()),nametext.getText(),Double.parseDouble(pricetext.getText()),Double.parseDouble(costtext.getText()),Integer.parseInt(quantitytext.getText())));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Update_item.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Update_item.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public static void main(String[] args) throws SQLException {
        new Update_item();
    }
}
