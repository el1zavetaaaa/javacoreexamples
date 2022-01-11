package javacoreexample.threadsconcurrent.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private final Lock lock = new ReentrantLock();
    private final Condition balanceIncreased = lock.newCondition();

    private long balance;

    public Account() {
        this(0L);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(long amount) {
        checkAmountNotNegative(amount);
        lock.lock();
        try {
            balance += amount;
            balanceIncreased.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void withdraw(long amount) {
        checkAmountNotNegative(amount);
        lock.lock();
        try {
            if (balance < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }

    }

    public void waitAndWithdraw(long amount) throws InterruptedException {
        checkAmountNotNegative(amount);
        lock.lock();
        try {
            while (balance < amount) {
                balanceIncreased.await();
                System.out.println("awake");
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }

    }

    public static void checkAmountNotNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}
