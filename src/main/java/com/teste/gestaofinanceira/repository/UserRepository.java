package com.teste.gestaofinanceira.repository;

import com.teste.gestaofinanceira.model.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPerson, Long> {

}
