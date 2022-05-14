package Decorator;

public class LeiteCondensado extends BaseDecorator {
	
	public LeiteCondensado(Adicional ad) {
	        super(ad);
	    }
	
	public void TamanhoCopo() {		
	}
	
	     @Override
	    public String getDescricao(){
	        return super.getDescricao()+" Leite Condensado ";
	    }
	    @Override
	    public double custo(){
	        return super.custo() + 2.50;
	    }

}
