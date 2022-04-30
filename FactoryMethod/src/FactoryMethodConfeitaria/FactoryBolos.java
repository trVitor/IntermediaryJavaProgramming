package FactoryMethodConfeitaria;

public class FactoryBolos {

	public enum Tipo {	
		BoloAbacaxi, BoloFlorestaNegra, BoloPrestigio, BoloChoconinho;
	}	
		public FazerBolos getFazerBolos (Tipo b) {
			FazerBolos c = null;
			
			 switch (b) {
			
			case BoloAbacaxi:
				c = new BoloAbacaxi();
		         break;
			case BoloFlorestaNegra:
				c = new BoloFlorestaNegra();
				break;
				
			case BoloPrestigio:
				c =  new BoloPrestigio();
		        break;
		        
			case BoloChoconinho:
				c = new BoloChoconinho();
				break;
			}
		return c;
}
}