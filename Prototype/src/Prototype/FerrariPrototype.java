package Prototype;

public class FerrariPrototype extends Carro{
	 protected FerrariPrototype(FerrariPrototype ferrariPrototype) {
	        this.valorCompra = ferrariPrototype.getValorCompra();
	    }
	 
	    public FerrariPrototype() {
	        valorCompra = 0.0;
	    }
	 
	    @Override
	    public String exibirInfo() {
	        return "Modelo: SF90 Spider\nMontadora: Ferrari\n" + "Valor: R$"
	                + getValorCompra();
	    }
	 
	    @Override
	    public Carro clonar() {
	        return new FerrariPrototype(this);
	    }

}
