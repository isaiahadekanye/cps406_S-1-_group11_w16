public class Printer {
    public void printReceipt(int an, double ch, double sa) {
        System.out.println("Printer: Receipt:");
        System.out.println("     Account Number: " + an);
        System.out.format( "     Chequing Balance: $%.2f\n", ch);
        System.out.format( "     Savings Balance: $%.2f\n", sa);
        System.out.println("     Thank You!\n");
    }
}
