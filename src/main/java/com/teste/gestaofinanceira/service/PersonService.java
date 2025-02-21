package com.teste.gestaofinanceira.service;

import com.teste.gestaofinanceira.converter.PersonConverter;
import com.teste.gestaofinanceira.dto.PersonRequest;
import com.teste.gestaofinanceira.dto.PersonResponse;
import com.teste.gestaofinanceira.model.Person;
import com.teste.gestaofinanceira.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Classe reponsável pela aplicaçao da logica para dados relacionados ao
@Service
public class PersonService {

    private final PersonRepository personRepository;

    //metodo construtor
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //metodo para listar todas as pessoas
    public List<PersonResponse> listUsers() {
        return personRepository.findAll().stream().map(PersonConverter::toResponse).toList();
    }

    //metodo para encontrar uma pessoa pelo id
    public Optional<PersonResponse> searchById(Long id) {
        return personRepository.findById(id).map(PersonConverter::toResponse);
    }

    //metodo para salvar um usuario
    public PersonResponse saveUser(PersonRequest personRequest) {
        Person person = PersonConverter.toEntity(personRequest);

        Person personbd = personRepository.save(person);
        return PersonConverter.toResponse(personbd);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

}
