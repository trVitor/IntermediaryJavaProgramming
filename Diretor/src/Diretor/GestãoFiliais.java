package Diretor;

public class GestãoFiliais {

	public static void main(String[] args) {
		System.out.println("Se aparecer o mesmo nome, o singleton deu bom!" + "\n" +
                "Se aparecer nomes diferentes, então o singleton deu ruim!!" + "\n\n" +
        
               "RESULTADO:" + "\n");
		
        Diretor diretor = Diretor.getInstance();
        Diretor diretor2= Diretor.getInstance();
        System.out.println(diretor.getNome());
        System.out.println(diretor2.getNome());
	}

	}


