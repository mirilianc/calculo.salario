package br.com.itau.funcionarios.calculo.salario.dto.response;

import br.com.itau.funcionarios.calculo.salario.entity.enums.SexoEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FuncionarioBonusResponseDTO {

    private Long matricula;
    private String nome;
    private String dtNasc;
    private SexoEnum sexo;
    private String endereco;
    private BigDecimal valorBonus;
    private BigDecimal salarioFinal;
    private CargoFuncResponseDTO cargo;
}
