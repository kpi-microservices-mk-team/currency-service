package com.example.currencyservice.infrastructure.mapper;

import com.example.currencyservice.infrastructure.bean.CurrencyRateToUSD;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openapitools.model.CurrencyRateDto;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RateMapper {

    public static List<CurrencyRateDto> toCurrencyRateDtos(List<CurrencyRateToUSD> currencyRateToUSD) {
        return currencyRateToUSD.stream()
                .map(RateMapper::toCurrencyRateDto)
                .toList();
    }

    private static CurrencyRateDto toCurrencyRateDto(CurrencyRateToUSD currencyRateToUSD) {
        return new CurrencyRateDto()
                .date(currencyRateToUSD.getDate())
                .rates(currencyRateToUSD.getRates());
    }
}
