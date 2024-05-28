public class Token {
    /*
    * Token:
    * Representa um token, armazenando seu tipo, valor e a linha onde foi encontrado.
    */
    private final TokenType type;
    private final String value;
    private final int lineNo;

    public Token(TokenType type, String value, int lineNo) {
        this.type = type;
        this.value = value;
        this.lineNo = lineNo;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public int getLineNo() {
        return lineNo;
    }

    @Override
    public String toString() {
        return String.format("<Line: %d, Token: %s, Value: %s>", lineNo, type.name(), value);
    }

}
