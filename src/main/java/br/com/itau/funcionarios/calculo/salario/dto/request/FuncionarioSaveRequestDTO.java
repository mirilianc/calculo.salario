package br.com.itau.funcionarios.calculo.salario.dto.request;

import br.com.itau.funcionarios.calculo.salario.entity.enums.SexoEnum;
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
