package com.teste.gestaofinanceira.controller;

import com.teste.gestaofinanceira.dto.*;
import com.teste.gestaofinanceira.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionResponse> lisUsers(){
        return transactionService.listTransactions();
    }

    @GetMapping("/{id}")
    public Optional<TransactionResponse> searchById(@PathVariable Long id){
        return transactionService.searchById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse saveTransaction(@RequestBody TransactionRequest transactionRequest){
        return transactionService.saveTransactions(transactionRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        transactionService.deleteById(id);
    }

    @GetMapping("/listTotal")
    public TotalResponse listAllTotals(){
        return transactionService.total();
    }

}
