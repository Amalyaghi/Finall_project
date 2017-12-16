

package View;

import Controller.Add_userC;
import Controller.ControllerFacade;
import DBConnection.connectSingleton;
import Model.User;
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

public class Add_user {
     private JFrame frame;
    private JLabel username;
    private JTextField usernametext;
    private JLabel password;
    private JTextField passwordtext;
    private JButton register;
    
    connectSingleton c = connectSingleton.getInstance();
   // Add_userC a = new Add_userC();
    ControllerFacade a = ControllerFacade.getControllerFacade();
    public Add_user(){
      frame=new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Add user"); 
        username=new JLabel("User name: ");
        usernametext=new JTextField(12);
        password=new JLabel("Password");
        passwordtext=new JTextField(12);
        register=new JButton("Register");
        JPanel panel = new JPanel();
        panel.add(username);
        panel.add(usernametext);
        panel.add(password);
        panel.add(passwordtext);
        panel.add(register);
        frame.add(panel);
        
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    a.Add_userC(new User (usernametext.getText(),passwordtext.getText()));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Add_user.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Add_user.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
   
}
}