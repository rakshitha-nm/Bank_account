public class BankService1 {

    
    static class BankAccount {
        private double balance;

      
        BankAccount(double balance) {
            if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
            this.balance = balance;
        }

        
        void deposit(double amount) {
            if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
            balance += amount;
        }

        
        void withdraw(double amount) {
            if (amount <= 0 || amount > balance) throw new IllegalArgumentException("Invalid withdrawal");
            balance -= amount;
        }

        
        double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(5000);

        System.out.println("Initial Balance: " + acc.getBalance());

        acc.deposit(800);
        System.out.println("After deposit: " + acc.getBalance());

        acc.withdraw(100);
        System.out.println("After withdrawal: " + acc.getBalance());
    }
}
