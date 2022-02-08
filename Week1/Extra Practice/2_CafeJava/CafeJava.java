public class CafeJava {
    public static void main(String[] args) {
        //APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe KickButt, ";
        String pendingMessage = ", you may or may not get your order";
        String readyMessage = ", come gettttt it";
        String displayTotalMessage = "Pay me this amount now: $";

        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 1.5;
        double lattePrice = 3.5;
        double cappucinoPrice = 2.5;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
        

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;

        // Cindhuri ordered a coffee.
        System.out.println(generalGreeting + customer1);
        System.out.println(customer1 + pendingMessage);
        
        // Noah ordered a cappucino. Use an if statement to check the status of his
        // order and print the correct status message. If it is ready, also print the
        // message to display the total. Note: Outcomes may be different depending on
        // what you assigned as the status.
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappucinoPrice);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }
        
        // Sam just ordered 2 lattes, print the message to display their total. Next, use an if statement to print the appropriate order status message. 
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + (lattePrice + lattePrice));
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }

        // Jimmy just realized he was charged for a coffee but had ordered a latte. Print the total message with the new calculated total (what he owes) to make up the difference.
        System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice));

        // Try changing the price values for each drink and isReady flags (booleans), to test if all of your logic works, even when prices and statuses are changed.


            }
        }
