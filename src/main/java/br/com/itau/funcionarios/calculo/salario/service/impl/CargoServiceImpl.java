package br.com.itau.funcionarios.calculo.salario.service.impl;

import br.com.itau.funcionarios.calculo.salario.entity.Cargo;
import br.com.itau.funcionarios.calculo.salario.repository.CargoRepository;
import br.com.itau.funcionarios.calculo.salario.service.CargoService;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public void delete(Long idCargo) {
        cargoRepository.deleteById(idCargo);
    }

    @Override
    public Cargo update(Cargo cargo) {
        return cargoRepository.save(cargo);
    }


    @Override
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }
}
