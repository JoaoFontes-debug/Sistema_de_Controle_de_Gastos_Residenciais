package com.teste.gestaofinanceira.converter;

import com.teste.gestaofinanceira.dto.PersonRequest;
import com.teste.gestaofinanceira.dto.PersonResponse;
import com.teste.gestaofinanceira.model.Person;

public class PersonConverter {

    private PersonConverter(){

    }

    public static PersonResponse toResponse(Person person){
        return new PersonResponse(person.getId(),
                person.getName(),
                person.getAge(),
                person.getTransactions());
    }

    public static Person toEntity(PersonRequest personRequest){
        Person person = new Person();
        person.setName(personRequest.getName());
        person.setAge(personRequest.getAge());

        return person;

    }
}
