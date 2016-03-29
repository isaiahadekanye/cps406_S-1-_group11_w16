public class NFCReader {
    private int currentNFCNumber;

    public boolean validateNFC(int number) {
        currentNFCNumber = number;
        return true;
    }

    public int getNFCNumber() {
        return currentNFCNumber;
    }
}
