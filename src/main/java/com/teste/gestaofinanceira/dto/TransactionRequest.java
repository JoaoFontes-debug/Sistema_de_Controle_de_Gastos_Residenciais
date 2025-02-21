package com.teste.gestaofinanceira.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

//Classe de request para as transaction
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//recebe dados relacionado as transaçoes
public class TransactionRequest {

    private String description;

    private BigDecimal amount;

    private TransactionType type;

    private Long personId;
}
