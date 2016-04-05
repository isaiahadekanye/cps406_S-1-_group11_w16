public class CardReader {
    private int currentCardNumber;

    public boolean validateCard(int number) {
        currentCardNumber = number;
        return true;
    }

    public void returnCard() {
        System.out.println("Card Reader: Card Ejected");
    }

    public int getCardNumber() {
        return currentCardNumber;
    }
}
