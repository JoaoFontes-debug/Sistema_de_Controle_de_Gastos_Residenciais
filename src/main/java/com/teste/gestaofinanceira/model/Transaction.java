package com.teste.gestaofinanceira.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

//Classe modelo dos dados das transações
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "type")
    private String type;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
