
/**
 * Representa um token no analisador léxico.
 */

 public class Token {
    private final TokenType type;
    private final String value;
     
    /**
     * Cria um novo token com o tipo e valor fornecidos.
     * 
     * @param type  O tipo do token.
     * @param value O valor do token.
     */

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

     /**
     * Obtém o tipo do token.
     * 
     * @return O tipo do token.
     */

    public TokenType getType() {
        return type;
    }

    /**
     * Obtém o valor do token.
     * 
     * @return O valor do token.
     */
    
    public String getValue() {
        return value;
    }

    /**
     * Retorna uma representação de string do token.
     * 
     * @return Uma representação de string do token.
     */
    
     @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }

}
