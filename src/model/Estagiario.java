package model;

public class Estagiario extends Funcionario{

    public Estagiario(int id, String nome, String cpf, int idade, double salario, String departamento){
        super(id, nome, cpf, idade, salario, departamento, Cargo.ESTAGIARIO);
    }

    @Override
    public double calcularSalario(){
        return getSalario();
    }

}
