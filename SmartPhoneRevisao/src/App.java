import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
         Scanner scanner = new Scanner(System.in);

    // Loop para permitir que o usuário tente novamente em caso de entrada inválida
    boolean entradaValida = false;
    String numeroTelefone = "";
    while (!entradaValida) {
        System.out.print("Digite o número de telefone: ");
        numeroTelefone = scanner.nextLine();

        // Verifica se o número de telefone possui um formato válido
        if (numeroTelefone.matches("\\d{11}")) { // Verifica se o número possui exatamente 10 dígitos
            entradaValida = true;
        } else {
            System.out.println("Formato de número de telefone inválido. Digite novamente.");
        }
    }

    // Pedindo para o usuário fornecer a mensagem
    System.out.print("Digite a mensagem: ");
    String mensagem = scanner.nextLine();

        Aparelho Iphone = new Aparelho();
        Aparelho2 Samsung = new Aparelho2();
        // Chamando o método enviarMensagem com os valores fornecidos pelo usuário
        Iphone.enviarMensagem(numeroTelefone, mensagem);
        Samsung.enviarMensagem(numeroTelefone, mensagem);
        Samsung.fazerLigacao(numeroTelefone);
        Iphone.fazerLigacao(numeroTelefone);
        Iphone.exibirHistoricoLigaçoes();
        Iphone.exibirHistoricoMensagens();
        // Fechando o scanner para liberar recursos
        scanner.close();
    }
}
