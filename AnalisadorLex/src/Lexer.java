import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    /**
     * Classe responsável por realizar a análise léxica de um código fonte.
    */

public class Lexer {
    private final String input;
    private final List<Token> tokens;
    private final Set<String> keywords;

    /**
     * Construtor da classe Lexer.
     * 
     * @param input O código fonte a ser analisado.
     */

    public Lexer(String input) {
        this.input = input;
        this.tokens = new ArrayList<>();
        this.keywords = new HashSet<>();
        initializeKeywords();
        token();
    }

        
    /**
     * Inicializa as palavras-chave da linguagem.
     * Adicione mais palavras-chave conforme necessário.
     */

    private void initializeKeywords() {
        // palavras-chave da linguagem  Java)
        keywords.add("int");
        keywords.add("float");
        keywords.add("if");
        keywords.add("else");
        keywords.add("while");
        keywords.add("for");
        keywords.add("return");
        keywords.add("then");

    }

    /**
     * Realiza a análise léxica do código fonte.
    */

    private void token() {
        String tokenPatterns = 
              "(?<IDENTIFIER>[a-zA-Z_][a-zA-Z_0-9]*)"
            + "|(?<NUMBER>[0-9]+)"
            + "|(?<OPERATOR>[+\\-*/=<>!&|])"
            + "|(?<SEPARATOR>[;\\(\\)\\{\\}\\[\\],])"
            + "|(?<STRING>\"(\\\\.|[^\\\\\"])*\")"
            + "|(?<WHITESPACE>\\s+)"
            + "|(?<COMMENT>//.*|/\\*.*?\\*/)"
            + "|(?<UNKNOWN>.)";

        Pattern pattern = Pattern.compile(tokenPatterns);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            if (matcher.group("IDENTIFIER") != null) {
                String identifier = matcher.group("IDENTIFIER");
                TokenType type = keywords.contains(identifier) ? TokenType.KEYWORD : TokenType.IDENTIFIER;
                tokens.add(new Token(type, identifier));
                continue;
            }
            if (matcher.group("NUMBER") != null) {
                tokens.add(new Token(TokenType.NUMBER, matcher.group("NUMBER")));
                continue;
            }
            if (matcher.group("OPERATOR") != null) {
                tokens.add(new Token(TokenType.OPERATOR, matcher.group("OPERATOR")));
                continue;
            }
            if (matcher.group("SEPARATOR") != null) {
                tokens.add(new Token(TokenType.SEPARATOR, matcher.group("SEPARATOR")));
                continue;
            }
            if (matcher.group("STRING") != null) {
                tokens.add(new Token(TokenType.STRING, matcher.group("STRING")));
                continue;
            }
            if (matcher.group("WHITESPACE") != null) {
                tokens.add(new Token(TokenType.WHITESPACE, matcher.group("WHITESPACE")));
                continue;
            }
            if (matcher.group("COMMENT") != null) {
                tokens.add(new Token(TokenType.COMMENT, matcher.group("COMMENT")));
                continue;
            }
            if (matcher.group("UNKNOWN") != null) {
                tokens.add(new Token(TokenType.UNKNOWN, matcher.group("UNKNOWN")));
            }
        }
    }

    /**
     * Retorna a lista de tokens após a análise léxica.
     * 
     * @return A lista de tokens.
     */

    public List<Token> getTokens() {
        return tokens;
    }
}
