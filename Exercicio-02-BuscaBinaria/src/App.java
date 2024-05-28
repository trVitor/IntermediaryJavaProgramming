
public class App {
    public static void main(String[] args) throws Exception {
        Produto produto = new Produto("Televisão");

        produto.adcPreco("2024-11-16", 1000.0); // Preço em 1º de janeiro de 2024
        produto.adcPreco("2024-11-11", 950.0); // Preço em 8 de abril de 2024
        produto.adcPreco("2024-11-12", 1050.0); // Preço em 15 de agosto de 2024

        System.out.println("Historico do Produto " + produto.getNome()+ ":" + "\n");
        for(HistoricoPreco entrada : produto.getHistoricoPreco()){
            System.out.println("Data: " + entrada.getData() + ", Valor $" + entrada.getPreco());
        }
        }
    }       

