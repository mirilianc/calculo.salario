package br.com.itau.funcionarios.calculo.salario.service;

import br.com.itau.funcionarios.calculo.salario.entity.Cargo;
import br.com.itau.funcionarios.calculo.salario.entity.Funcionario;

import java.util.List;
import java.util.Optional;


public interface CargoService  {

    Cargo save (Cargo cargo);

    Optional<Cargo> findById (Long idCargo);

    void delete (Long idCargo);

    Cargo update (Cargo cargo);


    List<Cargo> findAll ();

}
