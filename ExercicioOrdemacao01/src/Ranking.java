import java.util.List;

public class Ranking {

private Jogador[] jogadores;

public Ranking(List<Jogador> jogadores) {
     this.jogadores = jogadores.toArray(new Jogador[jogadores.size()]);
  }

public void classificacao(){
    int n = jogadores.length;

    for(int i = 0; i < n - 1; i++){
        for(int j = 0; j < n - i - 1; j++){
            if(jogadores[j].getScore() < jogadores[ j + 1].getScore()){
                Jogador temp = jogadores[j];
                jogadores[j] = jogadores[ j + 1];
                jogadores[j + 1] = temp;
            }
        }
    }
}

public void mostraRanking(){
    System.out.println("* CLASSIFICAÇÃO *");
    for (int i = 0; i < jogadores.length; i++) {
        System.out.println((i + 1) + "# " + jogadores[i]);
    }
}
}
