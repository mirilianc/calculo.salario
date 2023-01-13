package br.com.itau.funcionarios.calculo.salario.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Cargo {

    long idCargo;
    String nomeCargo;
    String descricacaoCargo;
    BigDecimal salarioBase;

}
