
package Controller;

import DBConnection.connectSingleton;
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
public class SearchByNameC implements ISearch{
    ResultSet rs;
    connectSingleton c = connectSingleton.getInstance();
    /*public void search(String n) throws ClassNotFoundException, SQLException{
           c.connect();
           Statement st = c.getStatement();
            String selectSQL = "select * from item where name = '"+ n +"'";  
            
           rs =  st.executeQuery(selectSQL);
       
            if(rs.next()){
            
                JOptionPane.showMessageDialog(null, "This item exists");
          
             } else{
               JOptionPane.showMessageDialog(null, "This item doesn't exists");
           } 
    }*/

    @Override
    public void searchItem(String value) {
        try {
            c.connect();
            Statement st = c.getStatement();  
            String selectSQL = "select * from item where name = '"+ value +"'";
            
            rs =  st.executeQuery(selectSQL);
            
            if(rs.next()){
                
                JOptionPane.showMessageDialog(null, "This item exists");
                
            } else{
                JOptionPane.showMessageDialog(null, "This item doesn't exists");
            } 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchByNameC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchByNameC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
