import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoCSV {
                /*  Método para listar os jogos do arquivo CSV */
    public static Item[] lista(String JogosDesordenados) {
        Item[] lista = new Item[40]; /* TAMANHO DO VETOR */
        int contador = 0; /*  CONTADOR PARA INCREMENTAR A LISTA */

        try {
            /* ABRE O LEITOR PARA LER O ARQUIVO */
            BufferedReader leitura = new BufferedReader(new FileReader(JogosDesordenados));
            String linha;

            while ((linha = leitura.readLine()) != null) {

                /*  USEI O PONTO E VÍRGULA COMO SEPARADOR */
                String[] bloco = linha.split(",");

                if (bloco.length >= 3) {
                    String jogos = bloco[0];
                    String categoria = bloco[1];
                    double avaliacao = Double.parseDouble(bloco[2]);

                    Item jogo = new Item(jogos, categoria, avaliacao);

                    /* ADICIONA NA LISTA */
                    lista[contador] = jogo;
                    contador++;

                } else {
                    System.out.println("Linha inválida>" + linha);
                }
            }
            leitura.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }


}
