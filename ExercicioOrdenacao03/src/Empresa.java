public class Empresa {

   private Lista[] lista;
   private int tamanho;

   public Empresa(int capacidade){
    lista =  new Lista[capacidade];
    tamanho = 0;
}
    
    public void ordenaLista(){
        OrdenaProdutos ordenador = new OrdenaProdutos();
        ordenador.quickSort(lista);
    }


    public void adcProduto(String name, float preco){
        if(tamanho < lista.length){
            lista[tamanho++] = new Lista(name, preco);
        }else {
            System.out.println("Capacidade máxima atingida. Não é possível adicionar mais produtos.");   
    }
}

    public void mostrarLista(){
        System.out.println(" # CATALÓGO # ");
        for(int i = 0; i < tamanho; i++){
            System.out.println((i + 1) + "." + lista[i]);
        }
    }
}
