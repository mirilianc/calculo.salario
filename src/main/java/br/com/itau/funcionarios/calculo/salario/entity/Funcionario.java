package br.com.itau.funcionarios.calculo.salario.entity;

import br.com.itau.funcionarios.calculo.salario.entity.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long matricula;
    private String nome;
    private String dtNasc;
    private SexoEnum sexo;
    private String endereco;

    private BigDecimal valorBonus;

    @ManyToOne
    @JoinColumn (name ="cargo_id", referencedColumnName ="idCargo")
    private Cargo cargo;

}
