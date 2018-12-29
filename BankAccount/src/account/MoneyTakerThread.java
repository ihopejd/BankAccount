package account;

public class MoneyTakerThread extends Thread {
    private final BankAccount account;

    MoneyTakerThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (account) {
                while (account.getBalance() < 5_000) {
                    try {
                        System.out.printf("Ошибка. Для списания %d, на балансе недостаточно средств. Необходимо пополнить баланс. \n", 5_000);
                        account.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (account.getBalance() > 0) {
                    account.gettingOfMoney(5_000);
                    System.out.printf("Произошло снятие средств со счёта в размере %d . Баланс: %s \n", 5_000, account.getBalance());
                }
            }
        }
    }
}
