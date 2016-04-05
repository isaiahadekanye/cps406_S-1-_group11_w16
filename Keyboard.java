import java.util.Scanner;

public class Keyboard {
    Scanner scan;

    public Keyboard() {
        scan = new Scanner(System.in);
    }

    public double getEnteredAmount() {
        double amount = -1;
        while (amount < 0) {
            amount = scan.nextDouble();
        }
        return amount;
    }

    public int getEnteredNumber() {
        return scan.nextInt();
    }

    public int getEnteredPin() {
        return scan.nextInt();
    }

    public int getSelectedOption(int maxOption) { //also
        int picked = 0;
        while (!(picked != 0 && picked <= maxOption)) {
            picked = scan.nextInt();
        }
        return picked;
    }

    public void pressEnter() {
        System.console().readLine();
    }


    public static void main (String[] args) {
        Keyboard key = new Keyboard();
        System.out.println(key.getEnteredAmount());
    }
}
