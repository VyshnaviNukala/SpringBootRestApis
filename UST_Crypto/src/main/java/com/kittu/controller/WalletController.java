package com.kittu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kittu.model.Wallet;
import com.kittu.service.WalletService;

@RestController
@RequestMapping("/wallets")
public class WalletController 
{
	@Autowired
	private WalletService walletService;
	
	@PostMapping
	public Wallet createWallet(@RequestBody Wallet wallet)
	{
		return walletService.createWallet(wallet);
	}
	
	@DeleteMapping("/{walletId}")
	public void deleteWallet(@PathVariable long walletId)
	{
		walletService.deleteWallet(walletId);
	}
	
	@GetMapping
	public List<Wallet> getAllWallets()
	{
		return walletService.getAllWallets();
	}
}
