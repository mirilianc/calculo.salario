package br.com.itau.funcionarios.calculo.salario.dto;

import br.com.itau.funcionarios.calculo.salario.entity.Cargo;
import br.com.itau.funcionarios.calculo.salario.entity.enums.SexoEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class FuncionarioSaveRequestDTO {



    private String nome;
    private String dtNasc;
    private SexoEnum sexo;
    private String endereco;

    private BigDecimal valorBonus;

    private FuncionarioCargoRequestDTO funcionarioCargoRequestDTO;

}
