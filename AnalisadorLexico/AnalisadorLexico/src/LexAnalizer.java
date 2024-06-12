import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexAnalizer {

    public LexAnalizer(String code) {
        this.code = code;
        this.matcher = TOKEN_PATTERNS.matcher(this.code);
        this.lineNo = 1;
        this.currentPos = 0;
        this.symbolTable = new SymbolTable(RESERVED_WORDS);
    }

    private static final List<String> RESERVED_WORDS = Arrays.asList(
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", 
        "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", 
        "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", 
        "int", "interface", "long", "native", "new", "package", "private", "protected", 
        "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", 
        "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
    );

    private static final Pattern TOKEN_PATTERNS = Pattern.compile(
        "(?<INTEGER>\\d+)|" +                                      // Número inteiro
        "(?<REAL>\\d+\\.\\d+)|" +                                  // Número real
        "(?<ID>[A-Za-z_][A-Za-z0-9_]*)|" +                         // Identificadores
        "(?<STRING>\"(\\\\\"|[^\"])*\")|" +                        // Strings delimitadas por aspas duplas
        "(?<CHAR>'(\\\\[nrt'\"\\\\]|[^'\\\\])')|" +                // Caracteres
        "(?<OP>[-+*/=<>!&|%^~?:]+)|" +                             // Operadores
        "(?<LPAREN>\\()|" +                                        // Delimitador - Parêntese Esquerdo
        "(?<RPAREN>\\))|" +                                        // Delimitador - Parêntese Direito
        "(?<LBRACE>\\{)|" +                                        // Delimitador - Chave Esquerda
        "(?<RBRACE>\\})|" +                                        // Delimitador - Chave Direita
        "(?<LSQUARE>\\[)|" +                                       // Delimitador - Colchete Esquerdo
        "(?<RSQUARE>\\])|" +                                       // Delimitador - Colchete Direito
        "(?<SEMICOLON>;)|" +                                       // Delimitador - Ponto e vírgula
        "(?<COLON>:)|" +                                           // Delimitador - Dois pontos
        "(?<COMMA>,)|" +                                           // Delimitador - Vírgula
        "(?<DOT>\\.)|" +                                           // Delimitador - Ponto
        "(?<WHITESPACE>[ \t]+)|" +                                 // Espaço em branco
        "(?<NEWLINE>\\n)|" +                                       // Nova linha
        "(?<COMMENT>/\\*.*?\\*/|//.*?\\n)|" +                      // Comentários
        "(?<MISMATCH>.)"                                           // Outros caracteres não reconhecidos
    );

    private final String code;
    private final Matcher matcher;
    private int lineNo;
    private int currentPos;
    private final SymbolTable symbolTable;

    public Token nextToken() {
        
        while (matcher.find(currentPos)) {
            if (matcher.group("NEWLINE") != null) {
                lineNo++;
                currentPos = matcher.end();
            } else if (matcher.group("WHITESPACE") != null || matcher.group("COMMENT") != null) {
                currentPos = matcher.end(); 
            } else if (matcher.group("INTEGER") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.INTEGER, matcher.group("INTEGER"), lineNo);
            } else if (matcher.group("REAL") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.REAL, matcher.group("REAL"), lineNo);
            } else if (matcher.group("ID") != null) {
                String value = matcher.group("ID");
                currentPos = matcher.end();
                if (symbolTable.isReservedWord(value)) {
                    return new Token(TokenType.KEYWORD, value, lineNo);
                } else {
                    return symbolTable.getToken(value, lineNo);
                }
            } else if (matcher.group("OP") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.OP, matcher.group("OP"), lineNo);
            } else if (matcher.group("LPAREN") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.LPAREN, matcher.group("LPAREN"), lineNo);
            } else if (matcher.group("RPAREN") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.RPAREN, matcher.group("RPAREN"), lineNo);
            } else if (matcher.group("LBRACE") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.LBRACE, matcher.group("LBRACE"), lineNo);
            } else if (matcher.group("RBRACE") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.RBRACE, matcher.group("RBRACE"), lineNo);
            } else if (matcher.group("LSQUARE") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.LSQUARE, matcher.group("LSQUARE"), lineNo);
            } else if (matcher.group("RSQUARE") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.RSQUARE, matcher.group("RSQUARE"), lineNo);
            } else if (matcher.group("SEMICOLON") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.SEMICOLON, matcher.group("SEMICOLON"), lineNo);
            } else if (matcher.group("COLON") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.COLON, matcher.group("COLON"), lineNo);
            } else if (matcher.group("COMMA") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.COMMA, matcher.group("COMMA"), lineNo);
            } else if (matcher.group("DOT") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.DOT, matcher.group("DOT"), lineNo);
            } else if (matcher.group("STRING") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.STRING, matcher.group("STRING"), lineNo);
            } else if (matcher.group("CHAR") != null) {
                currentPos = matcher.end();
                return new Token(TokenType.CHAR, matcher.group("CHAR"), lineNo);
            } else if (matcher.group("MISMATCH") != null) {
                throw new RuntimeException("Unexpected character: " + matcher.group("MISMATCH") + " at line " + lineNo);
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        String[] testCases = {
            "int a, b;\nvoid main() {\n  a = 10;\n  b = a + 5;\n}",
            "if (a > b) {\n  c = a - b;\n} else {\n  c = b - a;\n}",
            "class Max {\n  int max(int x, int y) {\n    if (x > y) return x;\n    else return y;\n  }\n}",
            "/* This is a comment */\nString s;\nvoid main() {\n  s = \"Hello, world!\";\n}"
        };

        for (String code : testCases) {
            System.out.println("Testing code:\n" + code);
            LexAnalizer lexer = new LexAnalizer(code);
            Token token;
            while ((token = lexer.nextToken()) != null) {
                System.out.println(token);
            }
            System.out.println("Test completed.\n");
        }
    }
}