public class Ordernacao {

    public static void quickSort(Livro[] livros, int esq, int dir){
        if(esq < dir){
            int pivot = particao(livros, esq, dir);
            quickSort(livros, esq, pivot - 1);
            quickSort(livros, pivot + 1, dir); 
        }
    }

    public static int particao(Livro[] livros, int esq, int dir){
        Livro p = livros[dir];
        int i = esq - 1;
        for(int j = esq; j < dir; j ++){
            if(livros[j].getTitulo().compareToIgnoreCase(p.getTitulo()) <= 0){
                i++;
            // troca
            Livro temp = livros[i];  
            livros[i] = livros[j];
            livros[j] = temp;
            }
        }

        Livro temp = livros[i + 1];
        livros[i + 1] = livros[dir];
        livros[dir] = temp;
        return i + 1;

    }

}
