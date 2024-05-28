import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    /*
     * SymbolTable:
     * Gerencia a tabela de símbolos e verifica palavras reservadas.
     * Utiliza um HashMap para armazenar identificadores.
     * A lista RESERVED_WORDS contém todas as palavras-chave da linguagem Mini-Pascal.
     * A symbolTable é um HashMap usado para armazenar identificadores.
     */

    private final Map<String, Token> symbolTable = new HashMap<>();
    private final List<String> reservedWords;

    public SymbolTable(List<String> reservedWords) {
        this.reservedWords = reservedWords;
    }

    public boolean isReservedWord(String word) {
        return reservedWords.contains(word);
    }

    public Token getToken(String identifier, int lineNo) {
        return symbolTable.computeIfAbsent(identifier, k -> new Token(TokenType.ID, k, lineNo));
    }

    public void addToken(String identifier, Token token) {
        symbolTable.put(identifier, token);
    }

    public boolean containsToken(String identifier) {
        return symbolTable.containsKey(identifier);
    }
}
