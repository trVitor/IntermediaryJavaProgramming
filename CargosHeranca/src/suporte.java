public class suporte extends Funcionario{

    public suporte(String nome, int id, double salarioBase, String cargoStr) {
        super(nome, id, salarioBase, cargoStr);
    }

    @Override
    public double calcularSalario(double salarioBase) {
        
        return salarioBase * 1.05;
    }

}
