package com.teste.gestaofinanceira.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

//classe de response para o total de cada person especifio.
@Getter
@AllArgsConstructor
public class TotalPersonResponse {

    private String name;

    private BigDecimal totalReceita;

    private BigDecimal totalDespesa;

    private BigDecimal netValue;
}
