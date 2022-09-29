package com.example.currencyservice.usecases.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConvertedValue {

    private String currency;
    private double value;
}
