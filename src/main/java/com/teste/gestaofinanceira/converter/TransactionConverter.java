package com.teste.gestaofinanceira.converter;

import com.teste.gestaofinanceira.dto.TransactionRequest;
import com.teste.gestaofinanceira.dto.TransactionResponse;
import com.teste.gestaofinanceira.model.Person;
import com.teste.gestaofinanceira.model.Transaction;
import com.teste.gestaofinanceira.repository.PersonRepository;

public class TransactionConverter {

    private TransactionConverter() {

    }

    public static TransactionResponse toResponse(Transaction transaction) {
        return new TransactionResponse(transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getPerson().getId());
    }

    //converte o para entidade transaction
    public static Transaction toEntity(TransactionRequest transactionRequest){

       //RESOLVER PROBLEMA
        Transaction transaction = new Transaction();
        Person person = new Person();
        person.setId(transactionRequest.getPersonId());

        System.out.println("teste " + transactionRequest.getPersonId() + "person: " + person);

        transaction.setType(transactionRequest.getType().name());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setPerson(person);
        transaction.setDescription(transactionRequest.getDescription());

        return transaction;
    }


}
