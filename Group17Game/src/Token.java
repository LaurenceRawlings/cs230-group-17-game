public class Token extends Item {
    private int tokenValue;

    public Token(int xPos, int yPos) {
        super(ItemType.token, xPos, yPos);
        tokenValue = 1;
    }

    public Token(int xPos, int yPos, int tokenValue) {
        super(ItemType.token, xPos, yPos);
        this.tokenValue = tokenValue;
    }

    public int getTokenValue() {
        return tokenValue;
    }
}
