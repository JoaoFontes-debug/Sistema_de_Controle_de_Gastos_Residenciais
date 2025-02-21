package com.teste.gestaofinanceira.controller;

import com.teste.gestaofinanceira.dto.PersonRequest;
import com.teste.gestaofinanceira.dto.PersonResponse;
import com.teste.gestaofinanceira.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@Tag(
        name = "Person",
        description = "Endpoint para gerenciar o cadastro de pessoas"
)
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @Operation(
            summary = "Listar",
            description = "Lista todos os usuarios cadastrados"
    )
    @GetMapping
    public List<PersonResponse> lisUsers(){
        return personService.listUsers();
    }

    @Operation(
            summary = "Buscar por id",
            description = "Permite buscar uma pessoa especifica através do seu id"
    )
    @GetMapping("/{id}")
    public Optional<PersonResponse> searchById(@PathVariable Long id){
        return personService.searchById(id);
    }

    @Operation(
            summary = "Criar",
            description = "Permite criar um usuário e salvar no banco de dados"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse saveUser(@RequestBody PersonRequest person){
        return personService.saveUser(person);
    }

    @Operation(
            summary = "Delete",
            description = "Permite deletar um usuário especifico através de seu id"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        personService.deleteById(id);
    }

}
