import java.util.Random;

public class BankAccount {
    private int accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    // class variable for the number of accounts objects instantiated
    public static int numberOfAccounts = 0;
    public static double amountInBank = 0;

    public int getAccountNumber() {
        Random randMachine = new Random();
        int randNum = randMachine.nextInt(1000000000,999999999);
        return randNum;
    }

    public BankAccount() {
        this.accountNumber = getAccountNumber();
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numberOfAccounts++;
    }

    public double getChecking() {
        return this.checkingBalance;
    }

    public double getSavings() {
        return this.savingsBalance;
    }

    // Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
    public void depositMoney(double num, String account) {
        if (account.equals("checking")) {
            this.checkingBalance += num;
        } else if (account.equals("savings")) {
            this.savingsBalance += num;
        }
        BankAccount.amountInBank += num;
    }

    // Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
    public void withdrawMoney(double num, String account) {
        if (account.equals("checking")) {
            if (this.checkingBalance - num >= 0) {
                this.checkingBalance -= num;
            }
        } 
        else if (account.equals("savings")) {
            if (this.savingsBalance - num >= 0) {
            this.savingsBalance -= num;
            }
        }
        else {
            System.out.println("There is not enough in your account");
        }
        BankAccount.amountInBank -= num;
    }
    
    public void totalMoney() {
        System.out.printf("Account Number: %s \n Checking Balance: %s \n Savings Balance: %s",getAccountNumber(), getChecking(), getSavings());
    }


}