package View;

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

public class Add_customer {

    private JFrame frame;
    private JLabel name;
    private JTextField nametext;
    private JLabel address;
    private JTextField addresstext;
    private JLabel email;
    private JTextField emailtext;
    private JLabel phone;
    private JTextField phonetext;
    private JButton register;
    connectSingleton c = connectSingleton.getInstance();

    public Add_customer() {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Add customer");
        name = new JLabel("name");
        nametext = new JTextField(12);
        address = new JLabel("address");
        addresstext = new JTextField(12);
        email = new JLabel("email");
        emailtext = new JTextField(12);
        phone = new JLabel("phone");
        phonetext = new JTextField(12);
        register = new JButton("Register");

        JPanel panel = new JPanel();
        panel.add(name);
        panel.add(nametext);
        panel.add(address);
        panel.add(addresstext);
        panel.add(email);
        panel.add(emailtext);
        panel.add(phone);
        panel.add(phonetext);
        panel.add(register);
        frame.add(panel);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    c.connect();
                    Statement st = c.getStatement();

                    st.execute("insert into customer values ('" + nametext.getText() + "','" + addresstext.getText() + "','" + emailtext.getText() + "','" + phonetext.getText() + "')");
                    JOptionPane.showMessageDialog(null, "Added successfully");

                } catch (SQLException ex) {
                    Logger.getLogger(Add_customer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Add_customer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

}
