public class ATM {

    private int             cardNumber;
    private BankNetwork     network;
    private Keyboard        keyboard;
    private NFCReader       nfcReader;
    private CardReader      cardReader;
    private Printer         printer;
    private CashDispenser   cashDispenser;
    private Screen          screen;

    public ATM() {
        cardNumber = -1;
        network = new BankNetwork();
        keyboard = new Keyboard();
        nfcReader = new NFCReader();
        cardReader = new CardReader();
        printer = new Printer();
        cashDispenser = new CashDispenser();
        screen = new Screen();
    }

    private void deposit(int amount) {
        network.changeBalance(amount); //exceptions // TODO:
    }

    private void withdrawal(int amount) {
        network.changeBalance(-amount); //exceptions // TODO:
    }

    private void transfer(int amount) {
        //uuuuh
    }

    private double checkBalance() { //checks balance of current card number
        return network.getBalance();
    }

    private void depositCheque(int amount) {
        network.changeBalance(amount);
    }

    //private viewTransactions() {}

    public static void main (String[] args) {

    }
}
