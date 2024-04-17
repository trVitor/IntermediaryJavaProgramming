import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Categoria {

    private Item[] items;

    public Categoria(Item[] items) {
        this.items = items;
    }
    //METODO SELECTION-SORT PARA FAZER A ORDENAÇÃO DA CATEGORIA
    public static void selectionSort(Item[] items){
        int n = items.length;
        for(int i = 0 ; i < n - 1; i++){
          int aux = i;
          for(int j = i + 1; j < n; j++){
              if (items[j].getCategoria().compareTo(items[aux].getCategoria()) < 0){
                  aux = j;
           }
        }
        // troca
        Item temp = items[aux];
        items[aux] = items[i];
        items[i] = temp;
      }
    
    
    try (BufferedWriter escrever = new BufferedWriter(new FileWriter("JogosOrdenadosCategoria.csv"))){
        escrever.write("Jogos, Categoria , Avaliação");
        escrever.newLine();
        for(Item jogo : items){
            escrever.write(jogo.getJogos() + " , " + jogo.getCategoria() + " , " + jogo.getAvaliacao());
            escrever.newLine();
        }
    }catch(IOException e){
        e.printStackTrace();
    }
}

    @Override
    public String toString() {
        //USANDO StringBuilder porque ajuda a otimizar muitas concatenações igual abaixo.
        StringBuilder sb = new StringBuilder();
        sb.append("\nLista de Jogos Ordenados por Categoria:\n");
        sb.append("---------------------------------------------------");
        sb.append(System.lineSeparator());
        sb.append(String.format("%-30s %-10s %-10s\n", "Nome", "Categoria", "Avaliação"));
        sb.append("---------------------------------------------------");
        sb.append(System.lineSeparator());
        for (Item item : items) {
            sb.append(String.format("%-30s %-10s %-10.2f\n", item.getJogos(), item.getCategoria() + " ", item.getAvaliacao()));
        }
        sb.append("---------------------------------------------------");
        return sb.toString();
    }
}

