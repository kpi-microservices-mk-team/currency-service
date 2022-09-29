package com.example.currencyservice.usecases;

import com.example.currencyservice.infrastructure.bean.CurrencyRateToUSD;
import com.example.currencyservice.infrastructure.exchangerate.ExchangeRateProvider;
import com.example.currencyservice.usecases.dto.ConvertedValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConvertRateUseCase {

    private final ExchangeRateProvider exchangeRateProvider;

    public ConvertedValue convertRate(String target, String from, double value) {
        final var freshRates = exchangeRateProvider.getCurrencyList().stream()
                .max(Comparator.comparing(CurrencyRateToUSD::getDate))
                .orElseThrow(() -> new NoSuchElementException("Cannot find such as rates"));

        final var targetValue = freshRates.getRates().get(target.toLowerCase());
        final var fromValue = freshRates.getRates().get(from.toLowerCase());

        final var result = value / fromValue * targetValue;

        log.info("Converter from {}, to {}; result -> {}", from.toUpperCase(), target.toUpperCase(), result);

        return ConvertedValue.builder()
                .currency(target.toUpperCase())
                .value(result)
                .build();
    }
}
