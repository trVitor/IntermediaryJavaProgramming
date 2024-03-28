public class Lista {

    private float preco;
    private String produto;
   

    public Lista(String produto, float preco) {
        this.produto = produto;
        this.preco = preco;
    }



    public float getPreco() {
        return preco;
    }


    public String getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return " Produto {" +
                " Nome = '" + produto + '\'' +
                " - Preço = " + preco +
                '}';
    }


}
