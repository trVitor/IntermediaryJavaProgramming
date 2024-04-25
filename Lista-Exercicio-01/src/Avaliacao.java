import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Avaliacao {

    private Item[] jogos;

    public Avaliacao(Item[] jogos){
        this.jogos = jogos;
    }
      /* METODO INSERTION-SORT PARA ORDERNAR A AVALIAÇÃO */
    public static void insertionSort(Item[] jogos){
        int n = jogos.length;
        for(int i = 1; i < n; i++){
            Item key = jogos[i];
            int j = i - 1;
            while(j >= 0 && Double.valueOf(jogos[j].getAvaliacao()).compareTo(key.getAvaliacao()) < 0){
                jogos[j + 1] = jogos[j];
                j = j - 1;
            }
            jogos[j + 1] = key;
        }
          /* METODO PARA RESCREVER ARQUIVO .CSV DE FORMA ORDENADA */
    try (BufferedWriter escrever = new BufferedWriter(new FileWriter("JogosOrdenadosAvaliação.csv"))){
        escrever.write("Jogos, Categoria , Avaliação");
        escrever.newLine();
        for(Item jogo : jogos){
            escrever.write(jogo.getJogos() + " , " + jogo.getCategoria() + " , " + jogo.getAvaliacao());
            escrever.newLine();
        }
    }catch(IOException e){
        e.printStackTrace();
        }
}


    @Override
    public String toString() {
        /* USANDO StringBuilder porque ajuda a otimizar muitas concatenações igual abaixo.*/
        StringBuilder sb = new StringBuilder();
     sb.append("\nLista de Jogos Ordenados por Avaliação:\n");
     sb.append("---------------------------------------------------");
     sb.append(System.lineSeparator());
     sb.append(String.format("%-30s %-10s %-10s\n", "Nome", "Categoria", "Avaliação"));
     sb.append("---------------------------------------------------");
     sb.append(System.lineSeparator());
        for (Item item : jogos) {
         sb.append(String.format("%-30s %-10s %-10.2f\n", item.getJogos(), item.getCategoria() + " ", item.getAvaliacao()));
        }
     sb.append("---------------------------------------------------\n");
        return sb.toString();
    }  
}

