import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {

        // Menu items
        Items item1 = new Items();
        item1.name = "mocha";
        item1.price = 4.25;

        Items item2 = new Items();
        item2.name = "latte";
        item2.price = 4.00;

        Items item3 = new Items();
        item3.name = "drip coffee";
        item3.price = 2.00;

        Items item4 = new Items();
        item4.name = "cappuccino";
        item4.price = 3.75;

        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";

        Order order2 = new Order();
        order2.name = "Jimmy";

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";

        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);
    }
}