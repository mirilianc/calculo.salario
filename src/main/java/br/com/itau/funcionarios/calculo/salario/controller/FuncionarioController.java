package br.com.itau.funcionarios.calculo.salario.controller;

import br.com.itau.funcionarios.calculo.salario.dto.CargoSaveRequestDTO;
import br.com.itau.funcionarios.calculo.salario.dto.CargoSaveResponseDTO;
import br.com.itau.funcionarios.calculo.salario.dto.FuncionarioSaveRequestDTO;
import br.com.itau.funcionarios.calculo.salario.dto.FuncionarioSaveResponseDTO;
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

    public FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;

    }


    @PostMapping
    public ResponseEntity<FuncionarioSaveResponseDTO> save (@RequestBody FuncionarioSaveRequestDTO funcionarioSaveRequestDTO){

        log.info(funcionarioSaveRequestDTO.toString());

        Funcionario funcionario = new Funcionario();

        funcionario.setMatricula(funcionarioSaveRequestDTO.getMatricula());
        funcionario.setNome(funcionarioSaveRequestDTO.getNome());


        funcionario = funcionarioService.save(funcionario);

       FuncionarioSaveResponseDTO funcionarioSaveResponseDTO = new FuncionarioSaveResponseDTO();
       funcionarioSaveResponseDTO.setMatricula(funcionario.getMatricula());


       return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSaveResponseDTO);

    }

    @DeleteMapping
    public ResponseEntity <String> delete (@PathVariable long id) {

        Optional<Funcionario> funcionario = funcionarioService.findById(id);
        if (funcionario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{matricula}")
    public ResponseEntity<Funcionario> findById (@PathVariable(value= "matricula") long id){
        //BUSCAR NO BANCO DE DADOS
        Funcionario funcionario = new Funcionario();


        //funcionario.setMatricula();
        //funcionario.setNome();



        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity <List<Cargo>> findAll(){
        //SELECT NO BANCO DE DADOS E POPULAR OBJETO PARA APRESENTAR

        return ResponseEntity.ok(new ArrayList<>());
    }



}
