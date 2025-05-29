package com.kittu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kittu.model.Wallet;

public interface walletRepository extends JpaRepository<Wallet, Long>{

}
