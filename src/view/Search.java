
package View;

import DBConnection.connectSingleton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author YaghiAmal
 */
public class Search {
     private JFrame frame;
    private JButton search_by_id;
    private JButton search_by_name;
    connectSingleton c = connectSingleton.getInstance();
    public Search(){
    frame=new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Search for item");
        search_by_id = new JButton("Search by id");
        search_by_name = new JButton("Search by name");
        JPanel panel = new JPanel();
        panel.add(search_by_id);    
        panel.add(search_by_name);
        frame.add(panel);
        
              search_by_id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                new SearchById();
                
            }
        });
              
              search_by_name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                new SearchByName();
                
            }
        });
    }
    public static void main(String[] args) {
        new Search();
    }

}
