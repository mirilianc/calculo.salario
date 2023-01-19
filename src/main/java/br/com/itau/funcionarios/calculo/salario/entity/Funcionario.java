package br.com.itau.funcionarios.calculo.salario.entity;

import br.com.itau.funcionarios.calculo.salario.entity.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Funcionario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long matricula;
    private String nome;
    private String dtNasc;
    private SexoEnum sexo;
    private String endereco;

    private BigDecimal valorBonus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name ="cargo_id", referencedColumnName ="idCargo")
    private Cargo cargo;

}
