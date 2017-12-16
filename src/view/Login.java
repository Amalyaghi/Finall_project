
package View;

import Controller.ControllerFacade;
import Controller.LoginC;
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
public class Login {

    private JFrame frame;
    private JLabel username;
    private JTextField usernametext;
    private JLabel password;
    private JTextField passwordtext;
    private JButton login;
    private JButton register;
    private JButton cancel;
   // private LoginC log;

    connectSingleton c;

    public Login() {
        
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Login");
        username = new JLabel("User name: ");
        usernametext = new JTextField(12);
        password = new JLabel("Password");
        passwordtext = new JTextField(12);
        login = new JButton("Login");
        register = new JButton("Register");
        cancel = new JButton("Cancel");
        c = connectSingleton.getInstance();

        JPanel panel = new JPanel();
        panel.add(username);
        panel.add(usernametext);
        panel.add(password);
        panel.add(passwordtext);
        panel.add(login);
        panel.add(register);
        panel.add(cancel);

        frame.add(panel);
        //log = new LoginC();
        final ControllerFacade log = ControllerFacade.getControllerFacade();
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    log.LoginC(new User(usernametext.getText(),passwordtext.getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new Add_user();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

    }

    
    public static void main(String[] args) {
        new Login();
    }
}
