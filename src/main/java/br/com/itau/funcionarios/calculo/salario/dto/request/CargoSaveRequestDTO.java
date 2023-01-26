package br.com.itau.funcionarios.calculo.salario.dto.request;

import br.com.itau.funcionarios.calculo.salario.entity.Funcionario;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CargoSaveRequestDTO {

    @NotNull @NotBlank
    private String nomeCargo;

    @NotNull
    private String descricaoCargo;

    @NotNull @DecimalMin(value = "0.1")
    private BigDecimal salarioBase;

}
