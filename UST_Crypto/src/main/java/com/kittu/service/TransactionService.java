 package com.kittu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kittu.model.Transaction;
import com.kittu.model.Wallet;
import com.kittu.repository.TransactionRepository;
import com.kittu.repository.walletRepository;

@Service
public class TransactionService 
{
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private walletRepository walletRepository;
	
	public Transaction initiateTransaction(Transaction transaction)
	{
		Wallet wallet = walletRepository.findById(transaction.getWallet().getWalletId()).orElseThrow(() -> new RuntimeException("wallet not found"));
		
		if("deposit".equalsIgnoreCase(transaction.getTransactionType()))
		{
			wallet.setCurrentBalance(wallet.getCurrentBalance() + transaction.getAmount());
		}
		else if("withdrawl".equalsIgnoreCase(transaction.getTransactionType()))
		{
			if(wallet.getCurrentBalance() < transaction.getAmount())
			{
				throw new RuntimeException("Insufficient balance");
			}
			
			wallet.setCurrentBalance(wallet.getCurrentBalance() - transaction.getAmount());
		}
		
		transaction.setTransactionStatus("Completed");
		
		walletRepository.save(wallet);
		return transactionRepository.save(transaction);
	}
	
	public List<Transaction> getAllTransactionsForWallet(long walletId)
	{
		return transactionRepository.findByWallet_WalletId(walletId);
	}
}
