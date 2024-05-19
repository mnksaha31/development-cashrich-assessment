package com.cashrich.inter.dev.cryptoapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cashrich.inter.dev.cryptoapp.entity.ApiRequestResponse;
import com.cashrich.inter.dev.cryptoapp.repository.ApiRequestResponseRepository;

import java.time.LocalDateTime;

@Service
public class CryptoService {
    private final ApiRequestResponseRepository apiRequestResponseRepository;
    private final RestTemplate restTemplate;

    public CryptoService(ApiRequestResponseRepository apiRequestResponseRepository, RestTemplate restTemplate) {
        this.apiRequestResponseRepository = apiRequestResponseRepository;
        this.restTemplate = restTemplate;
    }

    public String getCoinData(Long userId, String symbols) {
        String url = "https://proapi.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=" + symbols;
        String response = restTemplate.getForObject(url, String.class);

        ApiRequestResponse requestResponse = new ApiRequestResponse();
        requestResponse.setUserId(userId);
        requestResponse.setRequest(url);
        requestResponse.setResponse(response);
        requestResponse.setTimestamp(LocalDateTime.now());

        apiRequestResponseRepository.save(requestResponse);

        return response;
    }
}
