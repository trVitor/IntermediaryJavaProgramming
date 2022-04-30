package Prototype;

public abstract class Carro {
	protected double valorCompra;
	 
    public abstract String exibirInfo();
 
    public abstract Carro clonar();
 
    public double getValorCompra() {
        return valorCompra;
    }
 
    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
}
