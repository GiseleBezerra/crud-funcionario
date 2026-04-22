package main;

import model.Funcionario;
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
            System.out.println("3- Aumentar salário");
            System.out.println("4- Remover funcionário");
            System.out.println("0- Sair");
            System.out.println();
            System.out.print("Escolha a opção: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Salário: ");
                    double salario = sc.nextDouble();

                    if (salario < 0) {
                        System.out.println("Salário inválido.");
                        break;
                    }

                    Funcionario funcionario = new Funcionario(id, nome, salario);

                    if (service.adicionarFuncionario(funcionario)) {
                        System.out.println("Funcionário cadastrado!");
                    } else {
                        System.out.println("ID já existe.");
                    }
                    break;

                case 2:
                    service.listarFuncionarios();
                    break;

                case 3:
                    System.out.print("ID do funcionário: ");
                    int idAumento = sc.nextInt();

                    System.out.print("Porcentagem: ");
                    double porcentagem = sc.nextDouble();

                    if (service.aumentarSalario(idAumento, porcentagem)) {
                        System.out.println("Salário atualizado!");
                    } else {
                        System.out.println("Erro ao atualizar salário.");
                    }
                    break;

                case 4:
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