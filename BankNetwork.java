import java.util.TreeMap;

public class BankNetwork {
    private int accountNum;
    private static TreeMap<Integer, Double> accounts;

    public BankNetwork() {
        accountNum = -1;
        accounts = new TreeMap<>();
    }

    public boolean verifyPin(int accountNumber, int pinNumber) {
        accountNum = accountNumber;
        if (accounts.get(accountNum) == null) accounts.put(accountNum, 0.0);
        return true;
    }

    public void changeBalance(double amount) throws Exception {
        if (accountNum == -1) throw new Exception("noCurrentAccountException");
        if (amount > accounts.get(accountNum)) throw new Exception("InsufficientFundsException");

        accounts.put(accountNum, amount);
    }

    public double getBalance() {
        return accounts.get(accountNum);
    }
}
