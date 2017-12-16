

package View;

import Controller.ControllerFacade;
import Controller.SearchByIdC;
import Controller.SearchByNameC;
import DBConnection.connectSingleton;
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

public class SearchByName {

    private JFrame frame;
    private JLabel name;
    private JTextField nametext;
    private JButton search_for_item;
    connectSingleton c = connectSingleton.getInstance();
    //SearchByNameC s = new SearchByNameC();
    ControllerFacade s = ControllerFacade.getControllerFacade();
    public SearchByName() {

        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Search for item");
        name = new JLabel("name");
        nametext = new JTextField(12);
        search_for_item = new JButton("Search");
        JPanel panel = new JPanel();
        panel.add(name);
        panel.add(nametext);
        panel.add(search_for_item);
        frame.add(panel);

        search_for_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    s.SearchByNameC(nametext.getText());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SearchByName.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SearchByName.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });

    }
}
