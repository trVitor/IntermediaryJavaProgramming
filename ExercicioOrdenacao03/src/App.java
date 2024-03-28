import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a capacidade máxima do catálogo: ");
        int capacidade = scanner.nextInt();
        Empresa empresa = new Empresa(capacidade);

        scanner.nextLine();

        while (true) {
        System.out.print("Nome do Produto: ");
        String name = scanner.nextLine();
        
        System.out.print("Preço do Produto ");
        float preco = scanner.nextFloat();
        scanner.nextLine();
        
        empresa.adcProduto(name, preco);
        
        System.out.print("Deseja adicionar outro produto? (S/N): ");
        String choice = scanner.nextLine();
        if (!choice.equalsIgnoreCase("s")) {
        break;
       }
    } 

        System.out.println("Produtos antes da Ordenação:");
        empresa.mostrarLista();
        
        // Ordenando os produto por preço
        
        empresa.ordenaLista();
       
        // Exibindo os produtos após a Ordenação
        System.out.println("\nProdutos após a Ordenação: ");
        empresa.mostrarLista();
        scanner.close();
    }
}

