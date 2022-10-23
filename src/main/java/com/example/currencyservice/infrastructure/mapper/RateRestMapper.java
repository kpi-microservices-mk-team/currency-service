package com.example.currencyservice.infrastructure.mapper;

import com.example.currencyservice.infrastructure.bean.CurrencyRateToUSD;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openapitools.model.CurrencyRateDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RateRestMapper {

    public static CurrencyRateDto toCurrencyRateDto(CurrencyRateToUSD currencyRateToUSD) {
        return new CurrencyRateDto()
                .date(currencyRateToUSD.getDate())
                .rates(currencyRateToUSD.getRates());
    }
}
