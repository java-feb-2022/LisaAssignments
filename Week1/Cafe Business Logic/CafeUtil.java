import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
            // System.out.println(sum);
        }
        return sum;
    }
    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
            // System.out.println(sum);
        }
        return sum;
    }
    
    public double getOrderTotal(double[] priceList) {
        double totalPrice = 0;
        // ALTERNATIVE CODE
        // for (int i : priceList) {
        //     totalPrice += i;
        // }
        for (int i = 0; i < priceList.length; i++) {
            totalPrice += priceList[i];
        }
        return totalPrice;
    }
    
    public void displayMenu(ArrayList<String> itemsList) {
        int num = 0;
        for (String item : itemsList) {
            System.out.printf("%s \n", item);
            num += 1;
            // System.out.printf("%s ", itemsList.get(item));
        // }
        //ALTERNATIVE CODE
        // to access an element in an ArrayList using an index
        // for (int i=0; i< itemsList.size(); i++) {
        // System.out.printf("%s \n", itemsList.get(i));
        }

    }
    
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello " + userName);
        System.out.printf("There are %s people in front of you", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }
}
