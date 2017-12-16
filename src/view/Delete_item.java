

package View;

import Controller.ControllerFacade;
import Controller.Delete_itemC;
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
public class Delete_item {
    private JFrame frame;
    private JLabel id;
    private JTextField idtext;
    private JButton delete_item;
    connectSingleton c = connectSingleton.getInstance();
    //Delete_itemC d = new Delete_itemC();
    ControllerFacade d = ControllerFacade.getControllerFacade();
    public Delete_item() {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Delete item");
        id = new JLabel("id");
        idtext = new JTextField(12);
        delete_item = new JButton("Delete");
        JPanel panel = new JPanel();
        panel.add(id);
        panel.add(idtext);
        panel.add(delete_item);
        frame.add(panel);

        delete_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    d.Delete_itemC(Integer.parseInt(idtext.getText()));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Delete_item.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Delete_item.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    public static void main(String[] args) {
        new Delete_item();
    }

}
