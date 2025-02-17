package com.teste.gestaofinanceira.service;

import com.teste.gestaofinanceira.converter.TransactionConverter;
import com.teste.gestaofinanceira.dto.*;
import com.teste.gestaofinanceira.exception.BusinessException;
import com.teste.gestaofinanceira.model.Transaction;
import com.teste.gestaofinanceira.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final PersonService personService;
    private final TransactionRepository transactionRepository;

    //metodo construtor
    public TransactionService (PersonService personService, TransactionRepository transactionRepository){
        this.personService = personService;
        this.transactionRepository = transactionRepository;
    }

    //metodo para listar todas as transaçoes
    public List<TransactionResponse> listTransactions(){
        return transactionRepository.findAll().stream().map(TransactionConverter::toResponse).toList();
    }

    //buscar uma transaçao por id
    public Optional<TransactionResponse> searchById(Long id) {
        return transactionRepository.findById(id).map(TransactionConverter::toResponse);
    }

    //Salvar transaçao
    public TransactionResponse saveTransactions(TransactionRequest transactionRequest){
        if (transactionRequest.getAmount().compareTo(BigDecimal.ZERO) < 0){
            throw new BusinessException("Não é permitido valores menores que zero");
        }

        PersonResponse personResponse = personService.searchById(transactionRequest.getPersonId())
                .orElseThrow(()-> new BusinessException("Person não encontrada"));

        if (transactionRequest.getType() == TransactionType.RECEITA){
            if (personResponse.getAge() < 18){
                logger.info("Menores de idade não tem permissão para criar receitas");
                throw new BusinessException("Menores de idade não tem permissão para criar receitas");
            }

        }

        Transaction transaction = TransactionConverter.toEntity(transactionRequest);

        Transaction transactionbd = transactionRepository.save(transaction);
        return TransactionConverter.toResponse(transactionbd);
    }

    //deletar trasaçao
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

    public TotalResponse total (){

         BigDecimal totalReceita = BigDecimal.ZERO;

         BigDecimal totalDespesa = BigDecimal.ZERO;

         BigDecimal totalNetValue = BigDecimal.ZERO;

      List<PersonResponse> personResponseList = personService.listUsers();
      List<TotalPersonResponse> personResponses = new ArrayList<>();

      for(PersonResponse person : personResponseList){

          List<Transaction> transactionList = transactionRepository.findAllByPersonId(person.getId());

          BigDecimal totalReceitas = transactionList.stream()
                  .filter(transaction -> transaction.getType().equals(TransactionType.RECEITA.name()))
                  .map(Transaction::getAmount)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);

          BigDecimal totalDespesas = transactionList.stream()
                  .filter(transaction -> transaction.getType().equals(TransactionType.DESPESA.name()))
                  .map(Transaction::getAmount)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);

          BigDecimal netValue = totalReceitas.subtract(totalDespesas);

          totalNetValue = totalNetValue.add(netValue);
          totalReceita = totalReceita.add(totalReceitas);
          totalDespesa = totalDespesa.add(totalDespesas);

          personResponses.add(new TotalPersonResponse(person.getName(), totalReceitas, totalDespesas, netValue));
      }

      return new TotalResponse(personResponses,totalReceita, totalDespesa, totalNetValue);

    }

}
