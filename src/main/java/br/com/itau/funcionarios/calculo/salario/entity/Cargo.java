package br.com.itau.funcionarios.calculo.salario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
public class Cargo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCargo;
    private String nomeCargo;
    private String descricacaoCargo;
    private BigDecimal salarioBase;

    @OneToOne(mappedBy = "cargo")
    private Funcionario funcionario;

}
