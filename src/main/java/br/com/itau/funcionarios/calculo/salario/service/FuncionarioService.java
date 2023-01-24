package br.com.itau.funcionarios.calculo.salario.service;

import br.com.itau.funcionarios.calculo.salario.entity.Cargo;
import br.com.itau.funcionarios.calculo.salario.entity.Funcionario;
import br.com.itau.funcionarios.calculo.salario.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    Funcionario save (Funcionario funcionario);

    Optional<Funcionario> findById (Long matricula);

    void delete (Long id);

    Funcionario update (Funcionario funcionario);

    List<Funcionario> findAll ();

}
