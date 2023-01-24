package br.com.itau.funcionarios.calculo.salario.service.impl;

import br.com.itau.funcionarios.calculo.salario.entity.Funcionario;
import br.com.itau.funcionarios.calculo.salario.repository.FuncionarioRepository;
import br.com.itau.funcionarios.calculo.salario.service.FuncionarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;

    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);

    }

    @Override
    public Optional<Funcionario> findById(Long matricula) {
        return funcionarioRepository.findById(matricula);
    }

    @Override
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);

    }

    @Override
    public Funcionario update(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }


    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }
}
