package br.com.itau.funcionarios.calculo.salario.dto.request;

import br.com.itau.funcionarios.calculo.salario.entity.enums.SexoEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class FuncionarioSaveRequestDTO {

    @NotNull @NotBlank(message = "Nome é Obrigatório!")
    private String nome;

    @NotNull
    @Pattern(regexp = "^\\d{2}\\/\\d{2}\\/\\d{4}$", message = "Data Nascimento Inválida! Formato deve ser XX/XX/XXXX.")
    private String dtNasc;

    @NotNull(message = "Sexo é Obrigatório!")
    private SexoEnum sexo;

    @NotNull
    private String endereco;

    @NotNull @DecimalMin(value = "0.0")
    private BigDecimal valorBonus;

    private FuncionarioCargoRequestDTO cargo;

}
