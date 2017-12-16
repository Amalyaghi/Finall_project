
package Model;

/**
 *
 * @author YaghiAmal
 */
public class ModelFacade {

    private Item i;
    private User u;
    
    private ModelFacade(){
        i = new Item();
        u = new User();  
    }
    
    public void setUsername(String username) {
      u.setUsername(username);
    }

    public void setPassword(String password) {
        u.setPassword(password);
    }

    public String getUsername() {
        return u.getUsername();
    }

    public String getPassword() {
        return u.getPassword();
    }
    
    public void setId(int id) {
        i.setId(id);
    }

    public void setName(String name) {
        i.setName(name);
    }

    public void setPrice(double price) {
       i.setPrice(price);
    }

    public void setCost(double cost) {
        i.setCost(cost);
    }

    public void setQuantity(int quantity) {
        i.setQuantity(quantity);
    }

    public int getId() {
        return i.getId();
    }

    public String getName() {
        return i.getName();
    }

    public double getPrice() {
        return i.getPrice();
    }

    public double getCost() {
        return i.getCost();
    }

    public int getQuantity() {
        return i.getQuantity();
    }

}
