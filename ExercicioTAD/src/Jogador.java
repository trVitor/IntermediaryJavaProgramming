public class Jogador {

    private String nome;
    private int jogos;
    private int gols;
    private int assistencias;

    
    public Jogador(String nome, int jogos, int gols, int assistencias) {
        this.nome = nome;
        this.jogos = jogos;
        this.gols = gols;
        this.assistencias = assistencias;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getJogos() {
        return jogos;
    }
    public void setJogos(int jogos) {
        this.jogos = jogos;
    }
    public int getGols() {
        return gols;
    }
    public void setGols(int gols) {
        this.gols = gols;
    }
    public int getAssistencias() {
        return assistencias;
    }
    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

}
