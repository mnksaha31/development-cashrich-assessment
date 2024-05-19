package com.cashrich.inter.dev.cryptoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cashrich.inter.dev.cryptoapp.security.UserDetailsImpl;
import com.cashrich.inter.dev.cryptoapp.service.CryptoService;

@RestController
@RequestMapping("/api")
public class CryptoController {

    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/coins")
    public String getCoins(@RequestParam String symbol, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (userDetails instanceof UserDetailsImpl) {
            Long userId = ((UserDetailsImpl) userDetails).getId();
            return cryptoService.getCoinData(userId, symbol);
        } else {
            return "Error: User details not found";
        }
    }
}
