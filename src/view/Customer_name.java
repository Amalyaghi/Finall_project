
package View;

import DBConnection.connectSingleton;
import View.Add_customer;
import View.Sell_item;
import View.Services;
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

public class Customer_name {
    private JFrame frame;
    private JLabel cname;
    private JTextField cnametext;
    private JButton ok;
    private JButton cancel;
    ResultSet rs;
    connectSingleton c = connectSingleton.getInstance();
    public Customer_name(){
       frame=new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Sell item");  
        cname = new JLabel("Customer name");
        cnametext = new JTextField(12);
        ok = new JButton("Ok");
        cancel = new JButton("Cancel");
        JPanel panel = new JPanel();
        panel.add(cname);
        panel.add(cnametext);
        panel.add(ok);
        panel.add(cancel);
        frame.add(panel);
        
        
          ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.connect();
                    Statement st = c.getStatement();
                    rs =  fetch(st);
             
                    if(rs.next()){
                        
                      new Sell_item(rs.getString("name"));
                     }
                    else{
                        JOptionPane.showMessageDialog(null, "customer name not found .. Press OK to insert new customer : ");
                        new Add_customer();
                    }
                   
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_name.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Customer_name.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
         cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
              
                  
                new Services();
                    
            }
                
            
        });
    }
    
    
     public ResultSet fetch(Statement st) throws SQLException{
        
            String sql="select name from customer where name = '"+cnametext.getText()+"'"; 
            rs=st.executeQuery(sql);
       
        
        return rs;
    }
 
}
