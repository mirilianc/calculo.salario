package br.com.itau.funcionarios.calculo.salario.service.impl;

import br.com.itau.funcionarios.calculo.salario.entity.Funcionario;
import br.com.itau.funcionarios.calculo.salario.repository.FuncionarioRepository;
import br.com.itau.funcionarios.calculo.salario.service.SalarioService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SalarioServiceImpl implements SalarioService {

    private FuncionarioRepository funcionarioRepository;


    public SalarioServiceImpl(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;

    }


    @Override
    public BigDecimal calculoSalario(Long matricula) {


        Optional<Funcionario> funcionario = funcionarioRepository.findById(matricula);

        BigDecimal salarioCalculado = funcionario.get().getCargo().getSalarioBase().add(funcionario.get().getValorBonus());

        return salarioCalculado;
    }
}
