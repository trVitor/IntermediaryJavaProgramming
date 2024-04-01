import java.util.ArrayList;

public class Organizacao {

    public Organizacao(){
  
}

// USANDO INSERTIOn SORT PARA ORDENAR
public void insertionSort(ArrayList<Pessoa> pessoas){

  int n = pessoas.size();
  for(int i = 1; i < n; i++){
    Pessoa chave = pessoas.get(i);
    int j = i - 1;
    while(j >= 0 && pessoas.get(j).getNome().toLowerCase().compareToIgnoreCase(chave.getNome()) > 0 ){
        pessoas.set(j + 1, pessoas.get(j));
        j = j - 1;
    }
    pessoas.set(j + 1, chave);
   }
}

}




