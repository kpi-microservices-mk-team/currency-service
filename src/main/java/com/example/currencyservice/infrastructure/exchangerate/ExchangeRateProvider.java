package com.example.currencyservice.infrastructure.exchangerate;

import com.example.currencyservice.infrastructure.bean.CurrencyRateToUSD;
import com.example.currencyservice.infrastructure.repository.RatesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Comparator;

import static com.example.currencyservice.infrastructure.exchangerate.CurrencyRatesPersistenceMapper.toPersistenceDto;
import static java.util.Objects.nonNull;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateProvider {

    @Value("${exchange.api.url}")
    private String exchangeApiUrl;

    private final RestTemplate restTemplate;

    private final RatesRepository ratesRepository;

    public CurrencyRateToUSD provideRates() {
        final var allRates = ratesRepository.findAll();
        final var ratesToUsd = CurrencyRatesPersistenceMapper.fromPersistenceDto(allRates);

        return ratesToUsd.stream()
                .max(Comparator.comparing(CurrencyRateToUSD::getDate))
                .orElse(null);
    }

    @Scheduled(cron = "10 * * * * ?")
    private void provideCurrencyRate() {
        final var currencyRateResponse = restTemplate.getForEntity(exchangeApiUrl, CurrencyRateToUSD.class);
        final var currencyRateToUsd = nonNull(currencyRateResponse.getBody())
                ? currencyRateResponse.getBody()
                : null;
        final var persistenceCurrencyRates = toPersistenceDto(currencyRateToUsd);
        ratesRepository.saveAll(persistenceCurrencyRates);

        log.info("Currency rates are updated: " + LocalDateTime.now());
    }

    @PostConstruct
    private void loadRateOnStartup() {
        provideCurrencyRate();
    }
}
