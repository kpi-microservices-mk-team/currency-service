package com.example.currencyservice.infrastructure.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class CurrencyRateToUSD implements Serializable {

    private LocalDate date;
    @JsonProperty("usd")
    private Map<String, Double> rates;
}
