package AtividadeAdapter;

public class PinoQuadradoAdapter extends PinoRedondo {

	private  PinoQuadrado pino;
	
	public PinoQuadradoAdapter(PinoQuadrado pino) {
		this.pino = pino;
}
	
	public double getRaioPino() {
		double resultado;
		resultado =  (Math.sqrt(Math.pow((pino.getLargura()/2),2)*2));
       return resultado;	
	}
}
