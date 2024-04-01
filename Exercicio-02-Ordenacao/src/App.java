import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);        
    int n = 0 ;
    while (true) {
        System.out.print("Quantos nomes deseja inserir? ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            scanner.nextLine(); 
            if (n > 0) {
                break;
            } else {
                System.out.println("Por favor, insira um número.");
            }
        } else {
            System.out.println("Entrada inválida. Insira um número válido!");
            scanner.next(); 
        }
    } 

    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
  
    for (int i = 0; i < n; i++) {
        System.out.print("Digite o nome " + (i + 1) + ": ");
        String nome = scanner.nextLine();
        pessoas.add(new Pessoa (nome));
    }

    //ANTES DE ORDENAR
    System.out.println("Nomes antes da ordenação:\n");
    for (Pessoa pessoa : pessoas) {
        System.out.println(pessoa.getNome());
    }
  
    Organizacao organiza = new Organizacao();

    organiza.insertionSort(pessoas);

    System.out.println("\nNomes em ordem alfabética: \n");
      for(Pessoa pessoa : pessoas ){
        System.out.println(pessoa.getNome());
      }
    scanner.close();

    return;
    }
}
