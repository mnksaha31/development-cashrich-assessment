package com.cashrich.inter.dev.cryptoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashrich.inter.dev.cryptoapp.entity.ApiRequestResponse;

public interface ApiRequestResponseRepository extends JpaRepository<ApiRequestResponse, Long> {
}
