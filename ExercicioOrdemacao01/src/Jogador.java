public class Jogador {

    private String nick;
    private double score;

    public Jogador(String nick, double score){
        this.nick = nick;
        this.score = score ;
    }

    public String getNick() {
        return nick;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return nick + ": " + score + " pontos";
    }

    

}
