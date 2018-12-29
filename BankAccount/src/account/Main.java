package account;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        AccrualOfMoneyThread accrualOfMoney = new AccrualOfMoneyThread(account);
        MoneyTakerThread moneyTaker = new MoneyTakerThread(account);
        accrualOfMoney.start();
        moneyTaker.start();
    }
}
