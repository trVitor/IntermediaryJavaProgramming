import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
class Numero {
    char[] num = new char[201];
}
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class App {
    public static int ordem(Numero a, Numero b) {
        return strcmp(a.num, b.num);
    }

    private static int strcmp(char[] a, char[] b) {
        int i = 0;
        while (i < a.length && i < b.length && a[i] == b[i]) {
            i++;
        }
        if (i == a.length && i == b.length) {
            return 0;
        } else if (i == a.length) {
            return -1;
        } else if (i == b.length) {
            return 1;
        } else {
            return a[i] - b[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            Numero[] array = new Numero[n];
            for (int i = 0; i < n; i++) {
                array[i] = new Numero();
                array[i].num = scanner.nextLine().toCharArray();
            }

            Arrays.sort(array, App::ordem);

            int cont = 0;
            Numero comp = array[0];
            for (int i = 1; i < n; i++) {
                int j = 0;
                while (j < array[i].num.length && comp.num[j] == array[i].num[j]) {
                    cont++;
                    j++;
                }
                comp = array[i];
            }

            System.out.println(cont);
        }

        scanner.close();
    }
}