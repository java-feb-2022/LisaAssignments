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

        // Add item1 to order2's item list and increment the order's total
        order2.total = order2.total + item1.price;

        // order3 ordered a cappucino. Add the cappuccino to their order list and to
        // their tab.
        order3.total = order3.total + item4.price;

        // order4 added a latte. Update accordingly.
        order1.total = order1.total + item2.price;

        // Cindhuri’s order is now ready. Update her status.
        order1.ready = true;

        // Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.total = order4.total + (item2.price * 2);

        // Jimmy’s order is now ready. Update his status.
        order2.ready = true;

        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n Total: %s \n Status: %s \n", order1.name, order1.total, order1.ready);
        System.out.printf("Name: %s\n Total: %s \n Status: %s \n", order2.name, order2.total, order2.ready);
        System.out.printf("Name: %s\n Total: %s \n Status: %s \n", order3.name, order3.total, order3.ready);
        System.out.printf("Name: %s\n Total: %s \n Status: %s \n", order4.name, order4.total, order4.ready);
    }
}
