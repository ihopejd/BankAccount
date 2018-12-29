package account;

public class AccrualOfMoneyThread extends Thread {
    private final BankAccount account;

    AccrualOfMoneyThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (account) {
                account.increaseOfCash(1_000);
                System.out.printf("Пополнение баланса на сумму: %d. Баланс: %s \n", 1_000, account.getBalance());
                account.notifyAll();
            }
        }
    }
}
