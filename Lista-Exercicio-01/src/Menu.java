import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {
      Scanner scanner = new Scanner(System.in);
                 //LEMBRAR DE MUDAR O LOCAL DO ARQUIVO ELE PODE VARIAR DE PC PRA PC
       String JogosDesordenados = "C:/Users/conta/IntermediaryJavaProgramming/JogosDesordenados.csv";
       // Item[] items = ArquivoCSV.lista(JogosDesordenados);       
        Item[] items = new Item[40];       

        // DO WHILE PRA PERMITER UM MENU SEMPRE DISPONIVEL PARA A PESSOA ATÉ QUE ELA ESCOLHA SAIR
        int escolhe;
        //boolean continua = true;
        do {
          System.out.println("--- Menu ---");
          System.out.println("[1] Ler arquivo");
          System.out.println("[2] Ordenar por categoria");
          System.out.println("[3] Ordenar por avaliação");
          System.out.println("[4] Sair");
          System.out.print("Escolha uma opção: ");
          escolhe = scanner.nextInt();
          
                    //SWITCH PARA CRIAR UM MENU DE SELEÇÃO, ACHO MAIS PRATICO
        switch (escolhe) {

          case 1:
            items = ArquivoCSV.lista(JogosDesordenados);
          break;
          
          case 2:
                   //ORDENA OS JOGOS EM CATEGORIA usando selection SORT
          Categoria cat = new Categoria(items);
          Categoria.selectionSort(items);
          System.out.println(cat.toString()); 
          break;

          case 3:
                   //ORDENA OS JOGOS EM AVALIAÇÕES usando insertion SORT
            Avaliacao aval = new Avaliacao(items);
            Avaliacao.insertionSort(items);
            System.out.println(aval.toString());
          break;

          case 4:
                  // SAI DO DA EXECUÇÃO
             System.out.println("Execução ENCERRADA!! ");
          break;
             
          default:
                   // SE O USUARIO DIGITAR ALGO ERRADO
             System.out.println("Opção inválida, tente novamente.");
            break;
        }
        /*if (continua) {
          System.out.print("Deseja voltar ao menu? (S/N): ");
          String resposta = scanner.next();
          continua = resposta.equalsIgnoreCase("S");
      }*/
      } while(escolhe != 4);

      scanner.close();
  }
}
