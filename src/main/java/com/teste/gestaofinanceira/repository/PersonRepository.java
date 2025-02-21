package com.teste.gestaofinanceira.repository;

import com.teste.gestaofinanceira.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
//Interface de contato direto com banco de dados
public interface PersonRepository extends JpaRepository<Person, Long> {

}
