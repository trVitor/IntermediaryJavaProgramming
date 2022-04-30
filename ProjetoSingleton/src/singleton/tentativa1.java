package singleton;

//import tentativa1.CaldeiraChocolate;

public class tentativa1 {
	//public class CaldeiraChocolate {
		private boolean vazia;
		private boolean fervida;
		private static tentativa1 instancia = null;
		
		private tentativa1 () {}{
		vazia = true;
		fervida = false;
		}
		
		
		public static synchronized tentativa1 getInstancia () { 
			if ( instancia == null ) 
				 instancia = new tentativa1();	   
			return instancia;
		}
		
		public boolean estaVazia() {
		return vazia;
		}
		public boolean estaFervida() {
		return fervida;
		}
		public void preencher() {
		if (estaVazia()) {
		vazia = false;
		fervida = false;
		// preencher a caldeira com leite e chocolate
		}
		}
		public void drenar() {
		if (!estaVazia() && estaFervida()) {
		// drenar o leite e chocolate fervidos
		vazia = true;
		}
		}

		
		public void ferver() {
		if (!estaVazia() && !estaFervida()) {
		// colocar em ebulição
		fervida = true;
		}
		}
		
	}




		
	


