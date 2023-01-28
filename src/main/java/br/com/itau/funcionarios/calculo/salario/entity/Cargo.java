package br.com.itau.funcionarios.calculo.salario.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCargo;
    private String nomeCargo;
    private String descricaoCargo;
    private BigDecimal salarioBase;

    @OneToMany(mappedBy = "cargo" )
    private Set<Funcionario> funcionarios;

}
