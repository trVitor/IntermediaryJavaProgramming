package FactoryMethodConfeitaria;

public class MostraBolos {

	public static void main(String[] args) {
		
		FactoryBolos cc = new FactoryBolos();
		
		FazerBolos c1 = cc.getFazerBolos(FactoryBolos.Tipo.BoloAbacaxi);
		c1.SobreoBolo();
		c1.Receita();
	
		System.out.println("\n--------------------------------------------------------------------");

		FazerBolos c2 = cc.getFazerBolos(FactoryBolos.Tipo.BoloFlorestaNegra);
		c2.SobreoBolo();      
		c2.Receita();
		
	    System.out.println("\n---------------------------------------------------------------------" );

        
		FazerBolos c3 = cc.getFazerBolos(FactoryBolos.Tipo.BoloPrestigio);
        c3.SobreoBolo();
        c3.Receita();

	    System.out.println("\n---------------------------------------------------------------------" );

        
		FazerBolos c4 = cc.getFazerBolos(FactoryBolos.Tipo.BoloChoconinho);
        c4.SobreoBolo();
        c4.Receita();
	}

}
