import java.util.List;

public class OrdenadorFilmes {
 public static void ordenarPorAdicao(List<Filme> filmes) {
        // Algoritmo de ordenação por inserção
        for (int i = 1; i < filmes.size(); i++) {
            Filme chave = filmes.get(i);
            int j = i - 1;
            while (j >= 0 && filmes.get(j).getAno() < chave.getAno()) {
                filmes.set(j + 1, filmes.get(j));
                j = j - 1;
            }
            filmes.set(j + 1, chave);
        }
    }

    public static void ordenarPorNome(List<Filme> filmes) {
        // Algoritmo de ordenação por seleção
        for (int i = 0; i < filmes.size() - 1; i++) {
            int menorIndice = i;
            for (int j = i + 1; j < filmes.size(); j++) {
                if (filmes.get(j).getNome().compareToIgnoreCase(filmes.get(menorIndice).getNome()) < 0) {
                    menorIndice = j;
                }
            }
            Filme temp = filmes.get(menorIndice);
            filmes.set(menorIndice, filmes.get(i));
            filmes.set(i, temp);
        }
    }

    private static int particionar(List<Filme> filmes, int inicio, int fim) {
        int pivo = filmes.get(fim).getAvaliacao();
        int i = (inicio - 1);
        for (int j = inicio; j < fim; j++) {
            if (filmes.get(j).getAvaliacao() >= pivo) {
                i++;
                Filme temp = filmes.get(i);
                filmes.set(i, filmes.get(j));
                filmes.set(j, temp);
            }
        }
        Filme temp = filmes.get(i + 1);
        filmes.set(i + 1, filmes.get(fim));
        filmes.set(fim, temp);
        return i + 1;
    }

    public static void ordenarPorAvaliacao(List<Filme> filmes) {
        // Algoritmo de ordenação quick sort
        ordenarPorAvaliacaoRecursivo(filmes, 0, filmes.size() - 1);
    }

    private static void ordenarPorAvaliacaoRecursivo(List<Filme> filmes, int inicio, int fim) {
        if (inicio < fim) {
            int indiceParticao = particionar(filmes, inicio, fim);
            ordenarPorAvaliacaoRecursivo(filmes, inicio, indiceParticao - 1);
            ordenarPorAvaliacaoRecursivo(filmes, indiceParticao + 1, fim);
        }
    }
}
