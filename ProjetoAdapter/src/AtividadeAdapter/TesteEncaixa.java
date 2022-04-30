package AtividadeAdapter;

public class TesteEncaixa {

	public static void main(String[] args) {
		 
		// quando o pino redondo se encaixa no buraco redondo
		   BuracoRedondo buracoR = new BuracoRedondo(5);
	        PinoRedondo pinoR = new PinoRedondo(5);
	        if (buracoR.encaixa(pinoR)) {
	            System.out.println("\nEsse pino encaixa no buraco redondo !!");
	        }

	   // quando o pino não se encaixa
	        PinoQuadrado pinoQ = new PinoQuadrado(2);
	        PinoQuadrado pinoMaior = new PinoQuadrado(20);

	  // Usando o Adapter 
	        PinoQuadradoAdapter pinoQAdapter = new PinoQuadradoAdapter(pinoQ);
	        PinoQuadradoAdapter pinoMaiorAdapter = new PinoQuadradoAdapter(pinoMaior);
	        if (buracoR.encaixa(pinoQAdapter)) {
	            System.out.println("\nEsse pino quadrado se encaixa no buraco redondo !");
	        }
	        if (!buracoR.encaixa(pinoMaiorAdapter)) {
	            System.out.println("\nEsse pino não se encaixa no buraco redondo !!");
	        }
	    }
	}

