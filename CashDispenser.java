public class CashDispenser {
    public void dispenseCash(double amount) {
        System.out.format("Cash Dispenser: Dispensed: $%.2f\n", amount);
    }

    public static void main (String[] args) {
        CashDispenser a = new CashDispenser();
        a.dispenseCash(500.13);
    }
}
