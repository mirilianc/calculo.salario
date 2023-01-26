package br.com.itau.funcionarios.calculo.salario.dto.response;

import br.com.itau.funcionarios.calculo.salario.entity.Cargo;
import br.com.itau.funcionarios.calculo.salario.entity.enums.SexoEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FuncionarioResponseDTO {

    private Long matricula;
    private String nome;
    private String dtNasc;
    private SexoEnum sexo;
    private String endereco;

    private BigDecimal valorBonus;

    private Cargo cargo;
}
