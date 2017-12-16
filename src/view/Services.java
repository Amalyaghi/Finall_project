

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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YaghiAmal
 */
public class Services {

    private JFrame frame;
    private JButton add_item;
    private JButton update;
    private JButton search;
    private JButton delete;
    private JButton add_customer;
    private JButton view_items;
    private JButton sell_item;
    private JButton view_daily_movement;
    private JButton view_daily_report;
    private JButton view_invoice_details;
    private JButton pay_previous_invoice;
   // private JTable table;
   // private DefaultTableModel model;

    connectSingleton c = connectSingleton.getInstance();
    ResultSet rs;
    public Services() {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Services");
        add_item = new JButton("Add a new item");
        update = new JButton("Update item information");
        search = new JButton("Search for item");
        delete = new JButton("Delete an item");
        add_customer = new JButton("Add a new customer");
        view_items = new JButton("View all items");
        sell_item = new JButton("Sell an item");
        view_daily_movement = new JButton("View all invoices");
        view_daily_report = new JButton("View report");
        view_invoice_details = new JButton("View invoice details");
        pay_previous_invoice = new JButton("Pay previous invoice");
       // table = new JTable();
       // model = new DefaultTableModel(new String[]{"id", "name", "price", "cost", "quantity"}, 0);
        JPanel panel = new JPanel();
        panel.add(add_item);
        panel.add(update);
        panel.add(search);
        panel.add(delete);
        //panel.add(add_customer);
        panel.add(view_items);
        panel.add(sell_item);
      //  panel.add(view_daily_movement);
        //  panel.add(view_daily_report);
        //  panel.add(view_invoice_details);
        // panel.add(pay_previous_invoice);

        frame.add(panel);

        add_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.connect();
                    Statement st = c.getStatement();
                    rs = fetch(st);

                    if (rs.next()) {

                        new Add_item();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.connect();
                    Statement st = c.getStatement();
                    rs = fetch(st);

                    if (rs.next()) {

                        new Update_item();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.connect();
                    Statement st = c.getStatement();
                    rs = fetch(st);

                    if (rs.next()) {

                      new Search();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.connect();
                    Statement st = c.getStatement();
                    rs = fetch(st);

                    if (rs.next()) {

                        new Delete_item();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        /*        add_customer.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         try {
         c.connect();
         Statement st=c.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
         c.rs =  fetch(st);
             
         if(c.rs.next()){
                        
         new Add_customer();
         }
                   
                    
         } catch (SQLException ex) {
         Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         });*/
        view_items.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.connect();
                    Statement st = c.getStatement();
                    rs = fetch(st);

                    if (rs.next()) {
                    new View_item();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        sell_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.connect();
                    Statement st = c.getStatement();
                    rs = fetch(st);

                    if (rs.next()) {

                        new Customer_name();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        /*  view_daily_movement.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         try {
         c.connect();
         Statement st=c.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
         c.rs =  fetch(st);
             
         if(c.rs.next()){
                        
         new View_invoices();
         }
                   
                    
         } catch (SQLException ex) {
         Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         });*/
        /*   view_daily_report.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         try {
         c.connect();
         Statement st=c.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
         c.rs =  fetch(st);
             
         if(c.rs.next()){
                        
         new View_reports();
         }
                   
                    
         } catch (SQLException ex) {
         Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
         Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         });*/
        /*      view_invoice_details.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         try {
         c.connect();
         Statement st=c.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
         c.rs =  fetch(st);
             
         if(c.rs.next()){
                        
         new view_invoice_details();
         }
                   
                    
         } catch (SQLException ex) {
         Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         }); 
         */
        /*    pay_previous_invoice.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         try {
         c.connect();
         Statement st=c.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
         c.rs =  fetch(st);
             
         if(c.rs.next()){
                        
         new Pay_previous_invoice();
         }
                   
                    
         } catch (SQLException ex) {
         Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         });*/
    }

    public ResultSet fetch(Statement st) {
        try {
            String sql = "select * from item";
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
}
