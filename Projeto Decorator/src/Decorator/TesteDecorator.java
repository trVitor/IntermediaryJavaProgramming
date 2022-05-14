package Decorator;

public class TesteDecorator {

	public static void main(String[] args) {
		  Adicional Basico = new Acai();
	        System.out.println(Basico.getDescricao());
	        System.out.println(Basico.custo());
	        
	        Adicional add = new Morango(Basico);
	        add.TamanhoCopo('g');
	        System.out.println(add.getDescricao());
	        System.out.println(add.custo());
	        
	        add = new Banana(add);
	        add = new LeiteCondensado(add);
	        System.out.println(add.getDescricao());
	        System.out.println(add.custo());
	    }	    		// TODO Auto-generated method stub
	}
