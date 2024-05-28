public class Produto implements Cloneable {

    private String marca;
    private String descricao;
    private float preco;
    
    public Produto(String marca, String descricao, float preco) {
        this.marca = marca;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto clone() throws CloneNotSupportedException {
        return (Produto) super.clone();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String toString(){
        return this.marca + " " + this.descricao + " ( " + this.preco + " )";
    }

    

}
