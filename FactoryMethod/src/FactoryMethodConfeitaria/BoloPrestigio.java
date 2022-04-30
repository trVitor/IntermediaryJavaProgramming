package FactoryMethodConfeitaria;

public class BoloPrestigio extends FazerBolos {

	public BoloPrestigio() {
		   setNome("Bolo de Prestigio:");
		   setTipo("SOBREMESA");
		   setPreco(60.99f);
	   }
	
	public void SobreoBolo() {
		
		System.out.println(getNome() + "\nTipo: "+getTipo() + "\nPreço: R$"+getPreco()+"\n"
				+ "\nTipo de bolo de chocolate recheado com coco.\n");
			}
    @Override
	public void Receita() {
		 System.out.println("RECEITA :\n"
		 		    + "3 ovos,\r\n"
					+ "1/2 xícara (chá) de óleo,\r\n"
					+ "1 xícara (chá) de leite,\r\n"
					+ "1 xícara (chá) de açúcar,\r\n"
					+ "1 xícara (chá) de chocolate em pó,\r\n"
					+ "2 xícaras (chá) de farinha de trigo,\r\n"
					+ "1 colher (sopa) de fermento,\r\n"
					+ "coco ralado a gosto,\r\n"
					+ "Calda:\r\n"
					+ "1 garrafa de leite de coco,\r\n"
					+ "1 xícara (chá) de leite,\r\n"
					+ "3 colheres (sopa) de açúcar,\r\n"
					+ "Recheio:\r\n"
					+ "1 lata de leite condensado,\r\n"
					+ "1 colher (sopa) de margarina,\r\n"
					+ "100 g de coco ralado,\r\n"
					+ "Cobertura:\r\n"
					+ "3 colheres (sopa) de margarina,\r\n"
					+ "8 colheres (sopa) de açúcar,\r\n"
					+ "2 colheres (sopa) de chocolate em pó,\r\n"
					+ "2 xícaras (chá) de leite");
	}
}
