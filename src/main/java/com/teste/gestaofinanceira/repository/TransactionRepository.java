package com.teste.gestaofinanceira.repository;

import com.teste.gestaofinanceira.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
