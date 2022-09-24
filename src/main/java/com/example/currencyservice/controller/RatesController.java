package com.example.currencyservice.controller;

import com.example.currencyservice.infrastructure.exchangerate.ExchangeRateProvider;
import com.example.currencyservice.infrastructure.mapper.RateMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetRatesApi;
import org.openapitools.model.CurrencyRateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RatesController implements GetRatesApi {

    private final ExchangeRateProvider exchangeRateProvider;

    @Override
    public ResponseEntity<List<CurrencyRateDto>> getRates() {
        return ResponseEntity.ok(RateMapper.toCurrencyRateDtos(exchangeRateProvider.getCurrencyList()));
    }
}
