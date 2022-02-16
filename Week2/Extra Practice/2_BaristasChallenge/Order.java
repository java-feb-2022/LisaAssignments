import java.util.ArrayList;

// Here we're creating a new data type called Order
public class Order {

    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items = new ArrayList<Item>(); // defaults to null

    // CONSTRUCTOR

    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "Guest";
        this.ready = false;
    }

    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.

    public Order(String name) {
        this.name = name;
        this.ready = false;
    }

    // GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String orderName) {
        name = orderName;
    }

    public boolean getReady() {
        return ready;
    }

    public void isReady(boolean ready) {
        this.ready = true;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    // ORDER METHODS

    // Create a method called addItem that takes an Item object as an argument and adds the item to the order's items array. No need to return anything.
    
    public void addItem(Item item) {
        this.items.add(item);
    }

    // Create a method called getStatusMessage that returns a String message. If the order is ready, return "Your order is ready.", if not, return "Thank you for waiting. Your order will be ready soon."
    public String getStatusMessage() {
        if (this.ready == true) {
            return ("Your order is ready fool!");
        } else {
            return ("Thank you for waiting. Your order will be ready soon.");
        }
    }

    //Similar to the getOrderTotal method from the Cafe Business Logic assignment, create a method called getOrderTotal that sums together each of the item's prices, and returns the total amount. 
    // Note: This time, you do not need to pass in a list of prices, because each item object in this order's items array has its own price, that you can access using a getter!

    public double getOrderTotal() {
        double total = 0.00;
        for (Item item : this.items) {
            total += item.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.printf("\n Customer Name: %s \n", this.name);
        for (Item item : this.items) {
            System.out.printf(item.getName() + " - $" + item.getPrice() + "\n");
        }
        System.out.printf("Total: $%s", this.getOrderTotal());
    }
}