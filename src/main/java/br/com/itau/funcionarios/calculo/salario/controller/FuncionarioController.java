package br.com.itau.funcionarios.calculo.salario.controller;

import br.com.itau.funcionarios.calculo.salario.dto.request.FuncionarioSaveRequestDTO;
import br.com.itau.funcionarios.calculo.salario.dto.response.*;
import br.com.itau.funcionarios.calculo.salario.entity.Cargo;
import br.com.itau.funcionarios.calculo.salario.entity.Funcionario;
import br.com.itau.funcionarios.calculo.salario.repository.CargoRepository;
import br.com.itau.funcionarios.calculo.salario.service.CargoService;
import br.com.itau.funcionarios.calculo.salario.service.FuncionarioService;
import br.com.itau.funcionarios.calculo.salario.service.SalarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping ("/funcionarios")
public class FuncionarioController {
    private final CargoRepository cargoRepository;

    private FuncionarioService funcionarioService;
    private CargoService cargoService;

    private SalarioService salarioService;

    public FuncionarioController(FuncionarioService funcionarioService, CargoService cargoService,
                                 CargoRepository cargoRepository, SalarioService salarioService) {
        this.funcionarioService = funcionarioService;
        this.cargoService = cargoService;
        this.cargoRepository = cargoRepository;
        this.salarioService = salarioService;
    }


    @PostMapping
    public ResponseEntity<FuncionarioSaveResponseDTO> save(@RequestBody FuncionarioSaveRequestDTO funcionarioSaveRequestDTO) {

        log.info(funcionarioSaveRequestDTO.toString());

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(funcionarioSaveRequestDTO.getNome());
        funcionario.setNome(funcionarioSaveRequestDTO.getNome());
        funcionario.setSexo(funcionarioSaveRequestDTO.getSexo());
        funcionario.setDtNasc(funcionarioSaveRequestDTO.getDtNasc());
        funcionario.setEndereco(funcionarioSaveRequestDTO.getEndereco());
        funcionario.setValorBonus(funcionarioSaveRequestDTO.getValorBonus());

        funcionario.setCargo(new Cargo());

        funcionario.getCargo().setIdCargo(funcionarioSaveRequestDTO.getCargo().getIdCargo());

        log.info(funcionario.toString());

        funcionario = funcionarioService.save(funcionario);

        FuncionarioSaveResponseDTO funcionarioSaveResponseDTO = new FuncionarioSaveResponseDTO();
        funcionarioSaveResponseDTO.setMatricula(funcionario.getMatricula());


        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSaveResponseDTO);

    }

    @DeleteMapping(value = "/{matricula}")
    public ResponseEntity<String> delete(@PathVariable(value = "matricula") Long matricula) {


        Optional<Funcionario> funcionario = funcionarioService.findById(matricula);
        if (funcionario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        funcionarioService.delete(matricula);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{matricula}")
    public ResponseEntity<FuncionarioResponseDTO> findById(@PathVariable(value = "matricula") Long matricula) {
        //BUSCAR NO BANCO DE DADOS
        Optional<Funcionario> funcionario = funcionarioService.findById(matricula);

        if (funcionario.isPresent()) {

            FuncionarioResponseDTO funcionarioResponseDTO = new FuncionarioResponseDTO();
            CargoFuncResponseDTO cargoFuncResponseDTO = new CargoFuncResponseDTO();

            cargoFuncResponseDTO.setNomeCargo(funcionario.get().getCargo().getNomeCargo());
            cargoFuncResponseDTO.setDescricaoCargo(funcionario.get().getCargo().getDescricaoCargo());
            cargoFuncResponseDTO.setIdCargo(funcionario.get().getCargo().getIdCargo());
            cargoFuncResponseDTO.setSalarioBase(funcionario.get().getCargo().getSalarioBase());

            funcionarioResponseDTO.setMatricula(funcionario.get().getMatricula());
            funcionarioResponseDTO.setNome(funcionario.get().getNome());
            funcionarioResponseDTO.setSexo(funcionario.get().getSexo());
            funcionarioResponseDTO.setCargo(cargoFuncResponseDTO);
            funcionarioResponseDTO.setEndereco(funcionario.get().getEndereco());
            funcionarioResponseDTO.setDtNasc(funcionario.get().getDtNasc());
            funcionarioResponseDTO.setValorBonus(funcionario.get().getValorBonus());


            return ResponseEntity.ok(funcionarioResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping(value = "/calculosalario/{matricula}")

    public ResponseEntity<FuncionarioBonusResponseDTO> calculoSalario(@PathVariable(value = "matricula") Long matricula) {

        Optional<Funcionario> funcionario = funcionarioService.findById(matricula);

        if (funcionario.isPresent()) {

            FuncionarioBonusResponseDTO funcionarioBonusResponseDTO = new FuncionarioBonusResponseDTO();
            CargoFuncResponseDTO cargoFuncResponseDTO = new CargoFuncResponseDTO();

            cargoFuncResponseDTO.setNomeCargo(funcionario.get().getCargo().getNomeCargo());
            cargoFuncResponseDTO.setDescricaoCargo(funcionario.get().getCargo().getDescricaoCargo());
            cargoFuncResponseDTO.setIdCargo(funcionario.get().getCargo().getIdCargo());
            cargoFuncResponseDTO.setSalarioBase(funcionario.get().getCargo().getSalarioBase());

            funcionarioBonusResponseDTO.setMatricula(funcionario.get().getMatricula());
            funcionarioBonusResponseDTO.setNome(funcionario.get().getNome());
            funcionarioBonusResponseDTO.setSexo(funcionario.get().getSexo());
            funcionarioBonusResponseDTO.setCargo(cargoFuncResponseDTO);
            funcionarioBonusResponseDTO.setEndereco(funcionario.get().getEndereco());
            funcionarioBonusResponseDTO.setDtNasc(funcionario.get().getDtNasc());
            funcionarioBonusResponseDTO.setValorBonus(funcionario.get().getValorBonus());

            BigDecimal valorFinal = salarioService.calculoSalario(matricula);

            funcionarioBonusResponseDTO.setSalarioFinal(valorFinal);

            return ResponseEntity.ok(funcionarioBonusResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> findAll() {

        List<Funcionario> funcionarios = funcionarioService.findAll();
        List<FuncionarioResponseDTO> funcionarioResponseDTOS = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {

            FuncionarioResponseDTO funcionarioResponseDTO = new FuncionarioResponseDTO();
            CargoFuncResponseDTO cargoFuncResponseDTO = new CargoFuncResponseDTO();

            cargoFuncResponseDTO.setNomeCargo(funcionario.getCargo().getNomeCargo());
            cargoFuncResponseDTO.setDescricaoCargo(funcionario.getCargo().getDescricaoCargo());
            cargoFuncResponseDTO.setIdCargo(funcionario.getCargo().getIdCargo());
            cargoFuncResponseDTO.setSalarioBase(funcionario.getCargo().getSalarioBase());

            funcionarioResponseDTO.setMatricula(funcionario.getMatricula());
            funcionarioResponseDTO.setNome(funcionario.getNome());
            funcionarioResponseDTO.setSexo(funcionario.getSexo());
            funcionarioResponseDTO.setCargo(cargoFuncResponseDTO);
            funcionarioResponseDTO.setEndereco(funcionario.getEndereco());
            funcionarioResponseDTO.setDtNasc(funcionario.getDtNasc());
            funcionarioResponseDTO.setValorBonus(funcionario.getValorBonus());

            funcionarioResponseDTOS.add(funcionarioResponseDTO);
        }
        return ResponseEntity.ok(funcionarioResponseDTOS);

    }
}