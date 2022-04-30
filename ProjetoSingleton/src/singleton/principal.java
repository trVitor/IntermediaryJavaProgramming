
package singleton;

import singleton.tentativa1;

public class principal {


	public static void main(String[] args) {
		
		//tentativa1.getInstancia();
		tentativa1 Caldeira = tentativa1.getInstancia();
		tentativa1 Caldeira2 = tentativa1.getInstancia();
	System.out.println(Caldeira);
	System.out.println(Caldeira2);


	}

}
