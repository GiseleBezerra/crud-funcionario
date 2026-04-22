package service;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public boolean adicionarFuncionario(Funcionario funcionario) {
        if (buscarPorId(funcionario.getId()) != null) {
            return false; // ID já existe
        }
        funcionarios.add(funcionario);
        return true;
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    public Funcionario buscarPorId(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public boolean aumentarSalario(int id, double porcentagem) {
        Funcionario f = buscarPorId(id);

        if (f == null || porcentagem <= 0) {
            return false;
        }

        f.aumentarSalario(porcentagem);
        return true;
    }

    public boolean removerFuncionario(int id) {
        Funcionario funcionario = buscarPorId(id);

        if (funcionario == null) {
            return false;
        }

        funcionarios.remove(funcionario);
        return true;
    }
}