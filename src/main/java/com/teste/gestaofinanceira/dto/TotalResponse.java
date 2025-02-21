package com.teste.gestaofinanceira.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
//Classe de response correspondente a soma dos totais de cada person
@Getter
@AllArgsConstructor
public class TotalResponse {

    private List<TotalPersonResponse> listTotalPerson;

    private BigDecimal totalReceita;

    private BigDecimal totalDespesa;

    private BigDecimal netValue;
}
