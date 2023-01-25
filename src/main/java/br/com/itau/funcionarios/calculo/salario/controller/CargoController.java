package br.com.itau.funcionarios.calculo.salario.controller;

import br.com.itau.funcionarios.calculo.salario.dto.CargoResponseDTO;
import br.com.itau.funcionarios.calculo.salario.dto.CargoSaveRequestDTO;
import br.com.itau.funcionarios.calculo.salario.dto.CargoSaveResponseDTO;
import br.com.itau.funcionarios.calculo.salario.entity.Cargo;
import br.com.itau.funcionarios.calculo.salario.repository.CargoRepository;
import br.com.itau.funcionarios.calculo.salario.service.CargoService;
import br.com.itau.funcionarios.calculo.salario.service.impl.CargoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping ("/cargos")
public class CargoController {

    private CargoService cargoService;

    public CargoController(CargoService cargoService){
        this.cargoService = cargoService;

    }


    @PostMapping
    public ResponseEntity<CargoSaveResponseDTO> save (@RequestBody CargoSaveRequestDTO cargoSaveRequestDTO){

        log.info(cargoSaveRequestDTO.toString());

        Cargo cargo = new Cargo();

        cargo.setDescricacaoCargo(cargoSaveRequestDTO.getDescricacaoCargo());
        cargo.setNomeCargo(cargoSaveRequestDTO.getNomeCargo());
        cargo.setSalarioBase(cargoSaveRequestDTO.getSalarioBase());

        cargo = cargoService.save(cargo);

        CargoSaveResponseDTO cargoSaveResponseDTO = new CargoSaveResponseDTO();
        cargoSaveResponseDTO.setId(cargo.getIdCargo());

        return ResponseEntity.status(HttpStatus.CREATED).body(cargoSaveResponseDTO);
    }

    @DeleteMapping(value = "/{idCargo}")
    public ResponseEntity <String> delete (@PathVariable  Long idCargo) {

        Optional<Cargo> cargo = cargoService.findById(idCargo);
        if (cargo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

       cargoService.delete(idCargo);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{idCargo}")
    public ResponseEntity<CargoResponseDTO> getById (@PathVariable(value= "idCargo") Long id){

        Optional<Cargo> cargo = cargoService.findById(id);

        if (cargo.isPresent()) {
            CargoResponseDTO cargoResponseDTO = new CargoResponseDTO();

            cargoResponseDTO.setNomeCargo(cargo.get().getNomeCargo());
            cargoResponseDTO.setIdCargo(cargo.get().getIdCargo());
            cargoResponseDTO.setDescricacaoCargo(cargo.get().getDescricacaoCargo());
            cargoResponseDTO.setSalarioBase(cargo.get().getSalarioBase());
            cargoResponseDTO.setFuncionarios(cargo.get().getFuncionarios());

            return ResponseEntity.ok(cargoResponseDTO);

        }
        else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

    }


    @GetMapping
    public ResponseEntity <List<CargoResponseDTO>> findAll(){

        List<Cargo> cargo = cargoService.findAll();

        CargoResponseDTO cargoResponseDTO = new CargoResponseDTO();

        cargoResponseDTO.setNomeCargo(cargoResponseDTO.getNomeCargo());

        //SELECT NO BANCO DE DADOS E POPULAR OBJETO PARA APRESENTAR
        // ajustar o return apos implementar o metodo
        return ResponseEntity.ok(new ArrayList<>());
    }

}
