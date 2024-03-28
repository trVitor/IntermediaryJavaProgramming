public class Contatos {

    private String nome;
    private int numero;


    public Contatos(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "- Telefone: " + numero;
    } 

}
