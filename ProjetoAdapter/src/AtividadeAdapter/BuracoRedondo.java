package AtividadeAdapter;

public class BuracoRedondo {
	
	private double raio;
	
	public BuracoRedondo(double raio) {
		this.raio = raio;
	}
	public double getRaio() {
		return raio;
	}
	
	public boolean encaixa (PinoRedondo p) {
		boolean resultado;
		resultado = (this.getRaio() >= p.getRaioP());
		return resultado;
	}
}
