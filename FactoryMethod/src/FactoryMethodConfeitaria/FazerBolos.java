package FactoryMethodConfeitaria;

public abstract class FazerBolos {
	
	private String nome;
	private String tipo;
	private float preco;
	
	public void SobreoBolo() {
	}
	
	public abstract void Receita();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	

}
