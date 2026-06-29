package model;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private int idade;

    //Construtor -> valores iniciais do objeto
    public Pessoa(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    //Get
    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public int getIdade(){
        return idade;
    }

    //Set
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
}
