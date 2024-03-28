import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner scanner = new Scanner(System.in);
       List<Contatos> contatos = new ArrayList<>();


    boolean adcContato =  true ;
    while(adcContato){
        System.out.println(" Digite o nome do trouxa: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o número do trouxa:");
        int numero = scanner.nextInt();
        scanner.nextLine();

        contatos.add(new Contatos(nome, numero));

        System.out.println("Deseja adicionar mais um trouxa ? (S/N) ");
        String escolha = scanner.nextLine();
        adcContato = escolha.equalsIgnoreCase("s");
    }
        //AGENDA ANTES DE ORDENAR
        Agenda agenda = new Agenda(contatos);
        System.out.println("Lista sem Ordenação: ");
        agenda.mostrarLista();

    // ORDENANDO A LISTA
        agenda.ordenaAgenda();

    // AGENDA DEPOIS DE ORDENAR;
        System.out.println("Agenda Ordenada !");
        agenda.mostrarLista();
        scanner.close();
        
    }
}
