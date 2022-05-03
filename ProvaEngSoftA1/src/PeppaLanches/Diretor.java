package PeppaLanches;

public class Diretor {


	private static String nome;
	// variavel estatica e privada protegendo a classe
	private static  Diretor Diretorinstance = null;

	// construtor privado para impedir que outras instancias sejam criadas usando new
	private Diretor(String nome) {	
        Diretor.nome=nome;
	}
	// Método estático que retorna uma instância já existente, ou
    // cria uma nova instância
	public static synchronized Diretor getInstance(String nome) {
		if(Diretorinstance == null) 
			Diretorinstance = new Diretor(nome);
		return Diretorinstance;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Diretor.nome=nome;
	}
	
	
	
}
