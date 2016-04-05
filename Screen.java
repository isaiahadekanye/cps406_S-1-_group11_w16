public class Screen {
    public void initialScreen() {
        System.out.println("Welcome to an ATM, please provide card or NFC verification");
        System.out.println("1. Card");
        System.out.println("2. NFC");
    }

    public void phoneVerification() {
        System.out.println("Please provide phone verification");
    }

    public void cardVerification() {
        System.out.println("Please provide card verification");
    }

    public void validated() {
        System.out.println("Validated");
    }

    public void accountNumber() {
        System.out.println("Please provide account number:");
    }

    public void displayMenu() {
        System.out.println("\nChoose what to do:");
        System.out.println("1. Deposit Cash");
        System.out.println("2. Deposit Cheque");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Check Balance");
        System.out.println("5. Transfer Balances");
        System.out.println("6. Exit");
    }

    public void accountSelect() {
        System.out.println("Which account?");
        System.out.println("1. Chequing");
        System.out.println("2. Savings");
    }

    public void printDetails() {
        System.out.println("Want a reciept?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    public void depositCash() {
        System.out.println("Enter amount of cash to deposit:");
    }

    public void returnCard() {
        System.out.println("Returning Card");
    }

    public void withdrawCash() {
        System.out.println("Enter amount of cash to withdraw:");
    }
    public void invalidWithdrawCash() {
        System.out.println("Insufficient Funds/Invalid amount");
    }

    public void checkBalance(double value) {
        System.out.format("Current Balance: $%.2f\n", value);
    }

    public void depositCheque() {
        System.out.println("Enter value of cheque to deposit:");
    }

    public void transferFunds1() {
        System.out.println("Choose transfer direction:");
        System.out.println("1. Chequing to Savings");
        System.out.println("2. Savings to Chequing");
    }

    public void transferFunds2() {
        System.out.println("Enter amount to transfer:");
    }

    public void done() {
        System.out.println("Thank you!\n\n    (next transaction)\n\n");
    }
}
