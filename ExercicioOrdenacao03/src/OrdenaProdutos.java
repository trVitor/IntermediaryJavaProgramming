public class OrdenaProdutos {

    public void quickSort(Lista[] lista){
        ordena(lista, 0, lista.length - 1);
    }

    private void ordena(Lista[] lista, int esq, int dir){
        if(esq < dir){
            int indicePivot = particiona(lista, esq, dir);
            ordena(lista, esq, indicePivot - 1);
            ordena(lista, indicePivot + 1, dir);
        }
    }

    private int particiona(Lista[] lista, int esq, int dir){
        Lista pivot = lista[dir];
        int indicePivot = esq;

        for(int i = esq; i < dir; i++ ){
            if(lista[i].getPreco() < pivot.getPreco()){
                trocar(lista, i, indicePivot);
                indicePivot++;
            }
        }

        trocar(lista, indicePivot, dir);
        return indicePivot;

    }

    private void trocar(Lista[] lista, int i, int j){
        Lista temp = lista[i];
        lista[i] = lista[j];
        lista[j] =  temp;

    }
}
