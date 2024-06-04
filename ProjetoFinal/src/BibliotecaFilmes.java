import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaFilmes {

    private List<Filme> filmes;

    public BibliotecaFilmes() {
        this.filmes = new ArrayList<>();
        carregarFilmes();
    }

    public void adicionarFilme(String nome, String genero, String diretor, int ano, boolean assistido, boolean favorito) {
        filmes.add(new Filme(nome, genero, diretor, ano, assistido, favorito));
        salvarFilmes();
    }

    public List<Filme> listarFilmes() {
        return filmes;
    }

    public void marcarComoAssistido(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                filme.marcarComoAssistido();
                salvarFilmes();
                break;
            }
        }
    }

    public void desmarcarComoAssistido(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                filme.desmarcarComoAssistido();
                salvarFilmes();
                break;
            }
        }
    }

    public List<Filme> listarAssistidos() {
        List<Filme> assistidos = new ArrayList<>();
        for (Filme filme : filmes) {
            if (filme.isAssistido()) {
                assistidos.add(filme);
            }
        }
        return assistidos;
    }

    public void adicionarAosFavoritos(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                filme.adicionarAosFavoritos();
                salvarFilmes();
                break;
            }
        }
    }

    public List<Filme> listarFavoritos() {
        List<Filme> favoritos = new ArrayList<>();
        for (Filme filme : filmes) {
            if (filme.isFavorito()) {
                favoritos.add(filme);
            }
        }
        return favoritos;
    }

    public void removerFilme(String nome) {
        filmes.removeIf(filme -> filme.getNome().equalsIgnoreCase(nome));
        salvarFilmes();
    }

    public void removerDosFavoritos(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                filme.removerDosFavoritos();
                salvarFilmes();
                break;
            }
        }
    }

    public List<Filme> buscarFilme(String nome) {
        return filmes.stream().filter(filme -> filme.getNome().toLowerCase().contains(nome.toLowerCase())).collect(Collectors.toList());
    }
    private void salvarFilmes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("filmes.dat"))) {
            oos.writeObject(filmes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarFilmes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("filmes.dat"))) {
            filmes = (List<Filme>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            filmes = new ArrayList<>();
        }
    }

}