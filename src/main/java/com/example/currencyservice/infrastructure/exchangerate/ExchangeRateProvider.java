package com.example.currencyservice.infrastructure.exchangerate;

import com.example.currencyservice.infrastructure.bean.CurrencyRateToUSD;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateProvider {

    @Value("${exchange.api.url}")
    private String exchangeApiUrl;

    private final RestTemplate restTemplate;

    private List<CurrencyRateToUSD> currencyList = new ArrayList<>();

    @Scheduled(cron = "10 * * * * ?")
    public CurrencyRateToUSD provideCurrencyRate() {
        final var currencyRateResponse = restTemplate.getForEntity(exchangeApiUrl, CurrencyRateToUSD.class);
        currencyList.add(currencyRateResponse.getBody());
        log.info("Currency rates are updated: " + LocalDateTime.now());
        return currencyRateResponse.getBody();
    }

    public List<CurrencyRateToUSD> getCurrencyList() {
        return currencyList;
    }

    @PostConstruct
    private void loadRateOnStartup() {
        provideCurrencyRate();
    }
}
