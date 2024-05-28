import java.util.List;

public class Ordenacao {

    public void quickSort(List<HistoricoPreco> historicoPrecos){
        quickSort(historicoPrecos, 0, historicoPrecos.size() - 1);

    }

    private void quickSort(List<HistoricoPreco> historicoPrecos, int esq, int dir){
        if(esq < dir){
            int pivot = particao(historicoPrecos, esq, dir);
            quickSort(historicoPrecos, esq, pivot -1);
            quickSort(historicoPrecos, pivot + 1, dir);
        }
    }
    private int particao(List<HistoricoPreco> historicoPrecos, int esq, int dir){
        String p = historicoPrecos.get(dir).getData();
        int i = esq - 1;
        for(int j  = esq; j < dir; j++){
            if(historicoPrecos.get(j).getData().compareTo(p) < 0){
                i++;
                troca(historicoPrecos, i, j);
            }
        }
        troca(historicoPrecos, i + 1, dir);
        return i + 1;
    }

    private void troca(List<HistoricoPreco> historicoPrecos, int i, int j){
        HistoricoPreco temp = historicoPrecos.get(i);
        historicoPrecos.set(i, historicoPrecos.get(j));
        historicoPrecos.set(j, temp);
    }
}
