package Model;

/**
 *
 * @author YaghiAmal
 */
public class Item {
   private int id ;
   private String name ;
   private double price ;
   private double cost ;
   private int quantity;

    public Item(int id, String name, double price, double cost, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
    }

    Item() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }
   
   
}
