import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {
      Scanner scanner = new Scanner(System.in);

                 /* LEMBRAR DE MUDAR O LOCAL DO ARQUIVO ELE PODE VARIAR DE PC PRA PC */
        String JogosDesordenados = "JogosDesordenados.csv";
        Item[] items = null;


        /* DO WHILE PRA PERMITER UM MENU SEMPRE DISPONIVEL PARA A PESSOA ATÉ QUE ELA ESCOLHA SAIR */
        
        int escolhe;
        do {
          System.out.println("--- Menu ---");
          System.out.println("[1] Ler arquivo");
          System.out.println("[2] Ordenar por CATEGORIA");
          System.out.println("[3] Ordenar por AVALIAÇÃO");
          System.out.println("[4] Sair");
          System.out.print("Escolha uma opção: ");
          escolhe = scanner.nextInt();
          
                    /* SWITCH PARA CRIAR UM MENU DE SELEÇÃO, MAIS PRATICO */
        switch (escolhe) {
          case 1:
           items = ArquivoCSV.lista(JogosDesordenados);
           System.out.println("\nArquivo lido com sucesso.\n\n");
          break;
          
          case 2:
          /* VERIFICAÇÃO SE ARQUIVO FOI LIDO*/
          if(items != null){

                   /* ORDENA OS JOGOS EM CATEGORIA usando selection SORT */
          Categoria cat = new Categoria(items);
          Categoria.selectionSort(items);
          System.out.println(cat.toString());
          }else{
            System.out.println("\nPor favor, leia o arquivo primeiro (Opção 1).\n\n");
          } 
          break;

          case 3:
          /* VERIFICAÇÃO SE ARQUIVO FOI LIDO*/
          if(items != null){
                   /*ORDENA OS JOGOS EM AVALIAÇÕES usando insertion SORT*/
            Avaliacao aval = new Avaliacao(items);
            Avaliacao.insertionSort(items);
            System.out.println(aval.toString());
          }else{
            System.out.println("\nPor favor, leia o arquivo primeiro (Opção 1).\n\n");
          }

          break;

          case 4:
                  /* SAI DO DA EXECUÇÃO */
             System.out.println("\nExecução ENCERRADA!! ");
          break;
             
          default:
                   /* SE O USUARIO DIGITAR ALGO ERRADO */
             System.out.println("\nOpção inválida, tente novamente.\n");
            break;
        }
      } while(escolhe != 4);

      scanner.close();
  }
}