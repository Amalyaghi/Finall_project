package View;

import Controller.Add_itemC;
import Controller.ControllerFacade;
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
public class Add_item {

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
    private JButton add_item;

    connectSingleton c = connectSingleton.getInstance();
    //Add_itemC a = new Add_itemC();
    ControllerFacade a = ControllerFacade.getControllerFacade();
    public Add_item() {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Add item");
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
        add_item = new JButton("Add");
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
        panel.add(add_item);

        frame.add(panel);

        add_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    a.Add_itemC(new Item(Integer.parseInt(idtext.getText()),nametext.getText(),Double.parseDouble(pricetext.getText()),Double.parseDouble(costtext.getText()),Integer.parseInt(quantitytext.getText())));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Add_item.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Add_item.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        new Add_item();
    }

}
