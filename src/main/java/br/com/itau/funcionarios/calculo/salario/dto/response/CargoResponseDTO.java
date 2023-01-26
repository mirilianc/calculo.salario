package br.com.itau.funcionarios.calculo.salario.dto.response;

import br.com.itau.funcionarios.calculo.salario.entity.Funcionario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString
public class CargoResponseDTO {


    private Long idCargo;
    private String nomeCargo;
    private String descricaoCargo;
    private BigDecimal salarioBase;

    private Set<Funcionario> funcionarios;
}
