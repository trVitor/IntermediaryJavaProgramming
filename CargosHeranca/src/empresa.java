import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class empresa {

    Scanner scanner = new Scanner(System.in);

    private List<Funcionario> funcionarios; 


    public empresa(){   
    funcionarios = new ArrayList<>();
    }

    public void adcFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);

    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de funcionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Nome: " + funcionario.getNome() +", Cargo: " + funcionario.cargoStr + ", ID: " + funcionario.getId() + ", Salário: " + funcionario.calcularSalario(funcionario.getSalarioBase()));
            }
        }
    }

public Funcionario lerDadosFuncionario(){
   
    // Pedindo ao usuário para inserir o número de funcionários
        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();
        System.out.println("Digite o ID do funcionário:");
        int id = scanner.nextInt();
        System.out.println("Digite o salário base do funcionário:");
        double salarioBase = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o cargo do funcionário (DESENVOLVEDOR, GERENTE, SUPORTE):");
        String cargoStr = scanner.nextLine();
        
        Cargo funcao = Cargo.valueOf(cargoStr.toUpperCase());
        
        switch (funcao) {
            case DESENVOLVEDOR:
                return new desenvolvedor(nome, cargoStr, id, salarioBase);
            case GERENTE:
                return new gerente(nome, id, salarioBase, cargoStr);
            case SUPORTE:
                return new suporte(nome, id, salarioBase, cargoStr);
            default:
                throw new IllegalArgumentException("Cargo inválido");
            } 
             
}

public double CalcSalariosTotal(){
    double total = 0.0;
    for (Funcionario funcionario : funcionarios){
        total += funcionario.calcularSalario(funcionario.salarioBase);
    }
    return total;
}

}
    







