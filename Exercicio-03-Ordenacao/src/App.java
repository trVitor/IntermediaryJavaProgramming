import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner =  new Scanner(System.in);

        System.out.println("Digite a palavra:");
        String palavra = scanner.nextLine();
        
        char[] chars = palavra.toCharArray();

        System.out.println("\nNomes antes de orderna: ");  
        System.out.println(new String(chars));

        Organizacao organiza =  new Organizacao();
        organiza.bubbleSort(chars);

        System.out.println("\nString em ordem crescente:");
        System.out.println(new String(chars));
        scanner.close();
        return; 
    }
}
