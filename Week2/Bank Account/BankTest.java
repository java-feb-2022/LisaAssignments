public class BankTest {
    public static void main(String[] args) {
        BankAccount customer1 = new BankAccount();
        BankAccount customer2 = new BankAccount();
        System.out.println(BankAccount.numberOfAccounts);
        
        customer1.totalMoney();
    }
}
