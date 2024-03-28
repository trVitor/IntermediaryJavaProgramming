import java.util.List;

public class Agenda {

    private Contatos[] contatos;

    public Agenda(List<Contatos> contatos){
        this.contatos = contatos.toArray(new Contatos[contatos.size()]);
    }

public void ordenaAgenda(){
    int n = contatos.length;

    for(int i = 0; i < n; i++){
        Contatos key = contatos[i];
        int j = i - 1;

        while(j >=0 && contatos[j].getNome().compareTo(key.getNome()) > 0 ){
            contatos[j + 1] = contatos[j];
            --j;
        }
        contatos[j + 1] = key;
    }
}


public void mostrarLista(){
    System.out.println(" # AGENDA # ");
    for(int i = 0; i < contatos.length; i++){
        System.out.println((i + 1) + "." + contatos[i]);
    }
}



}
