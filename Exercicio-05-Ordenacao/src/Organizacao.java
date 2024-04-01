public class Organizacao {

    public void quickSort(char[] letras, int esq, int dir){
        if( esq < dir){
            int pivot = particao(letras, esq, dir);
            quickSort(letras, esq, pivot - 1);
            quickSort(letras, pivot + 1, dir);  
        }
    }

    public int particao(char[] letras, int esq, int dir){
        char p  = letras[dir];
        int i = esq - 1;
        for(int j = esq; j < dir; j++){
            if(letras[j] < p){
                i++;
            //TROCA
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
            }
        }
        char temp = letras[i + 1];
        letras[i + 1] = letras[dir];
        letras[dir] = temp;
        return i + 1;
    }
}
