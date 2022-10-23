package com.example.currencyservice.infrastructure.exchangerate;

import com.example.currencyservice.infrastructure.bean.CurrencyRateToUSD;
import com.example.currencyservice.infrastructure.bean.PersistenceCurrencyRate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrencyRatesPersistenceMapper {

    public static List<PersistenceCurrencyRate> toPersistenceDto(CurrencyRateToUSD currencyRateToUSD) {
        return nonNull(currencyRateToUSD)
                ? extractPersistenceRates(currencyRateToUSD)
                : Collections.emptyList();
    }

    public static List<CurrencyRateToUSD> fromPersistenceDto(List<PersistenceCurrencyRate> persistenceCurrencyRate) {
        final var collect = persistenceCurrencyRate.stream()
                .collect(Collectors.groupingBy(CurrencyRatesPersistenceMapper::extractDate));
        return collect.entrySet()
                .stream()
                .map(entry -> CurrencyRateToUSD.builder()
                        .date(entry.getKey())
                        .rates(toRatesMap(entry.getValue()))
                        .build())
                .toList();
    }

    private static LocalDate extractDate(PersistenceCurrencyRate persistenceCurrencyRate) {
        return persistenceCurrencyRate.getRateId().getEffectiveDate();
    }

    private static Map<String, Double> toRatesMap(List<PersistenceCurrencyRate> persistenceCurrencyRates) {
        return persistenceCurrencyRates.stream()
                .collect(Collectors.toMap(elem -> elem.getRateId().getCurrency(), PersistenceCurrencyRate::getRate));
    }

    private static List<PersistenceCurrencyRate> extractPersistenceRates(CurrencyRateToUSD currencyRateToUSD) {
        return currencyRateToUSD.getRates()
                .entrySet()
                .stream()
                .map(entry -> PersistenceCurrencyRate.builder()
                        .rateId(
                                PersistenceCurrencyRate.RateId.builder()
                                        .currency(entry.getKey())
                                        .effectiveDate(currencyRateToUSD.getDate())
                                        .build()
                        )
                        .rate(entry.getValue())
                        .build()
                )
                .toList();
    }
}
