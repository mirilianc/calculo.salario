package br.com.itau.funcionarios.calculo.salario.repository;

import br.com.itau.funcionarios.calculo.salario.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
