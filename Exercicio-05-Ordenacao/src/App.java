import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a palavra: ");
        String palavra = scanner.nextLine();

        char[] letras = palavra.toLowerCase().toCharArray();

        System.out.println("\nPalavra antes de ordenar: ");
        System.out.println(new String(letras));

        Organizacao organiza = new Organizacao();

        organiza.quickSort(letras,0, letras.length - 1);

        System.out.println("\nPalavra em ordem crescente: ");
        System.out.println(new String(letras));
        scanner.close();
        return;
    }
}
