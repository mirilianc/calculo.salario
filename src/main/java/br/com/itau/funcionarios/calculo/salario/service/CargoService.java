package br.com.itau.funcionarios.calculo.salario.service;

import br.com.itau.funcionarios.calculo.salario.entity.Cargo;

import java.util.Optional;


public interface CargoService  {

    Cargo save (Cargo cargo);

    Optional<Cargo> findById (Long id);


}
