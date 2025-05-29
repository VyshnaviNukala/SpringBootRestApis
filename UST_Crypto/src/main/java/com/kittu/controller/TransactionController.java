package com.kittu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kittu.model.Transaction;
import com.kittu.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController 
{
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public Transaction initiateTransaction(@RequestBody Transaction transaction)
	{
		return transactionService.initiateTransaction(transaction);
	}
	
	@GetMapping("/wallets/{walletId}")
	public List<Transaction> getAllTransactionsForWallet(@PathVariable long walletId)
	{
		return transactionService.getAllTransactionsForWallet(walletId);
	}
}
