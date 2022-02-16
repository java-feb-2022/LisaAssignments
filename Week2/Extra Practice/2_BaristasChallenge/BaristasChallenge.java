public class BaristasChallenge {
    public static void main(String[] args) {

        // Menu Item
        Item item1 = new Item("mocha", 4.25);
        Item item2 = new Item("latte", 4.00);
        Item item3 = new Item("drip coffee", 2.00);
        Item item4 = new Item("cappuccino", 3.75);

        // Create 2 orders for unspecified guests (without specifying a name);
        Order order1 = new Order();
        Order order2 = new Order();
        
        // Create 3 orders using the overloaded constructor to give each a name for the order.
        Order order3 = new Order("Lisa");
        Order order4 = new Order("Saria");
        Order order5 = new Order("Sephiroth");

        // Add at least 2 items to each of the orders using the addItem method you wrote, for example, to add item1 to order3 you would need to call the addItem method from the order3 instance like so: order3.addItem(item1);
        order1.addItem(item3);
        order1.addItem(item1);
        order2.addItem(item4);
        order2.addItem(item2);
        order3.addItem(item2);
        order3.addItem(item3);
        order4.addItem(item1);
        order4.addItem(item1);
        order5.addItem(item3);
        order5.addItem(item4);

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        // Test your getStatusMessage functionality by setting some orders to ready and printing the messages for each order. For example: order2.setReady(true);
        // System.out.println(order2.getStatusMessage());
        order2.isReady(true);
        order4.isReady(true);
        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());
        System.out.println(order3.getStatusMessage());
        System.out.println(order4.getStatusMessage());
        System.out.println(order5.getStatusMessage());


    }
}
