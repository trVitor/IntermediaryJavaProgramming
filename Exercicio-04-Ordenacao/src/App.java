import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner =  new Scanner(System.in);

        System.out.println("Quantos nomes você que inserir ?");
        int num = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> nomes =  new ArrayList<>();

        for(int i = 0; i < num; i++){
            System.out.println("Digite o nome " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            nomes.add(nome);
        }

        System.out.println("\nNomes antes de orderna: ");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        Organizacao organiza = new Organizacao();

        organiza.selectioSort(nomes);

        System.out.println("\nNomes ordenados pelo tamanho: ");
        for(String nome : nomes){
            System.out.println(nome);
        }
        scanner.close();
    }
}
