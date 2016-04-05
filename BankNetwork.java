import java.util.TreeMap;

public class BankNetwork {
    private int accountNum;
    private static TreeMap<Integer, Account> accounts;

    public BankNetwork() {
        accountNum = -1;
        accounts = new TreeMap<>();
    }

    public boolean verifyPin(int accountNumber, int pinNumber) {
        accountNum = accountNumber;
        if (accounts.get(accountNum) == null) accounts.put(accountNum, new Account(0.0,0.0));
        return true;
    }

    public void changeBalance(boolean chequing, double amount) throws Exception { //changes to ammount!!!
        if (chequing) {
            if (accounts.get(accountNum).chequing + amount < 0) throw new IllegalArgumentException();
            accounts.get(accountNum).chequing += amount;
        } else {
            if (accounts.get(accountNum).savings + amount < 0) throw new IllegalArgumentException();
            accounts.get(accountNum).savings += amount;
        }
    }

    public double getBalance(boolean chequing) {
        return chequing ? accounts.get(accountNum).chequing : accounts.get(accountNum).savings;
    }

    private class Account {
        public double chequing;
        public double savings;

        public Account (double c, double s) {
            chequing = c;
            savings = s;
        }
    }
}
