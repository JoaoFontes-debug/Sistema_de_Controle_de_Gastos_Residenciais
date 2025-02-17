package com.teste.gestaofinanceira.dto;

import com.teste.gestaofinanceira.model.Transaction;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonResponse {

    private Long id;

    private String name;

    private int age;

    private List<Transaction> transactions;
}
