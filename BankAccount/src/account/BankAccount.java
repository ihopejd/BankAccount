package account;

class BankAccount {
    private int balance;

    int getBalance() {
        return  balance;
    }

    void increaseOfCash(int money) {
        balance += money;
    }

    void gettingOfMoney(int money) {
        balance -= money;
    }

}
