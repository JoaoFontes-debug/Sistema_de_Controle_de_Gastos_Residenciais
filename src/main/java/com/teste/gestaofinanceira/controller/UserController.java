package com.teste.gestaofinanceira.controller;

import com.teste.gestaofinanceira.model.UserPerson;
import com.teste.gestaofinanceira.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserPerson> lisUsers(){
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserPerson> searchById(@PathVariable Long id){
        return userService.searchById(id);
    }

    @PostMapping
    public Object saveUser(@RequestBody UserPerson userPerson){
        return userService.saveUser(userPerson);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }

}
