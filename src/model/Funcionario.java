package model;

//Herança - Funcionario herda atributos e métodos de Pessoa
public abstract class Funcionario extends Pessoa{

    private int id;
    private double salario;
    private String departamento;
    private Cargo cargo;

    public Funcionario(int id, String nome, String cpf, int idade, double salario, String departamento, Cargo cargo){

        super(nome, cpf, idade); //chama o construtor da classe Pessoa

        this.id = id;
        this.salario = salario;
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public double getSalario() {
        return salario;
    }

    public Cargo cargo(){
        return cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + getNome() +
                " | Cargo: " + cargo +
                " | Departamento: " + departamento +
                " | Salário: R$ " + String.format("%.2f", salario);
    }
}