package model;

public class Gerente extends Funcionario{

    public Gerente(int id, String nome, String cpf, int idade, double salario, String departamento){
        super(id, nome, cpf, idade, salario, departamento, Cargo.GERENTE);
    }

    @Override
    public double calcularSalario(){
        return getSalario() * 1.20;
    }

}
