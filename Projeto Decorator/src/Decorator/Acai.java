package Decorator;

public class Acai implements Adicional {

	public char TamanhoCopo = 'p';

	public void TamanhoCopo(char t) {
         this.TamanhoCopo=t;
	}

	@Override
	public String getDescricao() {
		return "Acai Tradicional " + "Tamanho: "+TamanhoCopo;
	}

	@Override
	public double custo() {

		switch (TamanhoCopo) {

		case 'p':
			return 18.00;
		case 'm':
			return 20.00;
		default:
			return 21.00;
		}

	}

}
