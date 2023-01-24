package br.com.itau.funcionarios.calculo.salario.controller;

import br.com.itau.funcionarios.calculo.salario.dto.*;
import br.com.itau.funcionarios.calculo.salario.entity.Cargo;
import br.com.itau.funcionarios.calculo.salario.entity.Funcionario;
import br.com.itau.funcionarios.calculo.salario.service.CargoService;
import br.com.itau.funcionarios.calculo.salario.service.FuncionarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping ("/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;
    private CargoService cargoService;

    public FuncionarioController(FuncionarioService funcionarioService, CargoService cargoService){
        this.funcionarioService = funcionarioService;
        this.cargoService = cargoService;
    }


    @PostMapping
    public ResponseEntity<FuncionarioSaveResponseDTO> save (@RequestBody FuncionarioSaveRequestDTO funcionarioSaveRequestDTO){

        log.info(funcionarioSaveRequestDTO.toString());

        Funcionario funcionario = new Funcionario();

        Cargo cargo2 = new Cargo();

        Optional<Cargo> cargo = cargoService.findById(funcionarioSaveRequestDTO.getFuncionarioCargoRequestDTO().getIdCargo());

        //PRECISA AJUSTAR - CODIGO TA FEIO
        cargo2.setDescricacaoCargo(cargo.get().getDescricacaoCargo());
        cargo2.setNomeCargo(cargo.get().getNomeCargo());
        cargo2.setSalarioBase(cargo.get().getSalarioBase());

        funcionario.setNome(funcionarioSaveRequestDTO.getNome());

        funcionario.setNome(funcionarioSaveRequestDTO.getNome());
        funcionario.setSexo(funcionarioSaveRequestDTO.getSexo());
        funcionario.setDtNasc(funcionarioSaveRequestDTO.getDtNasc());
        funcionario.setEndereco(funcionarioSaveRequestDTO.getEndereco());
        funcionario.setValorBonus(funcionarioSaveRequestDTO.getValorBonus());

        funcionario.setCargo(cargo2);

        log.info(funcionario.toString());

        funcionario = funcionarioService.save(funcionario);

       FuncionarioSaveResponseDTO funcionarioSaveResponseDTO = new FuncionarioSaveResponseDTO();
       funcionarioSaveResponseDTO.setMatricula(funcionario.getMatricula());


       return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSaveResponseDTO);

    }

    @DeleteMapping (value = "/{matricula}")
    public ResponseEntity <String> delete (@PathVariable (value = "matricula") Long matricula) {


        Optional<Funcionario> funcionario = funcionarioService.findById(matricula);
        if (funcionario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        funcionarioService.delete(matricula);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{matricula}")
    public ResponseEntity<FuncionarioResponseDTO> findById (@PathVariable(value= "matricula") Long matricula){
        //BUSCAR NO BANCO DE DADOS
        Optional<Funcionario> funcionario = funcionarioService.findById(matricula);

        if(funcionario.isPresent()) {

            FuncionarioResponseDTO funcionarioResponseDTO = new FuncionarioResponseDTO();
            Cargo cargo = new Cargo();

            cargo.setNomeCargo(funcionario.get().getCargo().getNomeCargo());
            cargo.setDescricacaoCargo(funcionario.get().getCargo().getDescricacaoCargo());
            cargo.setIdCargo(funcionario.get().getCargo().getIdCargo());
            cargo.setSalarioBase(funcionario.get().getCargo().getSalarioBase());

            funcionarioResponseDTO.setMatricula(funcionario.get().getMatricula());
            funcionarioResponseDTO.setNome(funcionario.get().getNome());
            funcionarioResponseDTO.setSexo(funcionario.get().getSexo());
            funcionarioResponseDTO.setCargo(cargo);
            funcionarioResponseDTO.setEndereco(funcionario.get().getEndereco());
            funcionarioResponseDTO.setDtNasc(funcionario.get().getDtNasc());
            funcionarioResponseDTO.setValorBonus(funcionario.get().getValorBonus());


            return ResponseEntity.ok(funcionarioResponseDTO);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping
    public ResponseEntity <List<Cargo>> findAll(){
        //SELECT NO BANCO DE DADOS E POPULAR OBJETO PARA APRESENTAR

        return ResponseEntity.ok(new ArrayList<>());
    }



}
