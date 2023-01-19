package br.com.itau.funcionarios.calculo.salario.dto;

import br.com.itau.funcionarios.calculo.salario.entity.Funcionario;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CargoSaveRequestDTO {

    private String nomeCargo;
    
    private String descricacaoCargo;
    private BigDecimal salarioBase;

}
