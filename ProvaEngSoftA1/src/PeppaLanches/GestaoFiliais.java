package PeppaLanches;
public class GestaoFiliais {

	public static void main(String[] args) {

		System.out.println("Se aparecer o mesmo nome, o singleton deu bom!" + "\n" +
                "Se aparecer nomes diferentes, ent�o o singleton deu ruim!!" + "\n\n" +
                "RESULTADO:" + "\n");
        Diretor diretor = Diretor.getInstance("Vitor");
        Diretor diretor2= Diretor.getInstance("Let�cia");
        System.out.println(diretor.getNome());
        System.out.println(diretor2.getNome());
	}
}
