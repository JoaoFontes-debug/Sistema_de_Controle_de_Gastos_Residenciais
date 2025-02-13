package com.teste.gestaofinanceira.service;

import com.teste.gestaofinanceira.model.UserPerson;
import com.teste.gestaofinanceira.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    //metodo construtor
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //metodo para listar todas as pessoas
    public List<UserPerson> listUsers(){
        return userRepository.findAll();
    }

    //metodo para encontrar uma pessoa pelo id
    public Optional<UserPerson> searchById(Long id){
        return userRepository.findById(id);
    }

    //metodo para salvar um usuario
    public UserPerson saveUser(UserPerson userPerson){
        return userRepository.save(userPerson);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

}
