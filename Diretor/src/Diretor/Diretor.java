package Diretor;

import java.util.Scanner;

public final class Diretor {
	private static String nome;
	private static final Scanner input = new Scanner (System.in);
	
	// variavel estatica e privada protegendo a classe
	private static  Diretor Diretorinstance = null;

	// construtor privado para impedir que outras instancias sejam criadas usando new
	private Diretor() {
		System.out.println("Informe o nome do diretor:");
        this.nome=input.next();
	}
	// M�todo est�tico que retorna uma inst�ncia j� existente, ou
    // cria uma nova inst�ncia
	
	public static synchronized Diretor getInstance() {
		if(Diretorinstance == null) 
			Diretorinstance = new Diretor();
		return Diretorinstance;
	}

	public String getNome() {
		return nome;
	}


}
