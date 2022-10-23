package com.example.currencyservice.infrastructure.repository;

import com.example.currencyservice.infrastructure.bean.PersistenceCurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesRepository extends JpaRepository<PersistenceCurrencyRate, PersistenceCurrencyRate.RateId> {
}
