public class ATM {

    private BankNetwork     network;
    private Keyboard        keyboard;
    private NFCReader       nfcReader;
    private CardReader      cardReader;
    private Printer         printer;
    private CashDispenser   cashDispenser;
    private Screen          screen;

    public ATM() {
        network = new BankNetwork();
        keyboard = new Keyboard();
        nfcReader = new NFCReader();
        cardReader = new CardReader();
        printer = new Printer();
        cashDispenser = new CashDispenser();
        screen = new Screen();
    }

    private void deposit() {
        screen.depositCash();
        try {
            network.changeBalance(false, keyboard.getEnteredAmount());
        } catch (Exception e) {
            screen.invalidWithdrawCash();
        } //it will never throw
    }

    private void withdrawal() {
        screen.withdrawCash();
        double amount = keyboard.getEnteredAmount();
        try {
            network.changeBalance(false, -amount);
            cashDispenser.dispenseCash(amount);
        } catch (Exception e) {
            screen.invalidWithdrawCash();
        }
    }

    private void checkBalance() { //checks balance of current card number
        screen.accountSelect();
        int c = keyboard.getSelectedOption(2);
        screen.checkBalance(network.getBalance(c != 1));
    }

    private void depositCheque() {
        screen.depositCheque();
        try {
            network.changeBalance(false, keyboard.getEnteredAmount());
        } catch (Exception e) {
            screen.invalidWithdrawCash();
        } //it will never throw
    }

    public boolean run() {
        boolean ifCard = false;

        screen.initialScreen();
        int choice = keyboard.getSelectedOption(2);
        switch (choice) {
            case 1:
                ifCard = true;
                screen.accountNumber();
                cardReader.validateCard(keyboard.getEnteredNumber());
                screen.cardVerification();
                network.verifyPin(cardReader.getCardNumber(), keyboard.getEnteredPin());
                break;
            case 2:
                screen.accountNumber();
                nfcReader.validateNFC(keyboard.getEnteredNumber());
                screen.phoneVerification();
                network.verifyPin(nfcReader.getNFCNumber(), keyboard.getEnteredPin());
        }
        screen.validated();

        boolean go = true;
        while (go) {
            screen.displayMenu();
            choice = keyboard.getSelectedOption(6);
            switch (choice) {
                case 1: //deposit cash
                    deposit();
                    break;
                case 2: //deposit chequhqe
                    depositCheque();
                    break;
                case 3: //withd cash
                    withdrawal();
                    break;
                case 4: //check balance
                    checkBalance();
                    break;
                case 5: //trasfera b
                    double amount;
                    screen.transferFunds1();
                    choice = keyboard.getSelectedOption(2);
                    screen.transferFunds2();
                    amount = keyboard.getEnteredAmount();
                    try {
                        network.changeBalance(choice != 1, -amount);
                    } catch (Exception e) {
                        screen.invalidWithdrawCash();
                    }
                    try {
                        network.changeBalance(choice == 1, amount);
                    } catch (Exception e) {
                        screen.invalidWithdrawCash();
                    }
                    break;
                case 6: //exit
                    go = false;
            }
        }

        screen.printDetails();
        choice = keyboard.getSelectedOption(3);
        if (choice == 1) {
            int accountNumber = ifCard ? cardReader.getCardNumber() : nfcReader.getNFCNumber();
            printer.printReceipt(accountNumber, network.getBalance(false), network.getBalance(true));
        }
        if (choice == 3) {
             return false;
        }

        if (ifCard) {
            screen.returnCard();
            cardReader.returnCard();
        }
        screen.done();
        return true;
    }

    //private viewTransactions() {}

    public static void main (String[] args) {
        ATM atm = new ATM();
        while(atm.run());
    }
}
