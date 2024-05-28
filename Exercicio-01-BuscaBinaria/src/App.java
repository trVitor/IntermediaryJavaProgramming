public class App {
    public static void main(String[] args) throws Exception {

        Livro[] livroTI = { 
        new Livro("Clean Code", "Robert C. Martin", 2008),
        new Livro("Design Patterns", "Gang Of Four", 1994),
        new Livro("The Pragmatic Programmer", "Andrew Hunt, David Thomas", 1999),
        new Livro("Refactoring", "Martin Fowler", 1999),
        new Livro("Code Complete", "Steve McConnell", 1993),
        new Livro("Structure and Interpretation of Computer Programs", "Harold Abelson", 1985),
        new Livro("Introduction to Algorithms", "Thomas H. Cormen", 1990)
    };
  
    Ordernacao.quickSort(livroTI,0, livroTI.length - 1);
    /*System.out.println("Lista de livros ordenada:");
    for (Livro livro : livroTI) {
        System.out.println(livro);
    }*/

    String livroProcurado = "Introduction to Algorithms";
    int posicao = BuscaBinaria.busca(livroTI, livroProcurado);  

    if(posicao != -1){
        Livro achou = livroTI[posicao];
        System.out.println("\nLivro encontrado na posição: " + posicao);
        System.out.println("Título: " + achou.getTitulo());
        System.out.println("Autor: " + achou.getAutor());
        System.out.println("Ano de Publicação: " + achou.getAnoPublicacao()+"\n");
    } else {
        System.out.println("O livro com o título '" + livroProcurado + "' não foi encontrado.");
    }
}
}

