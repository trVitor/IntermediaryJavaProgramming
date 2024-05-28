public class BuscaBinaria {

    public static int busca(Livro[] listaLivros, String livroBuscado){
        Ordernacao.quickSort(listaLivros, 0, listaLivros.length - 1);
        return buscaBinaria(listaLivros, livroBuscado, 0, listaLivros.length - 1);
    }

    private static int buscaBinaria(Livro[] listaLivros, String livroBuscado, int inicio, int fim){
        if(inicio <= fim){
            int meio = (inicio+fim)/2;
            int compara = livroBuscado.compareToIgnoreCase(listaLivros[meio].getTitulo());
            if(compara == 0){
                return meio;
            }else if(compara < 0){
                return buscaBinaria(listaLivros, livroBuscado, inicio, meio - 1);
            }else{
                return buscaBinaria(listaLivros, livroBuscado, meio + 1, fim);
            }        
        }
        return -1;
    }

}
