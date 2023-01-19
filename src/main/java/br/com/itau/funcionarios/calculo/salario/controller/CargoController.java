package br.com.itau.funcionarios.calculo.salario.controller;

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

    @DeleteMapping
    public ResponseEntity <String> delete (@PathVariable long id){


        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{idcargo}")
    public ResponseEntity<Cargo> findById (@PathVariable(value= "idCargo") long id){
        //BUSCAR NO BANCO DE DADOS
        Cargo cargo = new Cargo();
        //cargo.setIdCargo(1111);
        cargo.setNomeCargo("TESTE");
        cargo.setDescricacaoCargo("teste");

        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity <List<Cargo>> findAll(){
            //SELECT NO BANCO DE DADOS E POPULAR OBJETO PARA APRESENTAR

        return ResponseEntity.ok(new ArrayList<>());
    }

}
