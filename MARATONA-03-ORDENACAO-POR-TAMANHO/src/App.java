import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
         Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); 

        while (n > 0) {
            n--;
            String line = scanner.nextLine();
            String[] c = line.split(" ");
            Arrays.sort(c, (a, b) -> Integer.compare(b.length(), a.length()));

            for (int i = 0; i < c.length; i++) {
                System.out.print(c[i]);
                if (i != c.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
  