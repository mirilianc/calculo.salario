package br.com.itau.funcionarios.calculo.salario.dto.request;

import br.com.itau.funcionarios.calculo.salario.entity.enums.SexoEnum;
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
public class FuncionarioSaveRequestDTO {

    @NotNull @NotBlank
    private String nome;

    @NotNull
    private String dtNasc;

    @NotNull @NotBlank
    private SexoEnum sexo;

    @NotNull
    private String endereco;

    @NotNull @DecimalMin(value = "0.0")
    private BigDecimal valorBonus;

    private FuncionarioCargoRequestDTO cargo;

}
