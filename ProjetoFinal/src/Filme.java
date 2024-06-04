import java.io.Serializable;

public class Filme implements Serializable {
    private String nome;
    private String genero;
    private String diretor;
    private int ano;
    private boolean assistido;
    private boolean favorito;
    private int avaliacao;

    public Filme(String nome, String genero, String diretor, int ano, boolean assistido, boolean favorito) {
        this.nome = nome;
        this.genero = genero;
        this.diretor = diretor;
        this.ano = ano;
        this.assistido = assistido;
        this.favorito = favorito;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public int getAno() {
        return ano;
    }

    public boolean isAssistido() {
        return assistido;
    }

    public void marcarComoAssistido() {
        this.assistido = true;
    }

    public void desmarcarComoAssistido() {
        this.assistido = false;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void adicionarAosFavoritos() {
        this.favorito = true;
    }

    public void removerDosFavoritos() {
        this.favorito = false;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return String.format("   %s (%d)\n Diretor: %s\n Gênero: %s", nome, ano, diretor, genero);
    }
}