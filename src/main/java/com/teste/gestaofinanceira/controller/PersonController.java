package com.teste.gestaofinanceira.controller;

import com.teste.gestaofinanceira.dto.PersonRequest;
import com.teste.gestaofinanceira.dto.PersonResponse;
import com.teste.gestaofinanceira.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<PersonResponse> lisUsers(){
        return personService.listUsers();
    }

    @GetMapping("/{id}")
    public Optional<PersonResponse> searchById(@PathVariable Long id){
        return personService.searchById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse saveUser(@RequestBody PersonRequest person){
        return personService.saveUser(person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        personService.deleteById(id);
    }

}
