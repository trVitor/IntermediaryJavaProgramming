import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Jogador> jogadores = new ArrayList<>();

    boolean adcJogador = true;
    while(adcJogador){
        System.out.println("Digite o nome do jogador: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a pontuação: ");
        double score = scanner.nextDouble();
        scanner.nextLine();
        
        jogadores.add(new Jogador(nome, score));

        System.out.println("Deseja adicionar mais um jogador ?  (S/N): ");
        String escolha = scanner.nextLine();
        adcJogador = escolha.equalsIgnoreCase("s");
    }
//LISTA ANTES DE ORDENAR
    Ranking ranking = new Ranking(jogadores);
    System.out.println(" \nRanking sem ordenarção");
    ranking.mostraRanking();
// ORDENDANDO O RANKING
    ranking.classificacao();
//LISTA DEPOIS DE ORDENAR
    System.out.println("\nRanking com ordenação");
    ranking.mostraRanking();
    scanner.close();
    }
}
