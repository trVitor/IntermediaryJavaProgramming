package Decorator;

public abstract class BaseDecorator implements Adicional{
	
	Adicional wrapper;
	Adicional TamanhoCopo;
 
    BaseDecorator (Adicional ad){
      this.wrapper = ad ;
    }
    
	@Override
	public void TamanhoCopo(char t) {
		wrapper.TamanhoCopo(t);
	}
    @Override
    public String getDescricao(){
        return wrapper.getDescricao()  ;
    }
    @Override
    public double custo() {
        return wrapper.custo() ;
    }


}
