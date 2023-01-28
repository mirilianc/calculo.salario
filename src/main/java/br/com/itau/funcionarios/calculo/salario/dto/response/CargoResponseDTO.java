package br.com.itau.funcionarios.calculo.salario.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class CargoResponseDTO {


    private Long idCargo;
    private String nomeCargo;
    private String descricaoCargo;
    private BigDecimal salarioBase;
    private Set<FuncionarioListaResponseDTO> funcionarios;


}
