package br.com.itau.funcionarios.calculo.salario.controller;

import br.com.itau.funcionarios.calculo.salario.entity.Cargo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping ("/cargos")
public class CargoController {

    @PostMapping
    public ResponseEntity<Cargo> save (@RequestBody Cargo cargoResponse){
        //SALVAR NO BANCO DE DADOS
        log.info(cargoResponse.toString());

        Cargo cargo = new Cargo();
        cargo.setIdCargo(1111L);
        cargo.setDescricacaoCargo(cargoResponse.getDescricacaoCargo());
        cargo.setNomeCargo(cargoResponse.getNomeCargo());
        cargo.setSalarioBase(cargoResponse.getSalarioBase());

        return ResponseEntity.status(HttpStatus.CREATED).body(cargo);
    }

    @DeleteMapping
    public ResponseEntity <String> delete (@PathVariable long id){


        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{idcargo}")
    public ResponseEntity<Cargo> findById (@PathVariable(value= "idCargo") long id){
        //BUSCAR NO BANCO DE DADOS
        Cargo cargo = new Cargo();
        cargo.setIdCargo(1111);
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
