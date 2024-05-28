import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
    /*
     * LexAnalizer:
     * Responsável pela análise léxica.
     * Usa expressões regulares para identificar tokens.
     * Controla a numeração das linhas e ignora comentários e espaços em branco.
     * Utiliza a SymbolTable para verificar palavras reservadas e gerenciar identificadores.
     * A expressão regular TOKEN_PATTERNS define todos os padrões necessários, incluindo números, identificadores, operadores, parênteses, etc.
     * Comentários entre (* e *) são ignorados
     * A lista RESERVED_WORDS contém todas as palavras-chave da linguagem Mini-Pascal.
     */
public class LexAnalizer {

    public LexAnalizer(String code) {
        this.code = code.toLowerCase(); 
        this.matcher = TOKEN_PATTERNS.matcher(this.code);
        this.lineNo = 1;
        this.currentPos = 0;
        this.symbolTable = new SymbolTable(RESERVED_WORDS);
    }

    /*
     * lista de palavras reservadas na linguagem pascal 
     */

    private static final List<String> RESERVED_WORDS = Arrays.asList(
        "and", "array", "begin", "case", "const", "div", "do", "downto", "else", "end", 
        "file", "for", "function", "goto", "if", "in", "label", "mod", "nil", "not", 
        "of", "or", "packed", "procedure", "program", "record", "repeat", "set", "then", 
        "to", "type", "until", "var", "while", "with"
    );

    private static final Pattern TOKEN_PATTERNS = Pattern.compile(

         /*
         * tabela de reconhecimento dos tokens da liguagem
         */

        "(?<INTEGER>\\d+)|" +                                      // Número inteiro
        "(?<REAL>\\d+\\.\\d+)|" +                                 // Número real
        "(?<ID>[A-Za-z][A-Za-z0-9]*)|" +                         // Identificadores
        "(?<STRING>'(\\\\'|[^'])*')|" +                          // String delimitada por aspas simples
        "(?<CHAR>\\'[^\\'\\\\]|\\\\[nrt'\"\\\\]\\')|" +          // Caracteres
        "(?<OP>[-+*/=<>]|:=)|" +                                 // Operadores
        "(?<LPAREN>\\()|" +                                      // Delimitador - Parenteses Esquerdo
        "(?<RPAREN>\\))|" +                                      // Delimitador - Parenteses Direito
        "(?<LBRACE>\\{)|" +                                      // Delimitador - Chave Esquerda
        "(?<RBRACE>\\})|" +                                      // Delimitador - Chave Direita
        "(?<LSQUARE>\\[)|" +                                     // Delimitador - Colchete Esquerdo
        "(?<RSQUARE>\\])|" +                                     // Delimitador - Colchete Direito
        "(?<SEMICOLON>;)|" +                                     // Delimitador - Ponto e vírgula
        "(?<COLON>:)|" +                                         // Delimitador - Dois pontos
        "(?<COMMA>,)|" +                                         // Delimitador - Vírgula
        "(?<DOT>\\.)|" +                                         // Delimitador - Ponto
        "(?<ASSIGN>:=)|" +                                       // Operador de Atribuição
        "(?<WHITESPACE>[ \t]+)|" +                               // Espaço em branco
        "(?<NEWLINE>\\n)|" +                                     // Nova linha
        "(?<COMMENT>\\{.*?\\}|//.*?\\n)|" +                      // Comentário de linha única
        "(?<MISMATCH>.)"                                         // Outros caracteres não reconhecidos
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
                String value = matcher.group("OP");
                currentPos = matcher.end();
                // Handle := as a special case
                if (value.equals(":") && matcher.find(currentPos) && matcher.group().equals("=")) {
                    currentPos = matcher.end();
                    return new Token(TokenType.OP, ":=", lineNo);
                }
                return new Token(TokenType.OP, value, lineNo);
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
        /*
         * caso de testes com algumas operações para identificar operações,
         * caracteres especiais, funções, e frases
         */
        String[] testCases = {
            "var a, b: integer;\nbegin\n  a := 10;\n  b := a + 5;\nend.",
            "if a > b then\n  c := a - b\nelse\n  c := b - a;",
            "function max(x, y: integer): integer;\nbegin\n  if x > y then\n    max := x\n  else\n    max := y;\nend;",
            "(* This is a comment *)\nvar s: string;\nbegin\n  s := 'Hello, world!';\nend."
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
