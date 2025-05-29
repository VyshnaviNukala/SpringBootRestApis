package com.kittu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kittu.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	List<Transaction> findByWallet_WalletId(long walletId);

}
