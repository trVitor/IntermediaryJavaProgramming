

public class Item {

    private String jogos;
    private String categoria;
    private double avaliacao;
    
            /* CONSTRUTOR DA CLASSE */
    public Item(String jogos, String categoria, double avaliacao){
        this.jogos = jogos;
        this.categoria = categoria;
        this.avaliacao = avaliacao;
    }

            /*METODOS GETS E SETS */
    public String getJogos() {
        return jogos;
    }

    public void setJogos(String jogos) {
        this.jogos = jogos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
}
