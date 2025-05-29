package com.kittu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kittu.model.Wallet;
import com.kittu.repository.walletRepository;

@Service
public class WalletService 
{
	@Autowired
	private walletRepository walletRepository;
	
	public Wallet createWallet(Wallet wallet)
	{
		return walletRepository.save(wallet);
	}
	
	public void deleteWallet(long walletId)
	{
		walletRepository.deleteById(walletId);
	}
	
	public List<Wallet> getAllWallets()
	{
		return walletRepository.findAll();
	}
}
