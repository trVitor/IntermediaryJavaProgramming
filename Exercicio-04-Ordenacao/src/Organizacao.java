import java.util.*;

public class Organizacao {

    public void selectioSort(ArrayList<String> nomes){
      int n = nomes.size();
      for(int i = 0 ; i < n - 1; i++){
        int aux = i;
        for(int j = i + 1; j < n; j++){
            if(nomes.get(j).length() < nomes.get(aux).length()){
                aux = j;
         }
      }
      // troca
      String temp = nomes.get(aux);
      nomes.set(aux, nomes.get(i));
      nomes.set(i, temp);
    }
  }
}
