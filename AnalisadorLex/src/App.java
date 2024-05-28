import java.util.List;

public class App {
    /**
     * Método principal para testar o analisador léxico.
     * 
     * @param args Os argumentos de linha de comando (não utilizados neste exemplo).
     */
    public static void main(String[] args) {
  String code = "if 2 + 3 + a then";

        Lexer lexer = new Lexer(code);
        List<Token> tokens = lexer.getTokens();

        // Imprime os tokens com a saída formatada
        for (Token token : tokens) {
            System.out.println(token.getValue() + " - " + getTokenDescription(token.getType()));
        }
    }

    // descrição do tipo de token
    private static String getTokenDescription(TokenType type) {
        switch (type) {
            case KEYWORD:
                return "Palavra reservada " + type.toString().toLowerCase();
            case IDENTIFIER:
                return "Identificador";
            case NUMBER:
                return "Número " + (isInteger(type) ? "Inteiro" : "Decimal");
            case OPERATOR:
                return "Operador " + type.toString();
            case WHITESPACE: // Adicionado caso para lidar com espaços em branco
                return "Espaço em branco";
            default:
                return "Desconhecido";            
        }
        
    }


    // verifica se o tipo de número é inteiro
    private static boolean isInteger(TokenType type) {
        return type == TokenType.NUMBER;
    }
}
