import java.util.ArrayList;
import java.util.List;

public abstract class ModeloAvancado implements Celular{

    private int numero;
    private String marca;
    private float preco;
    private List<String> historicoLigacoes;
    private List<String> historicoMensagens;   

public ModeloAvancado(){
    historicoLigacoes = new ArrayList<>();
    historicoMensagens =  new ArrayList<>();
}

    //SIMULA LIGAR O APARELHO
   
    public void ligar(){
        System.out.println("Ligando o aparelo!!");
    }
    //SIMULA DESLIGAR O APARELHO
    public void desligar(){
        System.out.println("Desligando aparelho!!");
    }
    
    //SIMULA LIGAÇAO
    
    public void fazerLigacao(String numero){
        System.out.println("Ligando para: " + numero);
        historicoLigacoes.add(numero);
    
    }
    //SIMULA MENSAGEM   
    public void enviarMensagem(String numero, String mensagem){
        System.out.println("Enviando mensagem para: " + numero + " : " + mensagem );
        historicoMensagens.add(numero + ": " + mensagem);
    }

    public void exibirHistoricoLigaçoes(){
        System.out.println("Historico de Ligações");
        for (String ligacao : historicoLigacoes) {
            System.out.println("- " + ligacao);
        }
    }

    public void exibirHistoricoMensagens() {
        System.out.println("Histórico de Mensagens:");
        for (String mensagem : historicoMensagens) {
            System.out.println("- " + mensagem);
        }
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    

}
