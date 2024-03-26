import java.util.Scanner;

public class principal {
    public static void main(String[] args) throws Exception {
      
        empresa Balacobaco =  new empresa();
        
        Scanner scanner = new Scanner(System.in);

        // Pedindo ao usuário para inserir o número de funcionários
        System.out.println("Digite o número de funcionários:");
        int numFuncionarios = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Lendo os dados de cada funcionário e adicionando à empresa
        for (int i = 0; i < numFuncionarios; i++) {
            System.out.println("\nFuncionário #" + (i + 1));
            Funcionario funcionario = Balacobaco.lerDadosFuncionario();
            Balacobaco.adcFuncionario(funcionario);
        }

        // Listando os funcionários
        Balacobaco.listarFuncionarios();

        // Calculando a folha salarial total
        double folhaSalarialTotal = Balacobaco.CalcSalariosTotal();
        System.out.println("Folha Salarial Total: " + folhaSalarialTotal);
    scanner.close();
    }
}
      

