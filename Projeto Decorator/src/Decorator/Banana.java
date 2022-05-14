package Decorator;

public class Banana extends BaseDecorator {
	
	public Banana(Adicional ad) {
	        super(ad);
	    }
	    @Override
	    public String getDescricao(){
	        return super.getDescricao()+ " Banana ";
	    }
	    @Override
	    public double custo(){
	   
	    	return super.custo() + 1.50;
	    }
	    

}
