package main;

import model.Desenvolvedor;
import model.Estagiario;
import model.Funcionario;
import model.Gerente;
import service.FuncionarioService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FuncionarioService service = new FuncionarioService();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1- Cadastrar funcionário");
            System.out.println("2- Listar funcionários");
            System.out.println("3- Remover funcionário");
            System.out.println("0- Sair");
            System.out.println();
            System.out.print("Escolha a opção: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Escolha o cargo:");
                    System.out.println("1- Gerente");
                    System.out.println("2- Desenvolvedor");
                    System.out.println("3- Estagiário");

                    int tipoCargo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();

                    System.out.print("Salário: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Departamento: ");
                    String departamento = sc.nextLine();

                    if (salario < 0) {
                        System.out.println("Salário inválido.");
                        break;
                    }

                    Funcionario funcionario = null;

                    switch (tipoCargo){
                        case 1:
                            funcionario = new Gerente(id, nome, cpf, idade, salario, departamento);
                            break;
                        case 2:
                            funcionario = new Desenvolvedor(id, nome, cpf, idade, salario, departamento);
                            break;
                        case 3:
                            funcionario = new Estagiario(id, nome, cpf, idade, salario, departamento);
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                    }

                    if(funcionario != null){
                        if(service.adicionarFuncionario(funcionario)){
                            System.out.println("Funcionário cadastrado!");
                        } else{
                            System.out.println("Id já existe.");
                        }
                    }

                case 2:
                    service.listarFuncionarios();
                    break;

                case 3:
                    System.out.print("Digite o ID para remover: ");
                    int idRemover = sc.nextInt();

                    if (service.removerFuncionario(idRemover)) {
                        System.out.println("Funcionário removido.");
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}