import java.util.ArrayList;
import java.util.List;

public class Produto {

private String nome;
private List<HistoricoPreco> historicoPreco;
private BuscaBinaria buscaBinaria;
private Ordenacao ordenacao;

public Produto(String nome){
    this.nome = nome;
    this.historicoPreco = new ArrayList<>();
    this.ordenacao =  new Ordenacao();
    this.buscaBinaria =  new BuscaBinaria();
}

public String getNome() {
    return nome;
}

public void adcPreco(String data, Double preco){
    int indice = buscaBinaria.indiceInsercao(historicoPreco, data);
    historicoPreco.add(indice, new HistoricoPreco(data, preco));
    ordenacao.quickSort(historicoPreco);
}

public List<HistoricoPreco> getHistoricoPreco(){
    return historicoPreco;  
}


}

