public class CashDispenser {
    public void dispenseCash(double amount) {
        System.out.format("CashDispenser: Dispensed: %.2lf\n", amount);
    }

    public static void main (String[] args) {
        CashDispenser a = new CashDispenser();
        a.dispenseCash(500.13);
    }
}
