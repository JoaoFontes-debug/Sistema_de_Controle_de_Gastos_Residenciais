package com.teste.gestaofinanceira.converter;

import com.teste.gestaofinanceira.dto.PersonRequest;
import com.teste.gestaofinanceira.dto.PersonResponse;
import com.teste.gestaofinanceira.model.Person;

//classe utilizada para transformar objetos
public class PersonConverter {

    private PersonConverter(){

    }

    //Converte para um person contendo id
    public static PersonResponse toResponse(Person person){
        return new PersonResponse(person.getId(),
                person.getName(),
                person.getAge(),
                person.getTransactions());
    }
    //Converte para uma entidade person
    public static Person toEntity(PersonRequest personRequest){
        Person person = new Person();
        person.setName(personRequest.getName());
        person.setAge(personRequest.getAge());

        return person;

    }
}
