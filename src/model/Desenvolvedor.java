package model;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(int id, String nome, String cpf, int idade, double salario, String departamento){
        super(id, nome, cpf, idade, salario, departamento, Cargo.DESENVOLVEDOR);
    }

}
