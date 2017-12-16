
package View;

import java.sql.SQLException;

/**
 *
 * @author YaghiAmal
 */
public class ViewFacade {
    private Add_customer ac;
    private Add_item ai;
    private Add_user au;
    private Customer_name cn;
    private Delete_item di;
    private  Login l;
    private Search s;
    private SearchById sbi;
    private SearchByName sbn;
    private Sell_item si;
    private Services se;
    private Update_item ui;
    private View_item vi;
    
    public ViewFacade() throws SQLException, ClassNotFoundException{
        ac = new Add_customer();
        ai = new Add_item();
        au = new Add_user();
        cn = new Customer_name();
        di = new Delete_item();
        l = new Login();
        s = new Search();
        sbi = new SearchById();
        sbn = new SearchByName();
        //si = new Sell_item(null);
        se = new Services();
        ui = new Update_item();
        vi = new View_item();
    }
    
}
