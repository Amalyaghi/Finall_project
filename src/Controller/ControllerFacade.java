
package Controller;

import Model.Item;
import Model.User;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YaghiAmal
 */
public class ControllerFacade {
    private Add_itemC ai;
    private Add_userC ac;
    private Delete_itemC di;
    private LoginC l;
    private SearchByIdC sbi;
    private SearchByNameC sbn;
    private Sell_itemC si;
    private Update_itemC ui;
    private View_itemC vi;
    private static ControllerFacade cont = new ControllerFacade ();
    
    private ControllerFacade(){
        ai = new Add_itemC();
        ac = new Add_userC();
        di = new Delete_itemC();
        l = new LoginC();
        sbi = new SearchByIdC();
        sbn = new SearchByNameC();
        si = new Sell_itemC();
        ui = new Update_itemC();
        vi = new View_itemC();
    }
    public  static ControllerFacade getControllerFacade(){
        return cont;
    }
    
     public void Add_itemC(Item i) throws ClassNotFoundException, SQLException{
         ai.Add_itemC(i);
     }
     
     public void Add_userC(User u) throws ClassNotFoundException, SQLException{
         ac.Add_userC(u);
     }
     
     public void Delete_itemC(int i) throws ClassNotFoundException, SQLException{
         di.Delete_itemC(i);
     }
     
     public void LoginC(User user) throws SQLException, ClassNotFoundException{
         l.LoginC(user);
     }
     
     public void SearchByIdC(int i) throws ClassNotFoundException, SQLException{
         sbi.searchItem(""+i);
     }
     
     public void SearchByNameC(String n) throws ClassNotFoundException, SQLException{
         sbn.searchItem(n);
     }
     
     public void Sell_item(String box , String name , String quan,double entered){
         si.Sell_item(box, name, quan, entered);
     }
     
     public void Update_itemC(Item i) throws ClassNotFoundException, SQLException{
         ui.Update_itemC(i);
     }
     
     public DefaultTableModel View_itemC() throws ClassNotFoundException, SQLException{
         return vi.View_itemC();
     }
}
