

package View;

import Controller.ControllerFacade;
import Controller.View_itemC;
import DBConnection.connectSingleton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YaghiAmal
 */
public class View_item {

    private JFrame frame;
    private JTable table;
    
    connectSingleton c = connectSingleton.getInstance();
    //View_itemC v = new View_itemC();
    ControllerFacade v = ControllerFacade.getControllerFacade();
    
    public View_item(/*JTable table,DefaultTableModel model*/) throws SQLException, ClassNotFoundException {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setTitle("View items");
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        table = new JTable();

        DefaultTableModel model = v.View_itemC();
       

        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        table.setFillsViewportHeight(true);
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        panel.add(scroll);
        frame.add(panel);
    }

   
}
