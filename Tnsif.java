abstract class Account {
    protected double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract double getBalance();

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.03;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount + (amount * INTEREST_RATE);
        System.out.println("SavingsAccount: Deposited " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("SavingsAccount: Withdrawn " + amount);
        } else {
            System.out.println("SavingsAccount: Insufficient balance!");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

class CheckingAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 500;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("CheckingAccount: Deposited " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + OVERDRAFT_LIMIT >= amount) {
            balance -= amount;
            System.out.println("CheckingAccount: Withdrawn " + amount);
        } else {
            System.out.println("CheckingAccount: Overdraft limit exceeded!");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

public class Tnsif {
    public static void main(String[] args) {
        Account savings = new SavingsAccount(1000);
        Account checking = new CheckingAccount(500);

        savings.deposit(200);
        savings.withdraw(100);
        savings.displayBalance();

        System.out.println();

        checking.deposit(300);
        checking.withdraw(700);
        checking.displayBalance();
    }
}
