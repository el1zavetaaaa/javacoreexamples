package javacoreexample.threads.synchronization.account;

public class Account {

    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public Account() {
        this(0L);
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amount) {
        checkAmountNotNegative(amount);
        balance += amount;
        notifyAll();
    }

    public void withdraw(long amount) {
        checkAmountNotNegative(amount);
        synchronized (this) {
            if (balance < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            balance -= amount;
        }
    }

    public synchronized void waitAndWithdraw(long amount) throws InterruptedException {
        checkAmountNotNegative(amount);
        while (balance < amount) {
            wait();
        }
        balance -= amount;
    }

    public static void checkAmountNotNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}
