package com.teste.gestaofinanceira.repository;

import com.teste.gestaofinanceira.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//Interface de contato direto com banco de dados
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByPersonId(Long personId);
}
