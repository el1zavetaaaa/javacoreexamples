package javacoreexample.threads.synchronization.account;

public class SynchronizedAccount {
    public static void main(String[] args) {
        Account account = new Account(100_000);
        System.out.println("Begin balance= " + account.getBalance());

        Thread withdrawThread = new WithdrawThread(account);
        Thread depositThread = new DepositThread(account);

        withdrawThread.start();
        depositThread.start();

        try {
            withdrawThread.join();
            depositThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End balance= " + account.getBalance());

    }

    private static class WithdrawThread extends Thread {
        private final Account account;

        private WithdrawThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.withdraw(1);
            }
        }
    }

    private static class DepositThread extends Thread {
        private final Account account;

        private DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.deposit(1);

            }
        }
    }
}
