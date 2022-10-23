package com.example.currencyservice.infrastructure.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CurrencyRateToUSD implements Serializable {

    private LocalDate date;
    @JsonProperty("usd")
    private Map<String, Double> rates;
}
