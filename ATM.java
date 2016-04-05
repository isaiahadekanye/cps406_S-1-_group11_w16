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

    private void deposit(boolean chequing, int amount) {
        try {
            network.changeBalance(chequing, amount); //exceptions // TODO:
        } catch (Exception e) {}
    }

    private void withdrawal(boolean chequing, int amount) {
        try {
            network.changeBalance(chequing, -amount); //exceptions // TODO:
        } catch (Exception e) {}
    }

    private double checkBalance(boolean chequing) { //checks balance of current card number
        return network.getBalance(chequing);
    }

    private void depositCheque(boolean chequing, int amount) {
        try {
            network.changeBalance(chequing, amount); //exceptions // TODO:
        } catch (Exception e) {}
    }

    public void run() {
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
                    screen.depositCash();
                    try {
                        network.changeBalance(false, keyboard.getEnteredAmount());
                    } catch (Exception e) {
                        screen.invalidWithdrawCash();
                    } //it will never throw
                    break;
                case 2: //deposit chequhqe
                    screen.depositCheque();
                    try {
                        network.changeBalance(false, keyboard.getEnteredAmount());
                    } catch (Exception e) {
                        screen.invalidWithdrawCash();
                    } //it will never throw
                    break;
                case 3: //withd cash
                    screen.withdrawCash();
                    try {
                        network.changeBalance(false, -keyboard.getEnteredAmount());
                        break;
                    } catch (Exception e) {
                        screen.invalidWithdrawCash();
                    }
                    break;
                case 4: //check balance
                    screen.accountSelect();
                    choice = keyboard.getSelectedOption(2);
                    screen.checkBalance(network.getBalance(choice != 1));
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
        choice = keyboard.getSelectedOption(2);
        if (choice == 1) {
            int accountNumber = ifCard ? cardReader.getCardNumber() : nfcReader.getNFCNumber();
            printer.printReceipt(accountNumber, network.getBalance(false), network.getBalance(true));
        }

        if (ifCard) {
            screen.returnCard();
            cardReader.returnCard();
        }
        screen.done();
    }

    //private viewTransactions() {}

    public static void main (String[] args) {
        ATM atm = new ATM();
        while(true) atm.run();
    }
}
