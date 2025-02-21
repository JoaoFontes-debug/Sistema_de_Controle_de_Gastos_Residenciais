package com.teste.gestaofinanceira.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Classe de dados de request
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//recebe dados relacionados a pessoa
public class PersonRequest {
    private String name;
    private int age;

}
