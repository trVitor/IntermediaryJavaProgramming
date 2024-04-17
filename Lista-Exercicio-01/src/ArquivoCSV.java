import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoCSV {

         // Método para listar os jogos do arquivo CSV
         public static Item[] lista(String JogosDesordenados){
            ArrayList<Item> lista = new ArrayList<>();
    
            try{
                                // Abrir o leitor para ler o arquivo
                BufferedReader leitura = new BufferedReader(new FileReader(JogosDesordenados));
                String linha;
    
                while((linha = leitura.readLine()) != null){
    
                                // usando o ponto e vírgula como separador
                    String[]bloco = linha.split(",");
                    
                    if(bloco.length >= 3){
                    String jogos = bloco[0];
                    String categoria = bloco[1];
                    double avaliacao = Double.parseDouble(bloco[2]);

                    Item jogo = new Item(jogos, categoria, avaliacao);

                    //adiciona na Lista
                    lista.add(jogo);
                 }else{
                    System.out.println("Linha inválida>" +  linha);
                 }
                }
                leitura.close();

            }catch(IOException e){
                e.printStackTrace();
            }
            
            Item[] listaJogos = new Item[lista.size()];
            listaJogos = lista.toArray(listaJogos);

            return listaJogos;
        }

}
