public class desenvolvedor extends Funcionario {

  
    public desenvolvedor(String nome, String cargoStr, int id, double salarioBase) {
        super(nome, id, salarioBase, cargoStr);
    }

    // metodo
    @Override
    public double calcularSalario(double salarioBase) {

        return salarioBase * 1.10;
    }

    
    
}
