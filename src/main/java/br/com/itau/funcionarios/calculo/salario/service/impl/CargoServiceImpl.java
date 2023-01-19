package br.com.itau.funcionarios.calculo.salario.service.impl;

import br.com.itau.funcionarios.calculo.salario.entity.Cargo;
import br.com.itau.funcionarios.calculo.salario.repository.CargoRepository;
import br.com.itau.funcionarios.calculo.salario.service.CargoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    private CargoRepository cargoRepository;

    public CargoServiceImpl(CargoRepository cargoRepository){
        this.cargoRepository= cargoRepository;

    }
    @Override
    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public Optional<Cargo> findById(Long id) {
        return cargoRepository.findById(id);
    }
}
