package com.teste.gestaofinanceira.controller;

import com.teste.gestaofinanceira.dto.*;
import com.teste.gestaofinanceira.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
@Tag(
        name = "Transações",
        description = "Endpoint responsavel por gerenciar as transações dos usuarios"
)
public class TransactionController {

    private final TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @Operation(
            summary = "Listar",
            description = "Lista todos as transações feitas pelo usuario"
    )
    @GetMapping
    public List<TransactionResponse> lisUsers(){
        return transactionService.listTransactions();
    }

    @Operation(
            summary = "Buscar por id",
            description = "Busca uma transação especifica atraves do id"
    )
    @GetMapping("/{id}")
    public Optional<TransactionResponse> searchById(@PathVariable Long id){
        return transactionService.searchById(id);
    }

    @Operation(
            summary = "Criar",
            description = "Permite criar transações e salvar no banco de dados"
    )

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse saveTransaction(@RequestBody TransactionRequest transactionRequest){
        return transactionService.saveTransactions(transactionRequest);
    }

    @Operation(
            summary = "Delete",
            description = "Permite deletar uma transação especifica atraves do seu id"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        transactionService.deleteById(id);
    }

    @Operation(
            summary = "Listar Totais",
            description = "Permite listar a soma dos totais de cada usuario"
    )
    @GetMapping("/listTotal")
    public TotalResponse listAllTotals(){
        return transactionService.total();
    }

}
