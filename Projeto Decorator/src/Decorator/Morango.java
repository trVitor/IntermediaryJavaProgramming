package Decorator;

public class Morango extends BaseDecorator {
	
	 public Morango(Adicional ad) {
	        super(ad);
	    }

	    @Override
	    public String getDescricao(){
	        return super.getDescricao()+" Morango ";
	    }
	    @Override
	    public double custo(){
	        return super.custo() + 2.00;
	    }

}
