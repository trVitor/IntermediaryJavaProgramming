public abstract class ModeloBasico implements Celular{

private int numero;
private String marca;
private float preco;


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

}
//SIMULA MENSAGEM   
public void enviarMensagem(String numero, String mensagem){
    System.out.println("Enviando mensagem para: " + numero + " : " /*mensagem*/ );
}


public int getNumero() {
    return numero;
}

public void setNumero(int numero) {
    this.numero = numero;
}

public String getNome() {
    return marca;
}

public void setNome(String marca) {
    this.marca = marca;
}

public float getPreco() {
    return preco;
}

public void setPreco(float preco) {
    this.preco = preco;
}

}
