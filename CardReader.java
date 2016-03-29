public class CardReader {
    private int currentCardNumber;

    public boolean validateCard(int number) {
        currentCardNumber = number;
        return true;
    }

    public void returnCard() {
        //your good
    }

    public int getCardNumber() {
        return currentCardNumber;
    }
}
