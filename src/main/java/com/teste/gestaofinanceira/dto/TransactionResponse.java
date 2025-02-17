package com.teste.gestaofinanceira.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class TransactionResponse {

    private Long id;

    private String description;

    private BigDecimal amount;

    private String type;

    private Long personId;
}
