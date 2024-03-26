abstract class Funcionario {

    protected String nome;
    protected String cargoStr;
    protected int id;
    protected double salarioBase;
    
    //Contrutores

    public Funcionario(String nome, int id, double salarioBase, String cargoStr) {
        this.nome = nome;
        this.cargoStr = cargoStr;
        this.id = id;
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //mnetodo abstrato
    public abstract double calcularSalario(double salarioBase);


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public double getSalarioBase() {
        return salarioBase;
    }


    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

}

