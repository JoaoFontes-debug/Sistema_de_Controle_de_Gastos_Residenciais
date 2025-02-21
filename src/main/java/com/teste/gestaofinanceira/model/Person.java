package com.teste.gestaofinanceira.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

//Classe modelo dos dados do usario
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "O campo deve ser preenchido")
    @Size(min = 5, message = "o nome deve conter pelo menos 5 caracteres")
    private String name;

    @Column(name = "age")
    @NotBlank(message = "O campo deve ser preenchido")
    private int age;
    @JsonManagedReference
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}
