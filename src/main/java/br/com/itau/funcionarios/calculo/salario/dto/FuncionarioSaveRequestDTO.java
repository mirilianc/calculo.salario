package br.com.itau.funcionarios.calculo.salario.dto;

import br.com.itau.funcionarios.calculo.salario.entity.enums.SexoEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class FuncionarioSaveRequestDTO {

    private Long matricula;
    private String nome;

}
