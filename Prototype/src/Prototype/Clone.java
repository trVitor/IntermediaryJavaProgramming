package Prototype;

public class Clone {

	public static void main(String[] args) {
		FerrariPrototype prototipoFerrari = new FerrariPrototype();
		 
	    Carro ferrariNovo = prototipoFerrari.clonar();
	    ferrariNovo.setValorCompra(270900.0);
	    Carro ferrariUsado = prototipoFerrari.clonar();
	    ferrariUsado.setValorCompra(210000.0);
	 
	    System.out.println(ferrariNovo.exibirInfo());
	    System.out.println("\n"+ferrariUsado.exibirInfo());
	}

}
