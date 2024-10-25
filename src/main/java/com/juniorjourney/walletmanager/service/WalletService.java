package com.juniorjourney.walletmanager.service;

import com.juniorjourney.walletmanager.domain.wallet.Wallet;
import com.juniorjourney.walletmanager.domain.wallet.WalletRequestDTO;
import com.juniorjourney.walletmanager.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(WalletRequestDTO walletRequestDTO) {
        Wallet wallet = new Wallet();
        wallet.setAmount(walletRequestDTO.amount());
        wallet.setUserId(walletRequestDTO.userId());
        wallet.setStatus(walletRequestDTO.status());
        wallet.setCreatedAt(new Date());
        wallet.setUpdatedAt(new Date());

        return walletRepository.save(wallet);
    }
}
