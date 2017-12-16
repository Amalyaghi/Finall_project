

package View;

import Controller.ControllerFacade;
import Controller.SearchByIdC;
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
public class SearchById {
     private JFrame frame;
    private JLabel id;
    private JTextField idtext;
    private JButton search_for_item;
    connectSingleton c  = connectSingleton.getInstance();
    //SearchByIdC s = new SearchByIdC();
    ControllerFacade s = ControllerFacade.getControllerFacade();
    public SearchById(){
        frame=new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Search for item");
        id = new JLabel("id");
        idtext = new JTextField(12);
        search_for_item = new JButton("Search");
        JPanel panel= new JPanel();
        panel.add(id);
        panel.add(idtext);
        panel.add(search_for_item);
        frame.add(panel);
        
        search_for_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    s.SearchByIdC(Integer.parseInt(idtext.getText()));
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(SearchById.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }
}
