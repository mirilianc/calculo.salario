package br.com.itau.funcionarios.calculo.salario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;
import java.util.Set;

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

    @OneToMany(mappedBy = "cargo" , cascade = CascadeType.ALL)
    private Set<Funcionario> funcionarios;

}
