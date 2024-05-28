import java.util.List;

public class BuscaBinaria {

    public  int indiceInsercao(List<HistoricoPreco> historico, String data){
        int esq = 0;
        int dir = historico.size() -1;
        while (esq <= dir){
            int meio = (esq + dir) / 2;
            String dataMeio = historico.get(meio).getData();
            if(data.compareTo(dataMeio) < 0){
                dir = meio - 1;
            }else if (data.compareTo(data) > 0 ) {
                esq = meio + 1;
            }else{
                return meio;
            }
        }
        return esq;
    }

}
